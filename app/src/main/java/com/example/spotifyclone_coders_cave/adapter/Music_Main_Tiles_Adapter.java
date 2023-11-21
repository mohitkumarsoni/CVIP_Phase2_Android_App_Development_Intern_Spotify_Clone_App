package com.example.spotifyclone_coders_cave.adapter;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.spotifyclone_coders_cave.R;
import com.example.spotifyclone_coders_cave.activity.Music_List_Activity;
import com.example.spotifyclone_coders_cave.databinding.HomeMusicOptionTilesBinding;
import com.example.spotifyclone_coders_cave.model.Home_Music_Tiles_Model;

import java.util.ArrayList;

public class Music_Main_Tiles_Adapter extends RecyclerView.Adapter<Music_Main_Tiles_Adapter.MusicTiles_ViewHolder> {

    private Context context;
    private ArrayList<Home_Music_Tiles_Model> music_tiles_models_list;

    public Music_Main_Tiles_Adapter(Context context, ArrayList<Home_Music_Tiles_Model> music_tiles_models_list) {
        this.context = context;
        this.music_tiles_models_list = music_tiles_models_list;
    }

    @NonNull
    @Override
    public MusicTiles_ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.home_music_option_tiles, parent, false);
        return new MusicTiles_ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MusicTiles_ViewHolder holder, int position) {
        Home_Music_Tiles_Model model = music_tiles_models_list.get(position);

        holder.binding.musicTypeTv.setText(model.getMusic_type());
        Glide.with(context).load(model.getMusic_title_image_iv()).into(holder.binding.musicTileImageIv);
        holder.binding.artistNameTv.setText(model.getArtist_name());
        holder.binding.musicNameTv.setText(model.getMusic_name());
        holder.binding.musicDescriptionTv.setText(model.getMusic_description());
        holder.binding.musicYearTv.setText(model.getMusic_year_of_production());
        Glide.with(context).load(model.getMusic_poster()).into(holder.binding.musicPosterIv);

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(context, Music_List_Activity.class);
                intent.putExtra("cover_image", model.getMusic_title_image_iv());
                intent.putExtra("cover_text", model.getMusic_name());
                context.startActivity(intent);
            }
        });

    }

    @Override
    public int getItemCount() {
        return music_tiles_models_list.size();
    }

    public class MusicTiles_ViewHolder extends RecyclerView.ViewHolder {
        HomeMusicOptionTilesBinding binding;
        public MusicTiles_ViewHolder(@NonNull View itemView) {
            super(itemView);
            binding = HomeMusicOptionTilesBinding.bind(itemView);
        }
    }
}
