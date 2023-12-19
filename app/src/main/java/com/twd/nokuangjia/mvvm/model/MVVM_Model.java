package com.twd.nokuangjia.mvvm.model;

import com.twd.nokuangjia.activity.bean.LoginBean;
import com.twd.nokuangjia.activity.bean.SQL_Utils;
import com.twd.nokuangjia.activity.callback.OnLoginCallback;

/**
 * @Author:Yangxin
 * @Description:
 * @time: Create in 15:31 2023/12/19
 */
public class MVVM_Model {
    public void loginRequest(LoginBean loginBean, OnLoginCallback onLoginCallback){
        if (SQL_Utils.userName.equals(loginBean.getUserName())
                && SQL_Utils.passWord.equals(loginBean.getPassWord())){
            onLoginCallback.onSuccess(loginBean);
        } else {
            onLoginCallback.onError();
        }
    }
}
