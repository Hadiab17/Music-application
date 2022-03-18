package com.hadiabbasi.musicplayer.Fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.hadiabbasi.musicplayer.Adapter.HeaderAlbumAdapter;
import com.hadiabbasi.musicplayer.Adapter.HeaderMusicAdapter;
import com.hadiabbasi.musicplayer.Adapter.PlayMusicAdapter;
import com.hadiabbasi.musicplayer.Model.Music;
import com.hadiabbasi.musicplayer.R;

import java.util.ArrayList;

public class MusicFragment extends Fragment {

    //view widgets

    //var
    View view;

    //header_music rec
    private ArrayList<Music> header_music_list = new ArrayList<>();
    private RecyclerView header_music_rec;
    private HeaderMusicAdapter headerMusicAdapter;

    //album header rec
    private ArrayList<Music> header_album_list = new ArrayList<>();
    private RecyclerView header_album_rec;
    private HeaderAlbumAdapter headerAlbumAdapter;

    //play music rec
    private ArrayList<Music> play_music_list = new ArrayList<>();
    private RecyclerView play_music_rec;
    private PlayMusicAdapter playMusicAdapter;




    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_music, container, false);

        //initViews
        initViews();
        //set header music data
        setHeaderMusicData();
        //set header album data
        setHeaderAlbumData();
        //set play music data
        setPlayMusicData();
        return view;
    }

    private void setPlayMusicData(){
        play_music_list.add(new Music("رضا صادقی","خدا شاهده","4:30","https://www.topseda.ir/wp-content/uploads/2015/12/Reza-Sadeghi-Shab-Barooni.jpg"));
        play_music_list.add(new Music("محسن چاووشی","باب دلمی","4:56","https://music-fa.com/wp-content/uploads/2021/12/Mohsen-Chavoshi-Hanoozam-Oon-Shabaye-Music-fa.com_.jpg"));
        play_music_list.add(new Music("محسن چاووشی","دل مغموم","3:30","https://webahang.ir/wp-content/uploads/2019/12/Mohsen-Chavoshi-Shahrzad.jpg"));
        play_music_list.add(new Music("مهدی یراحی","وداع بعد از رفتن","4:21","https://upmusics.com/wp-content/uploads/2021/11/Mehdi-Yarrahi-Vedae-Bad-Az-Raftan.jpg"));
        play_music_list.add(new Music("مهدی یراحی","هوای تو","3:46","https://www.myfaza2music.net/wp-content/uploads/2017/08/Mehdi-Yarahi.jpg"));
        play_music_list.add(new Music("کاوه آفاق","عطر تو","4:39","https://sakhamusic.ir/wp-content/uploads/2016/01/Kaveh-Afagh-Dance-With-Pills.jpg"));
        play_music_list.add(new Music("رضا صادقی","ندارمت","5:32","https://www.topseda.ir/wp-content/uploads/2015/12/Reza-Sadeghi-Shab-Barooni.jpg"));
        play_music_list.add(new Music("ایهام","بغض","3:12","https://next1.ir/wp-content/uploads/2017/08/Ehaam-Boghz-480x480.jpg"));
        play_music_list.add(new Music("سیاوش قمیشی","نوازش ","5:53","https://jibmusic.com/wp-content/uploads/2021/12/Siavash%20Ghomayshi-Navazesh.jpg"));
        playMusicAdapter = new PlayMusicAdapter(getContext());
        playMusicAdapter.setMusic(play_music_list);
        play_music_rec.setAdapter(playMusicAdapter);
        play_music_rec.setLayoutManager(new LinearLayoutManager(getContext()));
    }

    private void setHeaderAlbumData() {
        header_album_list.add(new Music("https://upmusics.com/wp-content/uploads/2021/01/Mohsen-Chavoshi-Gandomgoon.jpg"));
        header_album_list.add(new Music("https://next1.ir/wp-content/uploads/2017/08/Ehaam-Boghz-480x480.jpg"));
        headerAlbumAdapter = new HeaderAlbumAdapter(getContext());
        headerAlbumAdapter.setMusic(header_album_list);
        header_album_rec.setAdapter(headerAlbumAdapter);
        header_album_rec.setLayoutManager(new LinearLayoutManager(getContext()));
    }

    private void setHeaderMusicData(){
        header_music_list.add(new Music("دست من نیست","https://music-ava.com/wp-content/uploads/2021/10/Shadmehr-Aghili-Daste-Man-Nist-scaled.jpg"));
        header_music_list.add(new Music("رنگ صدام","https://upmusics.com/wp-content/uploads/2019/06/ergdf.jpg"));
        header_music_list.add(new Music("من دوست دارم","https://sakhamusic.ir/wp-content/uploads/2017/05/Reza-Sadeghi-Man-Dooset-Daram.jpg"));
        header_music_list.add(new Music("خسوف","https://musictag.ir/wp-content/uploads/2021/10/Mohsen-Chavoshi-Khosoof.jpg"));
        headerMusicAdapter = new HeaderMusicAdapter(getContext());
        headerMusicAdapter.setMusic(header_music_list);
        header_music_rec.setAdapter(headerMusicAdapter);
        header_music_rec.setLayoutManager(new GridLayoutManager(getContext(), 2));

    }

    private void initViews() {
        play_music_rec = view.findViewById(R.id.play_music_rec);
        header_music_rec = view.findViewById(R.id.header_music_rec);
        header_album_rec = view.findViewById(R.id.header_album_rec);
    }
}
