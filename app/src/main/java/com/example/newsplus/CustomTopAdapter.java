package com.example.newsplus;

import static android.content.ContentValues.TAG;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.newsplus.models.Datum;
import com.example.newsplus.models.Topanime;
import com.squareup.picasso.Picasso;

import java.util.List;

public class CustomTopAdapter  extends RecyclerView.Adapter<CustomViewHolder> {

    private Context context;
    private List<Datum> topanimes;
    private SelectedListener selectedListener;

    public CustomTopAdapter(Context context, List<Datum> topanimes, SelectedListener selectedListener) {
        this.context = context;
        this.topanimes = topanimes;
        this.selectedListener = selectedListener;
    }

    @NonNull
    @Override
    public CustomViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new CustomViewHolder(LayoutInflater.from(context).inflate(R.layout.headline_genre_items, parent, false));
    }

    @Override
    public void onBindViewHolder(@NonNull CustomViewHolder holder, int position) {
        holder.text_tile.setText(topanimes.get(position).getTitles().get(0).getTitle());
        holder.text_source.setText(topanimes.get(position).getGenres().get(0).getName());
        if(topanimes.get(position).getImages().getWebp().getSmallImageUrl() != null){

            Picasso.get().load(topanimes.get(position).getImages().getWebp().getImageUrl()).into(holder.img_headline);

        }

        holder.cardView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                selectedListener.onAnimeClicked(topanimes.get(holder.getAdapterPosition()));
            }
        });
    }

    @Override
    public int getItemCount() {
        return topanimes.size();
    }
}
