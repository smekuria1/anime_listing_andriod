package com.example.newsplus;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

public class CustomSearchViewHolder extends RecyclerView.ViewHolder {
    TextView text_tile_2, text_source_2;
    ImageView img_headline_2;
    CardView cardView_2;

    public CustomSearchViewHolder(@NonNull View itemView) {
        super(itemView);
        text_tile_2 = itemView.findViewById(R.id.text_title_2);
        text_source_2 = itemView.findViewById(R.id.text_source_2);
        img_headline_2 = itemView.findViewById(R.id.img_headline_2);
        cardView_2 = itemView.findViewById(R.id.main_container_2);

    }
}
