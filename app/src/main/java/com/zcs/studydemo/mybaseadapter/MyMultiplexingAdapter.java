package com.zcs.studydemo.mybaseadapter;

import android.content.Context;
import android.util.SparseArray;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.zcs.studydemo.R;

import java.util.ArrayList;

public abstract class MyMultiplexingAdapter<T> extends BaseAdapter {

    private ArrayList<T> mData;
    private int mLayoutRes;

    public MyMultiplexingAdapter(){

    }
    public MyMultiplexingAdapter(ArrayList<T> mData,int mLayoutRes){
        this.mData=mData;
        this.mLayoutRes=mLayoutRes;
    }
    @Override
    public int getCount() {
        return mData !=null?mData.size():0;
    }

    @Override
    public T getItem(int i) {
        return mData.get(i);
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        ViewHolder holder=ViewHolder.bind(viewGroup.getContext(),view,viewGroup,mLayoutRes,i);
        bindView(holder,getItem(i));
        return holder.getItemView();
    }

    public abstract void bindView(ViewHolder holder,T obj);

    /**
     * 往特定位置添加一个元素
     * @param position
     * @param data
     */
    public void add(int position,T data){
        if (mData==null){
            mData=new ArrayList<>();
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
    public static class ViewHolder{
        private SparseArray<View> mViews;
        private View item;
        private int position;
        private Context context;

        private ViewHolder(Context context,ViewGroup parent,int layoutRes){
            mViews=new SparseArray<>();
            this.context=context;
            View convertView= LayoutInflater.from(context).inflate(layoutRes,parent,false);
            convertView.setTag(this);
            item=convertView;

        }
        public static ViewHolder bind(Context context,View converView,ViewGroup parent,int layoutRes,int position){
            ViewHolder holder=null;
            if (converView==null){
                holder=new ViewHolder(context,parent,layoutRes);
            }else {
                holder= (ViewHolder) converView.getTag();
                holder.item=converView;
            }
            holder.position=position;
            return holder;
        }
        public <T extends View>T getView(int id){
            T t= (T) mViews.get(id);
            if (t==null){
                t=item.findViewById(id);
                mViews.put(id,t);
            }
            return t;
        }
        /**
         * 获取当前条目
         */
        public View getItemView(){
            return item;
        }

        /**
         *获取条目位置
         * @return
         */
        public int getItemPosition(){
            return position;
        }

        /**
         *设置文字
         * @param id
         * @param text
         * @return
         */
        public ViewHolder setText(int id,CharSequence text){
            View view=getView(id);
            if (view instanceof TextView){
                ((TextView) view).setText(text);
            }
            return this;
        }


        /**
         * 设置图片
         * @param id
         * @param drawableRes
         * @return
         */
        public ViewHolder SetImageResource(int id ,int drawableRes){
            View view=getView(id);
            if (view instanceof ImageView){
                ((ImageView) view).setImageResource(drawableRes);
            }else {
                view.setBackgroundResource(drawableRes);
            }
            return this;
        }

        /**
         * 设置点击事件
         * @param id
         * @param listener
         * @return
         */
        public ViewHolder setONClickListener(int id,View.OnClickListener listener){
            getView(id).setOnClickListener(listener);
            return this;
        }

        /**
         * 设置可见
         * @param id
         * @param visibly
         * @return
         */
        public ViewHolder setVisibility(int id,int visibly){
            getView(id).setVisibility(visibly);
            return this;
        }

        public ViewHolder setTag(int id,Object object){
            getView(id).setTag(object);
            return this;
        }
    }
}
