package com.example.kineduexample.ui.base

import android.text.Html
import android.text.method.LinkMovementMethod
import android.view.View
import android.widget.AdapterView
import android.widget.ImageView
import android.widget.Spinner
import android.widget.TextView

import com.example.kineduexample.ui.fragments.activities.adapter.ActivitiesAdapter

import java.text.SimpleDateFormat
import java.util.Date
import java.util.Locale

import androidx.databinding.BindingAdapter
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import androidx.viewpager.widget.ViewPager
import com.example.kineduexample.ui.fragments.articles.adapter.ArticlesAdapter
import com.example.kineduexample.ui.main.ViewPagerAdapter
import com.google.android.material.tabs.TabLayout
import com.squareup.picasso.Picasso

object DataBindingAdapters {
    @JvmStatic
    @BindingAdapter("app:imageResource")
    fun setImageDrawable(view: ImageView, picture: String?) {
        Picasso.with(view.context).load(picture)
                .noFade()
                .into(view)
    }

    @JvmStatic
    @BindingAdapter("app:htmlText")
    fun setHtmlText(view: TextView, htmlText: String?){
        if(htmlText != null) {
            view.text = Html.fromHtml(htmlText, Html.FROM_HTML_MODE_LEGACY)
            view.movementMethod = LinkMovementMethod.getInstance()
        }
    }

    @JvmStatic
    @BindingAdapter("app:setVisibility")
    fun setVisibility(view: ImageView, value: Int){
        view.visibility = View.GONE
    }

    @JvmStatic
    @BindingAdapter("app:viewPagerAdaper")
    fun setViewPagerAdapter(view: ViewPager, adapter: ViewPagerAdapter?){
        view.adapter = adapter
    }

    @JvmStatic
    @BindingAdapter("app:setupWithViewPager")
    fun setupWithViewPager(view: TabLayout, viewPager: ViewPager){
        view.setupWithViewPager(viewPager)
    }

    @JvmStatic
    @BindingAdapter("app:setupListener")
    fun setupListener(view: Spinner, mListener: AdapterView.OnItemSelectedListener){
        view.onItemSelectedListener = mListener
    }

    @JvmStatic
    @BindingAdapter("app:adapter")
    fun setAdapter(recyclerView: RecyclerView, adapter: ActivitiesAdapter?) {
        recyclerView.adapter = adapter
    }

    @JvmStatic
    @BindingAdapter("app:adapter")
    fun setAdapter(recyclerView: RecyclerView, adapter: ArticlesAdapter?) {
        recyclerView.adapter = adapter
    }

    @JvmStatic
    @BindingAdapter("app:layoutManager")
    fun setLayoutManager(recyclerView: RecyclerView, layoutManager: LinearLayoutManager?) {
        recyclerView.layoutManager = layoutManager
    }

    @JvmStatic
    @BindingAdapter("app:fixedSize")
    fun setFixedSize(recyclerView: RecyclerView, fixedSize: Boolean){
        recyclerView.setHasFixedSize(fixedSize)
    }

    @JvmStatic
    @BindingAdapter("app:date")
    fun setDate(textView: TextView, date: Date) {
        val myFormat = "dd/MM/yyyy"
        val sdf = SimpleDateFormat(myFormat, Locale.US)
        textView.text = sdf.format(date)
    }
}
