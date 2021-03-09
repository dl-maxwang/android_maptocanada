package com.zhen.maptocanada;

import com.zhen.maptocanada.data.news.CategoryData;
import com.zhen.maptocanada.data.news.NewsDetailData;
import com.zhen.maptocanada.data.news.NewsListData;
import com.zhen.maptocanada.httpdata.HttpManager;
import com.zhen.maptocanada.utility.Utils;

import org.junit.Test;

import java.io.IOException;

import okhttp3.Response;

import static org.junit.Assert.*;

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * @see <a href="http://d.android.com/tools/testing">Testing documentation</a>
 */
public class ExampleUnitTest {
    @Test
    public void addition_isCorrect() {
        assertEquals(4, 2 + 2);
    }

    @Test
    public void testHttpClient() throws IOException {
        HttpManager manager = new HttpManager();
//        Response categories = manager.getCategories();
//        System.out.println(categories.body().string());
        Response newsArticles = manager.getNewsList(1, 100);
        System.out.println(newsArticles.body().string());
    }

    @Test
    public void testNewsDetail() throws IOException{
        HttpManager manager = new HttpManager();
        Response newsDetail = manager.getNewsDetail(1);
        Response newsDetail2 = manager.getNewsDetail(2);
        Response newsDetail3 = manager.getNewsDetail(2);
        System.out.println(newsDetail.body().string());
        System.out.println(newsDetail2.body().string());
        System.out.println(newsDetail3.body().string());
    }

    @Test
    public void testGsonConverter() throws IOException{
        HttpManager manager = new HttpManager();
        Response categories = manager.getCategories();
        Response newsList = manager.getNewsList(1, 100);
        Response newsDetail = manager.getNewsDetail(1);

        CategoryData categoryData = Utils.parseCategory(categories.body().string());
        NewsListData newsListData = Utils.parseNewsList(newsList.body().string());
        NewsDetailData newsDetailData = Utils.parseNewsDetail(newsDetail.body().string());
        System.out.println("finished");
    }
}