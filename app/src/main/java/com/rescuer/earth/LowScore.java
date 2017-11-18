package com.rescuer.earth;

import android.app.Activity;
import android.content.Context;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;


import org.json.JSONArray;
import org.json.JSONObject;

import java.net.URL;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;


public class LowScore extends Fragment {

    public LayoutInflater inflater;
    ViewGroup container;
    View view;
    Activity host;

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




        /*Content[] array = {
                new Content("Angelo Merte",5),
                new Content("Earth++-Team",8),
                new Content("Francois Hollande",15),

        };

        List<Content> list = new ArrayList<>(Arrays.asList(array));*/
        View view = inflater.inflate(R.layout.fragment_low_score, container, false);
        this.view = view;
        this.host = (Activity) view.getContext();
        this.inflater = inflater;
        this.container = container;
        ReceiveData rc = new ReceiveData();
        try{
            rc.execute();
        }catch(Exception e){
            Log.e("json",e.toString());
        }


        return view;
    }

    public void setAdaptersHere(String s){
        List<Content> list = new ArrayList<>();
        JSONArray jsonObject = new JSONArray();
        try {
            jsonObject = new JSONArray(s);
            for(int i = 0;i < jsonObject.getJSONArray(0).length();i++){
                list.add(new Content(jsonObject.getJSONArray(0).getString(i),jsonObject.getJSONArray(1).getInt(i)));
            }
        }catch(Exception e){
            Log.e("json",e.toString());
        }
        Log.e("json",jsonObject.toString());

        ArrayAdapter<String> arrayAdapter = new MultiArrayAdapter(getActivity(),R.layout.lowscore_list_item,R.id.list_item_textview,list);
        // Inflate the layout for this fragment

        ListView listView = (ListView) view.findViewById(R.id.listview);
        listView.setAdapter(arrayAdapter);
    }


    private class ReceiveData extends AsyncTask {

        @Override
        protected Object doInBackground(Object[] params) {
            JSONRequest js = new JSONRequest();
            final String jsonStr = js.makeServiceCall("https://files.cdslash.de/earthpp.php");
            host.runOnUiThread(new Runnable() {
                @Override
                public void run() {
                    setAdaptersHere(jsonStr);
                }
            });
            return null;
        }
    }



    public class Content  {
        public String name;
        public int score;

        public Content(String name,int score){
            this.name = name;
            this.score = score;
        }
    }


}
