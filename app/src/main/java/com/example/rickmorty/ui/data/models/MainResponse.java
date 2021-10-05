
package com.example.rickmorty.ui.data.models;


import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;
import java.util.List;

public class MainResponse<T> {

    @SerializedName("info")
    @Expose
    private Info info;
    @SerializedName("results")

    private ArrayList<T> results = null;

    public Info getInfo() {
        return info;
    }

    public void setInfo(Info info) {
        this.info = info;
    }

    public ArrayList<T> getResults() {
        return results;
    }

    public void setResults(ArrayList<T> results) {
        this.results = results;
    }

}
