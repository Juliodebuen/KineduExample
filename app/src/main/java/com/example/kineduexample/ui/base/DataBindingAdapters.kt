package com.example.kineduexample.ui.base

import android.graphics.drawable.Drawable
import android.widget.ImageView
import android.widget.TextView

import com.example.kineduexample.ui.fragments.activities.adapter.ActivitiesAdapter

import java.text.SimpleDateFormat
import java.util.Date
import java.util.Locale

import androidx.databinding.BindingAdapter
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.kineduexample.ui.fragments.articles.adapter.ArticlesAdapter
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.activity_article_details.*

object DataBindingAdapters {
    @BindingAdapter("imageResource")
    fun setImageDrawable(view: ImageView, picture: String) {
        //view.setImageDrawable(drawable)
        Picasso.with(applicationContext).load(picture)
                .noFade()
                .into(view)
    }

    @BindingAdapter("adapter")
    fun setAdapter(recyclerView: RecyclerView, adapter: ActivitiesAdapter) {
        recyclerView.adapter = adapter
    }

    @BindingAdapter("adapter")
    fun setAdapter(recyclerView: RecyclerView, adapter: ArticlesAdapter) {
        recyclerView.adapter = adapter
    }

    @BindingAdapter("layoutManager")
    fun setLayoutManager(recyclerView: RecyclerView, layoutManager: LinearLayoutManager) {
        recyclerView.layoutManager = layoutManager
    }

    @BindingAdapter("fixedSize")
    fun setFixedSize(recyclerView: RecyclerView, fixedSize: Boolean){
        recyclerView.setHasFixedSize(fixedSize)
    }

    @BindingAdapter("date")
    fun setDate(textView: TextView, date: Date) {
        val myFormat = "dd/MM/yyyy"
        val sdf = SimpleDateFormat(myFormat, Locale.US)
        textView.text = sdf.format(date)
    }
}
