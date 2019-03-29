package com.example.kineduexample.ui.fragments.activities.adapter;

import android.graphics.Bitmap;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Filter;
import android.widget.Filterable;
import android.widget.ImageView;
import android.widget.TextView;
import com.example.kineduexample.R;
import com.example.kineduexample.data.network.model.Activities;
import java.util.ArrayList;
import java.util.List;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import butterknife.BindView;
import butterknife.ButterKnife;

public class ActivitiesAdapter extends RecyclerView.Adapter<ActivitiesAdapter.ActivitiesViewHolder> implements Filterable {
    private List<Activities> activitiesList;
    private List<Activities> filteredData;
    private List<Activities> nList;
    private List<Bitmap> bitmaps;
    private List<Bitmap> filteredBitmaps;
    private List<Bitmap> nListBitmap;
    private ItemFilter mFilter = new ItemFilter();


    public ActivitiesAdapter(List<Activities> activitiesList, List<Bitmap> bitmaps){
        this.activitiesList = activitiesList;
        this.filteredData = activitiesList;
        this.bitmaps = bitmaps;
        this.filteredBitmaps = bitmaps;
    }

    @NonNull
    @Override
    public ActivitiesViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.activities_item, parent, false);
        ActivitiesViewHolder activitiesViewHolder = new ActivitiesViewHolder(v);
        return activitiesViewHolder;
    }

    public Activities getItem(int position){
        return filteredData.get(position);
    }

    @Override
    public void onBindViewHolder(@NonNull ActivitiesViewHolder holder, int position) {
        Activities item = getItem(position);
        holder.name.setText(item.getName());
        holder.purpose.setText(item.getPurpose());
        holder.thumbnail.setImageBitmap(filteredBitmaps.get(position));
        holder.milestonesNumber(item.getActiveMilestones());
    }

    @Override
    public int getItemCount() {
        return filteredData.size();
    }


    public class ActivitiesViewHolder extends RecyclerView.ViewHolder {
        @BindView(R.id.thumbnail)
        ImageView thumbnail;

        @BindView(R.id.name)
        TextView name;

        @BindView(R.id.purpose)
        TextView purpose;

        @BindView(R.id.check1)
        ImageView check1;

        @BindView(R.id.check2)
        ImageView check2;

        @BindView(R.id.check3)
        ImageView check3;

        @BindView(R.id.check4)
        ImageView check4;

        @BindView(R.id.check5)
        ImageView check5;

        public ActivitiesViewHolder(@NonNull View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView.getRootView());
        }

        public void milestonesNumber(int value){
            clearAll();
            switch (value){
                case 5:
                    check1.setVisibility(View.VISIBLE);
                case 4:
                    check2.setVisibility(View.VISIBLE);
                case 3:
                    check3.setVisibility(View.VISIBLE);
                case 2:
                    check4.setVisibility(View.VISIBLE);
                case 1:
                    check5.setVisibility(View.VISIBLE);
            }
        }

        private void clearAll(){
            check1.setVisibility(View.GONE);
            check2.setVisibility(View.GONE);
            check3.setVisibility(View.GONE);
            check4.setVisibility(View.GONE);
            check5.setVisibility(View.GONE);
        }
    }

    @Override
    public Filter getFilter() {
        return mFilter;
    }

    private class ItemFilter extends Filter{
        @Override
        protected FilterResults performFiltering(CharSequence constraint) {
            String filterString = "";
            if(constraint != null)
                filterString = constraint.toString().toLowerCase();

            FilterResults results = new FilterResults();

            final List<Activities> items = activitiesList;
            int count = items.size();

            nList = new ArrayList<>(count);
            nListBitmap = new ArrayList<>(count);
            if(!filterString.equals("-1")) {
                for (int i = 0; i < count; i++) {
                    if (items.get(i).getAge() == Integer.valueOf(filterString)) {
                        nList.add(items.get(i));
                        nListBitmap.add(bitmaps.get(i));
                    }
                }
            }else{
                nList = activitiesList;
                nListBitmap = bitmaps;
            }

            results.values = nList;
            results.count = nList.size();

            filteredBitmaps = nListBitmap;

            return results;
        }

        @Override
        protected void publishResults(CharSequence constraint, FilterResults results) {
            filteredData = (ArrayList<Activities>) results.values;
            notifyDataSetChanged();
        }
    }
}
