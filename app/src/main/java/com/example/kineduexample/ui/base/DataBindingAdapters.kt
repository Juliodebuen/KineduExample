package com.example.kineduexample.ui.base

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

object DataBindingAdapters {
    @JvmStatic
    @BindingAdapter("imageResource")
    fun setImageDrawable(view: ImageView, picture: String) {
        //view.setImageDrawable(drawable)
        Picasso.with(view.context).load(picture)
                .noFade()
                .into(view)
    }

    @JvmStatic
    @BindingAdapter("adapter")
    fun setAdapter(recyclerView: RecyclerView, adapter: ActivitiesAdapter) {
        recyclerView.adapter = adapter
    }

    @JvmStatic
    @BindingAdapter("adapter")
    fun setAdapter(recyclerView: RecyclerView, adapter: ArticlesAdapter) {
        recyclerView.adapter = adapter
    }

    @JvmStatic
    @BindingAdapter("layoutManager")
    fun setLayoutManager(recyclerView: RecyclerView, layoutManager: LinearLayoutManager) {
        recyclerView.layoutManager = layoutManager
    }

    @JvmStatic
    @BindingAdapter("fixedSize")
    fun setFixedSize(recyclerView: RecyclerView, fixedSize: Boolean){
        recyclerView.setHasFixedSize(fixedSize)
    }

    @JvmStatic
    @BindingAdapter("date")
    fun setDate(textView: TextView, date: Date) {
        val myFormat = "dd/MM/yyyy"
        val sdf = SimpleDateFormat(myFormat, Locale.US)
        textView.text = sdf.format(date)
    }
}
