package com.pick.library.mvp;

import java.util.List;

/**
 * Created by zhaojingjing on 2016/12/27.
 */

public interface PermissionListener {

    void onGranted();

    void onDenied(List<String> deniedPermission);

}
