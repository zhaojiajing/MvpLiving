package com.pick.library.imageloader;

import android.widget.ImageView;

/**
 * 1.类的用途
 * 2.@author:zhaojingjing
 * 3.2016/12/28.
 */

public interface IMageLoader {
    /**
     * 前三个方法有待研究
     */
    void start();
    void pause();
    boolean ispaused();
  void  display(String url, ImageView img);
  void  display(int  resId, ImageView img);
}
