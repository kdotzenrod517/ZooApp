package com.example.kdotz.zoo.utils;

import com.example.kdotz.zoo.models.GalleryImage;
import com.example.kdotz.zoo.models.Pin;

import java.util.List;

import retrofit.Callback;
import retrofit.http.GET;

/**
 * Created by kdotz on 5/26/2017.
 */

public interface PinsApiInterface {

    @GET( "/Pins.json")
    void getStreams(Callback<List<Pin>> callback);
}
