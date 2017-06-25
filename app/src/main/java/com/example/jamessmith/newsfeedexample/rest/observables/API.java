package com.example.jamessmith.newsfeedexample.rest.observables;

import com.example.jamessmith.newsfeedexample.rest.model.Model;

import retrofit.http.GET;
import retrofit.http.Path;
import rx.Observable;

/**
 * Created by James on 23/06/2017.
 */

public interface API {

    @GET("/api/v1/{part}/json")
    Observable<Model> getNews(@Path("part") String urlPart);
}
