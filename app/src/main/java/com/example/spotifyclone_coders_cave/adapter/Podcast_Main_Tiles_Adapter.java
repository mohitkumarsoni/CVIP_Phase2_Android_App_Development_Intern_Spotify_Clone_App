package com.example.spotifyclone_coders_cave.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.spotifyclone_coders_cave.R;
import com.example.spotifyclone_coders_cave.databinding.HomePodcastsOptionTilesBinding;
import com.example.spotifyclone_coders_cave.model.Home_Podcasts_Tiles_Model;

import java.util.ArrayList;

public class Podcast_Main_Tiles_Adapter extends RecyclerView.Adapter<Podcast_Main_Tiles_Adapter.PodcastTilesViewHolder> {
    private Context context;
    private ArrayList<Home_Podcasts_Tiles_Model> podcastList;

    public Podcast_Main_Tiles_Adapter(Context context, ArrayList<Home_Podcasts_Tiles_Model> podcastList) {
        this.context = context;
        this.podcastList = podcastList;
    }

    @NonNull
    @Override
    public PodcastTilesViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.home_podcasts_option_tiles, parent, false);
        return new PodcastTilesViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull PodcastTilesViewHolder holder, int position) {
        Home_Podcasts_Tiles_Model pod_data = podcastList.get(position);

        Glide.with(context).load(pod_data.getPodcast_img()).into(holder.binding.podcastIv);
        holder.binding.podTitleTv.setText(pod_data.getPod_title());
        holder.binding.episodeNameTv.setText(pod_data.getPod_episode_name());
        holder.binding.podDescTv.setText(pod_data.getPod_description());
        holder.binding.podTimeDurationTv.setText(pod_data.getPod_time_duration());

    }

    @Override
    public int getItemCount() {
        return podcastList.size();
    }

    public class PodcastTilesViewHolder extends RecyclerView.ViewHolder {
        HomePodcastsOptionTilesBinding binding;
        public PodcastTilesViewHolder(@NonNull View itemView) {
            super(itemView);
            binding = HomePodcastsOptionTilesBinding.bind(itemView);
        }
    }
}
