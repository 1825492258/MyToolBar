package com.item.bar.activity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.item.bar.R;
import com.item.bar.view.ToolBarHelp;

import butterknife.BindView;
import butterknife.ButterKnife;

public class TwoActivity extends AppCompatActivity implements View.OnClickListener {
    private ToolBarHelp mHelp;
    @BindView(R.id.btn_tool)
    Button btnTool;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_two);
        ButterKnife.bind(this);
        mHelp = new ToolBarHelp(this);
        mHelp.setTitle("你好啊");
        mHelp.setLeftListener(this);
        btnTool.setText("你好阿达的");
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.bar_left_layout:
                finish();
                break;
        }
    }
}
