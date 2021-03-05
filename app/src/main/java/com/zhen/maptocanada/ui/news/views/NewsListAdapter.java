package com.zhen.maptocanada.ui.news.views;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import androidx.recyclerview.widget.RecyclerView;

import com.zhen.maptocanada.R;
import com.zhen.maptocanada.data.news.NewsListData;
import com.zhen.maptocanada.databinding.ItemNewsBinding;

import java.util.List;

public class NewsListAdapter extends RecyclerView.Adapter<NewsListAdapter.NewsListItemViewHolder> {

    private List<NewsListData.NewsPreviewBean> newsList;
    public ItemNewsBinding itemViewBinding;

    @NonNull
    @Override
    public NewsListItemViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        itemViewBinding = DataBindingUtil.inflate(layoutInflater, R.layout.item_news, parent, false);
        return new NewsListItemViewHolder(itemViewBinding);
    }

    @Override
    public void onBindViewHolder(@NonNull NewsListItemViewHolder holder, int position) {
        NewsListData.NewsPreviewBean item = newsList.get(position);
        holder.itemNewsBinding.setNewsItem(item);
    }

    @Override
    public int getItemCount() {
        if (newsList != null) {
            return newsList.size();
        }
        return 0;
    }

    public void setNewsList(List<NewsListData.NewsPreviewBean> newsList) {
        this.newsList = newsList;
        notifyDataSetChanged();
    }

    static class NewsListItemViewHolder extends RecyclerView.ViewHolder {

        ItemNewsBinding itemNewsBinding;

        public NewsListItemViewHolder(ItemNewsBinding newsBinding) {
            super(newsBinding.getRoot());
            this.itemNewsBinding = newsBinding;
        }
    }
}
