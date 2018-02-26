package com.gyx.android_animation.evalutor;

import android.animation.TypeEvaluator;

import com.gyx.android_animation.view.MyPoint;

/**
 * Created by gyx on 2018/2/26.
 */
public class PointEvaluator implements TypeEvaluator<MyPoint> {
	@Override
	public MyPoint evaluate(float fraction, MyPoint startValue, MyPoint endValue) {
		int startRadius = startValue.getRadius();
		int endRadius = endValue.getRadius();
		int resultRadius = (int) (startRadius + fraction * (endRadius - startRadius));
		return new MyPoint(resultRadius);
	}
}
