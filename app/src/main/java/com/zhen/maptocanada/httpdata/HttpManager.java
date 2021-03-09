package com.zhen.maptocanada.httpdata;

import androidx.annotation.WorkerThread;

import com.zhen.maptocanada.data.news.NewsListData;

import java.io.IOException;
import java.util.List;
import java.util.Objects;
import java.util.concurrent.TimeUnit;

import okhttp3.HttpUrl;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

public class HttpManager {
    private static final String BASE_URL = "https://backend.maptocanada.ca/";
    private StringBuilder sbCategoryUrl = new StringBuilder();
    private StringBuilder sbArticlesUrl = new StringBuilder();

    public String getLanguage() {
        return language;
    }

    public void setLanguage(String language) {
        this.language = language;
    }

    private String language = "zh-hans";

    private OkHttpClient httpClient;
    private final HttpUrl.Builder categoriesUrl;
    private final HttpUrl.Builder articlesUrlBuilder;
    private static HttpManager instance;

    public static HttpManager getInstance() {
        if (instance == null) {
            synchronized (HttpManager.class) {
                if (instance == null) {
                    instance = new HttpManager();
                }
            }
        }
        return instance;
    }

    public HttpManager() {
        httpClient = new OkHttpClient.Builder()
                .callTimeout(5000, TimeUnit.SECONDS)
                .build();
        sbCategoryUrl.append(BASE_URL);
        sbArticlesUrl.append(BASE_URL);
        if (HttpConfig.LANGUAGE_EN.equalsIgnoreCase(language)) {
            sbCategoryUrl.append(HttpConfig.LANGUAGE_EN);
            sbArticlesUrl.append(HttpConfig.LANGUAGE_EN);
        } else if (HttpConfig.LANGUAGE_ZH.equalsIgnoreCase(language)) {
            sbCategoryUrl.append(HttpConfig.LANGUAGE_ZH);
            sbArticlesUrl.append(HttpConfig.LANGUAGE_ZH);
        }
        sbCategoryUrl.append("/api/archive");
        sbArticlesUrl.append("/api/archive/");
        categoriesUrl = Objects.requireNonNull(
                HttpUrl.parse(sbCategoryUrl.append("/categories").toString()).newBuilder());
        articlesUrlBuilder = Objects.requireNonNull(
                HttpUrl.parse(sbArticlesUrl.toString())).newBuilder();
    }

    @WorkerThread
    public Response getCategories() throws IOException {
        Request req = new Request.Builder().url(categoriesUrl.build()).build();
        return httpClient.newCall(req).execute();
    }

    @WorkerThread
    public Response getNewsList(int pageNo, int itemNo) throws IOException {
        articlesUrlBuilder.removeAllQueryParameters("page");
        articlesUrlBuilder.removeAllQueryParameters("pageSize");
        articlesUrlBuilder.removeAllQueryParameters("c");

        articlesUrlBuilder.addQueryParameter("page", String.valueOf(pageNo))
                .addQueryParameter("pageSize", String.valueOf(itemNo));
        // add later
//                .addQueryParameter("c", "news");

        Request req = new Request.Builder().url(articlesUrlBuilder.build()).build();
        System.out.println(req.toString());
        return httpClient.newCall(req).execute();

    }

    @WorkerThread
    public Response getNewsDetail(int id) throws IOException {
        Request req = new Request.Builder().url(sbArticlesUrl + String.valueOf(id)).build();
        return httpClient.newCall(req).execute();
    }

}
