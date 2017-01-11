package bwie.mvpliving;

import com.pick.library.MineApp;

/**
 * 1.类的用途
 * 2.@author:zhaojingjing
 * 3.2017/1/4.
 */
//继承类库的Application,重写onCreate()方法,调用父类的方法,记得在manifest中配置name
public class MyAPP extends MineApp {
    @Override
    public void onCreate() {
        super.onCreate();
    }
}
