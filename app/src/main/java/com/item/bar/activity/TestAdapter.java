package com.item.bar.activity;

import android.support.annotation.Nullable;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.item.bar.R;

import java.util.List;

/**
 * Created by Administrator on 2018/3/16 0016.
 *
 */

public class TestAdapter extends BaseQuickAdapter<String, BaseViewHolder> {

    public TestAdapter( @Nullable List<String> data) {
        super(R.layout.item_list, data);
    }

    @Override
    protected void convert(BaseViewHolder helper, String item) {
        helper.setText(R.id.item_one, item);
        helper.addOnClickListener(R.id.item_one);
        helper.addOnClickListener(R.id.item_two);
    }
}
