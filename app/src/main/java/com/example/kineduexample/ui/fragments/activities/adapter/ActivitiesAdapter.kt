package com.example.kineduexample.ui.fragments.activities.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.Filter
import android.widget.Filterable
import androidx.databinding.DataBindingUtil
import com.example.kineduexample.R
import com.example.kineduexample.data.network.model.Activities
import androidx.recyclerview.widget.RecyclerView
import com.example.kineduexample.BR
import com.example.kineduexample.databinding.ActivitiesItemBinding
import java.util.*

class ActivitiesAdapter(private val context: Context, private val activitiesList: MutableList<Activities>) : RecyclerView.Adapter<ActivitiesAdapter.ActivitiesViewHolder>(), Filterable {
    private var filteredData: List<Activities>? = null
    private var nList: MutableList<Activities>? = null
    private val mFilter = ItemFilter()


    init {
        this.filteredData = activitiesList
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ActivitiesViewHolder {
        val binding: ActivitiesItemBinding = DataBindingUtil.inflate(LayoutInflater.from(parent.context), R.layout.activities_item, parent, false)
        return ActivitiesViewHolder(binding)
    }

    fun getItem(position: Int): Activities {
        return filteredData!![position]
    }

    override fun onBindViewHolder(holder: ActivitiesViewHolder, position: Int) {
        val item = getItem(position)
        holder.itemBinding.activities = item
        holder.bind(item)
    }

    override fun getItemCount(): Int {
        return filteredData!!.size
    }


    inner class ActivitiesViewHolder(itemView: ActivitiesItemBinding) : RecyclerView.ViewHolder(itemView.root) {
        var itemBinding: ActivitiesItemBinding = itemView

        fun bind(obj: Activities){
            itemBinding.setVariable(BR.activities, obj)
            itemBinding.executePendingBindings()
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
