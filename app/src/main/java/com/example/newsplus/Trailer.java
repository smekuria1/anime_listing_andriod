package com.example.newsplus;

import static android.content.ContentValues.TAG;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.newsplus.models.Datum;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;



public class Trailer extends AppCompatActivity {
    RecyclerView recyclerView;
    VideoAdapter adapter;
    List<Datum> videoItems;
    FirebaseAuth mAuth;
    DatabaseReference mDatabase;
    FirebaseUser mUser;
    String uuid;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_trailer);
        mAuth = FirebaseAuth.getInstance();
        mUser = mAuth.getCurrentUser();
        Log.d(TAG, "Trailer: get savedS");
        uuid = mUser.getUid();
        mDatabase = FirebaseDatabase.getInstance().getReference("animes").child(uuid);
        Log.d(TAG, "Trailer: get savedS"+uuid);
        Toolbar myToolbar = findViewById(R.id.my_toolbar);
        setSupportActionBar(myToolbar);
        getSavedAnimes();
        recyclerView = findViewById(R.id.videoRecycler);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setHasFixedSize(true);



    }

    private void getSavedAnimes() {
        Log.d(TAG, "onDataChange trailer: Going into function");
        mDatabase.addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                List<Datum> animeList = new ArrayList<>();
                for(DataSnapshot snapshot1: snapshot.getChildren()){
                    Datum anime = snapshot1.getValue(Datum.class);
                    animeList.add(anime);
                }
                videoItems = animeList;
                Log.d(TAG, "onDataChange trailer:"+animeList.toArray().length);
                adapter = new VideoAdapter(videoItems);
                recyclerView.setAdapter(adapter);
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {
                Toast.makeText(Trailer.this, error.getMessage(), Toast.LENGTH_SHORT).show();
            }
        });
    }
    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()){
            case R.id.home_icon:
                Intent intent = new Intent(this, Home.class);
                startActivity(intent);
                return true;

            case R.id.search:
                Intent intent2 = new Intent(this, SearchAnime.class);
                startActivity(intent2);
                return true;
            case R.id.logout:
                mAuth.signOut();
                Intent intent3 = new Intent(this, MainActivity.class);
                startActivity(intent3);
            default:
                return super.onOptionsItemSelected(item);

        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu){
        getMenuInflater().inflate(R.menu.menu_bar, menu);
        return true;
    }



}