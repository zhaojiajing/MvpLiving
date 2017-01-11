package com.pick.library.imageloader.glide;

import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.pick.library.imageloader.IMageLoader;

/**
 * 1.类的用途
 * 2.@author:zhaojingjing
 * 3.2016/12/28.
 */

public class GlideImageLoader implements IMageLoader {
    @Override
    public void start() {

    }

    @Override
    public void pause() {

    }

    @Override
    public boolean ispaused() {
        return false;
    }

    @Override
    public void display(String url, ImageView img) {
        Glide.with(img.getContext()).load(url).into(img);

    }

    @Override
    public void display(int resId, ImageView img) {
        Glide.with(img.getContext()).load(resId).into(img);
    }
}
