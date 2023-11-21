package com.example.spotifyclone_coders_cave.adapter;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.spotifyclone_coders_cave.R;
import com.example.spotifyclone_coders_cave.databinding.SearchBrowseTilesBinding;
import com.example.spotifyclone_coders_cave.model.Search_Browse_Tiles;

import java.util.ArrayList;

public class Search_Tiles_Adapter extends RecyclerView.Adapter<Search_Tiles_Adapter.TilesViewHolder> {
    private Context context;
    private ArrayList<Search_Browse_Tiles> tilesArrayList;

    public Search_Tiles_Adapter(Context context, ArrayList<Search_Browse_Tiles> tilesArrayList) {
        this.context = context;
        this.tilesArrayList = tilesArrayList;
    }

    @NonNull
    @Override
    public TilesViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.search_browse_tiles, parent, false);
        return new TilesViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull TilesViewHolder holder, int position) {
        Search_Browse_Tiles tiles = tilesArrayList.get(position);
        holder.binding.titleTv.setText(tiles.getTitle());
//        holder.binding.tileLayout.setBackground(tiles.getBgColor());
        Glide.with(context).load(tiles.getImage()).into(holder.binding.tileImage);
    }

    @Override
    public int getItemCount() {
        return tilesArrayList.size();
    }

    public class TilesViewHolder extends RecyclerView.ViewHolder {
        SearchBrowseTilesBinding binding;
        public TilesViewHolder(@NonNull View itemView) {
            super(itemView);
            binding = SearchBrowseTilesBinding.bind(itemView);
        }
    }

}
