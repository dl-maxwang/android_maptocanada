package com.zhen.maptocanada.httpdata;

import androidx.annotation.WorkerThread;

import java.io.IOException;
import java.util.Objects;

import okhttp3.HttpUrl;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

public class HttpManager {
    private static final String BASE_URL = "https://backend.maptocanada.ca/";
    private StringBuilder sbCategoryUrl = new StringBuilder();
    private StringBuilder sbArticlesUrl = new StringBuilder();

    OkHttpClient httpClient = new OkHttpClient();
    private final HttpUrl.Builder categoriesUrl;
    private final HttpUrl.Builder articlesUrlBuilder;

    public HttpManager(String language) {
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
        sbArticlesUrl.append("/api/archive");
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
    public Response getNewsArticles(int pageNo, int itemNo) throws IOException {
        articlesUrlBuilder.removeAllQueryParameters("page");
        articlesUrlBuilder.removeAllQueryParameters("pageSize");
        articlesUrlBuilder.removeAllQueryParameters("c");

        articlesUrlBuilder.addQueryParameter("page", String.valueOf(pageNo))
                .addQueryParameter("pageSize", String.valueOf(itemNo))
                .addQueryParameter("c", "news");

        Request req = new Request.Builder().url(articlesUrlBuilder.build()).build();
        return httpClient.newCall(req).execute();

    }

}
