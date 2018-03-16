package com.item.bar;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.item.bar.activity.FiveActivity;
import com.item.bar.activity.FourActivity;
import com.item.bar.activity.OneActivity;
import com.item.bar.activity.TestBaseRecyclerActivity;
import com.item.bar.activity.ThreeActivity;
import com.item.bar.activity.TwoActivity;
import com.item.bar.layout.ScrollingActivity;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    @BindView(R.id.btn_main_one)
    Button btnOne;
    @BindView(R.id.btn_main_two)
    Button btnTwo;
    @BindView(R.id.btn_main_three)
    Button btnThree;
    @BindView(R.id.btn_main_four)
    Button btnFour;
    @BindView(R.id.btn_main_five)
    Button btnFive;
    @BindView(R.id.btn_main_six)
    Button btnSix;
    @BindView(R.id.btn_main_text)
    Button btnText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        btnOne.setOnClickListener(this);
        btnTwo.setOnClickListener(this);
        btnThree.setOnClickListener(this);
        btnFour.setOnClickListener(this);
        btnFive.setOnClickListener(this);
        btnSix.setOnClickListener(this);
        btnText.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.btn_main_one:
                startActivity(new Intent(this, OneActivity.class));
                break;
            case R.id.btn_main_two:
                startActivity(new Intent(this, TwoActivity.class));
                break;
            case R.id.btn_main_three:
                startActivity(new Intent(this, ThreeActivity.class));
                break;
            case R.id.btn_main_four:
                startActivity(new Intent(this, FiveActivity.class));
                break;
            case R.id.btn_main_five:
                startActivity(new Intent(this, FourActivity.class));
                break;
            case R.id.btn_main_six: // CoordinatorLayout
                startActivity(new Intent(this, ScrollingActivity.class));
                break;
            case R.id.btn_main_text:
                startActivity(new Intent(this, TestBaseRecyclerActivity.class));
                break;
        }
    }
}
