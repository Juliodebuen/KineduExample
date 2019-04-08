package com.example.kineduexample.ui.fragments.articles.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Filter
import android.widget.Filterable
import android.widget.ImageView
import android.widget.TextView
import com.example.kineduexample.R
import com.example.kineduexample.data.network.model.Articles
import com.squareup.picasso.Picasso

import java.util.ArrayList
import androidx.cardview.widget.CardView
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.articles_item.view.*

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
        val v = LayoutInflater.from(parent.context).inflate(R.layout.articles_item, parent, false)
        return ArticlesViewHolder(v)
    }

    fun getItem(position: Int): Articles {
        return filteredData!![position]
    }

    override fun onBindViewHolder(holder: ArticlesViewHolder, position: Int) {
        val item = getItem(position)
        holder.name!!.text = item.name
        holder.shortDescription!!.text = item.shortDescription
        Picasso.with(context).load(item.picture).into(holder.picture)

        holder.articleCard!!.setOnClickListener { mListener!!.onArticleClick(item.id!!, holder.picture!!, holder.shortDescription!!) }

    }

    override fun getItemCount(): Int {
        return filteredData!!.size
    }

    inner class ArticlesViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
   //     @BindView(R.id.name)
        internal var name: TextView? = itemView.name

     //   @BindView(R.id.short_description)
        internal var shortDescription: TextView? = itemView.short_description

    //    @BindView(R.id.picture)
        internal var picture: ImageView? = itemView.picture

     //   @BindView(R.id.article_card)
        internal var articleCard: CardView? = itemView.article_card

        init {
        //    ButterKnife.bind(this, itemView.rootView)
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
