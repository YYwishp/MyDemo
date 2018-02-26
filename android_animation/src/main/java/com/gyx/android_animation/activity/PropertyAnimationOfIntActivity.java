package com.gyx.android_animation.activity;

import android.animation.Animator;
import android.animation.ValueAnimator;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.gyx.android_animation.R;

public class PropertyAnimationOfIntActivity extends AppCompatActivity {

	private TextView text;
	private Button button;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_property_animation_of_int);

		text = (TextView) findViewById(R.id.text);


		button = (Button) findViewById(R.id.button);

		text.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				Toast.makeText(PropertyAnimationOfIntActivity.this, "我被点击了", Toast.LENGTH_SHORT).show();
			}
		});



	}

	public void startAnimation(View view) {
		ValueAnimator valueAnimator = ValueAnimator.ofInt(0, 400);
		valueAnimator.setDuration(1000);
		valueAnimator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
			@Override
			public void onAnimationUpdate(ValueAnimator animation) {
				int curValue = (int) animation.getAnimatedValue();
				text.layout(curValue, curValue, text.getWidth() + curValue, text.getHeight() + curValue);

			}
		});

		valueAnimator.addListener(new Animator.AnimatorListener() {
			@Override
			public void onAnimationStart(Animator animation) {
			}

			@Override
			public void onAnimationEnd(Animator animation) {
			}

			@Override
			public void onAnimationCancel(Animator animation) {
			}

			@Override
			public void onAnimationRepeat(Animator animation) {
			}
		});
		valueAnimator.start();


	}
























}
