package com.liuxiaozhu.testlowrecyclerview.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

import com.liuxiaozhu.testlowrecyclerview.R;


public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    private Button mListview,mGridview,mWaterfull,mHListview,mHGridview, mHWaterfull;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();
        initLisinter();
    }

    /**
     * 初始化view
     */
    private void initView() {
        mListview = (Button) findViewById(R.id.Listview);
        mGridview = (Button) findViewById(R.id.GridView);
        mWaterfull = (Button) findViewById(R.id.WaterFull);
        mHListview = (Button) findViewById(R.id.HorizontalListview);
        mHGridview = (Button) findViewById(R.id.HorizontalGridView);
        mHWaterfull = (Button) findViewById(R.id.HorizontalWaterFull);
    }
    /**
     * 设置监听
     */
    private void initLisinter() {
        mListview.setOnClickListener(this);
        mGridview.setOnClickListener(this);
        mWaterfull.setOnClickListener(this);
        mHListview.setOnClickListener(this);
        mHGridview.setOnClickListener(this);
        mHWaterfull.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.Listview:
                startActivity(new Intent(this, ListViewActivity.class));
                break;
            case R.id.GridView:
                startActivity(new Intent(this, GridViewActivity.class));
                break;
            case R.id.WaterFull:
                startActivity(new Intent(this, WaterfullActivity.class));
                break;
            case R.id.HorizontalListview:
                startActivity(new Intent(this, HListviewActivity.class));
                break;
            case R.id.HorizontalGridView:
                startActivity(new Intent(this, HGridviewActivity.class));
                break;
            case R.id.HorizontalWaterFull:
                startActivity(new Intent(this, HWaterfullActivity.class));
                break;
        }
    }
}
