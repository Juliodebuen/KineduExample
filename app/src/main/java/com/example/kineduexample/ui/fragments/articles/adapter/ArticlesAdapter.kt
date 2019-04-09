package com.example.kineduexample.ui.fragments.articles.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.Filter
import android.widget.Filterable
import android.widget.ImageView
import android.widget.TextView
import com.example.kineduexample.R
import com.example.kineduexample.data.network.model.Articles
import java.util.ArrayList
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import com.example.kineduexample.BR
import com.example.kineduexample.databinding.ArticlesItemBinding

class ArticlesAdapter(private val context: Context, private val articlesList: MutableList<Articles>) : RecyclerView.Adapter<ArticlesAdapter.ArticlesViewHolder>(), Filterable {
    private var filteredData: List<Articles>? = null
    private var nList: MutableList<Articles>? = null
    private val mFilter = ItemFilter()
    private var mListener: OnArticleClickListener? = null

    init {
        this.filteredData = articlesList
    }

    fun setArticleListener(mListener: OnArticleClickListener) {
        this.mListener = mListener
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ArticlesViewHolder {
        val binding: ArticlesItemBinding = DataBindingUtil.inflate(LayoutInflater.from(parent.context), R.layout.articles_item, parent, false)
        return ArticlesViewHolder(binding)
    }

    fun getItem(position: Int): Articles {
        return filteredData!![position]
    }

    override fun onBindViewHolder(holder: ArticlesViewHolder, position: Int) {
        val item = getItem(position)

        holder.itemBinding.articles = item
        holder.itemBinding.itemClickListener = this
        holder.itemBinding.pictureImg = holder.itemBinding.picture
        holder.itemBinding.shortDescriptionTxt = holder.itemBinding.shortDescription
        holder.bind(item)
    }

    fun itemClick(id: Int, picture :ImageView, shortDescription :TextView){
        mListener!!.onArticleClick(id, picture, shortDescription)
    }

    override fun getItemCount(): Int {
        return filteredData!!.size
    }

    inner class ArticlesViewHolder(itemView: ArticlesItemBinding) : RecyclerView.ViewHolder(itemView.root) {
        var itemBinding: ArticlesItemBinding = itemView

        fun bind(obj: Articles){
            itemBinding.setVariable(BR.articles, obj)
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
            val items = articlesList
            val count = items.size

            nList = ArrayList(count)
            if (filterString != "-1") {
                for (i in 0 until count) {
                    if (items[i].minAge!! <= Integer.valueOf(filterString) && items[i].maxAge!! >= Integer.valueOf(filterString)) {
                        nList!!.add(items[i])
                    }
                }
            } else {
                nList = articlesList
            }

            results.values = nList
            results.count = nList!!.size

            return results
        }

        override fun publishResults(constraint: CharSequence, results: Filter.FilterResults) {
            filteredData = results.values as ArrayList<Articles>
            notifyDataSetChanged()
        }
    }
}
