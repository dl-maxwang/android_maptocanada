package com.zhen.maptocanada.ui.news.newsDetailPage;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.view.ViewCompat;
import androidx.databinding.DataBindingUtil;

import android.os.Bundle;

import com.zhen.maptocanada.R;
import com.zhen.maptocanada.data.Consts;
import com.zhen.maptocanada.data.news.NewsDetailData;
import com.zhen.maptocanada.data.news.NewsHandler;
import com.zhen.maptocanada.databinding.ActivityNewsDetailBinding;
import com.zhen.maptocanada.utility.WorkerPool;

import java.io.IOException;

public class NewsDetailActivity extends AppCompatActivity {

    private ActivityNewsDetailBinding newsDetailBinding;
    public static final String VIEW_NAME_HEADER_TITLE = "detail:header:title";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        newsDetailBinding = DataBindingUtil.inflate(getLayoutInflater(), R.layout.activity_news_detail, null, false);
        setContentView(newsDetailBinding.getRoot());

        ViewCompat.setTransitionName(newsDetailBinding.tvDetailTitle, VIEW_NAME_HEADER_TITLE);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        int newsId = getIntent().getIntExtra(Consts.KEY_NEWS_ID, -1);
        if (newsId > 0) {
            WorkerPool.getInstance().execute2(()->{
                try {
                    NewsDetailData newsDetail = NewsHandler.getInstance().getNewsDetail(newsId);
                    if (newsDetail != null) {
                        newsDetailBinding.setNewsData(newsDetail);
                    }
                } catch (IOException e) {
                    e.printStackTrace();
                }
            });
        }
    }

    @Override
    public boolean onSupportNavigateUp() {
        finish();
        return true;
    }
}