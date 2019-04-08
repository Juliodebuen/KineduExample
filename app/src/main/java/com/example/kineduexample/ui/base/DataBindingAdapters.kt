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

object DataBindingAdapters {
    @BindingAdapter("imageResource")
    fun setImageDrawable(view: ImageView, drawable: Drawable) {
        view.setImageDrawable(drawable)
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
