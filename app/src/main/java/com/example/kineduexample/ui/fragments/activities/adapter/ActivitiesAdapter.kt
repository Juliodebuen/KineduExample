package com.example.kineduexample.ui.fragments.activities.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Filter
import android.widget.Filterable
import android.widget.ImageView
import android.widget.TextView
import com.example.kineduexample.R
import com.example.kineduexample.data.network.model.Activities
import com.squareup.picasso.Picasso
import java.util.ArrayList
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.activities_item.view.*

class ActivitiesAdapter(private val context: Context, private val activitiesList: MutableList<Activities>) : RecyclerView.Adapter<ActivitiesAdapter.ActivitiesViewHolder>(), Filterable {
    private var filteredData: List<Activities>? = null
    private var nList: MutableList<Activities>? = null
    private val mFilter = ItemFilter()


    init {
        this.filteredData = activitiesList
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ActivitiesViewHolder {
        val v = LayoutInflater.from(parent.context).inflate(R.layout.activities_item, parent, false)
        return ActivitiesViewHolder(v)
    }

    fun getItem(position: Int): Activities {
        return filteredData!![position]
    }

    override fun onBindViewHolder(holder: ActivitiesViewHolder, position: Int) {
        val item = getItem(position)
        holder.name!!.text = item.name
        holder.purpose!!.text = item.purpose
        Picasso.with(context).load(item.thumbnail).into(holder.thumbnail)
        holder.milestonesNumber(item.activeMilestones!!)
    }

    override fun getItemCount(): Int {
        return filteredData!!.size
    }


    inner class ActivitiesViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        internal var thumbnail: ImageView? = itemView.thumbnail
        internal var name: TextView? = itemView.name
        internal var purpose: TextView? = itemView.purpose
        internal var check1: ImageView? = itemView.check1
        internal var check2: ImageView? = itemView.check2
        internal var check3: ImageView? = itemView.check3
        internal var check4: ImageView? = itemView.check4
        internal var check5: ImageView? = itemView.check5

        fun milestonesNumber(value: Int) {
            clearAll()
            when (value) {
                5 -> {
                    check1!!.visibility = View.VISIBLE
                    check2!!.visibility = View.VISIBLE
                    check3!!.visibility = View.VISIBLE
                    check4!!.visibility = View.VISIBLE
                    check5!!.visibility = View.VISIBLE
                }
                4 -> {
                    check2!!.visibility = View.VISIBLE
                    check3!!.visibility = View.VISIBLE
                    check4!!.visibility = View.VISIBLE
                    check5!!.visibility = View.VISIBLE
                }
                3 -> {
                    check3!!.visibility = View.VISIBLE
                    check4!!.visibility = View.VISIBLE
                    check5!!.visibility = View.VISIBLE
                }
                2 -> {
                    check4!!.visibility = View.VISIBLE
                    check5!!.visibility = View.VISIBLE
                }
                1 -> check5!!.visibility = View.VISIBLE
            }
        }

        private fun clearAll() {
            check1!!.visibility = View.GONE
            check2!!.visibility = View.GONE
            check3!!.visibility = View.GONE
            check4!!.visibility = View.GONE
            check5!!.visibility = View.GONE
        }
    }

    override fun getFilter(): Filter {
        return mFilter
    }

    private inner class ItemFilter : Filter() {
        override fun performFiltering(constraint: CharSequence?): Filter.FilterResults {
            var filterString = ""
            if (constraint != null)
                filterString = constraint.toString().toLowerCase()

            val results = Filter.FilterResults()

            val items = activitiesList
            val count = items.size

            nList = ArrayList(count)
            if (filterString != "-1") {
                for (i in 0 until count) {
                    if (items[i].age === Integer.valueOf(filterString)) {
                        nList!!.add(items[i])
                    }
                }
            } else {
                nList = activitiesList
            }

            results.values = nList
            results.count = nList!!.size

            return results
        }

        override fun publishResults(constraint: CharSequence, results: Filter.FilterResults) {
            filteredData = results.values as ArrayList<Activities>
            notifyDataSetChanged()
        }
    }
}