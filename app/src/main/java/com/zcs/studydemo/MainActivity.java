package com.zcs.studydemo;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ListView;

import com.zcs.studydemo.mybaseadapter.App;
import com.zcs.studydemo.mybaseadapter.Book;
import com.zcs.studydemo.mybaseadapter.MyMultiplexingAdapter;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private Context mContext;
    private ListView list_book;
    private ListView list_app;

    private MyMultiplexingAdapter<App> myAdapter1 = null;
    private MyMultiplexingAdapter<Book> myAdapter2 = null;
    private List<App> mData1 = null;
    private List<Book> mData2 = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mContext = MainActivity.this;
        init();

    }

    private void init() {

        list_book = (ListView) findViewById(R.id.list_book);
        list_app = (ListView) findViewById(R.id.list_app);

        //数据初始化
        mData1 = new ArrayList<App>();
        mData1.add(new App(R.mipmap.ic_launcher,"百度"));
        mData1.add(new App(R.mipmap.ic_launcher,"豆瓣"));
        mData1.add(new App(R.mipmap.ic_launcher,"支付宝"));

        mData2 = new ArrayList<Book>();
        mData2.add(new Book("《第一行代码Android》","郭霖"));
        mData2.add(new Book("《Android群英传》","徐宜生"));
        mData2.add(new Book("《Android开发艺术探索》","任玉刚"));

        //Adapter初始化
        myAdapter1 = new MyMultiplexingAdapter<App>((ArrayList)mData1,R.layout.list_item_one) {
            @Override
            public void bindView(MyMultiplexingAdapter.ViewHolder holder, App obj) {
                holder.SetImageResource(R.id.app_icon,obj.getIcon());
                holder.setText(R.id.app_name,obj.getName());
            }
        };
        myAdapter2 = new MyMultiplexingAdapter<Book>((ArrayList)mData2,R.layout.list_item_two) {
            @Override
            public void bindView(MyMultiplexingAdapter.ViewHolder holder, Book obj) {
                holder.setText(R.id.book_name,obj.getName());
                holder.setText(R.id.book_author,obj.getAuthor());
            }
        };

        //ListView设置下Adapter：
        list_book.setAdapter(myAdapter2);
        list_app.setAdapter(myAdapter1);

    }

}
