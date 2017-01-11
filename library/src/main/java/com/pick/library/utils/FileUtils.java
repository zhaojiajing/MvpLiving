package com.pick.library.utils;

import android.os.Environment;


import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;

/**
 * 类描述：
 * 创建人：zhaojingjing
 * 创建时间：2016/7/6 10:56
 */
public class FileUtils {
    /**
     * 检查是否存在SDCard
     *
     * @return
     */
    public static boolean hasSdcard() {
        String state = Environment.getExternalStorageState();
        if (state.equals(Environment.MEDIA_MOUNTED)) {
            return true;
        } else {
            return false;
        }
    }

//    public static String getCacheDir() {
//        return addLastDir(AppApplication.getAppApplication().getCacheDir().getAbsolutePath());
//    }
//
//    public static String getFileDir() {
//        return addLastDir(AppApplication.getAppApplication().getFilesDir().getAbsolutePath());
//    }
//
//    public static String getExternalCacheDir() {
//        return addLastDir(AppApplication.getAppApplication().getExternalCacheDir().getAbsolutePath());
//    }
//
//    public static String getExternalFileDir(String type) {
//        return addLastDir(AppApplication.getAppApplication().getExternalFilesDir(type).getAbsolutePath());
//    }

    public static String addLastDir(String dir){
        return dir!=null&&!dir.endsWith("/")?dir+"/":dir;
    }

    public static String getFileName(String path) {
        int index = path.lastIndexOf("/");
        return path.substring(index + 1);
    }

    public static String readTextFromSDcard(String fileName) {

        File file = new File(fileName);
        if (!file.exists()) {
            return null;
        }
        try {
            FileInputStream fileInputStream = new FileInputStream(file);
            int availableLength = fileInputStream.available();
            byte[] buffer = new byte[availableLength];
            fileInputStream.read(buffer);
            fileInputStream.close();

            return new String(buffer, "UTF-8");

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    public static boolean saveText2Sdcard(String fileName, String text) {

        File file = new File(fileName);
        File parentFile = file.getParentFile();
        if (!parentFile.exists()) {
            parentFile.mkdirs();
        }
        try {
            BufferedWriter bw = new BufferedWriter(new FileWriter(file));
            bw.write(text);
            bw.flush();
            bw.close();
        } catch (IOException e) {
            e.printStackTrace();
            file.delete();
            return false;
        }
        return true;
    }

    public static JSONObject readJsonByPath(String path) {
        FileInputStream fis = null;
        String jsonStr = "";
        try {
            File file = new File(path);
            int len = (int) file.length();
            fis = new FileInputStream(file);
            byte[] bytes = new byte[len];
            fis.read(bytes, 0, len);
            jsonStr = new String(bytes);
        } catch (FileNotFoundException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } finally {
            if (fis != null) {
                try {
                    fis.close();
                } catch (IOException e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                }
            }
        }
        JSONObject json = null;
        try {
            json = new JSONObject(jsonStr);
        } catch (JSONException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return json;
    }

    public static void WriteJsonByPath(String path, JSONObject json) {
        File file =new File(path);
        if(!file.getParentFile().exists()){//文件不存在
            file.getParentFile().mkdirs();//创建文件夹
        }
        FileOutputStream fos = null;
        try {
            fos = new FileOutputStream(path);
            byte[] bytes = json.toString().getBytes();
            fos.write(bytes);
            fos.flush();
        } catch (FileNotFoundException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } finally {
            if (fos != null)
                try {
                    fos.close();
                } catch (IOException e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                }
        }

    }


}
