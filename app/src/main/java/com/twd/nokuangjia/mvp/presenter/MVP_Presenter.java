package com.twd.nokuangjia.mvp.presenter;

import com.twd.nokuangjia.activity.bean.LoginBean;
import com.twd.nokuangjia.activity.callback.OnLoginCallback;
import com.twd.nokuangjia.mvp.model.MVP_Model;
import com.twd.nokuangjia.mvp.view.MVP_View;

/**
* @Author:Yangxin
* @Description:
* time: Create in 11:46 2023/12/19
*/
public class MVP_Presenter {
    private MVP_View mvp_view;
    private MVP_Model mvp_model;

    public MVP_Presenter(MVP_View mvp_view){
        this.mvp_view = mvp_view;
        this.mvp_model = new MVP_Model();
    }

    public void login(LoginBean loginBean){
        mvp_model.loginRequest(loginBean, new OnLoginCallback() {
            @Override
            public void onSuccess(LoginBean loginBean) {
                mvp_view.onSuccess(loginBean);
            }

            @Override
            public void onError() {
                mvp_view.onError();
            }
        });
    }


}
