package com.example.kineduexample.ui.fragments.activities.adapter;

import android.graphics.Bitmap;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.kineduexample.R;
import com.example.kineduexample.data.network.model.Activities;

import java.util.List;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import butterknife.BindView;
import butterknife.ButterKnife;

public class ActivitiesAdapter extends RecyclerView.Adapter<ActivitiesAdapter.ActivitiesViewHolder>{
    List<Activities> activitiesList;
    List<Bitmap> bitmaps;

    public ActivitiesAdapter(List<Activities> activitiesList, List<Bitmap> bitmaps){
        this.activitiesList = activitiesList;
        this.bitmaps = bitmaps;
    }

    @NonNull
    @Override
    public ActivitiesViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.activities_item, parent, false);
        ActivitiesViewHolder activitiesViewHolder = new ActivitiesViewHolder(v);
        return activitiesViewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull ActivitiesViewHolder holder, int position) {
        holder.name.setText(activitiesList.get(position).getName());
        holder.purpose.setText(activitiesList.get(position).getPurpose());
        holder.thumbnail.setImageBitmap(bitmaps.get(position));
    }

    @Override
    public int getItemCount() {
        return activitiesList.size();
    }


    public class ActivitiesViewHolder extends RecyclerView.ViewHolder {
        @BindView(R.id.thumbnail)
        ImageView thumbnail;

        @BindView(R.id.name)
        TextView name;

        @BindView(R.id.purpose)
        TextView purpose;

        public ActivitiesViewHolder(@NonNull View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView.getRootView());
        }
    }
}
