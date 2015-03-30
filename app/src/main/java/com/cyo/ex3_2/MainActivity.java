package com.cyo.ex3_2;

import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.view.animation.TranslateAnimation;
import android.widget.Button;
import android.widget.TextView;


public class MainActivity extends Activity {

    private TextView text;
    private Button btn_start;
    private Button btn_stop;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        findViews();
    }

    protected void findViews(){
        text = (TextView)findViewById(R.id.text);
        btn_start = (Button)findViewById(R.id.btn_start);
        btn_stop = (Button)findViewById(R.id.btn_stop);




    }

    public void start_click(View view){
        TranslateAnimation translateAnimation = getTranslateAnimation();
        translateAnimation.setInterpolator(
                AnimationUtils.loadInterpolator(MainActivity.this, android.R.anim.linear_interpolator));
        text.startAnimation(translateAnimation);


    }

    public void stop_click(View view){






    }


    private TranslateAnimation getTranslateAnimation() {

        View parentView = (View) text.getParent();
        // 文字移動的距離

        TranslateAnimation translateAnimation = new TranslateAnimation(0, parentView.getWidth()
                                                    , 0, parentView.getHeight());
        translateAnimation.setDuration(2000);
        translateAnimation.setRepeatMode(Animation.RESTART);
        translateAnimation.setRepeatCount(Animation.INFINITE);
        return translateAnimation;
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
