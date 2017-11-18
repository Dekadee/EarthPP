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


/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 * {@link StartPage.OnFragmentInteractionListener} interface
 * to handle interaction events.
 * Use the {@link StartPage#newInstance} factory method to
 * create an instance of this fragment.
 */
public class StartPage extends Fragment {

    private OnFragmentInteractionListener mListener;

    public StartPage() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment StartPage.
     */
    // TODO: Rename and change types and number of parameters
    public static StartPage newInstance(String param1, String param2) {
        StartPage fragment = new StartPage();
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
        Animation rotation = AnimationUtils.loadAnimation(getContext(), R.anim.rotator);
        rotation.setRepeatCount(Animation.INFINITE);
        img.startAnimation(rotation);

        return view;
    }


    @Override
    public void onDetach() {
        super.onDetach();
        mListener = null;
    }

    /**
     * This interface must be implemented by activities that contain this
     * fragment to allow an interaction in this fragment to be communicated
     * to the activity and potentially other fragments contained in that
     * activity.
     * <p>
     * See the Android Training lesson <a href=
     * "http://developer.android.com/training/basics/fragments/communicating.html"
     * >Communicating with Other Fragments</a> for more information.
     */
    public interface OnFragmentInteractionListener {
        // TODO: Update argument type and name
        void onFragmentInteraction(Uri uri);
    }
}
