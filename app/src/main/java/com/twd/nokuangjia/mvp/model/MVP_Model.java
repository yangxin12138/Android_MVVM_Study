package com.twd.nokuangjia.mvp.model;

import com.twd.nokuangjia.activity.bean.IdMap;
import com.twd.nokuangjia.activity.bean.LoginBean;
import com.twd.nokuangjia.activity.bean.SQL_Utils;
import com.twd.nokuangjia.activity.callback.OnLoginCallback;

import java.util.Map;

/**
* @Author:Yangxin
* @Description:
* time: Create in 11:43 2023/12/19
*/
public class MVP_Model {

    //登录请求
    public void loginRequest(LoginBean loginBean, OnLoginCallback onLoginCallback){
        if (SQL_Utils.userName.equals(loginBean.getUserName())
                && SQL_Utils.passWord.equals(loginBean.getPassWord())){
            onLoginCallback.onSuccess(loginBean);
        }else {
            onLoginCallback.onError();
        }
    }
}
