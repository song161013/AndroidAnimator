package com.animator;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.view.animation.AnimationSet;
import android.view.animation.AnimationUtils;
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
    RecyclerView mRvBtn;
    private BtnAdapter mBtnAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        tvStart = findViewById(R.id.tv_text);
        mRvBtn = findViewById(R.id.rv_btn);

        initAdapter();
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

    private void startInterpolator(int pos) {
        int[] names = {R.anim.accelerate_decelerate_interpolator, R.anim.accelerate_interpolator,
                R.anim.anticipate_interpolator, R.anim.anticipate_overshoot_interpolator, R.anim.bounce_interpolator,
                R.anim.cycle_interpolator, R.anim.decelerate_interpolator, R.anim.linear_interpolator, R.anim.overshoot_interpolator};
        Animation animation = AnimationUtils.loadAnimation(this, names[pos]);
        tvStart.startAnimation(animation);
    }

    private void initAdapter() {
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

        mBtnAdapter = new BtnAdapter(this, mDatas);
        mRvBtn.setAdapter(mBtnAdapter);
        mRvBtn.setLayoutManager(new LinearLayoutManager(this));
        mBtnAdapter.setOnItemClickListener(new BtnAdapter.OnItemClickListenere() {
            @Override
            public void onItemClick(int pos) {
                Log.e("AABB", "pos=" + pos);
                startInterpolator(pos);
            }
        });
    }
}
