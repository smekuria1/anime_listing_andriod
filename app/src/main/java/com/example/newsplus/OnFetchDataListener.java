package com.example.newsplus;

import com.example.newsplus.models.Datum;

import java.util.List;

public interface OnFetchDataListener<TopAnime> {
    void onFetchData(List<Datum> list, String message);
    void onError(String message);
}
