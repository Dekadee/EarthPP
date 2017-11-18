package com.rescuer.earth;

import android.content.Context;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

public class PagerAdapter extends FragmentPagerAdapter {


    public PagerAdapter(Context ctxt, FragmentManager mgr) {
        super(mgr);
    }

    @Override
    public int getCount() {
        return 4;
    }

    @Override
    public Fragment getItem(int position) {
        return PictureHolder.newInstance(position);
    }

    @Override
    public String getPageTitle(int position) {
        return ""+position;
    }
}