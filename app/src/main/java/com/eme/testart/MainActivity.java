package com.eme.testart;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * view动画、帧动画、属性动画练习
 */
public class MainActivity extends AppCompatActivity {

    @BindView(R.id.btn_view)
    Button btnView;
    @BindView(R.id.btn_zhen)
    Button btnZhen;
    @BindView(R.id.btn_property)
    Button btnProperty;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
    }

    @OnClick({R.id.btn_view, R.id.btn_zhen, R.id.btn_property})
    void click(View v) {
        switch (v.getId()) {
            case R.id.btn_view:
                startActivity(new Intent(this,ViewAnimationActivity.class));
                break;
            case R.id.btn_zhen:
                startActivity(new Intent(this,FrameAnimationActivity.class));
                break;
            case R.id.btn_property:
                startActivity(new Intent(this,PropertyActivity.class));
                break;
        }
    }
}
