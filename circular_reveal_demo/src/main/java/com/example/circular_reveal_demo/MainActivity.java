package com.example.circular_reveal_demo;

import android.animation.Animator;
import android.app.ActivityOptions;
import android.content.Intent;
import android.os.Build;
import android.support.annotation.RequiresApi;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.transition.TransitionInflater;
import android.view.View;
import android.view.ViewAnimationUtils;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
	private ImageView img1;
	private ImageView img2;
	private ImageView img3;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
			getWindow().setExitTransition(TransitionInflater.from(this).inflateTransition(R.transition.slide));
//			getWindow().setAllowEnterTransitionOverlap(false);
//			getWindow().setAllowReturnTransitionOverlap(false);
		}
		initView();
	}

	private void initView() {


		img1 = (ImageView) findViewById(R.id.img_1);
		img2 = (ImageView) findViewById(R.id.img_2);
		img3 = (ImageView) findViewById(R.id.img_3);
		img1.setOnClickListener(this);
		img2.setOnClickListener(this);
		img3.setOnClickListener(this);
	}

	@RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
	@Override
	public void onClick(View v) {
		switch (v.getId()) {
			case R.id.img_1:
				Intent intent = new Intent(this, SecondActivity.class);
				startActivity(intent, ActivityOptions.makeSceneTransitionAnimation(this, img1,img1.getTransitionName()).toBundle());
				break;
			case R.id.img_2:
				break;
			case R.id.img_3:
				break;
		}
	}

	@RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
	public void open(View view) {
		Animator circularReveal = ViewAnimationUtils.createCircularReveal(img1, img1.getWidth() / 2, img1.getHeight() / 2, img1.getWidth(), 0);
		circularReveal.setDuration(2000);
		circularReveal.start();
		circularReveal.addListener(new Animator.AnimatorListener() {
			@Override
			public void onAnimationStart(Animator animation) {

			}

			@Override
			public void onAnimationEnd(Animator animation) {
				img1.setVisibility(View.GONE);
			}

			@Override
			public void onAnimationCancel(Animator animation) {
			}

			@Override
			public void onAnimationRepeat(Animator animation) {
			}
		});
		Animator circularReveal_2 = ViewAnimationUtils.createCircularReveal(img2, img2.getWidth() / 2, img2.getHeight() / 2, img2.getWidth(), 0);
		circularReveal_2.setDuration(2000);
		circularReveal_2.start();
		Animator circularReveal_3 = ViewAnimationUtils.createCircularReveal(img3, img3.getWidth() / 2, img3.getHeight() / 2, img3.getWidth(), 0);
		circularReveal_3.setDuration(2000);
		circularReveal_3.start();


	}
}
