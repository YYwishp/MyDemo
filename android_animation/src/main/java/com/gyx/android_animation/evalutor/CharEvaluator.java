package com.gyx.android_animation.evalutor;

import android.animation.TypeEvaluator;

import java.util.Currency;

/**
 * Created by gyx on 2018/2/26.
 */
public class CharEvaluator implements TypeEvaluator<Character> {
	@Override
	public Character evaluate(float fraction, Character startValue, Character endValue) {
		int startInt = startValue;
		int endInt = endValue;
		int curInt = (int) (startInt + fraction * (endInt - startInt));
		char result = (char) curInt;
		return result;
	}





}
