package com.animator;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.view.animation.ScaleAnimation;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void btnStart(View view) {
        ScaleAnimation scaleAnimation = (ScaleAnimation) AnimationUtils.
                loadAnimation(this, R.anim.scale);

        TextView tvStart = findViewById(R.id.tv_text);
//        tvStart.setAnimation(scaleAnimation);
//        scaleAnimation.start();

        tvStart.startAnimation(scaleAnimation);//让动画执行是startAnimation，不是setAnimation
    }
}
