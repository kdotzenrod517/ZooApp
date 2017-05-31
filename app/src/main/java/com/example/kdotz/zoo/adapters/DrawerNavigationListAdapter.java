package com.example.kdotz.zoo.adapters;

import android.content.Context;
import android.support.annotation.LayoutRes;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import com.example.kdotz.zoo.R;

/**
 * Created by kdotz on 5/8/2017.
 */

public class DrawerNavigationListAdapter extends ArrayAdapter<String> {
    public DrawerNavigationListAdapter(@NonNull Context context, @LayoutRes int resource) {
        super(context, resource);
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        ViewHolder holder;
        if( convertView == null){
            holder = new ViewHolder();
            convertView = LayoutInflater.from( getContext() ).inflate(R.layout.navigation_drawer_list_item, parent, false);
            holder.title = (TextView) convertView.findViewById(R.id.title);
            convertView.setTag(holder);
        } else{
            holder = (ViewHolder) convertView.getTag();
        }

        holder.title.setText(getItem(position));

        return convertView;
    }

    class ViewHolder {
        TextView title;
    }
}
