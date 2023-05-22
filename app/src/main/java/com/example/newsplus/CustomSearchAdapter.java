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
import com.squareup.picasso.Picasso;

import java.util.List;

public class CustomSearchAdapter extends RecyclerView.Adapter<CustomSearchViewHolder> {

    private Context context;
    private List<Datum> topanimes;
    private SelectedListenerSearch_2 selectedListner_2;

    public CustomSearchAdapter(Context context, List<Datum> topanimes, SelectedListenerSearch_2 selectedListner_2) {
        this.context = context;
        this.topanimes = topanimes;
        this.selectedListner_2 = selectedListner_2;
    }

    @NonNull
    @Override
    public CustomSearchViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new CustomSearchViewHolder(LayoutInflater.from(context).inflate(R.layout.search_items, parent, false));
    }

    @Override
    public void onBindViewHolder(@NonNull CustomSearchViewHolder holder, int position) {
        holder.text_tile_2.setText(topanimes.get(position).getTitles().get(0).getTitle());
        if(!topanimes.get(position).getGenres().isEmpty()) {
            Log.d(TAG, "onBindViewHolder: "+topanimes.get(position).getGenres());
            holder.text_source_2.setText(topanimes.get(position).getGenres().get(0).getName());
        }
        else{
            holder.text_source_2.setText("Not Found");
        }
        if(topanimes.get(position).getImages().getWebp().getSmallImageUrl() != null){

            Picasso.get().load(topanimes.get(position).getImages().getWebp().getImageUrl()).into(holder.img_headline_2);

        }

        holder.cardView_2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                selectedListner_2.onAnimeClicked_2(topanimes.get(holder.getAdapterPosition()));
            }
        });
    }

    @Override
    public int getItemCount() {
        return topanimes.size();
    }
}
