package com.zcs.studydemo.mybaseadapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.zcs.studydemo.R;

import java.util.LinkedList;

public class Myadapter<T> extends BaseAdapter {
    private Context mContext;
    private LinkedList<T> mData;
    public Myadapter(){

    }
    public Myadapter(Context mContext,LinkedList<T> mData){
        this.mContext=mContext;
        this.mData=mData;
    }
    @Override
    public int getCount() {
        return mData.size();
    }

    @Override
    public Object getItem(int i) {
        return null;
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        ViewHolder holder=null;
        if (view==null){
            view= LayoutInflater.from(mContext).inflate(R.layout.item_list,viewGroup,false);
            holder=new ViewHolder();
            holder.img_icon=view.findViewById(R.id.img_icon);
            holder.txt_content=view.findViewById(R.id.txt_content);
            view.setTag(holder);
        }else {
            holder= (ViewHolder) view.getTag();
        }
        return view;
    }
    public void add(T data){





        if (mData==null){
            mData=new LinkedList<>();
        }
        mData.add(data);
        notifyDataSetChanged();
    }
    public void add(int position ,T data){
        if (mData==null){
            mData=new LinkedList<>();
        }
        mData.add(position,data);
        notifyDataSetChanged();
    }
    public void remove(T data){
        if (mData!=null){
            mData.remove(data);
        }
        notifyDataSetChanged();
    }
    public void remove(int position){
        if (mData!=null){
            mData.remove(position);
        }
        notifyDataSetChanged();
    }
    public void clear(){
        if (mData!=null){
            mData.clear();
        }
        notifyDataSetChanged();
    }
    private class ViewHolder{
        ImageView img_icon;
        TextView txt_content;
    }
}
