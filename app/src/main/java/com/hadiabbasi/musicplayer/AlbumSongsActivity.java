package com.hadiabbasi.musicplayer;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.hadiabbasi.musicplayer.Adapter.PlayAlbumMusicAdapter;
import com.hadiabbasi.musicplayer.Model.Music;
import com.hadiabbasi.musicplayer.databinding.ActivityAlbumSongsBinding;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;

public class AlbumSongsActivity extends AppCompatActivity {

    private ActivityAlbumSongsBinding binding;
//    private Bundle bundle = getIntent().getExtras();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        binding = ActivityAlbumSongsBinding.inflate(getLayoutInflater());
        super.onCreate(savedInstanceState);
        setContentView(binding.getRoot());

        setMusicRecData(setMusics());

        setActivityData();

        binding.forwardBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onBackPressed();
            }
        });



    }

    private ArrayList<Music> setMusics(){
        ArrayList<Music> musics = new ArrayList<>();
        musics.add(new Music("محسن چاووشی","ببر به نام خداوندت","4:30","https://upload.wikimedia.org/wikipedia/en/thumb/5/5e/MChavoshi_Abraham.png/220px-MChavoshi_Abraham.png"));
        musics.add(new Music("محسن چاووشی","تو در مسافت بارانی","4:56","https://upload.wikimedia.org/wikipedia/en/thumb/5/5e/MChavoshi_Abraham.png/220px-MChavoshi_Abraham.png"));
        musics.add(new Music("محسن چاووشی","در آستانه پیری","3:30","https://upload.wikimedia.org/wikipedia/en/thumb/5/5e/MChavoshi_Abraham.png/220px-MChavoshi_Abraham.png"));
        musics.add(new Music("محسن چاووشی","همراه خاک اره","4:21","https://upload.wikimedia.org/wikipedia/en/thumb/5/5e/MChavoshi_Abraham.png/220px-MChavoshi_Abraham.png"));
        musics.add(new Music("محسن چاووشی","لطفا به بند اول سبابه ات بگو","3:46","https://upload.wikimedia.org/wikipedia/en/thumb/5/5e/MChavoshi_Abraham.png/220px-MChavoshi_Abraham.png"));
        musics.add(new Music("محسن چاووشی","ای ماه مهر","4:39","https://upload.wikimedia.org/wikipedia/en/thumb/5/5e/MChavoshi_Abraham.png/220px-MChavoshi_Abraham.png"));
        musics.add(new Music("محسن چاووشی","ما بزرگ ندانیم","5:32","https://upload.wikimedia.org/wikipedia/en/thumb/5/5e/MChavoshi_Abraham.png/220px-MChavoshi_Abraham.png"));
        musics.add(new Music("محسن چاووشی","جهان فاسد مردم را","3:12","https://upload.wikimedia.org/wikipedia/en/thumb/5/5e/MChavoshi_Abraham.png/220px-MChavoshi_Abraham.png"));
        return musics;

    }

    private void setMusicRecData(ArrayList<Music> musics){
        PlayAlbumMusicAdapter adapter = new PlayAlbumMusicAdapter(this);
        adapter.setMusic(musics);
        binding.albumSongsRec.setAdapter(adapter);
        binding.albumSongsRec.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false));
    }

    private void setActivityData(){
        binding.albumName.setText(getIntent().getStringExtra("album_name"));
        Picasso.get()
                .load(getIntent().getStringExtra("album_image"))
                .into(binding.albumImage);
        binding.singerName.setText(getIntent().getStringExtra("singer_name"));
    }
}