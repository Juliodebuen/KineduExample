package com.example.kineduexample.ui.article_details;

import androidx.appcompat.app.AppCompatActivity;
import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Build;
import android.os.Bundle;
import android.text.Html;
import android.text.method.LinkMovementMethod;
import android.view.MotionEvent;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.kineduexample.R;
import com.example.kineduexample.data.network.KineduInteractor;
import com.example.kineduexample.data.network.KineduInteractorImpl;
import com.example.kineduexample.data.network.model.ArticleDetail;
import com.example.kineduexample.ui.base.BaseActivity;

import java.util.List;

public class ArticleDetailsActivity extends BaseActivity implements ArticleDetailsView{
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

    private int articleId;
    private ArticleDetail articleDetail;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_article_details);
        ButterKnife.bind(this);
        setProgressDialog(getString(R.string.loading));


        interactor = new KineduInteractorImpl();
        presenter = new ArticleDetailsPresenter(interactor);
        presenter.bind(this);

        Bundle extras = getIntent().getExtras();
        if(extras != null){
            articleId = extras.getInt("articleId");
            presenter.searchArticleDetails(articleId);
            showProgressDialog();
        }

        shareImg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent sendIntent = new Intent();
                sendIntent.setAction(Intent.ACTION_SEND);
                sendIntent.putExtra(Intent.EXTRA_TEXT, articleDetail.getLink());
                sendIntent.setType("text/plain");
                startActivity(sendIntent);
            }
        });
    }

    @Override
    public void onLoadArticleDetails(ArticleDetail articleDetail) {
        presenter.getImagesForArticleDetails(articleDetail);
        this.articleDetail = articleDetail;

    }

    @Override
    public void onLoadBitmaps(List<Bitmap> bitmap) {
        body.setText(Html.fromHtml(articleDetail.getBody(), Html.FROM_HTML_MODE_LEGACY));
        body.setMovementMethod(LinkMovementMethod.getInstance());

        title.setText(articleDetail.getTitle());
        picture.setImageBitmap(bitmap.get(0));
        hideProgressDialog();
    }
}
