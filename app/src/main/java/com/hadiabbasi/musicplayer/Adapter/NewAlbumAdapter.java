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

import com.hadiabbasi.musicplayer.AlbumSongsActivity;
import com.hadiabbasi.musicplayer.Model.Album;
import com.hadiabbasi.musicplayer.R;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;

public class NewAlbumAdapter extends RecyclerView.Adapter<NewAlbumAdapter.ViewHolder> {

    private ArrayList<Album> data = new ArrayList<>();
    private Context context;

    public NewAlbumAdapter(ArrayList<Album> data, Context context) {
        this.data = data;
        this.context = context;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_new_albums, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.setData();
    }

    @Override
    public int getItemCount() {
        return data.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{

        private ImageView album_image;
        private TextView album_name, like_count_number, music_count;


        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            album_image = itemView.findViewById(R.id.album_image);
            album_name = itemView.findViewById(R.id.album_name);
            like_count_number = itemView.findViewById(R.id.like_count_number);
            music_count = itemView.findViewById(R.id.music_count);
        }

        private void setData(){
            Picasso.get()
                    .load(data.get(getAdapterPosition()).getImage_url())
                    .fit()
                    .error(R.drawable.ic_launcher_background)
                    .into(album_image);
            album_name.setText(data.get(getAdapterPosition()).getName());
            like_count_number.setText("("+data.get(getAdapterPosition()).getFav_count()+"K)");
            music_count.setText(data.get(getAdapterPosition()).getSong_count());
            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Intent intent = new Intent(context, AlbumSongsActivity.class);
                    intent.putExtra("album_image", data.get(getAdapterPosition()).getImage_url());
                    intent.putExtra("album_name", data.get(getAdapterPosition()).getName());
                    intent.putExtra("singer_name", data.get(getAdapterPosition()).getSinger_name());
                    context.startActivity(intent);
                }
            });
        }
    }
}
