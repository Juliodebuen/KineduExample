package com.example.kineduexample.ui.main
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import android.graphics.Color
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.AdapterView
import android.widget.TextView
import androidx.databinding.DataBindingUtil
import com.example.kineduexample.R
import com.example.kineduexample.data.network.KineduInteractor
import com.example.kineduexample.data.network.KineduInteractorImpl
import com.example.kineduexample.data.network.model.DataActivities
import com.example.kineduexample.databinding.ActivityMainBinding
import com.example.kineduexample.ui.base.BaseActivity
import com.example.kineduexample.ui.fragments.MainViewModel
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : BaseActivity(), MainView {
    private var interactor: KineduInteractor? = null
    private var presenter: MainPresenter? = null
    private var viewPagerAdapter: ViewPagerAdapter? = null
    private var mMainViewModel: MainViewModel? = null
    private lateinit var binding: ActivityMainBinding

    private val listener = object : AdapterView.OnItemSelectedListener {
        override fun onItemSelected(parent: AdapterView<*>, view: View, position: Int, id: Long) {
            (parent.getChildAt(0) as TextView).setTextColor(Color.WHITE)
            mMainViewModel!!.setAgeFilter(presenter!!.getSelectedSpinnerValue(ageSpinner!!.selectedItem.toString()))
        }

        override fun onNothingSelected(parent: AdapterView<*>) {

        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        //setContentView(R.layout.activity_main)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)

        mMainViewModel = ViewModelProviders.of(this).get(MainViewModel::class.java)
        setProgressDialog(getString(R.string.loading))

        interactor = KineduInteractorImpl()
        presenter = MainPresenter(interactor as KineduInteractorImpl)
        presenter!!.bind(this)

        binding.toolbar.setNavigationOnClickListener { onBackPressed() }

        viewPagerAdapter = ViewPagerAdapter(supportFragmentManager, this)

        binding.adapter = viewPagerAdapter
        binding.setupViewPager = viewpager
        binding.spinnerListener = listener

        mMainViewModel!!.showDialog.observe(this, Observer { aBoolean ->
            if (aBoolean!!) {
                showProgressDialog()
            } else {
                hideProgressDialog()
            }
        })

        mMainViewModel!!.resetSpinner.observe(this, Observer { aBoolean ->
            if (aBoolean!!) {
                ageSpinner!!.setSelection(0)
            }
        })


    }


    override fun updateUI(dataActivities: DataActivities) {
        Log.d("Result", dataActivities.toString())
    }

    override fun onDestroy() {
        presenter!!.unbind()
        super.onDestroy()
    }
}
