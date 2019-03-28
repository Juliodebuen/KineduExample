package com.example.kineduexample.ui.fragments.articles.adapter;

import android.graphics.Bitmap;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.kineduexample.R;
import com.example.kineduexample.data.network.model.Articles;

import java.util.List;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;
import butterknife.BindView;
import butterknife.ButterKnife;

public class ArticlesAdapter extends RecyclerView.Adapter<ArticlesAdapter.ArticlesViewHolder> {
    private List<Articles> articlesList;
    private List<Bitmap> bitmaps;
    private OnArticleClickListener mListener;

    public ArticlesAdapter(List<Articles> articlesList, List<Bitmap> bitmaps){
        this.articlesList = articlesList;
        this.bitmaps = bitmaps;
    }

    public void setArticleListener(OnArticleClickListener mListener){
        this.mListener = mListener;
    }

    @NonNull
    @Override
    public ArticlesViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.articles_item, parent, false);
        ArticlesViewHolder articlesViewHolder = new ArticlesViewHolder(v);
        return articlesViewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull ArticlesViewHolder holder, final int position) {
        holder.name.setText(articlesList.get(position).getName());
        holder.shorDescription.setText(articlesList.get(position).getShortDescription());
        holder.picture.setImageBitmap(bitmaps.get(position));

        holder.articleCard.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mListener.onArticleClick(articlesList.get(position).getId());
            }
        });
    }

    @Override
    public int getItemCount() {
        return articlesList.size();
    }

    public class ArticlesViewHolder extends RecyclerView.ViewHolder {
        @BindView(R.id.name)
        TextView name;

        @BindView(R.id.short_description)
        TextView shorDescription;

        @BindView(R.id.picture)
        ImageView picture;

        @BindView(R.id.article_card)
        CardView articleCard;

        public ArticlesViewHolder(@NonNull View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView.getRootView());
        }
    }
}
