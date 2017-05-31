package com.example.kdotz.zoo.utils;

import com.example.kdotz.zoo.models.Animal;
import com.example.kdotz.zoo.models.GalleryImage;

import java.util.List;

import retrofit.Callback;
import retrofit.http.GET;

/**
 * Created by kdotz on 5/24/2017.
 */

public interface GalleryApiInterface {

    @GET( "/Gallery.json")
    void getStreams(Callback<List<GalleryImage>> callback);
}




