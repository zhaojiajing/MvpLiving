package com.pick.library.imageloader;

import com.pick.library.imageloader.glide.GlideImageLoader;

/**
 * 1.类的用途
 * 2.@author:zhaojingjing
 * 3.2016/12/28.
 */

public class ImageLoaderManager {
    private static ImageLoaderManager mImageLoaderManager;

    /**
     * 单例:
     */
    private ImageLoaderManager() {}

    public static  ImageLoaderManager getinstance(){
        if(mImageLoaderManager==null){
            synchronized (ImageLoaderManager.class){
                if(mImageLoaderManager==null){
                    mImageLoaderManager=new ImageLoaderManager();
                }
            }
        }
        return mImageLoaderManager;
    }

    //默认
    public IMageLoader getImageloader(){
       return getImageloader(null);
    }

    public IMageLoader getImageloader(Type type){
        if(type==Type.GLIDE){
            return  new GlideImageLoader();//8888888888888888
        }
        return  new GlideImageLoader();
    }


    /**
     * 枚举
     */
    public enum Type{
        GLIDE;
    }
}
