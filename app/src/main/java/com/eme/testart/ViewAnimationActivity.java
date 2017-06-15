package com.eme.testart;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.view.animation.AnimationSet;
import android.view.animation.RotateAnimation;
import android.view.animation.ScaleAnimation;
import android.view.animation.TranslateAnimation;
import android.widget.Button;
import android.widget.TextView;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class ViewAnimationActivity extends AppCompatActivity {

    @BindView(R.id.btn_translate)
    Button btnTranslate;
    @BindView(R.id.btn_scale)
    Button btnScale;
    @BindView(R.id.btn_rotate)
    Button btnRotate;
    @BindView(R.id.btn_alpha)
    Button btnAlpha;
    @BindView(R.id.tv_animation)
    TextView tvAnimation;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_animation);
        ButterKnife.bind(this);
    }

    @OnClick({R.id.btn_translate, R.id.btn_scale, R.id.btn_rotate, R.id.btn_alpha,R.id.btn_set})
    void click(View v) {
        switch (v.getId()) {
            case R.id.btn_translate://位移动画
                TranslateAnimation translateAnimation = new TranslateAnimation(0, 30, 0, 60);
                translateAnimation.setDuration(2000);
                tvAnimation.startAnimation(translateAnimation);
                break;
            case R.id.btn_scale://缩放动画
//                与旋转动画一样，缩放动画也可以设置罗芳的中心点，设置中心为自身中心效果
                ScaleAnimation scaleAnimation = new ScaleAnimation(0, 1, 0, 1, Animation.RELATIVE_TO_SELF, 0.5F, Animation.RELATIVE_TO_SELF, 0.5F);
//                ScaleAnimation scaleAnimation=new ScaleAnimation(0,5,0,5,10,10);
                scaleAnimation.setDuration(2000);
                tvAnimation.startAnimation(scaleAnimation);
                break;
            case R.id.btn_rotate://旋转动画
//                其参数分别为旋转的起始角度和旋转中心点的坐标，当然，可以通过设置参数来控制旋转动画的参考系，这里设置旋转动画的参考系为中心。
                RotateAnimation rotateAnimation = new RotateAnimation(0, 360, RotateAnimation.RELATIVE_TO_SELF, 0.5F, RotateAnimation.RELATIVE_TO_SELF, 0.5F);
//                RotateAnimation rotateAnimation=new RotateAnimation(0,360,20,20);
                rotateAnimation.setDuration(2000);
                tvAnimation.startAnimation(rotateAnimation);
                break;
            case R.id.btn_alpha://透明度动画
                AlphaAnimation alphaAnimation=new AlphaAnimation(0,1);
                alphaAnimation.setDuration(2000);
                tvAnimation.startAnimation(alphaAnimation);
                break;
            case R.id.btn_set:
                AnimationSet animationSet=new AnimationSet(true);
                animationSet.setDuration(2000);
                TranslateAnimation translateAnimation1=new TranslateAnimation(Animation.RELATIVE_TO_SELF,0.5F,Animation.RELATIVE_TO_SELF,1F,Animation.RELATIVE_TO_SELF,0.5F,Animation.RELATIVE_TO_SELF,1F);
                animationSet.addAnimation(translateAnimation1);
                ScaleAnimation scaleAnimation1=new ScaleAnimation(0,1,0,1);
                animationSet.addAnimation(scaleAnimation1);
                tvAnimation.startAnimation(animationSet);
                break;
        }
    }

}
