package com.example.kdotz.zoo.utils;

import com.example.kdotz.zoo.models.Animal;

import java.util.List;

import retrofit.Callback;
import retrofit.Callback;
import retrofit.http.GET;

/**
 * Created by kdotz on 5/8/2017.
 */

public interface AnimalApiInterface {

    @GET( "/Exhibits.json")
    void getStreams(Callback<List<Animal>> callback);

}
