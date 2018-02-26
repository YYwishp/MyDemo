package com.gyx.android_animation.activity;

import android.animation.ValueAnimator;
import android.os.Build;
import android.support.annotation.RequiresApi;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

import com.gyx.android_animation.R;

public class PropertyAnimationActivity extends AppCompatActivity {

	private TextView text;
	private ValueAnimator valueAnimator;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_property_animation);



		text = (TextView) findViewById(R.id.text);


	}


	public void changeBackground(View view) {
		valueAnimator = null;
		if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.LOLLIPOP) {
			valueAnimator = ValueAnimator.ofArgb(0xff00ff00,0xffff00ff,0xffff0000,0xffffff00);
		}
		valueAnimator.setDuration(1000);
		valueAnimator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
			@Override
			public void onAnimationUpdate(ValueAnimator animation) {
				int animatedValue = (int) animation.getAnimatedValue();
				Log.e("颜色", animatedValue + "");
				text.setBackgroundColor(animatedValue);
			}
		});
		valueAnimator.setRepeatCount(ValueAnimator.INFINITE);
		valueAnimator.setRepeatMode(ValueAnimator.REVERSE);
		valueAnimator.start();
	}

	@Override
	protected void onDestroy() {
		super.onDestroy();
		if (valueAnimator!=null) {
			valueAnimator.end();
		}
	}
}
