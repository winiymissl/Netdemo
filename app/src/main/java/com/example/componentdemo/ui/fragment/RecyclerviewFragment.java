package com.example.componentdemo.ui.fragment;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.OvershootInterpolator;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.MutableLiveData;
import androidx.recyclerview.widget.LinearLayoutManager;

import com.example.componentdemo.R;
import com.example.componentdemo.databinding.FragmentTestBinding;
import com.example.componentdemo.model.network.entities.InfoResult;
import com.example.componentdemo.ui.adapter.RecyclerviewAdapter;
import com.example.componentdemo.ui.fragment.Mylivedata.TestFragmentLiveData;

import java.util.ArrayList;
import java.util.List;

import jp.wasabeef.recyclerview.adapters.ScaleInAnimationAdapter;
import jp.wasabeef.recyclerview.animators.ScaleInLeftAnimator;

/**
 * @Author winiymissl
 * @Date 2024-03-16 17:56
 * @Version 1.0
 */
public class RecyclerviewFragment extends Fragment {
    private FragmentTestBinding binding;

    @Nullable
    @Override

    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_test, container, false);
        binding = FragmentTestBinding.bind(view);
//        VideoRecyclerviewAdapter adapter = new VideoRecyclerviewAdapter(TestFragmentLiveData.getData().getValue());
        binding.listviewTestFragment.setItemAnimator(new ScaleInLeftAnimator());
        TestFragmentLiveData testFragmentLiveData = new TestFragmentLiveData();
        List<InfoResult.InfoResultData> value = new ArrayList<>();
        MutableLiveData<List<InfoResult.InfoResultData>> data = testFragmentLiveData.getData();
        data.setValue(value);
        ScaleInAnimationAdapter adapter = new ScaleInAnimationAdapter(new RecyclerviewAdapter(value));
//        SlideInLeftAnimationAdapter adapter = new SlideInLeftAnimationAdapter(new VideoRecyclerviewAdapter(value));
        adapter.setDuration(1000);
        adapter.setInterpolator(new OvershootInterpolator());
        adapter.setFirstOnly(false);
        binding.listviewTestFragment.setLayoutManager(new LinearLayoutManager(getActivity()));
        binding.listviewTestFragment.setAdapter(adapter);
        data.observe(getViewLifecycleOwner(), list -> {
            Log.d("这是数据", list.toString());
            value.addAll(list);
            adapter.notifyDataSetChanged();
        });
        testFragmentLiveData.fetchData();
        binding.floatingActionButtonAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                List<InfoResult.InfoResultData> value = data.getValue();
                value.add(new InfoResult.InfoResultData("我是迪迦"));
                data.setValue(value);
                binding.listviewTestFragment.smoothScrollToPosition(adapter.getItemCount());
//                adapter.notifyItemInserted(adapter.getItemCount());
            }
        });
        binding.floatButton.setOnClickListener(new View.OnClickListener() {
            /**
             * 点击事件的处理方法。
             * 当某个视图被点击时，此方法将被调用。
             * 参数:
             *   v - 被点击的视图对象。
             */
            @Override
            public void onClick(View v) {
                List<InfoResult.InfoResultData> value = data.getValue();
                value.remove(adapter.getItemCount() - 1);
                binding.listviewTestFragment.smoothScrollToPosition(adapter.getItemCount());
                adapter.notifyItemRemoved(adapter.getItemCount());
                data.setValue(value);
            }
        });
        return view;
    }
}
