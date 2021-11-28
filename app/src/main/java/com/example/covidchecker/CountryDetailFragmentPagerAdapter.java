package com.example.covidchecker;


import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.lifecycle.Lifecycle;
import androidx.viewpager2.adapter.FragmentStateAdapter;

import java.util.ArrayList;

public class CountryDetailFragmentPagerAdapter extends FragmentStateAdapter {

    private ArrayList<Fragment> listFragment = new ArrayList<>();

    public CountryDetailFragmentPagerAdapter(@NonNull FragmentManager fragmentManager, @NonNull Lifecycle lifecycle, ArrayList<Fragment> listFragment) {
        super(fragmentManager, lifecycle);
        this.listFragment = listFragment;
    }

    @NonNull
    @Override
    public Fragment createFragment(int position) {
        return listFragment.get(position);
    }

    @Override
    public int getItemCount() {
        return listFragment.size();
    }

}
