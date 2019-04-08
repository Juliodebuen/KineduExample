package com.example.kineduexample.ui.fragments.articles

import com.example.kineduexample.data.network.KineduInteractor
import com.example.kineduexample.data.network.model.ArticlesIndex
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class ArticlesPresenter(private val interactor: KineduInteractor) {
    private var view: ArticlesView? = null

    fun bind(view: ArticlesView) {
        this.view = view
    }

    fun unbind() {
        view = null
    }

    fun searchArticles() {
        interactor.getArticles()
                .enqueue(object : Callback<ArticlesIndex> {
                    override fun onResponse(call: Call<ArticlesIndex>, response: Response<ArticlesIndex>) {
                        if (view != null)
                            view!!.onLoadArticles(response.body().data!!.articles!!)
                    }

                    override fun onFailure(call: Call<ArticlesIndex>, t: Throwable) {

                    }
                })
    }

}
