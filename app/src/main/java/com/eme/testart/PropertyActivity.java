package com.eme.testart;

import android.animation.Keyframe;
import android.animation.ObjectAnimator;
import android.animation.PropertyValuesHolder;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.view.animation.RotateAnimation;
import android.view.animation.ScaleAnimation;
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

    /**
     *
      在使用ObjectAnimator的时候，有一点非常重要，那就是要操纵的属性必须具有get、set方法，不然ObjectAnimator就无法生效。下面是常用的属性：

             translationX和translationY：这两个属性作为一种增量控制着View对象从它布局容器左上角坐标开始的位置。

             rotation、rotationX和rotationY：这个三个属性控制View对象围绕支点进行2D和3D旋转。

             scaleX和scaleY：这两个属性控制着View对象围绕他的支点进行2D缩放。

             pivotX和pivotY：这两个属性控制着View对象的支点位置，围绕这个支点进行旋转和缩放变换处理。默认情况下，该支点的位置就是View对象的中心点。

             x和y：这两个简单实用的属性，描述了View对象在它的容器中的最终位置，它是最初的左上角坐标和translationX、translationY值的累积和。

             alpha：表示View对象的alpha透明度。默认值是1（不透明），0代表完全透明（不可见）。
     *
     * @param v
     */
    @OnClick({R.id.btn_translate, R.id.btn_scale, R.id.btn_rotate, R.id.btn_alpha,R.id.btn_set,R.id.tv_animation})
    void click(View v) {
        switch (v.getId()) {
            case R.id.btn_translate://位移动画
                ObjectAnimator objectAnimator=ObjectAnimator.ofFloat(tvAnimation,"translationX",300F);
                objectAnimator.setDuration(2000);
                objectAnimator.start();
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
                ObjectAnimator objectAnimator1=ObjectAnimator.ofPropertyValuesHolder(tvAnimation,p1);
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
