package com.gyx.android_animation.view;

import android.content.Context;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.View;
import android.widget.TextView;

import com.gyx.android_animation.R;

/**
 * Created by gyx on 2018/2/27.
 */
public class MyTextView extends android.support.v7.widget.AppCompatTextView {
	public MyTextView(Context context, @Nullable AttributeSet attrs) {

		super(context, attrs);
	}

	public void setCharText(Character charText) {
		setText(String.valueOf(charText));

	}
}
