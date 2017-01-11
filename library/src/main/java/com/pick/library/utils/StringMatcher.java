package com.pick.library.utils;

import android.content.Context;
import android.content.Intent;
import android.content.pm.ApplicationInfo;
import android.net.Uri;
import android.util.DisplayMetrics;

import java.io.File;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * 类描述：
 * 创建人：zhaojingjing
 * 创建时间：2016/7/7 17:30
 */
public class StringMatcher {
    public static String stringHideFirst(String str){
        String hide="";
        if(str.length()<2){
            return str;
        }
        for(int i = 0 ;i<str.length()-1;i++){
            hide+="*";
        }
        String tail = str.substring(str.length()-1, str.length());
        return hide+tail;
    }
    /**银行卡号加密
     * 将字符串除前四位和后四位外其他位数用*替换
     * 本方法只适用于大于8位数，切前四后四明文显示情况
     * @param str
     * @return
     */
    public static String stringHide4to4(String str) {
        if(str.length()<=8){
            return str;
        }
        String total = "";
        String head = str.substring(0, 4);
        String tail = str.substring(str.length()-4, str.length());
        String hide = "";

        for(int i = 0;i<str.length()-8;i++){
            hide+="*";
        }
        total = head + hide + tail ;
        return total;
    }
    /**身份证号中间八位加*
     *
     * 本方法只适用于大于10位数，其他位数文显示情况
     * @param str
     * @return
     */
    public static String stringHideMid8(String str) {
        if(str.length()<=10){
            return str;
        }
        String total = "";
        String head = str.substring(0, 6);
        String tail = str.substring(str.length()-4, str.length());
        String hide = "";

        for(int i = 0;i<str.length()-10;i++){
            hide+="*";
        }
        total = head + hide + tail ;
        return total;
    }



    /*
     * 判断是否正确IP
     * IP地址：192.168.1.2
     */
    public static boolean isBoolIp(String ip){
        String ipRegex="(2[5][0-5]|2[0-4]\\d|1\\d{2}|\\d{1,2})\\.(25[0-5]|2[0-4]\\d|1\\d{2}|\\d{1,2})\\.(25[0-5]|2[0-4]\\d|1\\d{2}|\\d{1,2})\\.(25[0-5]|2[0-4]\\d|1\\d{2}|\\d{1,2})";
        Pattern p= Pattern.compile(ipRegex);
        Matcher m=p.matcher(ip);
        return m.matches();
    }

    //判断字符串是否为空
    public static boolean isEmpty(String str){
        if(str==null||"".equals(str.trim()))
            return true;
        return false;
    }

    //判断字符串2到5位整数
    public static boolean isNumber(String str){
        String intRegex = "\\d{16,25}";
        Pattern p= Pattern.compile(intRegex);
        Matcher m=p.matcher(str);
        return m.matches();
    }

    //根据ip和端口拼装URL
    public static String getUrlWsdl(String ip, int port, String url) {
        StringBuffer sb = new StringBuffer();
        sb.append("http://");
        sb.append(ip);
        sb.append(":");
        sb.append(port);
        sb.append("/");
        sb.append(url);
        return sb.toString();
    }


    /**
     * 获取图片资源的id
     * @param keyValue
     * @return int 图片资源的id
     */
    public static int getBackGroundImage(String keyValue, Context context) {
        if (null == keyValue||keyValue.trim().length() ==0) {
            return 0;
        }
        if (keyValue.contains(".png")) {
            int index = keyValue.indexOf(".");
            keyValue = keyValue.substring(0, index);
        }
        int resId = 0;
        ApplicationInfo appInfo = context.getApplicationInfo();
        resId = context.getResources().getIdentifier(keyValue, "drawable", appInfo.packageName);
        if (resId == 0) {
            resId = 0;
        }
        return resId;
    }


    /**
     * 获取设备的分辨率
     */
    public static int [] getDeviceResolution(Context context) {
        DisplayMetrics dm = context.getResources().getDisplayMetrics();
        int width = dm.widthPixels;
        int height=dm.heightPixels;
        int [] dms={width,height};
        return dms;
    }

    /**
     * 格式化日期时间数据.格式后的数据格式：00
     * @param object
     * @return
     */
    public static String formateInfor(Object object) {
        String result = null;
        if (null != object) {
            result = String.format("%02d", object);
        }
        return result;
    }
    /**
     * 将14位日期字符串格式化为日期格式
     * @param str
     * @return
     */
    public static String stringToDateTimeType(String str){
        String result = "";
        if (null != str && str.length() == 14){
            result = str.substring(0,4)+"年"+str.substring(4,6)+"月"+str.substring(6,8)+"日 "+str.substring(8,10)+":"+str.substring(10,12);
        }
        return result;
    }


    /**
     * 将8位日期字符串格式化为日期格式
     * @param str
     * @return
     */
    public static String stringToDateType(String str){
        String result = "";
        if (null != str && str.length() == 8){
            result = str.substring(0,4)+"/"+str.substring(4,6)+"/"+str.substring(6,8);
        }
        return result;
    }
    public static String stringToDateType1(String str){
        String result = "";
        if (null != str && str.length() == 8){
            result = str.substring(0,4)+"-"+str.substring(4,6)+"-"+str.substring(6,8);
        }
        return result;
    }
    public static String stringToDateType2(String str){
        String result = "";
        if (null != str && str.length() == 8){
            result = str.substring(0,4)+"年"+str.substring(4,6)+"月"+str.substring(6,8)+"日";
        }
        return result;
    }

    /**
     * 将4位时间字符串格式化为时间格式
     * @param time
     * @return
     */
    public  static String stringToTimeType(String time){
        String result = "";
        if (null != time && time.length() ==4 ){
            result = time.substring(0,2)+":"+time.substring(2,4);
        }
        return result;
    }
    /**
     * 将6位时间字符串格式化为时间格式
     * @param time
     * @return
     */
    public  static String stringToTimeType6(String time){
        String result = "";
        if (null != time && time.length() ==6 ){
            result = time.substring(0,2)+":"+time.substring(2,4)+":"+time.substring(4,6);
        }
        return result;
    }
    /**
     * 获取打开不同文件的Intent
     * @return  返回打开特定类型文件的intent
     */
    public static Intent getOpenFileIntent(File file){
        Intent intent = new Intent(	"android.intent.action.VIEW");
        intent	.addCategory("android.intent.category.DEFAULT");
        intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        Uri uri = Uri.fromFile(file);
        String fileName = file.getName();
        int index = fileName.lastIndexOf(".");
        String fileType = fileName.substring(index + 1);
        String type = "application/" + fileType;
        if (fileType.equalsIgnoreCase("png")
                || fileType.equalsIgnoreCase("jpg")
                || fileType.equalsIgnoreCase("gif")) {
            type = "image/" + fileType;
        } else if (fileType.equalsIgnoreCase("apk")) {
            type = "application/vnd.android.package-archive";
        } else if (fileType.contains("doc")) {
            type = "application/msword";
        } else if (type.contains("xls")) {
            type = "application/msexcel";
        } else if (type.contains("ppt")) {
            type = "application/mspowerpoint";
        } else if (type.contains("txt")) {
            type = "text/plain";
        }
        intent.setDataAndType(uri, type);
        return intent;
    }
}
