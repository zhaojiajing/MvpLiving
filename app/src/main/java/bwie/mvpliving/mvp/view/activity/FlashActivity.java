package bwie.mvpliving.mvp.view.activity;

import android.Manifest;

import com.pick.library.mvp.BaseActivity;
import com.pick.library.mvp.PermissionListener;

import java.util.List;
import java.util.concurrent.TimeUnit;

import bwie.mvpliving.R;
import rx.Observable;
import rx.android.schedulers.AndroidSchedulers;
import rx.functions.Action1;
import rx.schedulers.Schedulers;

public class FlashActivity extends BaseActivity {
    @Override
    public int bindLayout() {
        return R.layout.activity_flash;
    }

    @Override
    public void initVariables() {

    }

    @Override
    public void initViews() {
        String permissons[]={Manifest.permission.READ_PHONE_STATE,Manifest.permission.READ_EXTERNAL_STORAGE,Manifest.permission.CAMERA};
        requestRuntimePermission(permissons, new PermissionListener() {
            @Override
            public void onGranted() {
                Observable.timer(2000, TimeUnit.MILLISECONDS)
                        .subscribeOn(Schedulers.io())
                        .observeOn(AndroidSchedulers.mainThread())
                        .subscribe(new Action1<Long>() {
                            @Override
                            public void call(Long aLong) {
                                if (!isFinishing()) {
                                    startAct(HomeActivity.class);
                                    finish();
                                }

                            }
                        });
            }

            @Override
            public void onDenied(List<String> deniedPermission) {
                ShowToast("权限没同意,即将退出程序!");
                finish();
            }
        });
    }

    @Override
    public void loadData() {

    }


}
