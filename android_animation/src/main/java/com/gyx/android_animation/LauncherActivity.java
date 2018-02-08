package com.gyx.android_animation;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class LauncherActivity extends AppCompatActivity {
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_launcher);
	}

	public void viewAnimation(View view) {
		startActivity(new Intent(this, MainActivity.class));
	}

	public void ValueAnimator(View view) {

		startActivity(new Intent(this, PropertyAnimationActivity.class));


	}
}
