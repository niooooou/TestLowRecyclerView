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


/**
 * recyclerView--listview
 * 添加了不相同的headview和footerview
 * 添加了分割线
 */
public class ListViewActivity extends AppCompatActivity {
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
                Toast.makeText(adapter.getContext(), "您点击了图片" + position, Toast.LENGTH_SHORT).show();
            }
        });
//        item点击事件
        adapter.setOnItemClick(new OnItemClick() {
            @Override
            public void onItemClick(int position, View view, BaseRecycleViewsHolder holder) {
                Toast.makeText(adapter.getContext(), "您点击了item" + position, Toast.LENGTH_SHORT).show();
            }
        });
    }

    private void setdata() {
        list = new ArrayList<>();
        list.add(new Test("title", "http://d.5857.com/xgs_150428/001.jpg", "内容"));
        list.add(new Test("title", "http://d.5857.com/xgs_150428/002.jpg", "内容"));
        list.add(new Test("title", "https://a-ssl.duitang.com/uploads/item/201502/27/20150227112432_jcwSt.jpeg", "内容"));
        list.add(new Test("title", "http://d.5857.com/xgs_150428/003.jpg", "内容"));
        list.add(new Test("title", "http://d.5857.com/xgs_150428/004.jpg", "内容"));
        list.add(new Test("title", "https://b-ssl.duitang.com/uploads/item/201502/27/20150227112439_jZRcF.thumb.700_0.jpeg", "内容"));
        list.add(new Test("title", "http://d.5857.com/xgs_150428/005.jpg", "内容"));
        list.add(new Test("title", "http://d.5857.com/xgs_150428/006.jpg", "内容"));
        list.add(new Test("title", "https://b-ssl.duitang.com/uploads/item/201502/27/20150227112459_3WJeZ.thumb.700_0.jpeg", "内容"));
        list.add(new Test("title", "http://d.5857.com/xgs_150428/007.jpg", "内容"));
        list.add(new Test("title", "http://d.5857.com/xgs_150428/008.jpg", "内容"));
        adapter = new CommonRecyclerAdapter<Test>(this, list, R.layout.list_item, RecyclerViewStyle.ListView) {
            @Override
            protected void setData(BaseRecycleViewsHolder holder, int position, Test item) {
                //这里对listview每个itme中的子控件设置值
                holder.getTextView(R.id.item_title).setText(item.getTitle() + position);
                holder.getTextView(R.id.item_content).setText(item.getContent() + position);
                Picasso.with(mContext)
                        .load(item.getImg())
                        .into(holder.getImageView(R.id.item_image));
                //给ImageView设置点击事件监听
                holder.setClickListener(R.id.item_image);
                holder.setItemClickListener();
            }

            @Override
            protected void setFootData(BaseRecycleViewsHolder holder, int position, int footposition) {
//                设置每个footerview的数据()
                if (footposition == 1) {
                    holder.getTextView(R.id.head1_text).setText("我是foot"+footposition);
                } else {
                    Picasso.with(mContext)
                            .load("https://b-ssl.duitang.com/uploads/item/201404/15/20140415093636_Rdr3x.jpeg")
                            .fit()
                            .into(holder.getImageView(R.id.imageview));
                }
                //给Footer的Item设置监听
                holder.setItemClickListener();
            }

            @Override
            protected void setHeadData(BaseRecycleViewsHolder holder, int position) {
//                设置每个headerview的数据
                if (position == 1) {
                    holder.getTextView(R.id.head1_text).setText("我是Header" + position);
                } else {
                    Picasso.with(mContext)
                            .load("https://b-ssl.duitang.com/uploads/item/201404/15/20140415093636_Rdr3x.jpeg")
                            .fit()
                            .into(holder.getImageView(R.id.imageview));
                }
                //给Header的Item设置监听
                holder.setItemClickListener();
            }
        };
        recyclerView.setAdapter(adapter);//***非常重要，不要忘记
        //添加HeaderView和FooterView
        adapter.addHeaderView(R.layout.head);
        adapter.addHeaderView(R.layout.head1);
        adapter.addHeaderView(R.layout.head);
        adapter.addFooterView(R.layout.head);
        adapter.addFooterView(R.layout.head1);
        adapter.addFooterView(R.layout.head);
        //不需要分割线可不调用addItemDecoration
        new RecyclerViewUtils<>(recyclerView, adapter, 1).addItemDecoration(5,R.color.colorAccent);
    }

    /**
     * 初始化View
     */
    private void initView() {
        recyclerView = (RecyclerView) findViewById(R.id.recyclerview);
    }
}
