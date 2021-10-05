package com.example.rickmorty.ui;

import android.app.Application;

import com.example.rickmorty.ui.data.remote.ApiService;
import com.example.rickmorty.ui.data.remote.RetrofitClient;

public class App extends Application {

    public static ApiService service;

    @Override
    public void onCreate() {
        super.onCreate();
        service = new RetrofitClient().provideApiService();

    }
}
