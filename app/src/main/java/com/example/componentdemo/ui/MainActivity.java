package com.example.componentdemo.ui;

import android.os.Build;
import android.os.Bundle;
import android.view.Window;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import com.example.componentdemo.databinding.ActivityTestBinding;
import com.example.componentdemo.ui.adapter.ViewPagerAdapter;
import com.example.componentdemo.ui.fragment.RobotFragment;
import com.example.componentdemo.ui.fragment.TransitionFragment;
import com.example.componentdemo.ui.fragment.RecyclerviewFragment;
import com.example.componentdemo.ui.utils.DepthPageTransformer;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    private ActivityTestBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {  //检查sdk版本是否大于等于5.0
            getWindow().requestFeature(Window.FEATURE_CONTENT_TRANSITIONS);  //通过getWindow()方法拿到window对象，设置启用过渡
//            getWindow().setExitTransition(new Explode());  // 第一个Activity退出时，第二个启动因为第二个设置了启动动画，所以这里退出时的动画不启用。
//            getWindow().setSharedElementEnterTransition(new ChangeBounds());
//            getWindow().setSharedElementExitTransition(new ChangeBounds());
            /*
             * getWindow().setSharedElementEnterTransition(new ChangeBounds()) 和 getWindow().setSharedElementExitTransition(new ChangeBounds()) 是为了配置共享元素过渡的动画效果，以确保在共享元素从一个活动过渡到另一个活动时具有动画效果。在设置这些共享元素过渡效果后，系统会自动处理共享元素的动画效果。
             * 如果你直接使用 ActivityOptions.makeSceneTransitionAnimation() 方法，系统会根据传入的共享元素和过渡名称自动应用默认的共享元素过渡动画效果，无需手动设置 ChangeBounds 过渡。
             * */
            getWindow().setAllowEnterTransitionOverlap(true);
        }

        //splashScreen
//        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.S) {
//            getSplashScreen().setOnExitAnimationListener(splashScreenView -> {
//                final ObjectAnimator slideUp = ObjectAnimator.ofFloat(splashScreenView, View.TRANSLATION_Y, 0f, -splashScreenView.getHeight());
//                slideUp.setInterpolator(new AnticipateInterpolator());
//                slideUp.setDuration(200L);
//
//                // Call SplashScreenView.remove at the end of your custom animation.
//                slideUp.addListener(new AnimatorListenerAdapter() {
//                    @Override
//                    public void onAnimationEnd(Animator animation) {
//                        splashScreenView.remove();
//                    }
//                });
//                // Run your animation.
//                slideUp.start();
//            });
//        }

        binding = ActivityTestBinding.inflate(getLayoutInflater());
        super.onCreate(savedInstanceState);
        setContentView(binding.getRoot());
        List<Fragment> list = new ArrayList<>();
        list.add(new RecyclerviewFragment());
        list.add(new TransitionFragment());
        list.add(new RobotFragment());
        binding.viewPager2.setAdapter(new ViewPagerAdapter(getSupportFragmentManager(), getLifecycle(), list));
        binding.viewPager2.setPageTransformer(new DepthPageTransformer());
    }
}