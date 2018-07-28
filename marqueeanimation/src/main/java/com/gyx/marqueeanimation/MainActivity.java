package com.gyx.marqueeanimation;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.ValueAnimator;
import android.annotation.SuppressLint;
import android.app.Activity;
import android.os.Handler;
import android.os.Message;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.util.Log;
import android.view.View;
import android.view.animation.LinearInterpolator;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
	private TextView textView;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);







		textView = (TextView) findViewById(R.id.textview);




	}

	public void startAnimation(View view) {


		doAnimation();
	}

	private void doAnimation() {
		int spec = View.MeasureSpec.makeMeasureSpec(0, View.MeasureSpec.UNSPECIFIED);
		textView.measure(spec, spec);
		final int measuredWidth = textView.getMeasuredWidth();
		int widthPixels = getWindowWidth(this);
		ValueAnimator animator = ValueAnimator.ofInt(widthPixels, -measuredWidth);
		animator.setDuration(measuredWidth / 100 * 1000);
		animator.setInterpolator(new LinearInterpolator());
		animator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
			@Override
			public void onAnimationUpdate(ValueAnimator animation) {
				int curValue = (int) animation.getAnimatedValue();

                textView.layout(curValue, 0, curValue + measuredWidth, textView.getHeight());
			}
		});
		animator.addListener(new AnimatorListenerAdapter() {
			@Override
			public void onAnimationStart(Animator animation) {
				super.onAnimationStart(animation);
				textView.setVisibility(View.VISIBLE);
			}

			@SuppressLint("HandlerLeak")
			@Override
			public void onAnimationEnd(Animator animation) {
				super.onAnimationEnd(animation);
				textView.setVisibility(View.INVISIBLE);
				Log.e("lyf", "跑完");

				new Handler() {
					@Override
					public void handleMessage(Message msg) {
						super.handleMessage(msg);


					}
				}.sendEmptyMessageDelayed(0, 500);

			}
		});
		animator.start();
	}


	// 屏幕宽度（像素）
	public static int getWindowWidth(Activity context) {
		DisplayMetrics metric = new DisplayMetrics();
		context.getWindowManager().getDefaultDisplay().getMetrics(metric);
		return metric.widthPixels;
	}
}
