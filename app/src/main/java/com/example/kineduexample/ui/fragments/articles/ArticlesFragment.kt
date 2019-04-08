package com.example.kineduexample.ui.fragments.articles


import android.content.Intent
import android.os.Bundle
import androidx.core.app.ActivityCompat
import androidx.core.app.ActivityOptionsCompat
import androidx.core.util.Pair
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import com.example.kineduexample.R
import com.example.kineduexample.data.network.KineduInteractor
import com.example.kineduexample.data.network.KineduInteractorImpl
import com.example.kineduexample.data.network.model.Articles
import com.example.kineduexample.ui.article_details.ArticleDetailsActivity
import com.example.kineduexample.ui.fragments.articles.adapter.ArticlesAdapter
import com.example.kineduexample.ui.fragments.MainViewModel
import com.example.kineduexample.ui.fragments.articles.adapter.OnArticleClickListener
import kotlinx.android.synthetic.main.fragment_articles.*

/**
 * A simple [Fragment] subclass.
 */
class ArticlesFragment : Fragment(), ArticlesView, OnArticleClickListener {
    private var interactor: KineduInteractor? = null
    private var presenter: ArticlesPresenter? = null
    private var mMainViewModel: MainViewModel? = null
    private var adapter: ArticlesAdapter? = null

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.fragment_articles, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        mMainViewModel = ViewModelProviders.of(activity!!).get(MainViewModel::class.java)

        interactor = KineduInteractorImpl()
        presenter = ArticlesPresenter(interactor as KineduInteractorImpl)
        presenter!!.bind(this)

        presenter!!.searchArticles()
        mMainViewModel!!.setShowDialog(true)

        swipeRefresh!!.setOnRefreshListener {
            presenter!!.searchArticles()
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

    override fun onLoadArticles(articles: List<Articles>) {
        if (articles != null && articles.size > 0) {
            adapter = ArticlesAdapter(context!!, articles as MutableList<Articles>)
            adapter!!.setArticleListener(this)
            val linearLayoutManager = LinearLayoutManager(context)
            linearLayoutManager.orientation = RecyclerView.VERTICAL
            articlesRecyclerView!!.adapter = adapter
            articlesRecyclerView!!.layoutManager = linearLayoutManager
            // mMainViewModel.setShowDialog(false);
            swipeRefresh!!.isRefreshing = false
        }
    }

    override fun onArticleClick(articleId: Int, picture: ImageView, shorDescription: TextView) {
        val activityOptions = ActivityOptionsCompat.makeSceneTransitionAnimation(
                this.activity!!,
                Pair<View, String>(picture,
                        ArticleDetailsActivity.VIEW_NAME_HEADER_IMAGE),
                Pair<View, String>(shorDescription,
                        ArticleDetailsActivity.VIEW_NAME_HEADER_DESCRIPTION))


        val intent = Intent(context, ArticleDetailsActivity::class.java)
        intent.putExtra("articleId", articleId)
        ActivityCompat.startActivity(context!!, intent, activityOptions.toBundle())
    }

    companion object {

        fun newInstance(): ArticlesFragment {
            return ArticlesFragment()
        }
    }
}