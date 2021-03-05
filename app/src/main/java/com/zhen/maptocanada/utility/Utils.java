package com.zhen.maptocanada.utility;

import androidx.annotation.WorkerThread;

import com.google.gson.Gson;
import com.zhen.maptocanada.data.news.CategoryData;
import com.zhen.maptocanada.data.news.NewsDetailData;
import com.zhen.maptocanada.data.news.NewsListData;

import okhttp3.Response;

public final class Utils {
    private static Gson gson = new Gson();

    private Utils() {
    }

    @WorkerThread
    public static NewsDetailData parseNewsDetail(String newsDetailJson) {
        return gson.fromJson(newsDetailJson, NewsDetailData.class);
    }

    @WorkerThread
    public static NewsListData parseNewsList(String newsListJson) {
        return gson.fromJson(newsListJson, NewsListData.class);
    }

    @WorkerThread
    public static CategoryData parseCategory(String categoryJson) {
        return gson.fromJson(categoryJson, CategoryData.class);
    }
}
