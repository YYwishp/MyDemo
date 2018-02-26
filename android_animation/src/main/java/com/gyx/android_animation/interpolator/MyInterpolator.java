package com.gyx.android_animation.interpolator;

import android.animation.TimeInterpolator;

/**
 *
 * 自定义插值器
 * Created by gyx on 2018/2/24.
 */
public class MyInterpolator implements TimeInterpolator{
	@Override
	public float getInterpolation(float input) {
		return -input;
	}
}
