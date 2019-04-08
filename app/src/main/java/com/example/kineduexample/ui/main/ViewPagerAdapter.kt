package com.example.kineduexample.ui.main

import android.content.Context

import com.example.kineduexample.R
import com.example.kineduexample.ui.fragments.activities.ActivitesFragment
import com.example.kineduexample.ui.fragments.articles.ArticlesFragment
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentPagerAdapter

class ViewPagerAdapter(fm: FragmentManager, private val context: Context) : FragmentPagerAdapter(fm) {
    private val NUM_FRAGMENTS = 2

    override fun getItem(position: Int): Fragment {
        return if (position == 0) {
            ActivitesFragment.newInstance()
        } else {
            ArticlesFragment.newInstance()
        }
    }

    override fun getPageTitle(position: Int): CharSequence? {
        return if (position == 0) {
            context.getString(R.string.activities)
        } else {
            context.getString(R.string.articles)
        }
    }

    override fun getCount(): Int {
        return NUM_FRAGMENTS
    }
}
