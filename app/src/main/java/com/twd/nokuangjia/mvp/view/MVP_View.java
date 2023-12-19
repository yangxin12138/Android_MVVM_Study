package com.twd.nokuangjia.mvp.view;

import com.twd.nokuangjia.activity.bean.LoginBean;
import com.twd.nokuangjia.activity.callback.OnLoginCallback;

/**
 * @Author:Yangxin
 * @Description: 主要负责View数据的 获取 与 赋值
 * @time: Create in 11:51 2023/12/19
 */
public interface MVP_View extends OnLoginCallback {
    LoginBean getLoginData();
}
