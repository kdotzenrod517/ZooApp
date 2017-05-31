package com.example.kdotz.zoo.adapters;

import android.content.Context;
import android.support.annotation.LayoutRes;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;

import com.example.kdotz.zoo.R;
import com.example.kdotz.zoo.models.GalleryImage;
import com.squareup.picasso.Picasso;

/**
 * Created by kdotz on 5/24/2017.
 */

public class GalleryImageAdapter extends ArrayAdapter<GalleryImage>{


    public GalleryImageAdapter(@NonNull Context context, @LayoutRes int resource) {
        super(context, resource);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder holder;

        if(convertView == null){
            holder = new ViewHolder();
            convertView = LayoutInflater.from(getContext()).inflate(R.layout.view_gallery_thumbail, parent, false);
            holder.image = (ImageView) convertView.findViewById(R.id.image);
            convertView.setTag(holder);
        } else {
            holder = (ViewHolder) convertView.getTag();
        }

        Picasso.with(getContext()).load(getItem(position).getThumbnail()).into(holder.image);

        return convertView;
    }

    private class ViewHolder{
        ImageView image;
    }
}
