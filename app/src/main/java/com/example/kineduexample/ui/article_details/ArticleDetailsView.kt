package com.example.kineduexample.ui.article_details

import com.example.kineduexample.data.network.model.ArticleDetail

interface ArticleDetailsView {
    fun onLoadArticleDetails(articleDetail: ArticleDetail)
    fun onShareBtnClick(link: String?)
}
