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
      //  for(int i = 0; i < activitiesList.get(position).getActiveMilestones(); i++){
            LinearLayout linearLayout = new LinearLayout(context);
            ImageView imageView = new ImageView(context);
            imageView.setId(View.generateViewId());
            imageView.setVisibility(View.VISIBLE);
            imageView.setImageResource(R.drawable.baby_crawling);
            LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(LinearLayout.LayoutParams.WRAP_CONTENT, LinearLayout.LayoutParams.WRAP_CONTENT);
            imageView.setLayoutParams(new LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT, LinearLayout.LayoutParams.WRAP_CONTENT));
            imageView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Log.d("asdasd", ":::::::::::");
                }
            });
            linearLayout.addView(imageView);
            holder.milestonesContainer.addView(linearLayout);
            Log.d("doaijdsa", ":adsdasd");
     //   }
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

        @BindView(R.id.milestones_container)
        LinearLayout milestonesContainer;

        public ActivitiesViewHolder(@NonNull View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView.getRootView());
        }
    }
}
