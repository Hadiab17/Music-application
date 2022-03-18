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

import com.hadiabbasi.musicplayer.Adapter.NewAlbumAdapter;
import com.hadiabbasi.musicplayer.Adapter.NewSongAdapter;
import com.hadiabbasi.musicplayer.Model.Album;
import com.hadiabbasi.musicplayer.Model.Music;
import com.hadiabbasi.musicplayer.R;
import com.hadiabbasi.musicplayer.databinding.FragmentHomeBinding;

import java.util.ArrayList;

public class HomeFragment extends Fragment {

    private FragmentHomeBinding  binding;
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        binding = FragmentHomeBinding.inflate(getLayoutInflater());
        return binding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {

        setNewAlbumRec(setNewAlbumData());

        setNewSongRec(setNewSongData());

        super.onViewCreated(view, savedInstanceState);
    }


    private ArrayList<Album> setNewAlbumData(){
        ArrayList<Album> newAlbumList = new ArrayList<Album>();
        newAlbumList.add(new Album("https://e.snmc.io/i/600/w/ae60c2bac90c83245c37f8d693723202/7462578/%D9%85%D8%AD%D8%B3%D9%86-%DA%86%D8%A7%D9%88%D8%B4%DB%8C-mohsen-chavoshi-abraham-Cover-Art.jpg", "ابراهیم", "18", "8","محسن چاووشی"));
        newAlbumList.add(new Album("https://upload.wikimedia.org/wikipedia/en/thumb/5/5e/MChavoshi_Abraham.png/220px-MChavoshi_Abraham.png", "ابراهیم", "18", "8","محسن چاووشی"));
        newAlbumList.add(new Album("https://upload.wikimedia.org/wikipedia/en/thumb/5/5e/MChavoshi_Abraham.png/220px-MChavoshi_Abraham.png", "ابراهیم", "18", "8","محسن چاووشی"));
        newAlbumList.add(new Album("https://upload.wikimedia.org/wikipedia/en/thumb/5/5e/MChavoshi_Abraham.png/220px-MChavoshi_Abraham.png", "ابراهیم", "18", "8","محسن چاووشی"));
        return newAlbumList;
    }

    private void setNewAlbumRec(ArrayList<Album> album){
        NewAlbumAdapter adapter = new NewAlbumAdapter(album, getContext());
        binding.newAlbumRec.setAdapter(adapter);
        binding.newAlbumRec.setLayoutManager(new LinearLayoutManager(getContext(), LinearLayoutManager.HORIZONTAL, false));
    }

    private ArrayList<Music> setNewSongData(){
        ArrayList<Music> newSongList = new ArrayList<>();
        newSongList.add(new Music("رضا صادقی","خدا شاهده","4:30","https://www.topseda.ir/wp-content/uploads/2015/12/Reza-Sadeghi-Shab-Barooni.jpg"));
        newSongList.add(new Music("محسن چاووشی","باب دلمی","4:56","https://music-fa.com/wp-content/uploads/2021/12/Mohsen-Chavoshi-Hanoozam-Oon-Shabaye-Music-fa.com_.jpg"));
        newSongList.add(new Music("محسن چاووشی","دل مغموم","3:30","https://webahang.ir/wp-content/uploads/2019/12/Mohsen-Chavoshi-Shahrzad.jpg"));
        newSongList.add(new Music("مهدی یراحی","وداع بعد از رفتن","4:21","https://upmusics.com/wp-content/uploads/2021/11/Mehdi-Yarrahi-Vedae-Bad-Az-Raftan.jpg"));
        newSongList.add(new Music("مهدی یراحی","هوای تو","3:46","https://www.myfaza2music.net/wp-content/uploads/2017/08/Mehdi-Yarahi.jpg"));
        newSongList.add(new Music("کاوه آفاق","عطر تو","4:39","https://sakhamusic.ir/wp-content/uploads/2016/01/Kaveh-Afagh-Dance-With-Pills.jpg"));
        newSongList.add(new Music("رضا صادقی","ندارمت","5:32","https://www.topseda.ir/wp-content/uploads/2015/12/Reza-Sadeghi-Shab-Barooni.jpg"));
        newSongList.add(new Music("ایهام","بغض","3:12","https://next1.ir/wp-content/uploads/2017/08/Ehaam-Boghz-480x480.jpg"));
        newSongList.add(new Music("سیاوش قمیشی","نوازش ","5:53","https://jibmusic.com/wp-content/uploads/2021/12/Siavash%20Ghomayshi-Navazesh.jpg"));
        return newSongList;
    }

    private void setNewSongRec(ArrayList<Music> songs){
        NewSongAdapter adapter = new NewSongAdapter(songs, getContext());
        binding.newSongRec.setAdapter(adapter);
        binding.newSongRec.setLayoutManager(new GridLayoutManager(getContext(), 3));
    }
}
