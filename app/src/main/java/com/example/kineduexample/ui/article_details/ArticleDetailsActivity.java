package com.example.kineduexample.ui.article_details;

import androidx.appcompat.app.AppCompatActivity;
import butterknife.BindView;
import butterknife.ButterKnife;

import android.graphics.Bitmap;
import android.os.Build;
import android.os.Bundle;
import android.text.Html;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.kineduexample.R;
import com.example.kineduexample.data.network.KineduInteractor;
import com.example.kineduexample.data.network.KineduInteractorImpl;
import com.example.kineduexample.data.network.model.ArticleDetail;

import java.util.List;

public class ArticleDetailsActivity extends AppCompatActivity implements ArticleDetailsView{
    private KineduInteractor interactor;
    private ArticleDetailsPresenter presenter;

    @BindView(R.id.picture)
    ImageView picture;

    @BindView(R.id.body)
    TextView body;

    @BindView(R.id.title)
    TextView title;

    private int articleId;
    private ArticleDetail articleDetail;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_article_details);
        ButterKnife.bind(this);

        interactor = new KineduInteractorImpl();
        presenter = new ArticleDetailsPresenter(interactor);
        presenter.bind(this);

        Bundle extras = getIntent().getExtras();
        if(extras != null){
            articleId = extras.getInt("articleId");
            presenter.searchArticleDetails(articleId);
        }
    }

    @Override
    public void onLoadArticleDetails(ArticleDetail articleDetail) {
        presenter.getImagesForArticleDetails(articleDetail);
        this.articleDetail = articleDetail;

    }

    @Override
    public void onLoadBitmaps(List<Bitmap> bitmap) {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.N) {
            body.setText(Html.fromHtml(articleDetail.getBody(), Html.FROM_HTML_MODE_COMPACT));
        } else {
            body.setText(Html.fromHtml(articleDetail.getBody()));
        }

        title.setText(articleDetail.getTitle());
        picture.setImageBitmap(bitmap.get(0));
    }
}
