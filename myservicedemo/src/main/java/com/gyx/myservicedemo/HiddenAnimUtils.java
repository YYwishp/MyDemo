package com.gyx.myservicedemo;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.ValueAnimator;
import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.LinearInterpolator;
import android.view.animation.RotateAnimation;

/**
 * Created by GYX on 2017/10/3.
 */
public class HiddenAnimUtils {
	
	private int mHeight;//伸展高度
	
	private View hideView,down;//需要展开隐藏的布局，开关控件
	
	private RotateAnimation animation;//旋转动画
	private boolean isOpen = false;
	private  int origHeight;

	/**
	 * 构造器(可根据自己需要修改传参)
	 * @param context 上下文
	 * @param hideView 需要隐藏或显示的布局view
	 * @param down 按钮开关的view
	 * @param height 布局展开的高度(根据实际需要传)
	 */
	public static HiddenAnimUtils newInstance(Context context, View hideView, View down, int height,int origHeight,boolean isOpen){
		return new HiddenAnimUtils(context,hideView,down,height,origHeight,isOpen);
	}
	
	private HiddenAnimUtils(Context context, View hideView, View down, int height,int origHeight, boolean isOpen){
		this.hideView = hideView;
		this.down = down;
		float mDensity = context.getResources().getDisplayMetrics().density;
		mHeight = (int) (mDensity * height + 0.5);//伸展高度
		this.isOpen = isOpen;
		this.origHeight = origHeight;
	}
	
	/**
	 * 开关
	 */
	public void toggle(){
		//startAnimation();
		if (isOpen) {
			closeAnimate(hideView);//布局隐藏
		} else {
			openAnim(hideView);//布局铺开
		}
	}
	
	/**
	 * 开关旋转动画
	 */
	private void startAnimation() {
		if (View.VISIBLE == hideView.getVisibility()) {
			animation = new RotateAnimation(180, 0, Animation.RELATIVE_TO_SELF, 0.5f, Animation.RELATIVE_TO_SELF, 0.5f);
		} else {
			animation = new RotateAnimation(0, 180, Animation.RELATIVE_TO_SELF, 0.5f, Animation.RELATIVE_TO_SELF, 0.5f);
		}
		animation.setDuration(300);//设置动画持续时间
		animation.setInterpolator(new LinearInterpolator());
		animation.setRepeatMode(Animation.REVERSE);//设置反方向执行
		animation.setFillAfter(true);//动画执行完后是否停留在执行完的状态
		down.startAnimation(animation);
	}
	
	private void openAnim(View v) {
//		v.setVisibility(View.VISIBLE);
		ValueAnimator animator = createDropAnimator(v, mHeight, origHeight);
		animator.addListener(new AnimatorListenerAdapter() {
			@Override
			public void onAnimationEnd(Animator animation) {
				super.onAnimationEnd(animation);
			}
		});
		animator.start();
	}
	
	private void closeAnimate(final View view) {

		ValueAnimator animator = createDropAnimator(view, origHeight, mHeight);
		animator.addListener(new AnimatorListenerAdapter() {
			@Override
			public void onAnimationEnd(Animator animation) {
				//view.setVisibility(View.GONE);
			}
		});
		animator.start();
	}
	
	private ValueAnimator createDropAnimator(final View v, final int start, final int end) {
		ValueAnimator animator = ValueAnimator.ofInt(start, end);
		animator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
			@Override
			public void onAnimationUpdate(ValueAnimator animation) {
				int value = (int) animation.getAnimatedValue();
				ViewGroup.LayoutParams layoutParams = v.getLayoutParams();
				layoutParams.height = value;
//				layoutParams.width = value;
				v.setLayoutParams(layoutParams);
				
			}
		});
		return animator;
	}

	public void startRotateAnimation(View view, View hideView) {

		RotateAnimation animation;
		if (View.VISIBLE == hideView.getVisibility()) {
			hideView.setVisibility(View.GONE);
			animation = new RotateAnimation(180, 0, Animation.RELATIVE_TO_SELF, 0.5f, Animation.RELATIVE_TO_SELF, 0.5f);
		} else {
			hideView.setVisibility(View.VISIBLE);
			animation = new RotateAnimation(0, 180, Animation.RELATIVE_TO_SELF, 0.5f, Animation.RELATIVE_TO_SELF, 0.5f);
		}




		animation.setDuration(300);//设置动画持续时间
		animation.setInterpolator(new LinearInterpolator());
		animation.setRepeatMode(Animation.REVERSE);//设置反方向执行
		animation.setFillAfter(true);//动画执行完后是否停留在执行完的状态
		view.startAnimation(animation);
	}
}
