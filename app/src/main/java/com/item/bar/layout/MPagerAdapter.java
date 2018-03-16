package com.item.bar.layout;

import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;

/**
 * Created by Administrator on 2018/3/15 0015.
 *
 */

public class MPagerAdapter extends FragmentStatePagerAdapter{
    private String [] tabTitle = new String []{"tab1","tab2"};
    private OneFragment oneFragment;
    private TwoFragment twoFragment;

    public MPagerAdapter(FragmentManager fm) {
        super(fm);
    }

    @Override
    public Fragment getItem(int position) {
        if(position == 0) {
            if(oneFragment == null) {
                oneFragment = new OneFragment();
            }
            return oneFragment;
        }else if(position ==1){
            if(twoFragment == null) {
                twoFragment = new TwoFragment();
            }
            return twoFragment;
        }
        return null;
    }

    @Override
    public int getCount() {
        return tabTitle.length;
    }

    @Nullable
    @Override
    public CharSequence getPageTitle(int position) {
        return tabTitle[position];
    }
}
