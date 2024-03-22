package com.example.componentdemo.ui.fragment;

import android.app.ActivityOptions;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatDelegate;
import androidx.fragment.app.Fragment;

import com.example.componentdemo.R;
import com.example.componentdemo.databinding.FragmentDemoBinding;
import com.example.componentdemo.ui.ImageActivity;

/**
 * @Author winiymissl
 * @Date 2024-03-15 15:22
 * @Version 1.0
 */
public class TransitionFragment extends Fragment {
    FragmentDemoBinding binding;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        binding = FragmentDemoBinding.bind(inflater.inflate(R.layout.fragment_demo, container, false));
        binding.toggleButton.setOnClickListener(v -> {
//            toggleNightMode();
            //直接跳转到另一个活动
            // Check if we're running on Android 5.0 or higher

        });
        binding.imageViewImage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
                    Intent intent = new Intent(getActivity(), ImageActivity.class);
                    startActivity(intent, ActivityOptions.makeSceneTransitionAnimation(getActivity(), binding.imageViewImage, "imageView_image").toBundle());
                } else {

                    // Swap without transition
                }
            }
        });
        return binding.getRoot();
    }

    /**
     * 切换应用的夜间模式。当当前模式为夜间模式时，切换为日间模式；反之亦然。
     * 该方法不接受任何参数，也不会返回任何值。
     */
    private void toggleNightMode() {
        // 获取当前的夜间模式设置
        int nightMode = AppCompatDelegate.getDefaultNightMode();
        // 根据当前模式，切换到相反的模式
        if (nightMode == AppCompatDelegate.MODE_NIGHT_YES) {
            AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO);
        } else {
            AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_YES);
        }
        // 重新创建当前活动以应用新的夜间模式设置
        getActivity().recreate();
    }
}
