package com.example.rickmorty.ui.data.remote;

import com.example.rickmorty.ui.data.models.MainResponse;
import com.example.rickmorty.ui.data.models.Result;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.http.GET;

public interface ApiService {

    @GET("api/character")
    Call<MainResponse<Result>> fetchCharacters();


}
