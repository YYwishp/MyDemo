package com.gyx.android_animation;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import com.gyx.android_animation.activity.MainActivity;
import com.gyx.android_animation.activity.PropertyAnimationActivity;
import com.gyx.android_animation.activity.PropertyAnimationOfIntActivity;
import com.gyx.android_animation.activity.PropertyAnimationWithInterpolatorActivity;
import com.gyx.android_animation.activity.PropertyAnimationWithMyInterpolatorActivity;
import com.gyx.android_animation.activity.ValueAnimatorWithMyOfObjectActivity;
import com.gyx.android_animation.activity.ValueAnimatorWithOfObjectActivity;

public class LauncherActivity extends AppCompatActivity {
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_launcher);
	}

	public void viewAnimation(View view) {
		startActivity(new Intent(this, MainActivity.class));
	}

	public void ValueAnimatorofArgb(View view) {

		startActivity(new Intent(this, PropertyAnimationActivity.class));


	}

	public void ValueAnimatorOfInt(View view) {

		startActivity(new Intent(this, PropertyAnimationOfIntActivity.class));

	}

	public void ValueAnimatorWithInterpolator(View view) {

		startActivity(new Intent(this, PropertyAnimationWithInterpolatorActivity.class));
	}

	public void ValueAnimatorWithMyInterpolator(View view) {
		startActivity(new Intent(this, PropertyAnimationWithMyInterpolatorActivity.class));

	}

	public void ValueAnimatorWithOfObject(View view) {

		startActivity(new Intent(this, ValueAnimatorWithOfObjectActivity.class));





	}

	public void ValueAnimatorWithMyOfObject(View view) {

		startActivity(new Intent(this, ValueAnimatorWithMyOfObjectActivity.class));



	}

	public void ObjectAnimatorNormalUsage(View view) {
	}
}





























































