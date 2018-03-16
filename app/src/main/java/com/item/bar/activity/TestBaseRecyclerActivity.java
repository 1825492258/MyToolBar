package com.item.bar.activity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.item.bar.R;

import java.util.ArrayList;

/**
 * BaseRecyclerViewAdapterHelper 基本使用
 */
public class TestBaseRecyclerActivity extends AppCompatActivity {

    private RecyclerView mRecyclerView;
    private ArrayList<String> mDataList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_test_base_recycler);
        initView();
    }

    private void initView() {
        mRecyclerView = findViewById(R.id.rl_listView);
        mRecyclerView.setLayoutManager(new LinearLayoutManager(this));
        mDataList = new ArrayList<>();
        for (int i = 0; i < 100; i++) {
            mDataList.add("我是  " + i);
        }
        BaseQuickAdapter mAdapter = new TestAdapter(mDataList);
        mAdapter.openLoadAnimation(BaseQuickAdapter.SLIDEIN_LEFT); // 展示从左到右的动画
        mRecyclerView.setAdapter(mAdapter);

        mAdapter.setOnItemClickListener(new BaseQuickAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(BaseQuickAdapter adapter, View view, int position) {
                Toast.makeText(TestBaseRecyclerActivity.this,"onItem" + position , Toast.LENGTH_SHORT).show();
            }
        });
        mAdapter.setOnItemChildClickListener(new BaseQuickAdapter.OnItemChildClickListener() {
            @Override
            public void onItemChildClick(BaseQuickAdapter adapter, View view, int position) {

                if(view.getId() == R.id.item_one){
                    Log.d("jiejie","------------" + position);
                }else {
                    Log.d("jiejie","+++++++++++++" + position);
                }
            }
        });
    }
}
