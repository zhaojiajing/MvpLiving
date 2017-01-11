package com.pick.library.utils;

import android.content.Context;
import android.telephony.TelephonyManager;

/**
 * 类描述：
 * 创建人：zhaojingjing
 * 创建时间：2016/7/7 17:10
 */
public class DeviceUtils {
    public static String getDeviceId(Context context) {
        TelephonyManager tm = (TelephonyManager)context.getSystemService(Context.TELEPHONY_SERVICE);
        String DEVICE_ID = tm.getDeviceId();
        return DEVICE_ID;
    }

}
