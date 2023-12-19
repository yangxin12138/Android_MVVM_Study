package com.twd.nokuangjia.activity.callback;

import com.twd.nokuangjia.activity.bean.LoginBean;

public interface OnLoginCallback {
    void onSuccess(LoginBean loginBean);
    void onError();
}
