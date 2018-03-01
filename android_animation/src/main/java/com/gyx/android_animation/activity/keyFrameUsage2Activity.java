package com.gyx.android_animation.activity;

import android.animation.Keyframe;
import android.animation.ObjectAnimator;
import android.animation.PropertyValuesHolder;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.animation.BounceInterpolator;

import com.gyx.android_animation.R;
import com.gyx.android_animation.view.MyTextView;

/**
 * 关键帧使用插值器
 */
public class keyFrameUsage2Activity extends AppCompatActivity {
	private MyTextView text;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_key_frame_usage2);
		text = (MyTextView) findViewById(R.id.text);
	}

	/**
	 * 关键帧使用插值器
	 * @param view
	 */
	public void startAnimation(View view) {
		Keyframe keyframe0 = Keyframe.ofFloat(0f, 0f);
		Keyframe keyframe1 = Keyframe.ofFloat(0.2f, 90f);
		Keyframe keyframe2 = Keyframe.ofFloat(1f);
		keyframe2.setValue(0f);
		/**
		 * 关键帧使用插值器
		 */
		keyframe2.setInterpolator(new BounceInterpolator());
		PropertyValuesHolder holder = PropertyValuesHolder.ofKeyframe("rotation", keyframe0, keyframe1, keyframe2);
		ObjectAnimator objectAnimator = ObjectAnimator.ofPropertyValuesHolder(text, holder);
		objectAnimator.setDuration(3000);
//		objectAnimator.setInterpolator(new BounceInterpolator());
		objectAnimator.start();
	}

	public void cancelAnimation(View view) {
	}
}
