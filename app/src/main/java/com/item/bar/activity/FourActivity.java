package com.item.bar.activity;

import android.graphics.drawable.Drawable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.RelativeLayout;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.resource.bitmap.CircleCrop;
import com.bumptech.glide.request.RequestOptions;
import com.bumptech.glide.request.target.SimpleTarget;
import com.bumptech.glide.request.transition.Transition;
import com.item.bar.R;

import butterknife.BindView;
import butterknife.ButterKnife;
import jp.wasabeef.glide.transformations.BlurTransformation;
import jp.wasabeef.glide.transformations.CropCircleTransformation;

public class FourActivity extends AppCompatActivity {
    @BindView(R.id.rl_four)
    RelativeLayout rlFour;
    @BindView(R.id.img_four)
    ImageView imgFour;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_four);
        ButterKnife.bind(this);
        Glide.with(this)
                .load(R.drawable.ic_home_weibo)
                .apply(RequestOptions.bitmapTransform(new BlurTransformation(25)))
                .into(new SimpleTarget<Drawable>() {
                    @Override
                    public void onResourceReady(Drawable resource, Transition<? super Drawable> transition) {
                        rlFour.setBackground(resource);
                    }
                });

        Glide.with(this).load(R.drawable.ic_home_weibo)
                .apply(RequestOptions.bitmapTransform(new CropCircleTransformation()))
                .into(imgFour);
    }
}
