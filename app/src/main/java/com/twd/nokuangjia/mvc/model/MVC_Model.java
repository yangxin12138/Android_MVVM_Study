package com.twd.nokuangjia.mvc.model;

import com.twd.nokuangjia.activity.bean.LoginBean;
import com.twd.nokuangjia.activity.bean.SQL_Utils;
import com.twd.nokuangjia.activity.callback.OnLoginCallback;
/**
* @Author:Yangxin
* @Description:其实就是将与Ui无关的事情搬至Mvc_Model中
 * 如：网络请求，数据获取，查询等
 * 不管是那个Activity只需要提供数据源和反馈数据接口，即可复用该逻辑代码
*/
public class MVC_Model {
    //登录请求，将数据与数据库的数据进行比较
    public void loginRequest(LoginBean loginBean, OnLoginCallback onLoginCallback){
        if (SQL_Utils.userName.equals(loginBean.getUserName()) &&
                SQL_Utils.passWord.equals(loginBean.getPassWord())){
            //登录成功
            onLoginCallback.onSuccess(loginBean);
        }else {
            //登录失败
            onLoginCallback.onError();
        }
    }
}
