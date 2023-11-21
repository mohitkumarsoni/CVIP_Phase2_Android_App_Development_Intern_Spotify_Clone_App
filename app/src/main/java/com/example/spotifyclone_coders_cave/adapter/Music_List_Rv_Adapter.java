package com.example.spotifyclone_coders_cave.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.spotifyclone_coders_cave.R;
import com.example.spotifyclone_coders_cave.databinding.MusicListTilesBinding;
import com.example.spotifyclone_coders_cave.model.Music_List_Model;

import java.util.ArrayList;

public class Music_List_Rv_Adapter extends RecyclerView.Adapter<Music_List_Rv_Adapter.MusicListViewHolder> {
    private Context context;
    private ArrayList<Music_List_Model> musicList;

    public Music_List_Rv_Adapter(Context context, ArrayList<Music_List_Model> musicList) {
        this.context = context;
        this.musicList = musicList;
    }

    @NonNull
    @Override
    public MusicListViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.music_list_tiles, parent, false);
        return new MusicListViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MusicListViewHolder holder, int position) {
        Music_List_Model data = musicList.get(position);

        Glide.with(context).load(data.getPosterImg()).into(holder.binding.musicTilePoster);
        holder.binding.musicTitleTextTv.setText(data.getSongName());
        holder.binding.musicTitleDurationTv.setText(data.getSongDuration());

    }

    @Override
    public int getItemCount() {
        return musicList.size();
    }

    public class MusicListViewHolder extends RecyclerView.ViewHolder {
        MusicListTilesBinding binding;
        public MusicListViewHolder(@NonNull View itemView) {
            super(itemView);
            binding = MusicListTilesBinding.bind(itemView);
        }
    }
}
