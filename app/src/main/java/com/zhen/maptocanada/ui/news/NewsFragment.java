package com.zhen.maptocanada.ui.news;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.GestureDetector;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.app.ActivityCompat;
import androidx.core.app.ActivityOptionsCompat;
import androidx.databinding.DataBindingUtil;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;

import com.zhen.maptocanada.R;
import com.zhen.maptocanada.data.Consts;
import com.zhen.maptocanada.data.news.NewsHandler;
import com.zhen.maptocanada.data.news.NewsListData;
import com.zhen.maptocanada.data.news.NewsListData.NewsPreviewBean;
import com.zhen.maptocanada.databinding.FragmentNewsBinding;
import com.zhen.maptocanada.ui.news.newsDetailPage.NewsDetailActivity;
import com.zhen.maptocanada.ui.news.views.NewsListAdapter;
import com.zhen.maptocanada.utility.WorkerPool;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutionException;

public class NewsFragment extends Fragment {

    FragmentNewsBinding fragmentNewsBinding;
    List<NewsPreviewBean> newsPreviewBeanList = new ArrayList<>(50);

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        fragmentNewsBinding = DataBindingUtil.inflate(inflater, R.layout.fragment_news, null, false);
        return fragmentNewsBinding.getRoot();
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        SwipeRefreshLayout srlNewsRefreshing = fragmentNewsBinding.srlNewsRefreshing;
        srlNewsRefreshing.setColorSchemeColors(Color.RED, Color.BLUE, Color.CYAN);
        srlNewsRefreshing.setRefreshing(true);
        // setup adapter
        RecyclerView rvNewsItem = fragmentNewsBinding.rvNewsItem;
        NewsListAdapter adapter = new NewsListAdapter();
        rvNewsItem.setAdapter(adapter);
        rvNewsItem.setLayoutManager(new LinearLayoutManager(getContext()));
        WorkerPool.getInstance().execute1(() -> {
            try {
                if (newsPreviewBeanList.size() == 0) {
                    NewsListData newsListData = NewsHandler.getInstance().getNewsList(1);
                    newsPreviewBeanList.addAll(newsListData.getResults());
                }
                getActivity().runOnUiThread(() -> {
                    adapter.setNewsList(newsPreviewBeanList);
                    srlNewsRefreshing.setRefreshing(false);
                });
            } catch (IOException e) {
                e.printStackTrace();
            }
        });
        // setup swipe refresh layout

        srlNewsRefreshing.setOnRefreshListener(() ->
                WorkerPool.getInstance().submit2(NewsFragment.this.getActivity(), () -> {
                    try {
                        NewsHandler.getInstance().refreshNewsListCache(1);
                        newsPreviewBeanList.clear();
                        NewsListData newsListData = NewsHandler.getInstance().getNewsList(1);
                        newsPreviewBeanList.addAll(newsListData.getResults());

                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                    return newsPreviewBeanList;
                }, o -> {
                    getActivity().runOnUiThread(() -> {
                        adapter.setNewsList(o);
                        srlNewsRefreshing.setRefreshing(false);
                    });
                }));


        // setup on click event
        rvNewsItem.addOnItemTouchListener(new RecyclerView.SimpleOnItemTouchListener() {
            final RecyclerView rv = rvNewsItem;

            GestureDetector gd = new GestureDetector(NewsFragment.this.getActivity(), new GestureDetector.SimpleOnGestureListener() {
                int getItemPosition(MotionEvent e) {
                    View childViewUnder = rv.findChildViewUnder(e.getX(), e.getY());
                    if (childViewUnder == null) {
                        return -1;
                    }
                    return rv.getChildAdapterPosition(childViewUnder);
                }

                @Override
                public boolean onSingleTapConfirmed(MotionEvent e) {
                    long startTime = System.currentTimeMillis();
                    int childAdapterPosition = getItemPosition(e);
                    if (newsPreviewBeanList == null) {
                        return false;
                    }
                    NewsPreviewBean newsItem = newsPreviewBeanList.get(childAdapterPosition);
                    if (newsItem != null) {
                        View childViewUnder = rv.findChildViewUnder(e.getX(), e.getY());
                        int newsId = newsItem.getId();
                        Intent i = new Intent(NewsFragment.this.getActivity(), NewsDetailActivity.class);
                        i.putExtra(Consts.KEY_NEWS_ID, newsId);
                        ActivityOptionsCompat activityOptions = ActivityOptionsCompat.makeSceneTransitionAnimation(getActivity(),
                                childViewUnder.findViewById(R.id.tv_news_item_title), NewsDetailActivity.VIEW_NAME_HEADER_TITLE);
                        ActivityCompat.startActivity(NewsFragment.this.getActivity(), i, activityOptions.toBundle());
                        return true;
                    }
                    return false;
                }
            });

            @Override
            public boolean onInterceptTouchEvent(@NonNull RecyclerView rv, @NonNull MotionEvent e) {
                return gd.onTouchEvent(e);
            }

            @Override
            public void onTouchEvent(@NonNull RecyclerView rv, @NonNull MotionEvent e) {
                gd.onTouchEvent(e);
            }
        });

    }


    @Override
    public void onDestroy() {
        super.onDestroy();
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
    }
}