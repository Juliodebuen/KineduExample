package com.example.kineduexample.ui.fragments.activities

import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import android.os.Bundle
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.ViewTreeObserver
import com.example.kineduexample.R
import com.example.kineduexample.data.network.KineduInteractor
import com.example.kineduexample.data.network.KineduInteractorImpl
import com.example.kineduexample.data.network.model.Activities
import com.example.kineduexample.ui.fragments.activities.adapter.ActivitiesAdapter
import com.example.kineduexample.ui.fragments.MainViewModel
import kotlinx.android.synthetic.main.activites_fragment.*

class ActivitesFragment : Fragment(), ActivitiesView {

    private var interactor: KineduInteractor? = null
    private var presenter: ActivitiesPresenter? = null
    private var mMainViewModel: MainViewModel? = null
    private var adapter: ActivitiesAdapter? = null

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.activites_fragment, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        mMainViewModel = ViewModelProviders.of(activity!!).get(MainViewModel::class.java)

        interactor = KineduInteractorImpl()
        presenter = ActivitiesPresenter(interactor as KineduInteractorImpl)
        presenter!!.bind(this)

        presenter!!.searchActivities()
        mMainViewModel!!.setShowDialog(true)

        swipeRefresh!!.setOnRefreshListener {
            presenter!!.searchActivities()
            mMainViewModel!!.setResetSpinner(true)
        }

        mMainViewModel!!.ageFilter.observe(this, Observer { integer ->
            if (adapter != null) {
                adapter!!.filter.filter(integer.toString())
            }
        })
    }

    override fun onDestroy() {
        presenter!!.unbind()
        super.onDestroy()
    }

    override fun onLoadActivities(activities: List<Activities>) {
        if (activities != null && activities.isNotEmpty()) {
            adapter = ActivitiesAdapter(context!!, activities as MutableList<Activities>)
            val linearLayoutManager = LinearLayoutManager(context)
            linearLayoutManager.orientation = RecyclerView.VERTICAL
            activitiesRecyclerView!!.adapter = adapter
            activitiesRecyclerView!!.layoutManager = linearLayoutManager
            activitiesRecyclerView!!.viewTreeObserver
                    .addOnGlobalLayoutListener(object : ViewTreeObserver.OnGlobalLayoutListener {
                        override fun onGlobalLayout() {
                            mMainViewModel!!.setShowDialog(false)
                            activitiesRecyclerView!!.viewTreeObserver.removeOnGlobalLayoutListener(this)
                        }
                    })
            swipeRefresh!!.isRefreshing = false
        }
    }

    companion object {

        fun newInstance(): ActivitesFragment {
            return ActivitesFragment()
        }
    }
}
