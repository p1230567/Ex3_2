package com.cyo.ex3_2;

import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationSet;
import android.view.animation.AnimationUtils;
import android.view.animation.RotateAnimation;
import android.view.animation.TranslateAnimation;
import android.widget.Button;
import android.widget.TextView;


public class MainActivity extends Activity {

    private TextView text;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        findViews();
    }

    protected void findViews() {
        text = (TextView) findViewById(R.id.text);
    }

    public void start_click(View view) {

        AnimationSet animation = new AnimationSet(true);
//        動畫放入動畫集合
        animation.addAnimation(getrotateAnimation());
        animation.addAnimation(getTranslateAnimation());
//      text開始執行動畫集合
        text.startAnimation(animation);


    }

    public void stop_click(View view) {
//        清除動畫
        text.clearAnimation();

    }

    private TranslateAnimation getTranslateAnimation() {
//      取得text的parent View
        View parentView = (View) text.getParent();
        // 文字移動的距離
        int hight = parentView.getHeight();
        int width = parentView.getWidth();
//      位移距離(fromX, toX, fromY, toY)
        TranslateAnimation translateAnimation = new TranslateAnimation(0, width - width / 4
                , 0, hight - hight / 4);
//      time 2s
        translateAnimation.setDuration(2000);
        translateAnimation.setRepeatMode(Animation.RESTART);
        translateAnimation.setRepeatCount(Animation.INFINITE);
        return translateAnimation;
    }

    private RotateAnimation getrotateAnimation() {
//      旋轉360度
        RotateAnimation rotateAnimation = new RotateAnimation(0f, 360f);
        rotateAnimation.setDuration(400);
        rotateAnimation.setRepeatMode(Animation.RESTART);
        rotateAnimation.setRepeatCount(Animation.INFINITE);
        return rotateAnimation;
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
