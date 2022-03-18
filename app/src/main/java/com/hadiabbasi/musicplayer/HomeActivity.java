package com.hadiabbasi.musicplayer;

import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.ViewPager;

import android.os.Bundle;

import com.google.android.material.tabs.TabLayout;
import com.hadiabbasi.musicplayer.Adapter.FragmentPagerAdapter;
import com.hadiabbasi.musicplayer.Fragment.HomeFragment;
import com.hadiabbasi.musicplayer.Fragment.MusicFragment;

public class HomeActivity extends AppCompatActivity {

    //view widgets
    private TabLayout tab_layout;
    private ViewPager view_pager;

    //var
    private FragmentPagerAdapter fragmentPagerAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        //initViews
        initViews();

        //set view pager data
        setViewPagerData();
    }

    private void setViewPagerData(){
        HomeFragment homeFragment = new HomeFragment();
        MusicFragment musicFragment = new MusicFragment();
        fragmentPagerAdapter = new FragmentPagerAdapter(getSupportFragmentManager());
        fragmentPagerAdapter.setFragment("خانه", homeFragment);
        fragmentPagerAdapter.setFragment("موزیک", musicFragment);
        view_pager.setAdapter(fragmentPagerAdapter);
        tab_layout.setupWithViewPager(view_pager);

    }

    private void initViews() {
        tab_layout = findViewById(R.id.tab_layout);
        view_pager = findViewById(R.id.view_pager);
    }
}