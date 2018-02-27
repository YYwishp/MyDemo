package com.gyx.android_animation.activity;

import android.animation.ArgbEvaluator;
import android.animation.IntEvaluator;
import android.animation.ObjectAnimator;
import android.animation.PointFEvaluator;
import android.animation.PropertyValuesHolder;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.animation.AccelerateDecelerateInterpolator;
import android.view.animation.BounceInterpolator;
import android.view.animation.DecelerateInterpolator;
import android.view.animation.LinearInterpolator;
import android.widget.TextView;

import com.gyx.android_animation.R;
import com.gyx.android_animation.evalutor.CharEvaluator;
import com.gyx.android_animation.view.MySecondPointView;
import com.gyx.android_animation.view.MyTextView;

public class PropertyValuesHolderActivity extends AppCompatActivity {

	private MyTextView text;
	private MySecondPointView mySecondpoint;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_property_values_holder);




		text = (MyTextView) findViewById(R.id.text);
		mySecondpoint = (MySecondPointView) findViewById(R.id.my_secondpoint);
		text.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				PropertyValuesHolder charHodler = PropertyValuesHolder.ofObject("CharText", new CharEvaluator(), new Character('A'), new Character('Z'));
				ObjectAnimator objectAnimator = ObjectAnimator.ofPropertyValuesHolder(text, charHodler);
				objectAnimator.setDuration(4000);
				objectAnimator.setInterpolator(new BounceInterpolator());
				objectAnimator.start();
			}
		});

	}

	public void startAnimation(View view) {
		PropertyValuesHolder rotationHolder = PropertyValuesHolder.ofFloat("Rotation", 60, -60, 50, -50, 40, -40, 30, -30, 20, -20, 10, -10, 0);
		PropertyValuesHolder colorHolder = PropertyValuesHolder.ofInt("BackgroundColor", 0xffff0000, 0xffffff00, 0xff00ff00, 0xff0000ff, 0xffff00ff);
		ObjectAnimator objectAnimator = ObjectAnimator.ofPropertyValuesHolder(text, colorHolder, rotationHolder);
		objectAnimator.setDuration(3000);
		objectAnimator.setEvaluator(new ArgbEvaluator());

		objectAnimator.setInterpolator(new AccelerateDecelerateInterpolator());
		objectAnimator.start();

	}

	public void cancelAnimation(View view) {
	}
}
