package com.liuxiaozhu.testlowrecyclerview.activity;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Toast;

import com.liuxiaozhu.lrecyclerviews.adapter.CommonRecyclerAdapter;
import com.liuxiaozhu.lrecyclerviews.adapter.viewHolder.BaseRecycleViewsHolder;
import com.liuxiaozhu.lrecyclerviews.constants.OnClick;
import com.liuxiaozhu.lrecyclerviews.constants.OnItemClick;
import com.liuxiaozhu.lrecyclerviews.constants.RecyclerViewStyle;
import com.liuxiaozhu.lrecyclerviews.utils.RecyclerViewUtils;

import com.liuxiaozhu.testlowrecyclerview.R;
import com.liuxiaozhu.testlowrecyclerview.bean.Test;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.List;

public class WaterfullActivity extends AppCompatActivity {

    private RecyclerView recyclerView;
    private CommonRecyclerAdapter<Test> adapter;
    private List<Test> list;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_base);
        initView();
        setdata();
        setLisinter();
    }

    private void setLisinter() {
        //item的子view点击事件
        adapter.setOnClick(new OnClick() {
            @Override
            public void onClick(int position, View view, BaseRecycleViewsHolder holder) {
                Toast.makeText(adapter.getContext(), "您点击了图片"+position, Toast.LENGTH_SHORT).show();
            }
        });
//        item点击事件
        adapter.setOnItemClick(new OnItemClick() {
            @Override
            public void onItemClick(int position, View view, BaseRecycleViewsHolder holder) {
                Toast.makeText(adapter.getContext(), "您点击了item"+position, Toast.LENGTH_SHORT).show();
            }
        });
    }

    private void setdata() {
        list = new ArrayList<>();
        list.add(new Test("http://d.5857.com/xgs_150428/001.jpg"));
        list.add(new Test("http://d.5857.com/xgs_150428/002.jpg"));
        list.add(new Test("https://a-ssl.duitang.com/uploads/item/201502/27/20150227112432_jcwSt.jpeg"));
        list.add(new Test("http://d.5857.com/xgs_150428/003.jpg"));
        list.add(new Test("http://d.5857.com/xgs_150428/004.jpg"));
        list.add(new Test("https://b-ssl.duitang.com/uploads/item/201502/27/20150227112439_jZRcF.thumb.700_0.jpeg"));
        list.add(new Test("http://d.5857.com/xgs_150428/005.jpg"));
        list.add(new Test("http://d.5857.com/xgs_150428/006.jpg"));
        list.add(new Test("https://b-ssl.duitang.com/uploads/item/201502/27/20150227112459_3WJeZ.thumb.700_0.jpeg"));
        list.add(new Test("http://d.5857.com/xgs_150428/007.jpg"));
        list.add(new Test("http://d.5857.com/xgs_150428/008.jpg"));
        adapter = new CommonRecyclerAdapter<Test>(this, list, R.layout.item, RecyclerViewStyle.WaterFall) {
            @Override
            protected void setData(BaseRecycleViewsHolder holder, int position, Test item) {
                holder.getTextView(R.id.id_index_gallery_item_text).setText(position+"");
                Picasso.with(adapter.getContext())
                        .load(item.getImg())
                        .into(holder.getImageView(R.id.id_index_gallery_item_image));
                holder.setImageHeight(R.id.id_index_gallery_item_image,300+(position%3)*50);
                holder.setClickListener(R.id.id_index_gallery_item_image);
                holder.setItemClickListener();
            }

            @Override
            protected void setFootData(BaseRecycleViewsHolder holder, int position, int footposition) {
                Picasso.with(adapter.getContext())
                        .load("https://b-ssl.duitang.com/uploads/item/201404/15/20140415093636_Rdr3x.jpeg")
                        .fit()
                        .into(holder.getImageView(R.id.imageview));
            }

            @Override
            protected void setHeadData(BaseRecycleViewsHolder holder, int position) {
                Picasso.with(adapter.getContext())
                        .load("https://b-ssl.duitang.com/uploads/item/201404/15/20140415093636_Rdr3x.jpeg")
                        .fit()
                        .into(holder.getImageView(R.id.imageview));
            }
        };
        adapter.addHeaderView(R.layout.head);
        adapter.addHeaderView(R.layout.head);
        adapter.addFooterView(R.layout.head);
        adapter.addFooterView(R.layout.head);
        recyclerView.setAdapter(adapter);
        new RecyclerViewUtils<Test>(recyclerView, adapter, 2);
    }

    private void initView() {
        recyclerView = (RecyclerView) findViewById(R.id.recyclerview);
    }
}
