package com.twd.nokuangjia.mvvm.view_model;

import android.app.Application;
import android.view.View;

import androidx.databinding.BaseObservable;
import androidx.databinding.Bindable;

import com.twd.nokuangjia.BR;
import com.twd.nokuangjia.activity.bean.LoginBean;
import com.twd.nokuangjia.activity.callback.OnLoginCallback;
import com.twd.nokuangjia.databinding.ActivityMvvmBinding;
import com.twd.nokuangjia.mvvm.model.MVVM_Model;

/**
 * @Author:Yangxin
 * @Description:
 * @time: Create in 15:47 2023/12/19
 */
public class MVVM_ViewModel extends BaseObservable {
    private MVVM_Model mvvmModel;
    private String result;
    private ActivityMvvmBinding binding; //layout自动生成
    private Application application;
    @Bindable
    public String getResult() {
        return result;
    }

    public void setResult(String result) {
        this.result = result;
        notifyPropertyChanged(BR.result);
    }

    public MVVM_ViewModel(Application application,ActivityMvvmBinding binding) {
        this.binding = binding;
        this.application = application;
        mvvmModel = new MVVM_Model();
    }

    private LoginBean getLoginBean(){
        return new LoginBean(
                binding.etUserName.getText().toString(),
                binding.etPassWord.getText().toString()
        );
    }
    public void getData(View view){
        mvvmModel.loginRequest(getLoginBean(), new OnLoginCallback() {
            @Override
            public void onSuccess(LoginBean loginBean) {
                setResult("获取成功："+loginBean.toString());
            }

            @Override
            public void onError() {
                setResult("获取失败：账号或者密码错误！");
            }
        });
    }
}
