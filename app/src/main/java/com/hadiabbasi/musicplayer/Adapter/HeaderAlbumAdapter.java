package com.hadiabbasi.musicplayer.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.hadiabbasi.musicplayer.Model.Music;
import com.hadiabbasi.musicplayer.R;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;

public class HeaderAlbumAdapter extends RecyclerView.Adapter<HeaderAlbumAdapter.ViewHolder> {

    private Context context;
    private ArrayList<Music> music = new ArrayList<Music>();

    public HeaderAlbumAdapter(Context context) {
        this.context = context;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.item_header_album, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {

        Picasso.get()
                .load(music.get(position).getMusic_image_link())
                .into(holder.img);
    }

    @Override
    public int getItemCount() {
        return music.size();
    }

    public void setMusic(ArrayList<Music> music){
        this.music = music;
    }

    public class ViewHolder extends RecyclerView.ViewHolder{

        private ImageView img;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            img = itemView.findViewById(R.id.img);
        }
    }
}
