package com.zhen.maptocanada.ui.news;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.zhen.maptocanada.R;
import com.zhen.maptocanada.data.news.NewsListData;
import com.zhen.maptocanada.httpdata.HttpManager;
import com.zhen.maptocanada.ui.news.views.NewsListAdapter;
import com.zhen.maptocanada.utility.Utils;
import com.zhen.maptocanada.utility.WorkerPool;

import java.io.IOException;

import okhttp3.Response;

public class NewsFragment extends Fragment {

    private NewsViewModel dashboardViewModel;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        View root = inflater.inflate(R.layout.fragment_news, container, false);
        return root;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        RecyclerView rvNewsItem = getView().findViewById(R.id.rv_news_item);
        NewsListAdapter adapter = new NewsListAdapter();
        rvNewsItem.setAdapter(adapter);
        rvNewsItem.setLayoutManager(new LinearLayoutManager(getContext()));
        WorkerPool instance = WorkerPool.getInstance();
        instance.execute1(()->{
            try {
                Response newsList = HttpManager.getInstance().getNewsList(1, 100);
                NewsListData newsListData = Utils.parseNewsList(newsList.body().string());
                getActivity().runOnUiThread(()->{
                    adapter.setNewsList(newsListData.getResults());
                });
            } catch (IOException e) {
                e.printStackTrace();
            }
        });
    }
}