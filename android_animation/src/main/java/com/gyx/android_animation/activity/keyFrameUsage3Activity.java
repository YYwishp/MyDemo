package com.gyx.android_animation.activity;

import android.animation.Keyframe;
import android.animation.ObjectAnimator;
import android.animation.PropertyValuesHolder;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import com.gyx.android_animation.R;
import com.gyx.android_animation.evalutor.CharEvaluator;
import com.gyx.android_animation.view.MyTextView;

import java.util.stream.Collector;

/**
 * keyFrame关键帧，ofObject使用
 */
public class keyFrameUsage3Activity extends AppCompatActivity {
	private MyTextView text;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_key_frame_usage3);




		text = (MyTextView) findViewById(R.id.text);

	}

	public void startAnimation(View view) {
		Keyframe frame0 = Keyframe.ofObject(0f, new Character('A'));
		Keyframe frame1 = Keyframe.ofObject(0.2f, new Character('L'));
		Keyframe frame2 = Keyframe.ofObject(1f, new Character('Z'));
		PropertyValuesHolder holder = PropertyValuesHolder.ofKeyframe("CharText", frame0, frame1, frame2);
		holder.setEvaluator(new CharEvaluator());
		ObjectAnimator objectAnimator = ObjectAnimator.ofPropertyValuesHolder(text, holder);
		objectAnimator.setDuration(3000);
//		objectAnimator.setEvaluator(new CharEvaluator());

		objectAnimator.start();

	}

	public void cancelAnimation(View view) {
	}
}
