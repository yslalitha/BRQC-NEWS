package com.brqc.app.jnj.activity;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.widget.ImageView;
import android.widget.TextView;

import com.brqc.app.jnj.R;
import com.brqc.app.jnj.constants.BRQCConstants;
import com.squareup.picasso.Picasso;

/**
 * Created by ajay on 1/10/2018.
 */

public class BRQCNewsDetailActivity extends AppCompatActivity {

    private ImageView mNewsDetailImageView;
    private TextView mNewsDetailTitleTV;
    private TextView mNewsDetailDescriptionTV;


    private String newsImageUrl;
    private String newsTitle;
    private String newsDescription;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.brqc_news_details);

        if (getIntent().getExtras() != null) {
            newsImageUrl = getIntent().getExtras().getString(BRQCConstants.NEWSLIST_IMAGE_URL);
            newsTitle = getIntent().getExtras().getString(BRQCConstants.NEWSLIST_TITLE_KEY);
            newsDescription = getIntent().getExtras().getString(BRQCConstants.NEWSLIST_DESC_KEY);
        }

        mNewsDetailImageView = findViewById(R.id.news_detail_imageview);
        mNewsDetailTitleTV = findViewById(R.id.news_detail_title);
        mNewsDetailDescriptionTV = findViewById(R.id.news_detail_description);

        Picasso.with(this)
                .load(newsImageUrl)
                .fit()
                .placeholder(R.drawable.choose_region)
                .error(R.drawable.functional_area)
                .into(mNewsDetailImageView);

        mNewsDetailTitleTV.setText(newsTitle);
        mNewsDetailDescriptionTV.setText(newsDescription);

    }

}
