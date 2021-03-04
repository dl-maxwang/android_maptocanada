package com.zhen.maptocanada;

import com.zhen.maptocanada.httpdata.HttpManager;

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
        HttpManager manager = new HttpManager("zh-hans");
        Response categories = manager.getCategories();
        System.out.println(categories.body().string());
        Response newsArticles = manager.getNewsArticles(1, 100);
        System.out.println(newsArticles.body().string());
    }
}