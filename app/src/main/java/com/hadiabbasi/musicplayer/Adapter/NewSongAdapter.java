package com.hadiabbasi.musicplayer.Adapter;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import com.hadiabbasi.musicplayer.Model.Album;
import com.hadiabbasi.musicplayer.Model.Music;
import com.hadiabbasi.musicplayer.PlayMusicActivity;
import com.hadiabbasi.musicplayer.R;
import com.hadiabbasi.musicplayer.databinding.ItemNewAlbumsBinding;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;

import eightbitlab.com.blurview.BlurView;
import eightbitlab.com.blurview.RenderScriptBlur;

public class NewSongAdapter extends RecyclerView.Adapter<NewSongAdapter.ViewHolder> {

    private ItemNewAlbumsBinding binding;
    private ArrayList<Music> data = new ArrayList<>();
    private Context context;

    public NewSongAdapter(ArrayList<Music> data, Context context) {
        this.data = data;
        this.context = context;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_new_song, parent, false);
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

        private ImageView song_image;
        private CardView parent;
        private BlurView blur_view;
        private TextView singer_name, song_name;
        BlurView blur;


        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            parent = itemView.findViewById(R.id.parent);
            blur_view = itemView.findViewById(R.id.blur_view);
            song_image = itemView.findViewById(R.id.song_image);
            singer_name = itemView.findViewById(R.id.singer_name);
            song_name = itemView.findViewById(R.id.song_name);
            blur_view.setupWith(parent)
                    .setBlurAlgorithm(new RenderScriptBlur(context))
                    .setHasFixedTransformationMatrix(true)
                    .setBlurRadius(25f);
        }

        private void setData(){
            Picasso.get()
                    .load(data.get(getAdapterPosition()).getMusic_image_link())
                    .fit()
                    .error(R.drawable.ic_launcher_background)
                    .into(song_image);
            singer_name.setText(data.get(getAdapterPosition()).getSinger_name());
            song_name.setText(data.get(getAdapterPosition()).getMusic_name());
            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Intent intent = new Intent(context, PlayMusicActivity.class);
                    intent.putExtra("name", data.get(getAdapterPosition()).getMusic_name());
                    intent.putExtra("singer", data.get(getAdapterPosition()).getSinger_name());
                    intent.putExtra("time", data.get(getAdapterPosition()).getMusic_time());
                    intent.putExtra("image",data.get(getAdapterPosition()).getMusic_image_link());
                    context.startActivity(intent);
                }
            });
        }


    }
}
