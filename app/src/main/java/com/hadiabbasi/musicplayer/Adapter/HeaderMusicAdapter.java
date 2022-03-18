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

public class HeaderMusicAdapter extends RecyclerView.Adapter<HeaderMusicAdapter.ViewHolder> {

    private Context context;
    private ArrayList<Music> music = new ArrayList<Music>();

    public HeaderMusicAdapter(Context context) {
        this.context = context;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.item_header_music, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {

        holder.music_name.setText(music.get(position).getMusic_name());
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
        private TextView music_name;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            img = itemView.findViewById(R.id.img);
            music_name = itemView.findViewById(R.id.music_name);
        }
    }
}
