package com.gyx.android_animation.activity;

import android.animation.Keyframe;
import android.animation.ObjectAnimator;
import android.animation.PropertyValuesHolder;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import com.gyx.android_animation.R;
import com.gyx.android_animation.view.MySecondPointView;
import com.gyx.android_animation.view.MyTextView;

public class keyFrameUsageActivity extends AppCompatActivity {


	private MyTextView text;
	private MySecondPointView mySecondpoint;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_key_frame_usage);




		text = (MyTextView) findViewById(R.id.text);
		mySecondpoint = (MySecondPointView) findViewById(R.id.my_secondpoint);

	}

	public void startAnimation(View view) {
		Keyframe frame0 = Keyframe.ofFloat(0f, 0);
		Keyframe frame1 = Keyframe.ofFloat(0.1f, -20f);
		Keyframe frame2 = Keyframe.ofFloat(0.2f, 20f);
		Keyframe frame3 = Keyframe.ofFloat(0.3f, -20f);
		Keyframe frame4 = Keyframe.ofFloat(0.4f, 20f);
		Keyframe frame5 = Keyframe.ofFloat(0.5f, -20f);
		Keyframe frame6 = Keyframe.ofFloat(0.6f, 20f);
		Keyframe frame7 = Keyframe.ofFloat(0.7f, -20f);
		Keyframe frame8 = Keyframe.ofFloat(0.8f, 20f);
		Keyframe frame9 = Keyframe.ofFloat(0.9f, -20f);
		Keyframe frame10 = Keyframe.ofFloat(1, 0);
		PropertyValuesHolder holder = PropertyValuesHolder.ofKeyframe("rotation", frame0, frame1, frame2,frame3,frame4,frame5
		,frame6,frame7,frame8,frame9,frame10);
		ObjectAnimator objectAnimator = ObjectAnimator.ofPropertyValuesHolder(text, holder);
		objectAnimator.setDuration(1000);
		objectAnimator.start();
	}

	public void cancelAnimation(View view) {
	}
}
