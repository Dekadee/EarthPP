package com.rescuer.earth;

import android.content.Context;
import android.media.Image;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageButton;
import android.widget.ImageView;


public class StartPage extends Fragment {

    private int percPoll = 35;

    public StartPage() {
        // Required empty public constructor
    }

    public static StartPage newInstance(int percPoll) {
        StartPage fragment = new StartPage();
        fragment.percPoll = percPoll;
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_start_page, container, false);

        ImageView img = (ImageView) view.findViewById(R.id.earthView);
        if(percPoll < 34){
            img.setImageDrawable(getResources().getDrawable(R.drawable.earth_sad));
        }else if(percPoll < 67){
            img.setImageDrawable(getResources().getDrawable(R.drawable.earth_meh));
        }else{
            img.setImageDrawable(getResources().getDrawable(R.drawable.earth_happy));
        }
        Animation rotation = AnimationUtils.loadAnimation(getContext(), R.anim.rotator);
        rotation.setRepeatCount(Animation.INFINITE);
        img.startAnimation(rotation);

        return view;
    }
}
