package com.eme.testart;

import android.graphics.drawable.AnimationDrawable;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * 帧动画
 *
 * 两种当时处理帧动画
 */
public class FrameAnimationActivity extends AppCompatActivity {

    @BindView(R.id.iv_show)
    ImageView ivShow;
    @BindView(R.id.btn_start)
    Button btnStart;
    @BindView(R.id.btn_stop)
    Button btnStop;

    private AnimationDrawable animationDrawable;

    private int type;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_frame_animation);
        ButterKnife.bind(this);
        init();
    }

    private void init() {
        type=2;//两种方式
        if(type==1){
            ivShow.setImageResource(R.drawable.frame_animation_list);
            animationDrawable= (AnimationDrawable) ivShow.getDrawable();
        }else{
            animationDrawable=new AnimationDrawable();
            for (int i=0;i<24;i++){
                int id=getResources().getIdentifier("p"+i,"mipmap",getPackageName());
                Drawable drawable = getResources().getDrawable(id);
                animationDrawable.addFrame(drawable,100);
            }
            animationDrawable.setOneShot(true);
            ivShow.setImageDrawable(animationDrawable);
        }
    }


    @OnClick({R.id.btn_start, R.id.btn_stop})
    void click(View v) {
        switch (v.getId()) {
            case R.id.btn_start:
                animationDrawable.stop();
                animationDrawable.start();
                break;
            case R.id.btn_stop:
                animationDrawable.stop();
                break;
        }
    }
}
