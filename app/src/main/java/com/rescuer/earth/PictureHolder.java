package com.rescuer.earth;

import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;


public class PictureHolder extends Fragment {

    int position;

    ImageView image;

    public PictureHolder() {
        // Required empty public constructor
    }


    public static PictureHolder newInstance(int position) {
        PictureHolder fragment = new PictureHolder();
        fragment.position = position;
        return fragment;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_pciture_holder, container, false);
        image = (ImageView) view.findViewById(R.id.factView);
        switch(position){
            case 0:
                image.setImageDrawable(getResources().getDrawable(R.drawable.fact_1));
                break;
            case 1:
                image.setImageDrawable(getResources().getDrawable(R.drawable.fact_2));
                break;
            case 2:
                image.setImageDrawable(getResources().getDrawable(R.drawable.fact_3));
                break;
            case 3:
                image.setImageDrawable(getResources().getDrawable(R.drawable.fact_4));
                break;
            default:
                image.setImageDrawable(getResources().getDrawable(R.drawable.fact_1));
        }
        return view;
    }
}
