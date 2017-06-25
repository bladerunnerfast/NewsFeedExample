package com.example.jamessmith.newsfeedexample.fragments;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.jamessmith.newsfeedexample.R;
import com.example.jamessmith.newsfeedexample.adapter.RecyclerAdapter;
import com.example.jamessmith.newsfeedexample.rest.connection.Connection;
import com.example.jamessmith.newsfeedexample.rest.model.Model;
import com.example.jamessmith.newsfeedexample.rest.observables.API;

import rx.Observer;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

public class RecyclerFragment extends Fragment {

    private RecyclerView recyclerView;
    private Connection connection;

    protected Model customModel = new Model();

    private RecyclerAdapter recyclerAdapter;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_news_listing_layout, container, false);
        recyclerView = view.findViewById(R.id.rv_list);
        Bundle bundle = getArguments();

        if(bundle != null){
            String part = bundle.getString("urlPart");
            if(part != null) {
                connection = new Connection();
                downloadData(part);
            }
        }

        return  view;
    }

    private void downloadData(String urlPart) {

        API api = connection.getRest().build().create(API.class);

        connection.getCompositeSubscription().add(api.getNews(urlPart)
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeOn(Schedulers.newThread())
                .subscribe(new Observer<Model>() {

                    @Override
                    public void onCompleted() {
                        connection.getCompositeSubscription().unsubscribe();
                    }

                    @Override
                    public void onError(Throwable e) {
                        if (e != null) {
                            connection.getCompositeSubscription().unsubscribe();
                        }
                    }

                    @Override
                    public void onNext(Model model) {
                        customModel = model;
                        setRecyclerView();
                    }
                })
        );
    }
    private void setRecyclerView(){

        if(recyclerView != null){
            recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
            recyclerView.setItemAnimator(new DefaultItemAnimator());
        }

        recyclerAdapter = new RecyclerAdapter(getContext(), customModel);
        recyclerView.setAdapter(recyclerAdapter);
    }
}
