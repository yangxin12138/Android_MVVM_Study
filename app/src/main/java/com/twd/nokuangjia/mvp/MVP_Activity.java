package com.twd.nokuangjia.mvp;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.twd.nokuangjia.R;
import com.twd.nokuangjia.activity.bean.LoginBean;
import com.twd.nokuangjia.mvp.presenter.MVP_Presenter;
import com.twd.nokuangjia.mvp.view.MVP_View;

/**
 * @Author:Yangxin
 * @Description:
 * @time: Create in 13:53 2023/12/19
 */
public class MVP_Activity extends AppCompatActivity implements View.OnClickListener, MVP_View {
    /*
    * 主要负责初始化数据
    */

    private TextView tv_showData;
    private EditText et_userName;
    private EditText et_passWord;
    private MVP_Presenter mvpPresenter;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        tv_showData = findViewById(R.id.tv_showData);
        et_userName = findViewById(R.id.et_userName);
        et_passWord = findViewById(R.id.et_passWord);
        findViewById(R.id.btn_login).setOnClickListener(this);

        mvpPresenter = new MVP_Presenter(this);
    }

    @Override
    public void onClick(View v) {
        mvpPresenter.login(getLoginData());
    }

    @Override
    public void onSuccess(LoginBean loginBean) {
        tv_showData.setText("登录成功："+loginBean.toString());
    }

    @Override
    public void onError() {
        tv_showData.setText("登录失败，账号密码错误！");
    }

    @Override
    public LoginBean getLoginData() {
        String userName = et_userName.getText().toString();
        String passWord = et_passWord.getText().toString();
        return new LoginBean(userName,passWord);
    }
}
