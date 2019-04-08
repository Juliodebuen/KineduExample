package com.example.kineduexample.ui.fragments.articles.adapter

import android.widget.ImageView
import android.widget.TextView

interface OnArticleClickListener {
    fun onArticleClick(articleId: Int, picture: ImageView, shorDescription: TextView)
}
