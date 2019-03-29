package com.example.kineduexample.ui.fragments.activities.adapter;

import android.content.Context;
import android.graphics.Bitmap;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
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
    Context context;

    public ActivitiesAdapter(Context context, List<Activities> activitiesList, List<Bitmap> bitmaps){
        this.activitiesList = activitiesList;
        this.bitmaps = bitmaps;
        this.context = context;
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
        holder.milestonesNumber(activitiesList.get(position).getActiveMilestones());
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
    }
}
