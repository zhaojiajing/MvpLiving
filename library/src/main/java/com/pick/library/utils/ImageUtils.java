package com.pick.library.utils;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Point;

/**
 * 类描述：
 * 创建人：zhaojingjing
 * 创建时间：2016/7/7 17:23
 */
public class ImageUtils {
    /**
     * 获取图片的尺寸
     * @param context
     * @param resource
     * @return
     */
    public static Point getImageDimension(Context context, int resource){
        Bitmap bm = BitmapFactory.decodeResource(context.getResources(), resource);
        Point point = new Point();
        point.x = bm.getWidth();
        point.y = bm.getHeight();
        bm.recycle();
        bm = null;

        return point;
    }

    /**
     * 获取所有图片的最大的宽和高
     * @param context
     * @param imgRes
     * @return
     */
    public static Point getImageMaxDimension(Context context, int[] imgRes){
        final Point point = new Point();

        for (int i = 0, length = imgRes.length; i < length; i++){
            Bitmap tmp = BitmapFactory.decodeResource(
                    context.getResources(),
                    imgRes[i]);
            int width = tmp.getWidth();
            int height = tmp.getHeight();
            tmp.recycle();
            tmp = null;

            if (point.x < width){
                point.x = width;
            }

            if (point.y < height){
                point.y = height;
            }
        }

        return point;
    }
}
