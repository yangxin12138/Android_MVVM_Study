package com.twd.nokuangjia.mvvm.view;

import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingComponent;
import androidx.databinding.DataBindingUtil;

import com.twd.nokuangjia.R;
import com.twd.nokuangjia.databinding.ActivityMvvmBinding;
import com.twd.nokuangjia.mvvm.view_model.MVVM_ViewModel;

/**
 * @Author:Yangxin
 * @Description:
 * @time: Create in 16:04 2023/12/19
 */
public class MVVM_Activity extends AppCompatActivity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mvvm);
        ActivityMvvmBinding binding = DataBindingUtil.setContentView(this,R.layout.activity_mvvm);
        MVVM_ViewModel mvvmViewModel = new MVVM_ViewModel(getApplication(),binding);
        binding.setViewModel(mvvmViewModel);
    }
}
