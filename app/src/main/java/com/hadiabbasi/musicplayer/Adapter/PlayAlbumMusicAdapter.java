package com.hadiabbasi.musicplayer.Adapter;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.hadiabbasi.musicplayer.Model.Music;
import com.hadiabbasi.musicplayer.PlayMusicActivity;
import com.hadiabbasi.musicplayer.R;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;

public class PlayAlbumMusicAdapter extends RecyclerView.Adapter<PlayAlbumMusicAdapter.ViewHolder> {

    private Context context;
    private ArrayList<Music> music = new ArrayList<Music>();

    public PlayAlbumMusicAdapter(Context context) {
        this.context = context;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.item_play_music, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {

        holder.music_name.setText(music.get(position).getMusic_name());
        holder.singer_name.setText(music.get(position).getSinger_name());
        holder.music_time.setText(music.get(position).getMusic_time());
        Picasso.get()
                .load(music.get(position).getMusic_image_link())
                .into(holder.img);

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(context, PlayMusicActivity.class);
                intent.putExtra("name", music.get(holder.getAdapterPosition()).getMusic_name());
                intent.putExtra("singer", music.get(holder.getAdapterPosition()).getSinger_name());
                intent.putExtra("time", music.get(holder.getAdapterPosition()).getMusic_time());
                intent.putExtra("image",music.get(holder.getAdapterPosition()).getMusic_image_link());
                context.startActivity(intent);
            }
        });
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
        private TextView music_name, singer_name, music_time;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            img = itemView.findViewById(R.id.img);
            music_name = itemView.findViewById(R.id.music_name);
            singer_name = itemView.findViewById(R.id.singer_name);
            music_time = itemView.findViewById(R.id.music_time);
        }
    }
}
