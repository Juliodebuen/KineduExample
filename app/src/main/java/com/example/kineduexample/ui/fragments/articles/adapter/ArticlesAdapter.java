package com.example.kineduexample.ui.fragments.articles.adapter;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Filter;
import android.widget.Filterable;
import android.widget.ImageView;
import android.widget.TextView;
import com.example.kineduexample.R;
import com.example.kineduexample.data.network.model.Articles;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.List;
import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.core.app.ActivityOptionsCompat;
import androidx.recyclerview.widget.RecyclerView;
import butterknife.BindView;
import butterknife.ButterKnife;

public class ArticlesAdapter extends RecyclerView.Adapter<ArticlesAdapter.ArticlesViewHolder> implements Filterable {
    private List<Articles> articlesList;
    private List<Articles> filteredData;
    private List<Articles> nList;
    private ItemFilter mFilter = new ItemFilter();
    private Context context;
    private OnArticleClickListener mListener;

    public ArticlesAdapter(Context context, List<Articles> articlesList){
        this.articlesList = articlesList;
        this.filteredData = articlesList;
        this.context = context;
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

    public Articles getItem(int position){
        return filteredData.get(position);
    }

    @Override
    public void onBindViewHolder(@NonNull final ArticlesViewHolder holder, final int position) {
        final Articles item = getItem(position);
        holder.name.setText(item.getName());
        holder.shorDescription.setText(item.getShortDescription());
        Picasso.with(context).load(item.getPicture()).into(holder.picture);

        holder.articleCard.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mListener.onArticleClick(item.getId(), holder.picture, holder.shorDescription);
            }
        });

    }

    @Override
    public int getItemCount() {
        return filteredData.size();
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

    @Override
    public Filter getFilter() {
        return mFilter;
    }

    private class ItemFilter extends Filter {

        @Override
        protected FilterResults performFiltering(CharSequence constraint) {
            String filterString = "";
            if(constraint != null)
                filterString = constraint.toString().toLowerCase();

            FilterResults results = new FilterResults();
            final List<Articles> items = articlesList;
            int count = items.size();

            nList = new ArrayList<>(count);
            if(!filterString.equals("-1")){
                for(int i = 0; i < count; i++){
                    if(items.get(i).getMinAge() <= Integer.valueOf(filterString) && items.get(i).getMaxAge() >= Integer.valueOf(filterString)){
                        nList.add(items.get(i));
                    }
                }
            }else{
                nList = articlesList;
            }

            results.values = nList;
            results.count = nList.size();

            return results;
        }

        @Override
        protected void publishResults(CharSequence constraint, FilterResults results) {
            filteredData = (ArrayList<Articles>) results.values;
            notifyDataSetChanged();
        }
    }
}
