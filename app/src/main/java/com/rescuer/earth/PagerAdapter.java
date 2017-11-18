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
        return 2;
    }

    @Override
    public Fragment getItem(int position) {
        switch(position) {
            case 0:
                return new LowScore();
            case 1:
                return new PictureHolder();
            default:
                return new PictureHolder();
        }
    }

    @Override
    public String getPageTitle(int position) {
        return ""+position;
    }
}