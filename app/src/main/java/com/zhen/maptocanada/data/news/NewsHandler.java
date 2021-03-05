package com.zhen.maptocanada.data.news;

import androidx.annotation.WorkerThread;

import com.zhen.maptocanada.httpdata.HttpManager;
import com.zhen.maptocanada.utility.Utils;

import java.io.IOException;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.concurrent.ConcurrentHashMap;

import okhttp3.Response;

public class NewsHandler {

    // page, newsList
    private Map<Integer, NewsListData> newsListDataMap;
    // id, newsDetail Data
    private Map<Integer, NewsDetailData> newsDetailDataMap;
    public static final int PAGE_SIZE = 50;
    private static NewsHandler instance;

    private NewsHandler() {
        newsListDataMap = new ConcurrentHashMap<>();
        newsDetailDataMap = new ConcurrentHashMap<>();
    }

    public static NewsHandler getInstance() {
        if (instance == null) {
            synchronized (NewsHandler.class) {
                if (instance == null) {
                    instance = new NewsHandler();
                }
            }
        }
        return instance;
    }

    @WorkerThread
    public void refreshNewsListCache(int page) throws IOException {
        newsListDataMap.clear();
        Response resNewsList = HttpManager.getInstance().getNewsList(page, PAGE_SIZE);
        newsListDataMap.put(page, Utils.parseNewsList(Objects.requireNonNull(resNewsList.body()).string()));
    }

    public void refreshNewsDetailCache(int newsId) throws IOException {
        newsDetailDataMap.clear();
        Response newsDetail = HttpManager.getInstance().getNewsDetail(newsId);
        newsDetailDataMap.put(newsId, Utils.parseNewsDetail(Objects.requireNonNull(newsDetail.body()).string()));
    }

    @WorkerThread
    public NewsListData getNewsList(int page) throws IOException {
        if (newsListDataMap.get(page) == null) {
            Response resNewsList = HttpManager.getInstance().getNewsList(page, PAGE_SIZE);
            newsListDataMap.put(page, Utils.parseNewsList(Objects.requireNonNull(resNewsList.body()).string()));
        }
        return newsListDataMap.get(page);
    }

    public NewsDetailData getNewsDetail(int newsId) throws IOException {
        if (newsDetailDataMap.get(newsId) == null) {
            Response newsDetail = HttpManager.getInstance().getNewsDetail(newsId);
            newsDetailDataMap.put(newsId, Utils.parseNewsDetail(Objects.requireNonNull(newsDetail.body()).string()));
        }
        return newsDetailDataMap.get(newsId);
    }


}
