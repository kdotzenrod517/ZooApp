package com.example.kdotz.zoo.fragments;

import android.graphics.Camera;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.util.Log;
import android.view.View;

import com.example.kdotz.zoo.R;
import com.example.kdotz.zoo.models.Pin;
import com.example.kdotz.zoo.utils.PinsApiInterface;
import com.google.android.gms.maps.CameraUpdate;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.google.android.gms.maps.model.CameraPosition;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.Marker;
import com.google.android.gms.maps.model.MarkerOptions;
import com.squareup.picasso.Downloader;

import java.util.List;

import retrofit.Callback;
import retrofit.RestAdapter;
import retrofit.RetrofitError;
import retrofit.client.Response;

import com.example.kdotz.zoo.R;
import com.example.kdotz.zoo.models.GalleryImage;
import com.example.kdotz.zoo.models.Pin;
import com.example.kdotz.zoo.utils.PinsApiInterface;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.MapFragment;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.google.android.gms.maps.model.CameraPosition;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.Marker;
import com.google.android.gms.maps.model.MarkerOptions;

import java.util.List;

import retrofit.Callback;
import retrofit.RestAdapter;
import retrofit.RetrofitError;
import retrofit.client.Response;

/**
 * Created by kdotz on 5/8/2017.
 */

public class ZooMapFragment extends SupportMapFragment implements
        OnMapReadyCallback {

    private GoogleMap mMap;

    public static ZooMapFragment getInstance(){
        ZooMapFragment fragment = new ZooMapFragment();

        return fragment;
    }

    @Override
    public void onResume() {
        super.onResume();

        setUpMapIfNeeded();

        //Other stuff:
        RestAdapter adapter = new RestAdapter.Builder()
                .setEndpoint(getString(R.string.pins_feed))
                .build();

        PinsApiInterface pinsApiInterface = adapter.create(PinsApiInterface.class);

        pinsApiInterface.getStreams( new Callback<List<Pin>>() {
            @Override
            public void success(List<Pin> pins, Response response) {
                if( !isAdded() || pins == null || pins.isEmpty())
                    return;
                for( Pin pin : pins ) {
                    MarkerOptions options = new MarkerOptions().position( new LatLng( pin.getLatitude(), pin.getLongitude() ) );
                    options.title( pin.getName() );
                    options.icon( BitmapDescriptorFactory.defaultMarker( BitmapDescriptorFactory.HUE_GREEN ) );
                    mMap.addMarker( options );
                }
            }
            @Override
            public void failure(RetrofitError error) {

            }
        });

    }

    private void setUpMapIfNeeded() {
        if (mMap == null) {
            getMapAsync(this);
        }
    }

    @Override
    public void onMapReady(GoogleMap googleMap) {
        mMap = googleMap;

        //mMap.setMyLocationEnabled(true);
        mMap.setMapType(GoogleMap.MAP_TYPE_HYBRID);

        mMap.getUiSettings().setMapToolbarEnabled(false);


        mMap.setOnMarkerClickListener( new GoogleMap.OnMarkerClickListener() {
            @Override
            public boolean onMarkerClick(Marker marker) {
                marker.showInfoWindow();
                return true;
            }
        });

        // Add a marker in Denver, Zoo
        // and move the map's camera to the same location.
        LatLng denverZoo = new LatLng(39.7500, -104.9500);
        mMap.addMarker(new MarkerOptions().position(denverZoo)
                .title("Denver Zoo"));
        mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(denverZoo, 15));
    }
}