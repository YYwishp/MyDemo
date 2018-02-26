package com.gyx.android_animation.activity;

import android.animation.ValueAnimator;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.animation.BounceInterpolator;
import android.widget.TextView;

import com.gyx.android_animation.R;
import com.gyx.android_animation.evalutor.MyEvalutor;
import com.gyx.android_animation.interpolator.MyInterpolator;

/**
 * 自定义插值器
 */
public class PropertyAnimationWithMyInterpolatorActivity extends AppCompatActivity {

	private TextView text;
	private ValueAnimator valueAnimator;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_property_animation_with_my_interpolator);
		text = (TextView) findViewById(R.id.text);

	}

	public void startAnimation(View view) {
		valueAnimator = ValueAnimator.ofInt(0,400);
		valueAnimator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
			@Override
			public void onAnimationUpdate(ValueAnimator animation) {
				int animatedValue = (int) animation.getAnimatedValue();
				text.layout(text.getLeft(),animatedValue,text.getRight(),animatedValue+text.getHeight());

			}
		});
		valueAnimator.setDuration(1000);
		//自定义Evalutor，计算器
		valueAnimator.setEvaluator(new MyEvalutor());
		valueAnimator.setInterpolator(new BounceInterpolator());
		valueAnimator.start();
	}

	public void cancelAnimation(View view) {
		valueAnimator.cancel();
	}
}
