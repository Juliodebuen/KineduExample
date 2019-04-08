package com.example.kineduexample.ui.fragments.activities

import com.example.kineduexample.data.network.KineduInteractor
import com.example.kineduexample.data.network.model.ActivitiesIndex
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class ActivitiesPresenter(private val interactor: KineduInteractor) {
    private var view: ActivitiesView? = null

    fun bind(view: ActivitiesView) {
        this.view = view
    }

    fun unbind() {
        view = null
    }

    fun searchActivities() {
        interactor.getActivities()
                .enqueue(object : Callback<ActivitiesIndex> {
                    override fun onResponse(call: Call<ActivitiesIndex>, response: Response<ActivitiesIndex>) {
                        if (view != null) {
                            view!!.onLoadActivities(response.body().dataActivities!!.activities!!)
                        }
                    }

                    override fun onFailure(call: Call<ActivitiesIndex>, t: Throwable) {
                        t.printStackTrace()
                    }
                })
    }

}
