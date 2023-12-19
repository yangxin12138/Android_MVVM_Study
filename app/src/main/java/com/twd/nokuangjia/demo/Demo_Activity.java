package com.twd.nokuangjia.demo;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.twd.nokuangjia.R;
import com.twd.nokuangjia.activity.bean.LoginBean;
import com.twd.nokuangjia.activity.bean.SQL_Utils;
import com.twd.nokuangjia.activity.callback.OnLoginCallback;

public class Demo_Activity extends AppCompatActivity implements View.OnClickListener {
    private TextView tv_showData;
    private EditText et_userName;
    private EditText et_passWord;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        initView();
    }

    private void initView(){
        tv_showData = findViewById(R.id.tv_showData);
        et_userName = findViewById(R.id.et_userName);
        et_passWord = findViewById(R.id.et_passWord);
        findViewById(R.id.btn_login).setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        loginRequest(getLoginData(), new OnLoginCallback() {
            @SuppressLint("SetTextI18n")
            @Override
            public void onSuccess(LoginBean loginBean) {
                tv_showData.setText("登录成功：" + loginBean.toString());
            }


            @Override
            public void onError() {
                tv_showData.setText("登录失败,账号密码错误！");
            }
        });
    }

    //获取登录数据
    private LoginBean getLoginData(){
        String userName = et_userName.getText().toString();
        String passWord = et_passWord.getText().toString();
        return new LoginBean(userName,passWord);
    }

    //登录请求
    private void loginRequest(LoginBean MVVMLoginBean, OnLoginCallback loginCallback) {
        if (SQL_Utils.userName.equals(MVVMLoginBean.getUserName()) && SQL_Utils.passWord.equals(MVVMLoginBean.getPassWord())){
            //登录成功
            loginCallback.onSuccess(MVVMLoginBean);
        } else {
            //登录失败
            loginCallback.onError();
        }
    }
}
