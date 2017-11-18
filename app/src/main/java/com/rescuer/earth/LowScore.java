package com.rescuer.earth;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


public class LowScore extends Fragment {

    public LowScore() {
        // Required empty public constructor
    }

    public static LowScore newInstance() {
        LowScore fragment = new LowScore();

        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {


        String[] array = {
                "\t#1\t\t\tAngela Merkel     \t\t- 5t",
                "\t#2\t\t\tFrancois Hollande \t\t- 8t",
                "\t#3\t\t\tVladimir Putin    \t\t- 10t",
                "\t#4\t\t\tKim Yong Un       \t\t- 20t",
                "\t#5\t\t\tDonald Duck       \t\t- 420t",
                "\t#6\t\t\tDonald Trump      \t\t- 9001t"
        };
        List<String> list = new ArrayList<>(Arrays.asList(array));

        ArrayAdapter<String> arrayAdapter = new ArrayAdapter<>(getActivity(),R.layout.lowscore_list_item,R.id.list_item_textview,list);
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_low_score, container, false);

        ListView listView = (ListView) view.findViewById(R.id.listview);
        listView.setAdapter(arrayAdapter);

        return view;
    }



}
