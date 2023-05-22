package com.example.newsplus;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.SearchView;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.app.ProgressDialog;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.Toast;

import com.example.newsplus.models.Datum;
import com.example.newsplus.models.Topanime;
import com.google.firebase.auth.FirebaseAuth;

import java.util.List;

public class SearchAnime extends AppCompatActivity implements SelectedListenerSearch_2 {
    SearchView searchView;
    RecyclerView recyclerView;
    CustomSearchAdapter customSearchAdapter;

    ProgressDialog dialog;

    FirebaseAuth mAuth;
    CheckBox sfw,comp;
    String status,SFW;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search_anime);
        mAuth = FirebaseAuth.getInstance();
        searchView = findViewById(R.id.search_view);
        Toolbar myToolbar = findViewById(R.id.my_toolbar);
        setSupportActionBar(myToolbar);

        sfw = findViewById(R.id.SFW);
        comp = findViewById(R.id.comp);
        status = "complete";
        SFW = "false";
        sfw.setOnCheckedChangeListener((buttonView, isChecked) -> {
            if(isChecked){
                SFW = "true";
            }else{
                SFW = "false";
            }
        });

        comp.setOnCheckedChangeListener(((buttonView, isChecked) -> {
            if(isChecked){
                status = "airing";
            }else{
                status = "complete";
            }
        }));

        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {
                dialog = new ProgressDialog(SearchAnime.this);
                dialog.setTitle("Searching Animes");
                dialog.show();
                APICallManager manager = new APICallManager(SearchAnime.this);
                manager.getSearchAnimes(listenerSearch,query,status,SFW,5);

                return true;
            }

            @Override
            public boolean onQueryTextChange(String newText) {
                return false;
            }
        });



    }



    @Override
    public void onAnimeClicked_2(Datum datum) {
        startActivity(new Intent(SearchAnime.this, ShowDetails.class)
                .putExtra("data", datum));
    }

    private final OnFetchDataListenerSearch<Topanime> listenerSearch = new OnFetchDataListenerSearch<Topanime>() {
        @Override
        public void onFetchData(List<Datum> list, String message) {
            if(list.isEmpty()){
                dialog.dismiss();
                Toast.makeText(SearchAnime.this, "No Shows Found ", Toast.LENGTH_SHORT).show();
            }
            else {
                showSearches(list);
                dialog.dismiss();

            }
        }

        @Override
        public void onError(String message) {
            Toast.makeText(SearchAnime.this, "An error Occurred", Toast.LENGTH_SHORT).show();

        }
    };

    private void showSearches(List<Datum> list) {
        recyclerView = findViewById(R.id.recycler_Search);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new GridLayoutManager(this, 1));
        customSearchAdapter = new CustomSearchAdapter(this,list,this);
        recyclerView.setAdapter(customSearchAdapter);

    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()){
            case R.id.trailer:
                Intent intent = new Intent(this, Trailer.class);
                startActivity(intent);
                return true;

            case R.id.home_icon:
                Intent intent2 = new Intent(this, Home.class);
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