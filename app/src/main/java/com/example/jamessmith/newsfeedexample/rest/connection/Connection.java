package com.example.jamessmith.newsfeedexample.rest.connection;

import android.util.Log;

import com.example.jamessmith.newsfeedexample.rest.base.BaseLinks;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import retrofit.ErrorHandler;
import retrofit.RestAdapter;
import retrofit.RetrofitError;
import retrofit.converter.GsonConverter;
import rx.subscriptions.CompositeSubscription;

/**
 * Created by James on 23/06/2017.
 */

public class Connection {

    private CompositeSubscription compositeSubscription;
    private RestAdapter.Builder rest;

    public Connection(){
        initWebServices();
    }

    private void initWebServices() {
        compositeSubscription = new CompositeSubscription();
        rest = new RestAdapter.Builder();

        Gson gson = new GsonBuilder()
                .setDateFormat("yyyy'-'MM'-'dd'T'HH':'mm':'ss'.'SSS'Z'")
                .create();

        rest.setEndpoint(BaseLinks.getBaseUrl())
                .setLogLevel(RestAdapter.LogLevel.FULL)
                .setConverter(new GsonConverter(gson))
                .setErrorHandler(new ErrorHandler() {
                    @Override
                    public Throwable handleError(RetrofitError cause) {
                        Log.v("downloadData", cause.getMessage());
                        return null;
                    }
                })
                .build();
    }

    public CompositeSubscription getCompositeSubscription() {
        return compositeSubscription;
    }

    public RestAdapter.Builder getRest() {
        return rest;
    }
}
