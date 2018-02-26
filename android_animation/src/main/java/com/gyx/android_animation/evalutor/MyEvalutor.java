package com.gyx.android_animation.evalutor;

import android.animation.TypeEvaluator;

/**
 *
 *
 * 自定义Evalutor
 * Created by gyx on 2018/2/24.
 */
public class MyEvalutor implements TypeEvaluator<Integer> {
	@Override
	public Integer evaluate(float fraction, Integer startValue, Integer endValue) {
		int startInt = startValue;
		return (int) (200 + startInt + fraction * (endValue - startInt));
	}




}
