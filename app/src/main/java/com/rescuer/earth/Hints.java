package com.rescuer.earth;

import android.content.Context;
import android.net.Uri;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetSocketAddress;


public class Hints extends Fragment{



    public Hints() {
        // Required empty public constructor
    }

    public static Hints newInstance(String param1, String param2) {
        Hints fragment = new Hints();
        return fragment;
    }



    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {


        View view  = inflater.inflate(R.layout.pager,container,false);
        ViewPager vp = (ViewPager) view.findViewById(R.id.pager);

        vp.setAdapter(buildAdapter());

        return view;
    }

    private PagerAdapter buildAdapter() {
        return(new PagerAdapter(getActivity(), getChildFragmentManager()));
    }
}
