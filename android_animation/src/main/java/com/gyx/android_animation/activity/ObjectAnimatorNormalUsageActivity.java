package com.gyx.android_animation.activity;

import android.animation.ObjectAnimator;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.TextView;

import com.gyx.android_animation.R;

public class ObjectAnimatorNormalUsageActivity extends AppCompatActivity {
	private TextView text;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_object_animator_normal_usage);
		text = (TextView) findViewById(R.id.text);
	}

	public void startAnimation(View view) {
//		alphaAnim(text);
		rotationAnimX(text);
//		rotationAnimY(text);
//		rotationAnim(text);
//		translationXAnim(text);
//		translationYAnim(text);
//		scaleXAnim(text);
//		scaleYAnim(text);
	}



	private void alphaAnim(View view) {
		ObjectAnimator alpha = ObjectAnimator.ofFloat(view, "alpha", 1, 0, 1);
		alpha.setDuration(2000);
		alpha.start();
	}

	/**
	 * 围绕X轴旋转的
	 *
	 * @param view
	 */
	private void rotationAnimX(View view) {
		ObjectAnimator alpha = ObjectAnimator.ofFloat(view, "rotationX", 0, 180, 0);
		alpha.setDuration(2000);
		alpha.start();
	}

	/**
	 * 围绕Y轴旋转的
	 *
	 * @param view
	 */
	private void rotationAnimY(View view) {
		ObjectAnimator alpha = ObjectAnimator.ofFloat(view, "rotationY", 0, 180, 0);
		alpha.setDuration(2000);
		alpha.start();
	}

	/**
	 * 围绕Z轴旋转的
	 *
	 * @param view
	 */
	private void rotationAnim(View view) {
		ObjectAnimator alpha = ObjectAnimator.ofFloat(view, "rotation", 0, 180, 0);
		alpha.setDuration(2000);
		alpha.start();
	}

	/**
	 * 水平移动，X轴
	 * @param view
	 */
	private void translationXAnim(View view) {
		ObjectAnimator alpha = ObjectAnimator.ofFloat(view, "translationX", 0, 180, -180,0);
		alpha.setDuration(2000);
		alpha.start();
	}
	/**
	 * 水平移动，轴
	 * @param view
	 */
	private void translationYAnim(View view) {
		ObjectAnimator alpha = ObjectAnimator.ofFloat(view, "translationY", 0, 180,-180, 0);
		alpha.setDuration(2000);
		alpha.start();
	}
	/**
	 * 沿着X轴拉伸
	 * @param view
	 */
	private void scaleXAnim(View view) {
		ObjectAnimator alpha = ObjectAnimator.ofFloat(view, "scaleX", 0, 3, 0);
		alpha.setDuration(2000);
		alpha.start();
	}
	/**
	 * 沿着X轴拉伸
	 * @param view
	 */
	private void scaleYAnim(View view) {
		ObjectAnimator alpha = ObjectAnimator.ofFloat(view, "scaleY", 0, 3, 0);
		alpha.setDuration(2000);
		alpha.start();
	}
}














































