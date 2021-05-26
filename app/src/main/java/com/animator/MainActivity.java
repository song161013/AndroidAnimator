package com.animator;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.animation.AccelerateDecelerateInterpolator;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.view.animation.AnimationSet;
import android.view.animation.AnimationUtils;
import android.view.animation.BounceInterpolator;
import android.view.animation.LinearInterpolator;
import android.view.animation.RotateAnimation;
import android.view.animation.ScaleAnimation;
import android.view.animation.TranslateAnimation;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    TextView tvStart;
    RecyclerView mRvInterplator;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        tvStart = findViewById(R.id.tv_text);
        mRvInterplator = findViewById(R.id.rv_interpolator);

        initInterpolatorAdapter();
        initJavaAnimator();
    }

    public void scaleStart(View view) {
        ScaleAnimation scaleAnimation = (ScaleAnimation) AnimationUtils.loadAnimation(this, R.anim.scale);

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

    public void setStart(View v) {
        AnimationSet animationSet = (AnimationSet) AnimationUtils.loadAnimation(this, R.anim.set_anim);
        tvStart.startAnimation(animationSet);
    }

    //------插值器---------
    private void initInterpolatorAdapter() {
        List<String> mDatas = new ArrayList<>();
        mDatas.add("accelerate_decelerate_interpolator");
        mDatas.add("accelerate_interpolator");
        mDatas.add("anticipate_interpolator");
        mDatas.add("anticipate_overshoot_interpolator");
        mDatas.add("bounce_interpolator");
        mDatas.add("cycle_interpolator");
        mDatas.add("decelerate_interpolator");
        mDatas.add("linear_interpolator");
        mDatas.add("overshoot_interpolator");

        AnimatorAdapter mAnimatorAdapter = new AnimatorAdapter(this, mDatas);
        mRvInterplator.setAdapter(mAnimatorAdapter);
        mRvInterplator.setLayoutManager(new LinearLayoutManager(this));
        mAnimatorAdapter.setOnItemClickListener(new AnimatorAdapter.OnItemClickListenere() {
            @Override
            public void onItemClick(int pos) {
                Log.e("AABB", "pos=" + pos);
                startInterpolator(pos);
            }
        });
    }

    private void startInterpolator(int pos) {
        int[] names = {R.anim.accelerate_decelerate_interpolator, R.anim.accelerate_interpolator,
                R.anim.anticipate_interpolator, R.anim.anticipate_overshoot_interpolator, R.anim.bounce_interpolator,
                R.anim.cycle_interpolator, R.anim.decelerate_interpolator, R.anim.linear_interpolator, R.anim.overshoot_interpolator};
        Animation animation = AnimationUtils.loadAnimation(this, names[pos]);
        tvStart.startAnimation(animation);
    }

    //-------代码生成动画----------

    private void initJavaAnimator() {
        List<String> mDatas = new ArrayList<>();
        mDatas.add("Java Scale");
        mDatas.add("java Alpha");
        mDatas.add("java Translate");
        mDatas.add("java Rolate");
        mDatas.add("java SetAnimatior");

        AnimatorAdapter javaAnimatorAdapter = new AnimatorAdapter(MainActivity.this, mDatas);
        RecyclerView rvJavaAnimator = findViewById(R.id.rv_java_animation);
        rvJavaAnimator.setLayoutManager(new LinearLayoutManager(MainActivity.this));
        rvJavaAnimator.setAdapter(javaAnimatorAdapter);

        javaAnimatorAdapter.setOnItemClickListener(new AnimatorAdapter.OnItemClickListenere() {
            @Override
            public void onItemClick(int pos) {
                startJavaAnimator(pos);
            }
        });
    }

    private void startJavaAnimator(int pos) {
        Animation animation = null;
        switch (pos) {
            case 0:
                animation = new ScaleAnimation(0.0f, 1.5f, 0.0f, 1.5f, Animation.RELATIVE_TO_SELF,
                        0.5f, Animation.RELATIVE_TO_SELF, 0.5f);
                animation.setDuration(3000);
                animation.setInterpolator(new BounceInterpolator());
                break;
            case 1:
                animation = new AlphaAnimation(0, 1);
                animation.setDuration(3000);
                animation.setInterpolator(new LinearInterpolator());
                break;

            case 2:
                animation = new TranslateAnimation(Animation.RELATIVE_TO_SELF, 0.0f,
                        Animation.RELATIVE_TO_SELF, 1.0f, Animation.RELATIVE_TO_SELF,
                        0.0f, Animation.RELATIVE_TO_SELF, 0.0f);
                animation.setDuration(3000);
                animation.setInterpolator(new BounceInterpolator());
                break;
            case 3:
                animation = new RotateAnimation(0, -720, Animation.RELATIVE_TO_SELF, 0.5f,
                        Animation.RELATIVE_TO_SELF, 0.5f);
                animation.setInterpolator(new AccelerateDecelerateInterpolator());
                animation.setDuration(3000);

                break;
            case 4:
                ScaleAnimation scale = new ScaleAnimation(0f, 1.5f, 0f, 1.5f,
                        Animation.RELATIVE_TO_SELF, 0.5f, Animation.RELATIVE_TO_SELF, 0.5f);
                AlphaAnimation alpha = new AlphaAnimation(0, 1);
//                TranslateAnimation translate = new TranslateAnimation(Animation.RELATIVE_TO_SELF, 0f,
//                        Animation.RELATIVE_TO_SELF, 1.5f, Animation.RELATIVE_TO_SELF, 0f,
//                        Animation.RELATIVE_TO_SELF, 0f);
                RotateAnimation rotate = new RotateAnimation(0, 360, Animation.RELATIVE_TO_SELF,
                        0.5f, Animation.RELATIVE_TO_SELF, 0.5f);

                AnimationSet set = new AnimationSet(true);
                set.setDuration(3000);
                set.setInterpolator(new BounceInterpolator());
                set.addAnimation(scale);
                set.addAnimation(alpha);
//                set.addAnimation(translate);
                set.addAnimation(rotate);
                tvStart.startAnimation(set);
                set.setRepeatCount(Animation.INFINITE);
                set.setRepeatMode(Animation.REVERSE);
                set.setFillAfter(true);
                set.setAnimationListener(new Animation.AnimationListener() {
                    @Override
                    public void onAnimationStart(Animation animation) {
                        Toast.makeText(MainActivity.this, "animation start", Toast.LENGTH_SHORT).show();
                        Log.e("AABB", "animation start");
                    }

                    @Override
                    public void onAnimationEnd(Animation animation) {
                        Toast.makeText(MainActivity.this, "animation end", Toast.LENGTH_SHORT).show();
                        Log.e("AABB", "animation end");
                    }

                    @Override
                    public void onAnimationRepeat(Animation animation) {
                        Toast.makeText(MainActivity.this, "animation repeat", Toast.LENGTH_SHORT).show();
                        Log.e("AABB", "animation repeat");
                    }
                });
                tvStart.startAnimation(set);
                return;
            default:
                return;
        }

        
        tvStart.startAnimation(animation);

    }
}
