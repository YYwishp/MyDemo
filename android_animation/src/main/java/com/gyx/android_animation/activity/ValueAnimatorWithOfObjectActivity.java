package com.gyx.android_animation.activity;

import android.animation.ValueAnimator;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.animation.LinearInterpolator;
import android.widget.TextView;

import com.gyx.android_animation.R;
import com.gyx.android_animation.evalutor.CharEvaluator;

public class ValueAnimatorWithOfObjectActivity extends AppCompatActivity {
	private TextView text;
	private ValueAnimator animator;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_value_animator_with_of_object);



		text = (TextView) findViewById(R.id.text);

	}

	public void startAnimation(View view) {
		animator = ValueAnimator.ofObject(new CharEvaluator(), new Character('A'), new Character('Z'));

		animator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
			@Override
			public void onAnimationUpdate(ValueAnimator animation) {
				Character animatedValue = (Character) animation.getAnimatedValue();
				text.setText(String.valueOf(animatedValue));
			}
		});
		animator.setInterpolator(new LinearInterpolator());
		animator.setDuration(10000);
		animator.start();

	}

	public void cancelAnimation(View view) {
		animator.cancel();

	}
}
