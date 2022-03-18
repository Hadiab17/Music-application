package com.hadiabbasi.musicplayer.Adapter;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;

import java.util.ArrayList;

public class FragmentPagerAdapter extends androidx.fragment.app.FragmentPagerAdapter {

    private ArrayList<String> fragmentName = new ArrayList<>();
    private ArrayList<Fragment> fragment = new ArrayList<>();

    public void setFragment(String name, Fragment fragment){
        this.fragmentName.add(name);
        this.fragment.add(fragment);
    }

    public FragmentPagerAdapter(@NonNull FragmentManager fm) {
        super(fm);
    }

    @NonNull
    @Override
    public Fragment getItem(int position) {
        return fragment.get(position);
    }

    @Override
    public int getCount() {
        return fragment.size();
    }

    @Nullable
    @Override
    public CharSequence getPageTitle(int position) {
        return fragmentName.get(position);
    }
}
