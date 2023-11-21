package com.example.spotifyclone_coders_cave.adapter;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;
import com.example.spotifyclone_coders_cave.R;
import com.example.spotifyclone_coders_cave.activity.Music_List_Activity;
import com.example.spotifyclone_coders_cave.databinding.CoverImageAndNameBinding;
import com.example.spotifyclone_coders_cave.model.Album_Cover_info;

import java.util.ArrayList;

public class Artist_Cover_Image_And_Name_Adapter extends RecyclerView.Adapter<Artist_Cover_Image_And_Name_Adapter.CoverViewHolder> {
    private Context context;
    private ArrayList<Album_Cover_info> albumCover_ArrayList;

    public Artist_Cover_Image_And_Name_Adapter(Context context, ArrayList<Album_Cover_info> albumCover_ArrayList) {
        this.context = context;
        this.albumCover_ArrayList = albumCover_ArrayList;
    }

    @NonNull
    @Override
    public CoverViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.cover_image_and_name, parent, false);
        return new CoverViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull CoverViewHolder holder, int position) {
        Album_Cover_info cover = albumCover_ArrayList.get(position);

        Glide.with(context).load(cover.getImage()).apply(RequestOptions.circleCropTransform()).into(holder.coverImageAndNameBinding.coverIv);
        holder.coverImageAndNameBinding.coverNameTv.setText(cover.getText());

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(context, Music_List_Activity.class);
                intent.putExtra("cover_image", cover.getImage());
                intent.putExtra("cover_text", cover.getText());
                context.startActivity(intent);
            }
        });

    }

    @Override
    public int getItemCount() {
        return albumCover_ArrayList.size();
    }

    public class CoverViewHolder extends RecyclerView.ViewHolder {
        CoverImageAndNameBinding coverImageAndNameBinding;
        public CoverViewHolder(@NonNull View itemView) {
            super(itemView);
            coverImageAndNameBinding = CoverImageAndNameBinding.bind(itemView);

//            itemView.setOnClickListener(new View.OnClickListener() {
//                @Override
//                public void onClick(View view) {
////                    Toast.makeText(context, "reached to itemview", Toast.LENGTH_SHORT).show();
//                    Intent intent = new Intent(context, Music_List_Activity.class);
//                    intent.putExtra("cover_image", albumCover_ArrayList.get(getAdapterPosition()).getImage());
//                    intent.putExtra("cover_text", albumCover_ArrayList.get(getAdapterPosition()).getText());
//                    context.startActivity(intent);
//                }
//            });
        }
    }
}
