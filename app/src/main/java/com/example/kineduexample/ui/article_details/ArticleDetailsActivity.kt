package com.example.kineduexample.ui.article_details

import androidx.core.view.ViewCompat
import android.content.Intent
import android.os.Bundle
import androidx.databinding.DataBindingUtil
import com.example.kineduexample.R
import com.example.kineduexample.data.network.KineduInteractor
import com.example.kineduexample.data.network.KineduInteractorImpl
import com.example.kineduexample.data.network.model.ArticleDetail
import com.example.kineduexample.databinding.ActivityArticleDetailsBinding
import com.example.kineduexample.ui.base.BaseActivity
import kotlinx.android.synthetic.main.activity_article_details.*

class ArticleDetailsActivity : BaseActivity(), ArticleDetailsView {
    private var interactor: KineduInteractor? = null
    private var presenter: ArticleDetailsPresenter? = null
    private var articleId: Int = 0
    private lateinit var binding: ActivityArticleDetailsBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_article_details)

        setProgressDialog(getString(R.string.loading))
        setSupportActionBar(toolbar)
        supportActionBar!!.setDisplayHomeAsUpEnabled(true)


        interactor = KineduInteractorImpl()
        presenter = ArticleDetailsPresenter(interactor as KineduInteractorImpl)
        presenter!!.bind(this)

        binding.presenter = presenter

        val extras = intent.extras
        if (extras != null) {
            articleId = extras.getInt("articleId")
            presenter!!.searchArticleDetails(articleId)
        }

        ViewCompat.setTransitionName(picture!!, VIEW_NAME_HEADER_IMAGE)
        ViewCompat.setTransitionName(tTitle!!, VIEW_NAME_HEADER_DESCRIPTION)
    }

    override fun onSupportNavigateUp(): Boolean {
        onBackPressed()
        return true
    }

    override fun onShareBtnClick(link: String?) {
        val sendIntent = Intent()
        sendIntent.action = Intent.ACTION_SEND
        sendIntent.putExtra(Intent.EXTRA_TEXT, link)
        sendIntent.type = "text/plain"
        startActivity(Intent.createChooser(sendIntent, resources.getString(R.string.share)))
    }

    override fun onLoadArticleDetails(articleDetail: ArticleDetail) {
        binding.articleDetail = articleDetail
    }

    companion object {
        val VIEW_NAME_HEADER_DESCRIPTION = "detail:header:description"
        val VIEW_NAME_HEADER_IMAGE = "detail:header:image"
    }

}
