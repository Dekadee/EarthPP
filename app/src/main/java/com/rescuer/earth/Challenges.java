package com.rescuer.earth;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.TransitionDrawable;
import android.media.Image;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.CardView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.Toast;


public class Challenges extends Fragment {

    private ImageView imageView;

    private Drawable home;

    private Drawable bulb;

    private CardView card;



    public Challenges() {
        // Required empty public constructor
    }

    public static Challenges newInstance(String param1, String param2) {
        Challenges fragment = new Challenges();
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

        View view = inflater.inflate(R.layout.fragment_challenges, container, false);

        ImageView upperImage = (ImageView) view.findViewById(R.id.upperImage);
        upperImage.setOnClickListener(new OnClicker(upperImage,R.drawable.personal_challenge,R.drawable.personal_challenge_done));
        ImageView lowerimage = (ImageView) view.findViewById(R.id.lowerImage);
        lowerimage.setOnClickListener(new OnClicker(lowerimage,R.drawable.community_challenge,R.drawable.community_challenge_done));

        return view;
    }


    public void onButtonPressed(Uri uri) {

    }

    @Override
    public void onDetach() {
        super.onDetach();
    }

    private class OnClicker implements View.OnClickListener {

        TransitionDrawable td;

        ImageView self;

        boolean reverse = false;

        OnClicker(ImageView self, int id1, int id2){
            this.self = self;
            td = new TransitionDrawable( new Drawable[] {
                    getResources().getDrawable(id1),
                    getResources().getDrawable(id2)
            });
            td.setCrossFadeEnabled(true);
            self.setImageDrawable(td);
        }

        @Override
        public void onClick(View v) {
            if(reverse){
                td.reverseTransition(500);
                reverse = false;
            }else {
                td.startTransition(500);
                reverse = true;
            }

        }
    }

}
