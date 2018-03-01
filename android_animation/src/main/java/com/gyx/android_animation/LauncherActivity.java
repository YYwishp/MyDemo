package com.gyx.android_animation;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import com.gyx.android_animation.activity.MainActivity;
import com.gyx.android_animation.activity.ObjectAnimatorCustomerUsageActivity;
import com.gyx.android_animation.activity.ObjectAnimatorNormalUsageActivity;
import com.gyx.android_animation.activity.PropertyAnimationActivity;
import com.gyx.android_animation.activity.PropertyAnimationOfIntActivity;
import com.gyx.android_animation.activity.PropertyAnimationWithInterpolatorActivity;
import com.gyx.android_animation.activity.PropertyAnimationWithMyInterpolatorActivity;
import com.gyx.android_animation.activity.PropertyValuesHolderActivity;
import com.gyx.android_animation.activity.ValueAnimatorWithMyOfObjectActivity;
import com.gyx.android_animation.activity.ValueAnimatorWithOfObjectActivity;
import com.gyx.android_animation.activity.keyFrameUsage2Activity;
import com.gyx.android_animation.activity.keyFrameUsage3Activity;
import com.gyx.android_animation.activity.keyFrameUsageActivity;

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
		startActivity(new Intent(this, ObjectAnimatorNormalUsageActivity.class));
	}

	public void ObjectAnimatorCustomerUsage(View view) {
		startActivity(new Intent(this, ObjectAnimatorCustomerUsageActivity.class));
	}

	public void PropertyValuesHolder(View view) {
		startActivity(new Intent(this, PropertyValuesHolderActivity.class));



	}

	public void keyFrameUsage(View view) {

		startActivity(new Intent(this, keyFrameUsageActivity.class));


	}

	public void keyFrameUsage2(View view) {
		startActivity(new Intent(this, keyFrameUsage2Activity.class));
	}

	public void keyFrameUsage3(View view) {
		startActivity(new Intent(this, keyFrameUsage3Activity.class));

	}
}





























































