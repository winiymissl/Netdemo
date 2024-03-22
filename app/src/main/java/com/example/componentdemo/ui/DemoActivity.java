package com.example.componentdemo.ui;

import android.os.Bundle;
import android.util.Log;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import androidx.lifecycle.ViewModelProvider;

import com.example.componentdemo.R;
import com.example.componentdemo.databinding.ActivityDemoBinding;
import com.example.componentdemo.model.network.entities.InfoResult;
import com.example.componentdemo.ui.adapter.RecyclerviewAdapter;
import com.example.componentdemo.ui.fragment.TransitionFragment;
import com.example.componentdemo.viewmodel.DemoActivityViewModel;

import java.util.ArrayList;
import java.util.List;

public class DemoActivity extends AppCompatActivity {

    private ActivityDemoBinding binding;

    /**
     * 创建Activity时调用的方法。
     * 在这个方法中，我们进行了以下操作：
     * 1. 绑定布局。
     * 2. 调用父类的onCreate方法。
     * 3. 设置Activity的内容视图。
     * 4. 初始化列表数据和列表适配器。
     * 5. 创建并获取ViewModel，用于数据的获取和更新。
     * 6. 观察ViewModel中的数据变化，并更新列表适配器。
     * 7. 触发数据的获取操作。
     *
     * @param savedInstanceState 如果Activity被系统重新创建，这个参数包含了之前Activity结束时的状态。否则是null。
     */

    protected void onCreate(Bundle savedInstanceState) {
        binding = ActivityDemoBinding.inflate(getLayoutInflater());
        super.onCreate(savedInstanceState);
        setContentView(binding.getRoot());
        List<InfoResult.InfoResultData> list = new ArrayList<>();
        Log.d("数据发生变化", "onCreate()");
        RecyclerviewAdapter adapter = new RecyclerviewAdapter(list);
        binding.listview.setAdapter(adapter);
        DemoActivityViewModel demoActivityViewModel = new ViewModelProvider(this).get(DemoActivityViewModel.class);
        
        //为什么会触发两次
        demoActivityViewModel.getData().observe(this, (result) -> {
            Log.d("数据发生变化", "list : " + list.toString());
            list.addAll(result.getData());
            Log.d("数据发生变化", "list : " + list.toString());
            adapter.notifyDataSetChanged();
        });

        demoActivityViewModel.fetchData();
        binding.fab.setOnClickListener(v -> {
            FragmentManager fragmentManager = getSupportFragmentManager();
            FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
            fragmentTransaction.setCustomAnimations(android.R.anim.fade_in, android.R.anim.fade_out);
            fragmentTransaction.add(R.id.coordinatorLayout, new TransitionFragment());
            fragmentTransaction.addToBackStack(null);
            fragmentTransaction.commit();
        });
    }
}