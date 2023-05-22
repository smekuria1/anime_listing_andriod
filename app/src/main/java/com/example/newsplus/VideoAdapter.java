package com.example.newsplus;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.newsplus.models.Datum;
import com.pierfrancescosoffritti.androidyoutubeplayer.core.player.YouTubePlayer;
import com.pierfrancescosoffritti.androidyoutubeplayer.core.player.listeners.AbstractYouTubePlayerListener;
import com.pierfrancescosoffritti.androidyoutubeplayer.core.player.views.YouTubePlayerView;

import java.util.List;

public class VideoAdapter extends RecyclerView.Adapter<VideoAdapter.VideoViewHolder> {

    private List<Datum> videoItems;

    public VideoAdapter(List<Datum> videoItems) {
        this.videoItems = videoItems;
    }

    @NonNull
    @Override
    public VideoViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.trailer_item, parent, false);
        return new VideoViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull VideoViewHolder holder, int position) {
        Datum videoItem = videoItems.get(position);
        holder.title.setText(videoItem.getTitle());

        holder.youtubePlayerView.addYouTubePlayerListener(new AbstractYouTubePlayerListener() {
            @Override
            public void onReady(@NonNull YouTubePlayer youTubePlayer) {
                String videoId;
                if(videoItem.getTrailer() != null){
                    videoId = videoItem.getTrailer().getYoutubeId();
                }
                else {
                    videoId = "dQw4w9WgXcQ";
                }
                youTubePlayer.loadVideo(videoId, 0);


            }
        });
    }

    @Override
    public int getItemCount() {
        return videoItems.size();
    }

    public static class VideoViewHolder extends RecyclerView.ViewHolder {

        YouTubePlayerView youtubePlayerView;
        ImageView thumbnail;
        TextView title;

        public VideoViewHolder(@NonNull View itemView) {
            super(itemView);
            youtubePlayerView = itemView.findViewById(R.id.youtube_player_view);
            thumbnail = itemView.findViewById(R.id.thumbnail);
            title = itemView.findViewById(R.id.title);
        }
    }
}
