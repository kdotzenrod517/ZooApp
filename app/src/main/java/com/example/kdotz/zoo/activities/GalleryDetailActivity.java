package com.example.kdotz.zoo.activities;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.ActionBarActivity;
import android.support.v7.widget.Toolbar;
import android.util.AttributeSet;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.kdotz.zoo.R;
import com.google.android.gms.vision.text.Text;
import com.squareup.picasso.Picasso;

/**
 * Created by kdotz on 5/24/2017.
 */

public class GalleryDetailActivity extends ActionBarActivity {

    public static final String EXTRA_IMAGE = "extra_image";
    public static final String EXTRA_CAPTION = "extra_caption";

    private TextView mCaptionTextView;
    private ImageView mImageView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_gallery_detail);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        mCaptionTextView = (TextView) findViewById(R.id.caption);
        mImageView = (ImageView) findViewById(R.id.image);

        if(getIntent() != null && getIntent().getExtras() != null ){
            if (getIntent().getExtras().containsKey(EXTRA_IMAGE)){
                Picasso.with(this).load(getIntent().getExtras().getString(EXTRA_IMAGE)).into(mImageView);
            }

            if (getIntent().getExtras().containsKey(EXTRA_CAPTION)){
                mCaptionTextView.setText(getIntent().getExtras().getString(EXTRA_CAPTION));
            }
        }
    }
}
