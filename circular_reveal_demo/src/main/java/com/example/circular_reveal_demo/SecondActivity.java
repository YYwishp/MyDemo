package com.example.circular_reveal_demo;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.annotation.TargetApi;
import android.os.Build;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.transition.Explode;
import android.transition.Fade;
import android.transition.Slide;
import android.transition.Transition;
import android.transition.TransitionInflater;
import android.view.View;
import android.view.ViewAnimationUtils;
import android.view.animation.AccelerateDecelerateInterpolator;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.RelativeLayout;

public class SecondActivity extends AppCompatActivity {


	private RelativeLayout container;
	private ImageView img1;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_second);


		container = (RelativeLayout) findViewById(R.id.container);
		img1 = (ImageView) findViewById(R.id.img_1);

		if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
			setupEnterAnimation(); // 入场动画
			setupExitAnimation(); // 退场动画
		} else {

		}
		img1.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				onBackPressed();

			}
		});
	}

	@TargetApi(Build.VERSION_CODES.LOLLIPOP)
	private void setupExitAnimation() {
		//这个界面的返回动画，要在很短时间内消失
		Fade fade = new Fade();
		getWindow().setReturnTransition(fade);
		fade.setDuration(0);
	}

	// 入场动画
	@TargetApi(Build.VERSION_CODES.LOLLIPOP)
	private void setupEnterAnimation() {
		Transition transition = TransitionInflater.from(this).inflateTransition(R.transition.arc_motion);
		getWindow().setSharedElementEnterTransition(transition);

		Fade explode = new Fade();
//		explode.setDuration(2000);
		getWindow().setEnterTransition(explode);
//		//getWindow().setExitTransition(explode);
		Transition sharedElementEnterTransition = getWindow().getSharedElementEnterTransition();
		sharedElementEnterTransition.addListener(new Transition.TransitionListener() {
			@Override public void onTransitionStart(Transition transition) {
				transition.removeListener(this);
				animateRevealShow();
			}

			@Override public void onTransitionEnd(Transition transition) {



			}

			@Override public void onTransitionCancel(Transition transition) {

			}

			@Override public void onTransitionPause(Transition transition) {

			}

			@Override public void onTransitionResume(Transition transition) {

			}
		});
	}
	// 动画展示
	@TargetApi(Build.VERSION_CODES.LOLLIPOP)
	private void animateRevealShow() {
		float finalRadius = (float) Math.hypot(container.getWidth(), container.getHeight());
		// 设置圆形显示动画
		Animator anim = ViewAnimationUtils.createCircularReveal(container, container.getWidth()/2, container.getHeight()/2, img1.getWidth() / 2, finalRadius);
		anim.setDuration(1000);
		anim.setInterpolator(new AccelerateDecelerateInterpolator());
		anim.addListener(new AnimatorListenerAdapter() {
			@Override public void onAnimationEnd(Animator animation) {
				super.onAnimationEnd(animation);
//				container.setVisibility(View.VISIBLE);
//
//				Animation animation_1 = AnimationUtils.loadAnimation(SecondActivity.this, android.R.anim.fade_in);
//				animation_1.setDuration(300);
//				img1.startAnimation(animation_1);
//				img1.setAnimation(animation_1);
//				img1.setVisibility(View.VISIBLE);
//				img1.setVisibility(View.VISIBLE);

			}

			@Override public void onAnimationStart(Animator animation) {
				super.onAnimationStart(animation);
				container.setBackgroundColor(ContextCompat.getColor(SecondActivity.this, R.color.colorAccent));
			}
		});

		anim.start();
	}

	@TargetApi(Build.VERSION_CODES.LOLLIPOP)
	@Override
	public void onBackPressed() {

		float finalRadius = (float) Math.hypot(container.getWidth(), container.getHeight());
		float img1_Radius = (float) Math.hypot(img1.getWidth(), img1.getHeight());
		// 设置圆形显示动画
		Animator anim = ViewAnimationUtils.createCircularReveal(container, container.getWidth()/2, container.getHeight()/2, finalRadius, img1_Radius/2);
		anim.setDuration(1000);
		anim.setInterpolator(new AccelerateDecelerateInterpolator());
		anim.addListener(new AnimatorListenerAdapter() {
			@Override public void onAnimationEnd(Animator animation) {
				//super.onAnimationEnd(animation);
				//img1.setVisibility(View.INVISIBLE);
				SecondActivity.super.onBackPressed();
				//finish();
				//finishAfterTransition();
//				container.setVisibility(View.VISIBLE);
//
//				Animation animation_1 = AnimationUtils.loadAnimation(SecondActivity.this, android.R.anim.fade_in);
//				animation_1.setDuration(300);
//				img1.startAnimation(animation_1);
//				img1.setAnimation(animation_1);
//				img1.setVisibility(View.VISIBLE);
//				img1.setVisibility(View.VISIBLE);

			}

			@Override public void onAnimationStart(Animator animation) {
				super.onAnimationStart(animation);
				container.setBackgroundColor(ContextCompat.getColor(SecondActivity.this, R.color.colorAccent));
			}
		});

		anim.start();
	}
}
