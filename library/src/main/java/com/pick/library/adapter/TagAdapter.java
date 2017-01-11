package com.pick.library.adapter;

import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by zhy on 16/5/16.
 */
public abstract class TagAdapter<T>
{
    private List<T> mDatas;

    public TagAdapter(List<T> datas)
    {
        if (datas == null)
            datas = new ArrayList<>(0);
        mDatas = datas;
    }

    public TagAdapter(T[] datas)
    {
        mDatas = new ArrayList<>(Arrays.asList(datas));
    }

    public abstract View getView(ViewGroup parent, int position, T t);

    /**
     * 传入position，如果返回true则认为默认选中
     *
     * @param position
     * @return
     */
    public boolean select(int position)
    {
        return false;
    }

    /**
     * 未选中->选中，可以在这里设置样式
     */
    public void onSelect(ViewGroup parent, View view, int position)
    {
    }

    /**
     * 选中->未选中，可以在这里设置样式
     */
    public void onUnSelect(ViewGroup parent, View view, int position)
    {
    }


    public boolean enabled(int position)
    {
        return true;
    }


    public T getItem(int position)
    {
        return mDatas.get(position);
    }

    public int getCount()
    {
        return mDatas.size();
    }

    public void notifyDataSetChanged()
    {
        if (mOnAdapterDataChanged != null)
        {
            mOnAdapterDataChanged.onChange();
        }
    }

    private OnAdapterDataChanged mOnAdapterDataChanged;

    public  void setOnAdapterDataChanged(OnAdapterDataChanged onAdapterDataChanged)
    {
        mOnAdapterDataChanged = onAdapterDataChanged;
    }

    public interface OnAdapterDataChanged
    {
        void onChange();
    }

}
