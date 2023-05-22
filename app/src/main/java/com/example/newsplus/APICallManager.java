package com.example.newsplus;

import static android.content.ContentValues.TAG;

import android.content.Context;
import android.util.Log;
import android.widget.Toast;

import androidx.annotation.NonNull;

import com.example.newsplus.models.Datum;
import com.example.newsplus.models.Topanime;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.http.GET;
import retrofit2.http.Query;

public class APICallManager {
    Context context;

    private DatabaseReference mDatabase;

    FirebaseAuth mAuth;
    FirebaseUser mUser;


    Retrofit retrofit = new Retrofit.Builder()
            .baseUrl("https://api.jikan.moe/v4/top/")
            .addConverterFactory(GsonConverterFactory.create())
            .build();

    Retrofit retrofit2 = new Retrofit.Builder()
            .baseUrl("https://api.jikan.moe/v4/")
            .addConverterFactory(GsonConverterFactory.create())
            .build();




    public void getTopAnimes(OnFetchDataListener<Topanime> listener, String filter, Integer limit){
        CallTopAnimeApi callTopAnimeApi = retrofit.create(CallTopAnimeApi.class);
        Call<Topanime> call = callTopAnimeApi.topAnimes(filter, limit);
        if(Objects.equals(filter, "saved")){
            mAuth = FirebaseAuth.getInstance();
            mUser = mAuth.getCurrentUser();
            Log.d(TAG, "getTopAnimes: filter if");
            String uuid = mUser.getUid();
            mDatabase = FirebaseDatabase.getInstance().getReference("animes").child(uuid);
            mDatabase.addListenerForSingleValueEvent(new ValueEventListener() {
                @Override
                public void onDataChange(@NonNull DataSnapshot snapshot) {
                    List<Datum> animeList = new ArrayList<>();
                    for(DataSnapshot snapshot1: snapshot.getChildren()){
                        Datum anime = snapshot1.getValue(Datum.class);
                        animeList.add(anime);
                    }
                    Log.d(TAG, "onDataChange:"+animeList.toArray().length);
                    listener.onFetchData(animeList, "Success");
                }

                @Override
                public void onCancelled(@NonNull DatabaseError error) {
                    listener.onError("Error Pulling Saved");
                }
            });
        }
        else {
            try {
                call.enqueue(new Callback<Topanime>() {
                    @Override
                    public void onResponse(Call<Topanime> call, Response<Topanime> response) {
                        if (!response.isSuccessful()) {
                            Toast.makeText(context, "Error happened!", Toast.LENGTH_SHORT).show();
                        }

                        listener.onFetchData(response.body().getData(), response.message());
                        Log.d(TAG, "onResponse: " + response.body().getData());
                    }

                    @Override
                    public void onFailure(Call<Topanime> call, Throwable t) {
                        listener.onError("Request has Failed!");

                    }
                });
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
        }
    }

    public void getSearchAnimes(OnFetchDataListenerSearch<Topanime> listener, String q, String order_by, String sort, Integer limit){
        CallSearchApi callSearchApi = retrofit2.create(CallSearchApi.class);
        Call<Topanime> call2 = callSearchApi.searchAnimes(q,order_by,sort,limit);

        try {
            call2.enqueue(new Callback<Topanime>() {
                @Override
                public void onResponse(Call<Topanime> call, Response<Topanime> response) {
                    if(!response.isSuccessful()){
                        Toast.makeText(context,"Error happened!", Toast.LENGTH_SHORT).show();
                    }

                    listener.onFetchData(response.body().getData(), response.message());
                    Log.d(TAG, "onResponse: "+ response.body().getData());
                }

                @Override
                public void onFailure(Call<Topanime> call, Throwable t) {
                    listener.onError("Request has Failed!");

                }
            });
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public APICallManager(Context context) {
        this.context = context;
    }


    public interface CallTopAnimeApi{
        @GET("anime")
        Call<Topanime> topAnimes(
                @Query("filter") String filter,
                @Query("limit") Integer limit
        );
    }

    public interface CallSearchApi{
        @GET("anime")
        Call<Topanime> searchAnimes(
                @Query("q") String q,
                @Query("status") String order_by,
                @Query("sfw") String sort,
                @Query("limit") Integer limit
        );
    }

}
