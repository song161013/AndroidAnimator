package com.animator;

import android.os.Bundle;
import android.view.View;
import android.view.animation.AlphaAnimation;
import android.view.animation.AnimationSet;
import android.view.animation.AnimationUtils;
import android.view.animation.RotateAnimation;
import android.view.animation.ScaleAnimation;
import android.view.animation.TranslateAnimation;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    TextView tvStart;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        tvStart = findViewById(R.id.tv_text);
    }

    public void scaleStart(View view) {
        ScaleAnimation scaleAnimation = (ScaleAnimation) AnimationUtils.
                loadAnimation(this, R.anim.scale);

//        tvStart.setAnimation(scaleAnimation);
//        scaleAnimation.start();

        tvStart.startAnimation(scaleAnimation);//让动画执行是startAnimation，不是setAnimation
    }

    public void alphaStart(View view) {
        AlphaAnimation alphaAnimation = (AlphaAnimation) AnimationUtils.loadAnimation(this, R.anim.alpha);
        tvStart.startAnimation(alphaAnimation);
    }

    public void roateStart(View view) {
        RotateAnimation rotateAnimation = (RotateAnimation) AnimationUtils.loadAnimation(this, R.anim.rotate);
        tvStart.startAnimation(rotateAnimation);
    }

    public void translateStart(View view) {
        TranslateAnimation translateAnimation = (TranslateAnimation) AnimationUtils.loadAnimation(this, R.anim.translate);
        tvStart.startAnimation(translateAnimation);
    }

    public void setStart(View v){
        AnimationSet animationSet = (AnimationSet) AnimationUtils.loadAnimation(this, R.anim.set_anim);
        tvStart.startAnimation(animationSet);
    }
}
