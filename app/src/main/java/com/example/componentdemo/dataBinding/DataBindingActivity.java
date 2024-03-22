package com.example.componentdemo.dataBinding;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;

import com.example.componentdemo.R;
import com.example.componentdemo.databinding.ActivityDataBindingBinding;

public class DataBindingActivity extends AppCompatActivity {

    private ActivityDataBindingBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
//        setContentView(R.layout.activity_data_binding);
        binding = DataBindingUtil.setContentView(this, R.layout.activity_data_binding);
        Student student = new Student("世界你好", 18);
        binding.setStudent(student);

    }
}