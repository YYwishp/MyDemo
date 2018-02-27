package com.gyx.android_animation.activity;

import android.animation.ArgbEvaluator;
import android.animation.ObjectAnimator;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.animation.BounceInterpolator;
import android.widget.TextView;

import com.gyx.android_animation.R;
import com.gyx.android_animation.view.MySecondPointView;

public class ObjectAnimatorCustomerUsageActivity extends AppCompatActivity {
	private MySecondPointView mySecondpoint;

	private TextView text;


	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_object_animator_customer_usage);



		mySecondpoint = (MySecondPointView) findViewById(R.id.my_secondpoint);

		text = (TextView) findViewById(R.id.text);
		text.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				ObjectAnimator objectAnimator = ObjectAnimator.ofInt(text, "backgroundColor", 0xffff00ff, 0xffffff00, 0xff12340f);
				objectAnimator.setDuration(3000);
				objectAnimator.setEvaluator(new ArgbEvaluator());

				objectAnimator.start();

			}
		});

	}

	public void startAnimation(View view) {
		//自定义属性动画，
		ObjectAnimator objectAnimator = ObjectAnimator.ofInt(mySecondpoint, "pointRadius", 0, 300, 100, 300);
		objectAnimator.setDuration(3000);
		objectAnimator.setInterpolator(new BounceInterpolator());
		objectAnimator.start();
	}
}
