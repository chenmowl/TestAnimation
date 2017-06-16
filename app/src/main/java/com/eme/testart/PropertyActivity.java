package com.eme.testart;

import android.animation.Keyframe;
import android.animation.ObjectAnimator;
import android.animation.PropertyValuesHolder;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class PropertyActivity extends AppCompatActivity {

    @BindView(R.id.tv_animation)
    TextView tvAnimation;
    @BindView(R.id.btn_translate)
    Button btnTranslate;
    @BindView(R.id.btn_scale)
    Button btnScale;
    @BindView(R.id.btn_rotate)
    Button btnRotate;
    @BindView(R.id.btn_alpha)
    Button btnAlpha;
    @BindView(R.id.btn_set)
    Button btnSet;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_property);
        ButterKnife.bind(this);
    }


    private boolean translation=true;
    private boolean scale=true;

    /**
     * 属性动画中只要该属性在目标view中存在get和set方法即可应用于属性动画
     * @param v
     */
    @OnClick({R.id.btn_translate, R.id.btn_scale, R.id.btn_rotate, R.id.btn_alpha,R.id.btn_set,R.id.tv_animation,R.id.btn_background,R.id.btn_text_color})
    void click(View v) {
        switch (v.getId()) {
            case R.id.btn_translate://位移动画
//                ObjectAnimator objectAnimator=ObjectAnimator.ofFloat(tvAnimation,"translationX",300F);
                PropertyValuesHolder translateX;
                PropertyValuesHolder translateY;
                if(translation){
                    translateX=PropertyValuesHolder.ofFloat("translationX",200F);
                    translateY=PropertyValuesHolder.ofFloat("translationY",200F);
                }else{
                    translateX=PropertyValuesHolder.ofFloat("translationX",200f,0);
                    translateY=PropertyValuesHolder.ofFloat("translationY",200f,0);
                }
                ObjectAnimator.ofPropertyValuesHolder(tvAnimation,translateX,translateY).setDuration(2000).start();
                translation=!translation;
                break;
            case R.id.btn_scale://缩放动画
                PropertyValuesHolder scaleXProperty;
                PropertyValuesHolder scaleYProperty;
                if(scale){
                    scaleXProperty=PropertyValuesHolder.ofFloat("scaleX",0.5f);
                    scaleYProperty=PropertyValuesHolder.ofFloat("scaleY",0.5f);
                }else{
                    scaleXProperty=PropertyValuesHolder.ofFloat("scaleX",1f);
                    scaleYProperty=PropertyValuesHolder.ofFloat("scaleY",1f);
                }
                ObjectAnimator.ofPropertyValuesHolder(tvAnimation,scaleXProperty,scaleYProperty).setDuration(2000).start();
                scale=!scale;
                break;
            case R.id.btn_rotate://旋转动画
                ObjectAnimator.ofFloat(tvAnimation,"rotation",0,360).setDuration(2000).start();
                break;
            case R.id.btn_alpha://透明度动画
                ObjectAnimator objectAnimator = ObjectAnimator.ofFloat(tvAnimation, "alpha", 0, 1);
                objectAnimator.setRepeatCount(5);
                objectAnimator.setDuration(300);
                objectAnimator.start();
                break;
            case R.id.btn_background:
                ObjectAnimator objectAnimator2 = ObjectAnimator.ofInt(tvAnimation, "BackgroundColor",0xfff45678,0xff444444,0xff677766,0xff111111,0xfff72345,0xffaaaaaa);
                objectAnimator2.setDuration(3000);
                objectAnimator2.start();
                break;
            case R.id.btn_text_color:
                ObjectAnimator.ofInt(tvAnimation,"textColor",0xfff45678,0xff444444,0xff677766,0xff111111,0xfff72345,0xffaaaaaa,0xff8b235c).setDuration(3000).start();
                break;
            case R.id.btn_set:
                Keyframe k1=Keyframe.ofFloat(0,0);
                Keyframe k2=Keyframe.ofFloat(0.25f,-30f);
                Keyframe k3=Keyframe.ofFloat(0.5f,0);
                Keyframe k4=Keyframe.ofFloat(0.75f,30);
                Keyframe k5=Keyframe.ofFloat(0.85f,0);
                Keyframe k6=Keyframe.ofFloat(1,-30);
                Keyframe k7=Keyframe.ofFloat(1.25f,0);
                PropertyValuesHolder pk=PropertyValuesHolder.ofKeyframe("rotation",k1,k2,k3,k4,k5,k6,k7);
                PropertyValuesHolder p1=PropertyValuesHolder.ofFloat("translationX",200F,50F,300F,-50F);
                PropertyValuesHolder p2=PropertyValuesHolder.ofFloat("scaleX",1f,0.2f,1f,0.5f,1,1.5f,1);
                PropertyValuesHolder p3=PropertyValuesHolder.ofFloat("scaleY",1f,0.2f,1f,0.5f,1f,2);
                PropertyValuesHolder p4=PropertyValuesHolder.ofFloat("translationY",200F);
                PropertyValuesHolder p5=PropertyValuesHolder.ofInt("BackgroundColor",0XFFFFFF00, 0XFF0000FF);
                ObjectAnimator objectAnimator1=ObjectAnimator.ofPropertyValuesHolder(tvAnimation,p1,p5);
//                objectAnimator1.setInterpolator(new OvershootInterpolator());
                objectAnimator1.setDuration(3000);
                objectAnimator1.start();
                break;
            case R.id.tv_animation:
                Toast.makeText(this,"show view is clicked",Toast.LENGTH_SHORT).show();
                break;

        }
    }


}
