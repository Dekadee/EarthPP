package com.rescuer.earth;

import android.app.Activity;
import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;


import java.util.List;


public class MultiArrayAdapter extends ArrayAdapter {
    private Context context;
    private final List list;


    public MultiArrayAdapter(Context context, int resource, int textViewResourceId, List objects) {
        super(context,resource,textViewResourceId,objects);
        this.context = context;
        this.list = objects;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View rowView = convertView;
        ViewHolder view;

        if(rowView == null)
        {
            // Get a new instance of the row layout view
            LayoutInflater inflater =  LayoutInflater.from(context);
            rowView = inflater.inflate(R.layout.lowscore_list_item, null);

            // Hold the view objects in an object, that way the don't need to be "re-  finded"
            view = new ViewHolder();
            view.listitem = (TextView) rowView.findViewById(R.id.list_item_textview);
            view.listsubitem= (TextView) rowView.findViewById(R.id.list_item_subtextview);

            rowView.setTag(view);
        } else {
            view = (ViewHolder) rowView.getTag();
        }

        /** Set data to your Views. */
        LowScore.Content item = (LowScore.Content) list.get(position);
        view.listitem.setText("#"+(position+1)+"\t\t\t"+item.name);
        view.listsubitem.setText(item.score+" tons");

        return rowView;
    }

    protected static class ViewHolder{
        protected TextView listitem;
        protected TextView listsubitem;
    }
}