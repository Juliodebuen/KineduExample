package com.example.kineduexample.ui.article_details;

import androidx.appcompat.widget.Toolbar;
import androidx.core.view.ViewCompat;
import butterknife.BindView;
import butterknife.ButterKnife;
import android.content.Intent;
import android.os.Bundle;
import android.text.Html;
import android.text.method.LinkMovementMethod;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import com.example.kineduexample.R;
import com.example.kineduexample.data.network.KineduInteractor;
import com.example.kineduexample.data.network.KineduInteractorImpl;
import com.example.kineduexample.data.network.model.ArticleDetail;
import com.example.kineduexample.ui.base.BaseActivity;
import com.squareup.picasso.Picasso;

public class ArticleDetailsActivity extends BaseActivity implements ArticleDetailsView{
    public static final String VIEW_NAME_HEADER_DESCRIPTION = "detail:header:description";
    public static final String VIEW_NAME_HEADER_IMAGE = "detail:header:image";
    private KineduInteractor interactor;
    private ArticleDetailsPresenter presenter;

    @BindView(R.id.picture)
    ImageView picture;

    @BindView(R.id.body)
    TextView body;

    @BindView(R.id.title)
    TextView title;

    @BindView(R.id.shareImg)
    ImageView shareImg;

    @BindView(R.id.toolbar)
    Toolbar toolbar;

    private int articleId;
    private ArticleDetail articleDetail;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_article_details);
        ButterKnife.bind(this);
        setProgressDialog(getString(R.string.loading));
    //    assert getSupportActionBar() != null;
      //  getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);


        interactor = new KineduInteractorImpl();
        presenter = new ArticleDetailsPresenter(interactor);
        presenter.bind(this);

        Bundle extras = getIntent().getExtras();
        if(extras != null){
            articleId = extras.getInt("articleId");
            presenter.searchArticleDetails(articleId);
        }

        shareImg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent sendIntent = new Intent();
                sendIntent.setAction(Intent.ACTION_SEND);
                sendIntent.putExtra(Intent.EXTRA_TEXT, articleDetail.getLink());
                sendIntent.setType("text/plain");
                startActivity(Intent.createChooser(sendIntent, getResources().getString(R.string.share)));
            }
        });

        ViewCompat.setTransitionName(picture, VIEW_NAME_HEADER_IMAGE);
        ViewCompat.setTransitionName(title, VIEW_NAME_HEADER_DESCRIPTION);
    }

    @Override
    public boolean onSupportNavigateUp() {
        onBackPressed();
        return true;
    }

    @Override
    public void onLoadArticleDetails(ArticleDetail articleDetail) {
        this.articleDetail = articleDetail;

        body.setText(Html.fromHtml(articleDetail.getBody(), Html.FROM_HTML_MODE_LEGACY));
        body.setMovementMethod(LinkMovementMethod.getInstance());
        title.setText(articleDetail.getTitle());
        Picasso.with(getApplicationContext()).load(articleDetail.getPicture())
                .noFade()
                .into(picture);
    }

}
