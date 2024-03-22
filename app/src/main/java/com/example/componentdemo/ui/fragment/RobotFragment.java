package com.example.componentdemo.ui.fragment;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.GridLayoutManager;

import com.example.componentdemo.R;
import com.example.componentdemo.databinding.FragmentRobotBinding;
import com.example.componentdemo.model.network.BaiDuAPI;
import com.example.componentdemo.model.network.MyRetrofit;
import com.example.componentdemo.model.network.entities.baidu.MyAnswerResult;
import com.example.componentdemo.model.network.entities.baidu.TokenResult;
import com.example.componentdemo.model.network.entities.baidu.request.MessageRequest;
import com.example.componentdemo.model.network.entities.baidu.request.MyMessage;
import com.example.componentdemo.ui.adapter.MessageAdapter;
import com.example.componentdemo.ui.fragment.Mylivedata.RobotFragmentViewModel;
import com.tencent.mmkv.MMKV;

import java.util.ArrayList;
import java.util.List;

import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers;
import io.reactivex.rxjava3.functions.Consumer;
import io.reactivex.rxjava3.schedulers.Schedulers;

/**
 * @Author winiymissl
 * @Date 2024-03-18 14:25
 * @Version 1.0
 */
public class RobotFragment extends Fragment {
    private FragmentRobotBinding binding;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_robot, container, false);
        binding = FragmentRobotBinding.bind(view);
        MMKV.initialize(getActivity());
        MMKV mMMKV = MMKV.defaultMMKV();
        Log.d("世界你好", mMMKV.getString("token", null));
        /*  初次申请token  */
        requestToken();
        RobotFragmentViewModel viewModel = new ViewModelProvider(getActivity()).get(RobotFragmentViewModel.class);
        List<MyMessage> list = new ArrayList<>();
        MessageAdapter adapter = new MessageAdapter(list);
        binding.recyclerviewRobot.setLayoutManager(new GridLayoutManager(getActivity(), 1));
        binding.recyclerviewRobot.setAdapter(adapter);
        MutableLiveData<List<MyMessage>> data = viewModel.getMessageData();
        data.setValue(list);
        binding.buttonSendMessage.setOnClickListener(v -> {
            /* 更新消息列表 */

            List<MyMessage> value = data.getValue();
            value.add(new MyMessage("user", binding.etContent.getText().toString()));
            Log.d("世界你好", "list : " + value.toString());
            MyRetrofit.baiDuAPI.getAnswer(MMKV.defaultMMKV().getString("token", null), new MessageRequest(value)).subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread()).subscribe(new Consumer<MyAnswerResult>() {
                @Override
                public void accept(MyAnswerResult myAnswerResult) throws Throwable {
                    value.add(new MyMessage("assistant", myAnswerResult.getResult()));
                    data.setValue(value);
                }
            }, throwable -> {
                Log.d("世界你好", throwable.toString());
                // 处理错误情况
            });

        });
        binding.buttonGetToken.setOnClickListener(v -> {
            MyRetrofit.baiDuAPI.getToken(BaiDuAPI.GRANT_TYPE, BaiDuAPI.client_id, BaiDuAPI.client_secret).subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread()).subscribe(tokenResult -> {
                setToken(tokenResult);
                mMMKV.encode("token", tokenResult.getToken());
            });
            binding.buttonGetToken.setEnabled(false);
        });
        data.observe(getViewLifecycleOwner(), myMessages -> {
            adapter.notifyDataSetChanged();
            binding.recyclerviewRobot.smoothScrollToPosition(adapter.getItemCount());
        });
        return view;
    }

    private void requestToken() {
        MyRetrofit.baiDuAPI.getToken(BaiDuAPI.GRANT_TYPE, BaiDuAPI.client_id, BaiDuAPI.client_secret).subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread()).subscribe(tokenResult -> {
            setToken(tokenResult);
            MMKV.defaultMMKV().encode("token", tokenResult.getToken());
        });
    }

    public void setToken(TokenResult token) {
        binding.textViewToken.setText(token.getToken());
    }
}
