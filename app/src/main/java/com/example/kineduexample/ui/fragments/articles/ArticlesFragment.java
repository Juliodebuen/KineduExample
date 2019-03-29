package com.example.kineduexample.ui.fragments.articles;


import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;
import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.kineduexample.R;
import com.example.kineduexample.data.network.KineduInteractor;
import com.example.kineduexample.data.network.KineduInteractorImpl;
import com.example.kineduexample.data.network.model.Articles;
import com.example.kineduexample.ui.article_details.ArticleDetailsActivity;
import com.example.kineduexample.ui.fragments.articles.adapter.ArticlesAdapter;
import com.example.kineduexample.ui.fragments.MainViewModel;
import com.example.kineduexample.ui.fragments.articles.adapter.OnArticleClickListener;

import java.util.List;

/**
 * A simple {@link Fragment} subclass.
 */
public class ArticlesFragment extends Fragment implements ArticlesView, OnArticleClickListener {
    private KineduInteractor interactor;
    private ArticlesPresenter presenter;
    private List<Articles> articlesList;
    private MainViewModel mMainViewModel;
    private Unbinder unbinder;
    private ArticlesAdapter adapter;


    @BindView(R.id.articlesRecyclerView)
    RecyclerView mRecyclerView;

    @BindView(R.id.swipeRefresh)
    SwipeRefreshLayout swipeRefresh;

    public static ArticlesFragment newInstance() {
        return  new ArticlesFragment();
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_articles, container, false);
        unbinder = ButterKnife.bind(this, rootView);
        mMainViewModel = ViewModelProviders.of(getActivity()).get(MainViewModel.class);

        interactor = new KineduInteractorImpl();
        presenter = new ArticlesPresenter(interactor);
        presenter.bind(this);

        presenter.searchArticles();
        mMainViewModel.setShowDialog(true);

        swipeRefresh.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
                presenter.searchArticles();
                mMainViewModel.setResetSpinner(true);
            }
        });

        mMainViewModel.getAgeFilter().observe(this, new Observer<Integer>() {
            @Override
            public void onChanged(Integer integer) {
                if(adapter != null){
                    adapter.getFilter().filter(String.valueOf(integer));
                }
            }
        });

        return rootView;
    }

    @Override
    public void onDestroy() {
        presenter.unbind();
        unbinder.unbind();
        super.onDestroy();
    }

    @Override
    public void onLoadBitmaps(List<Bitmap> bitmaps) {
        if(articlesList != null && articlesList.size() > 0){
            adapter = new ArticlesAdapter(articlesList, bitmaps);
            adapter.setArticleListener(this);
            LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getContext());
            linearLayoutManager.setOrientation(RecyclerView.VERTICAL);
            mRecyclerView.setAdapter(adapter);
            mRecyclerView.setLayoutManager(linearLayoutManager);
            mMainViewModel.setShowDialog(false);
            swipeRefresh.setRefreshing(false);
        }

    }

    @Override
    public void onLoadArticles(List<Articles> articles) {
        presenter.getImagesForArticles(articles);
        this.articlesList = articles;
    }

    @Override
    public void onArticleClick(int articleId) {
        Intent intent = new Intent(getContext(), ArticleDetailsActivity.class);
        intent.putExtra("articleId", articleId);
        startActivity(intent);
    }
}
