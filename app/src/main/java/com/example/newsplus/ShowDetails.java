package com.example.newsplus;

import static android.content.ContentValues.TAG;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.newsplus.models.Datum;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.squareup.picasso.Picasso;

public class ShowDetails extends AppCompatActivity {
    Datum topanime;
    TextView txt_title, txt_popularity, txt_rating, txt_synopsis, txt_synopsis_content;
    ImageView img_anime;
    Button saveBtn;
    FirebaseAuth mAuth;
    FirebaseUser mUser;


    String uuid;

    @SuppressLint("SetTextI18n")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_show_details);
        Toolbar myToolbar = findViewById(R.id.my_toolbar);
        setSupportActionBar(myToolbar);

        mAuth = FirebaseAuth.getInstance();
        mUser = mAuth.getCurrentUser();

        uuid = mUser.getUid();

        FirebaseDatabase database = FirebaseDatabase.getInstance();
        DatabaseReference myRef = database.getReference("animes");

        myRef.get().addOnCompleteListener(new OnCompleteListener<DataSnapshot>() {
            @Override
            public void onComplete(@NonNull Task<DataSnapshot> task) {
                if(!task.isSuccessful()){
                    Log.e("firebase", "error", task.getException());
                }
                else{
                    Log.d("firebase", String.valueOf(task.getResult()));
                }
            }
        });


        saveBtn = findViewById(R.id.saveAnime);


        txt_title = findViewById(R.id.text_detail_title);
        txt_popularity = findViewById(R.id.text_detail_popularity);
        txt_rating = findViewById(R.id.text_detail_rating);
        txt_synopsis = findViewById(R.id.text_detail_synopsis);
        txt_synopsis_content = findViewById(R.id.text_detail_synopsis_content);
        img_anime = findViewById(R.id.img_detail);

        topanime = (Datum) getIntent().getSerializableExtra("data");

        saveBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try{
                    myRef.child(uuid).push().setValue(topanime).addOnCompleteListener(new OnCompleteListener<Void>() {
                        @Override
                        public void onComplete(@NonNull Task<Void> task) {
                            Toast.makeText(ShowDetails.this, "Success", Toast.LENGTH_SHORT).show();
                        }
                    });
                } catch (Exception e) {
                    Toast.makeText(ShowDetails.this, "Error Happened Saving to DB", Toast.LENGTH_SHORT).show();
                    throw new RuntimeException(e);
                }
            }
        });


        txt_title.setText(topanime.getTitles().get(0).getTitle());
        txt_popularity.setText("Popularity "+topanime.getPopularity().toString());
        txt_rating.setText(topanime.getRating());
        txt_synopsis.setText(topanime.getSeason());
        txt_synopsis_content.setText(topanime.getSynopsis());
        Picasso.get().load(topanime.getImages().getWebp().getLargeImageUrl()).into(img_anime);
        Log.d(TAG, "onCreate: "+topanime);


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
            case R.id.home_icon:
                Intent intent3 = new Intent(this, Home.class);
                startActivity(intent3);
                return true;
            default:
                return super.onOptionsItemSelected(item);

        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu){
        getMenuInflater().inflate(R.menu.menu_bar, menu);
        return true;
    }
    @Override
    public boolean onPrepareOptionsMenu(Menu menu) {
        return true;
    }
}