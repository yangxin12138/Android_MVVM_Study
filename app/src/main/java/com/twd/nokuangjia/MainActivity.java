package com.twd.nokuangjia;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

import com.twd.nokuangjia.R;
import com.twd.nokuangjia.demo.Demo_Activity;
import com.twd.nokuangjia.mvc.MVC_Activity;
import com.twd.nokuangjia.mvp.MVP_Activity;
import com.twd.nokuangjia.mvvm.view.MVVM_Activity;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        findViewById(R.id.bt_demo).setOnClickListener(this);
        findViewById(R.id.bt_mvc).setOnClickListener(this);
        findViewById(R.id.bt_mvp).setOnClickListener(this);
        findViewById(R.id.bt_mvvm).setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        String message = "";
        if (view.getId() == R.id.bt_demo){
            message = "单击 demo";
            startActivity(new Intent(MainActivity.this, Demo_Activity.class));
        } else if (view.getId() == R.id.bt_mvc) {
            message = "单击 mvc";
            startActivity(new Intent(MainActivity.this, MVC_Activity.class));
        } else if (view.getId() == R.id.bt_mvp) {
            message = "单击 mvp";
            startActivity(new Intent(MainActivity.this, MVP_Activity.class));
        } else if (view.getId() == R.id.bt_mvvm) {
            message = "单击 mvvm";
            startActivity(new Intent(MainActivity.this, MVVM_Activity.class));
        }
        Log.i("yangxin", message);
    }
}