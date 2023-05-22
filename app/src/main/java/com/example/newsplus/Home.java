package com.example.newsplus;

import static android.content.ContentValues.TAG;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.example.newsplus.models.Datum;
import com.example.newsplus.models.Topanime;
import com.google.android.gms.auth.api.signin.GoogleSignIn;
import com.google.android.gms.auth.api.signin.GoogleSignInAccount;
import com.google.android.gms.auth.api.signin.GoogleSignInClient;
import com.google.android.gms.auth.api.signin.GoogleSignInOptions;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

import java.util.List;

public class Home extends AppCompatActivity implements SelectedListener, View.OnClickListener{
    RecyclerView recyclerView;
    CustomTopAdapter adapter;

    ProgressDialog dialog;
    FirebaseAuth mAuth;
    FirebaseUser mUser;
    Button b1,b2,b3,b4,b5;
    String uuid;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        mAuth = FirebaseAuth.getInstance();
        mUser = mAuth.getCurrentUser();

        uuid = mUser.getUid();
        dialog = new ProgressDialog(this);
        dialog.setTitle("Getting Top Animes");
        dialog.show();

        Toolbar myToolbar = findViewById(R.id.my_toolbar);
        setSupportActionBar(myToolbar);

        b1 = findViewById(R.id.airingBtn);
        b1.setOnClickListener(this);
        b2 = findViewById(R.id.upcomingBtn);
        b2.setOnClickListener(this);
        b3 = findViewById(R.id.popularity);
        b3.setOnClickListener(this);
        b4 = findViewById(R.id.favoriteBtn);
        b4.setOnClickListener(this);
        b5 = findViewById(R.id.listSavedBtn);
        b5.setOnClickListener(this);




        APICallManager manager = new APICallManager(this);
        manager.getTopAnimes(listener, "", 25);


  }

  private final OnFetchDataListener<Topanime> listener = new OnFetchDataListener<Topanime>() {
      @Override
      public void onFetchData(List<Datum> list, String message) {
          showNews(list);
          dialog.dismiss();
      }

      @Override
      public void onError(String message) {

      }
  };

    private void showNews(List<Datum> list) {
        recyclerView = findViewById(R.id.recycler_Main);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new GridLayoutManager(this, 1));
        adapter = new CustomTopAdapter(this, list, this);
        recyclerView.setAdapter(adapter);
    }


    @Override
    public void onAnimeClicked(Datum datum) {
        startActivity(new Intent(Home.this, ShowDetails.class)
                .putExtra("data", datum));
    }

    @Override
    public void onClick(View v) {
        Button button = (Button) v;
        String filter = button.getText().toString();

        dialog.setTitle("Fetching  " + filter);
        dialog.show();
        APICallManager manager = new APICallManager(this);
        manager.getTopAnimes(listener, filter, 25);


    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()){
            case R.id.trailer:
                Intent intent = new Intent(this, Trailer.class);
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