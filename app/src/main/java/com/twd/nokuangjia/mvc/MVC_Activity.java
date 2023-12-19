package com.twd.nokuangjia.mvc;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.twd.nokuangjia.R;
import com.twd.nokuangjia.activity.bean.LoginBean;
import com.twd.nokuangjia.activity.callback.OnLoginCallback;
import com.twd.nokuangjia.mvc.model.MVC_Model;

public class MVC_Activity extends AppCompatActivity implements View.OnClickListener {

    private TextView tv_showData;
    private EditText et_userName;
    private EditText et_passWord;
    private MVC_Model mvcModel;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        initView();
        mvcModel = new MVC_Model();//初始化Model Model
    }

    @Override
    public void onClick(View v) {
        mvcModel.loginRequest(getLoginData(), new OnLoginCallback() {//业务代码 Controller
            @SuppressLint("SetTextI18n")
            @Override
            public void onSuccess(LoginBean loginBean) {
                tv_showData.setText("登录成功：" + loginBean.toString());//设置数据 View
            }


            @Override
            public void onError() {
                tv_showData.setText("登录失败，账号密码错误！");//设置数据 View
            }
        });
    }
    /*界面代码 View*/
    private void initView(){
        tv_showData = findViewById(R.id.tv_showData);
        et_userName = findViewById(R.id.et_userName);
        et_passWord = findViewById(R.id.et_passWord);
        findViewById(R.id.btn_login).setOnClickListener(this);//注册事件
    }

    //获取登录数据 View
    public LoginBean getLoginData(){
        String userName = et_userName.getText().toString();
        String passWord = et_passWord.getText().toString();
        return new LoginBean(userName,passWord);
    }
}
