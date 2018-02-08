package com.gyx.android_animation;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.view.animation.AnimationSet;
import android.view.animation.AnimationUtils;
import android.view.animation.BounceInterpolator;
import android.view.animation.RotateAnimation;
import android.view.animation.ScaleAnimation;
import android.view.animation.TranslateAnimation;
import android.widget.Button;
import android.widget.QuickContactBadge;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

	private Button btnAnimation;
	private TextView tv;
	private Button btnAlpha;
	private Button btnRotate;
	private Button btnTranslate;
	private ScaleAnimation scaleAnimation;
	private AlphaAnimation alphaAnimation;
	private RotateAnimation rotateAnimation;
	private TranslateAnimation translateAnimation;
	private Button btnAnimationSet;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);


		btnAnimation = (Button) findViewById(R.id.btn_animation);
		tv = (TextView) findViewById(R.id.tv);




		btnAlpha = (Button) findViewById(R.id.btn_alpha);
		btnRotate = (Button) findViewById(R.id.btn_rotate);
		btnTranslate = (Button) findViewById(R.id.btn_translate);



		btnAnimationSet = (Button) findViewById(R.id.btn_Animation_set);

		//
		btnAnimation.setOnClickListener(this);
		btnAlpha.setOnClickListener(this);
		btnRotate.setOnClickListener(this);
		btnTranslate.setOnClickListener(this);
		btnAnimationSet.setOnClickListener(this);
		tv.setVisibility(View.GONE);

/*
		final Animation animation = AnimationUtils.loadAnimation(this, R.anim.scaleanim);
		btnAnimation.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				tv.startAnimation(animation);

			}
		});*/
		scaleAnimation = new ScaleAnimation(0.0f, 1.4f, 0.0f, 1.7f, Animation.RELATIVE_TO_SELF, 0.5f, Animation.RELATIVE_TO_SELF, 0.5f);
		scaleAnimation.setDuration(3000);
		//
		alphaAnimation = new AlphaAnimation(0.0f,1.0f);
		alphaAnimation.setDuration(1000);
		//
		rotateAnimation = new RotateAnimation(0.0f, 180f, Animation.RELATIVE_TO_SELF, 0.5f, Animation.RELATIVE_TO_SELF, 0.5f);
		rotateAnimation.setDuration(1000);
		//
		translateAnimation = new TranslateAnimation(Animation.RELATIVE_TO_SELF, 0.0f, Animation.RELATIVE_TO_SELF, 0.5f, Animation.RELATIVE_TO_SELF, 0.0f, Animation.RELATIVE_TO_SELF, 0.4f);
		translateAnimation.setDuration(1000);
	}

	@Override
	public void onClick(View v) {
		tv.setVisibility(View.VISIBLE);
		switch (v.getId()) {
			//scale
			case R.id.btn_animation:

				tv.startAnimation(scaleAnimation);


				break;
			//alpha
			case R.id.btn_alpha:

				tv.startAnimation(alphaAnimation);

				break;
			//rotate
			case R.id.btn_rotate:

				tv.startAnimation(rotateAnimation);

				break;
			//translate
			case R.id.btn_translate:

				tv.startAnimation(translateAnimation);
				break;
			//Animation_set
			case R.id.btn_Animation_set:
				AnimationSet animationSet = new AnimationSet(true);
				animationSet.addAnimation(scaleAnimation);
				animationSet.addAnimation(alphaAnimation);
				animationSet.addAnimation(rotateAnimation);
				animationSet.addAnimation(translateAnimation);
				animationSet.setDuration(2000);
				animationSet.setFillAfter(true);
				animationSet.setInterpolator(new BounceInterpolator());
				tv.startAnimation(animationSet);

				break;

		}
	}
}












































