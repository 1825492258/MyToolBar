package com.item.bar.activity;

import android.graphics.drawable.Drawable;
import android.support.design.widget.AppBarLayout;
import android.support.design.widget.CollapsingToolbarLayout;
import android.support.design.widget.CoordinatorLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;
import com.bumptech.glide.request.target.SimpleTarget;
import com.bumptech.glide.request.transition.Transition;
import com.item.bar.R;

import jp.wasabeef.glide.transformations.BlurTransformation;

public class ThreeActivity extends AppCompatActivity {
    private CollapsingToolbarLayout mCollapsingToolbarLayout;
    private LinearLayout head_layout;

    // private CoordinatorLayout root_layout;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_three);
        //  root_layout = (CoordinatorLayout) findViewById(R.id.root_layout);
        AppBarLayout appBarLayout = (AppBarLayout) findViewById(R.id.app_bar_layout);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        head_layout = (LinearLayout) findViewById(R.id.head_layout);
        mCollapsingToolbarLayout = (CollapsingToolbarLayout) findViewById(R.id.collapsing_toolbar_layout);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });
        appBarLayout.addOnOffsetChangedListener(new AppBarLayout.OnOffsetChangedListener() {
            @Override
            public void onOffsetChanged(AppBarLayout appBarLayout, int verticalOffset) {
                if (verticalOffset <= -head_layout.getHeight() / 2) {
                    mCollapsingToolbarLayout.setTitle("你好啊");
                } else {
                    mCollapsingToolbarLayout.setTitle("不好");
                }
            }
        });
        // 设置毛玻璃效果
        Glide.with(this).load(R.drawable.ic_home_weibo)
                .apply(RequestOptions.bitmapTransform(
                        new BlurTransformation(25)
                ))
                .into(new SimpleTarget<Drawable>() {
                    @Override
                    public void onResourceReady(Drawable resource, Transition<? super Drawable> transition) {
                        head_layout.setBackground(resource);
                        //root_layout.setBackground(resource);
                    }
                });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_main,menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        String msg = "";
        switch (item.getItemId()){
            case R.id.webview:
                msg += "11111";
                break;
            case R.id.weibo:
                msg += "22222";
                break;
            case R.id.action_settings:
                msg += "33333";
                break;
        }
        if(!msg.equals("")){
            Toast.makeText(ThreeActivity.this,msg,Toast.LENGTH_SHORT).show();
        }
        return super.onOptionsItemSelected(item);
    }
}
