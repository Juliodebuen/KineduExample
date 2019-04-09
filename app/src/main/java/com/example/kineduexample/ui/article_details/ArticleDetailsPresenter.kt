package com.example.kineduexample.ui.article_details

import android.util.Log
import com.example.kineduexample.data.network.KineduInteractor
import com.example.kineduexample.data.network.model.ArticleDetailsIndex
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class ArticleDetailsPresenter(private val interactor: KineduInteractor) {
    private var view: ArticleDetailsView? = null

    fun bind(view: ArticleDetailsView) {
        this.view = view
    }

    fun unbind() {
        view = null
    }

    fun searchArticleDetails(articleId: Int) {
        interactor.getArticleDetails(articleId)
                .enqueue(object : Callback<ArticleDetailsIndex> {
                    override fun onResponse(call: Call<ArticleDetailsIndex>, response: Response<ArticleDetailsIndex>) {
                        view!!.onLoadArticleDetails(response.body().data!!.articleDetail!!)
                    }

                    override fun onFailure(call: Call<ArticleDetailsIndex>, t: Throwable) {

                    }
                })
    }

    fun onClick(link: String?){
        view!!.onShareBtnClick(link)
    }
}
