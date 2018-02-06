package com.example.circle_line_progressbar.View;

import android.content.Context;
import android.graphics.Typeface;
import android.support.annotation.Nullable;
import android.support.v7.widget.LinearLayoutCompat;
import android.util.AttributeSet;
import android.view.Gravity;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.circle_line_progressbar.R;

/**
 * Created by gyx on 2018/2/6.
 */
public class ComplexView2 extends LinearLayout {
	private final ImageView ivIcon;
	private final TextView tvTitle;

	public ComplexView2(Context context, @Nullable AttributeSet attrs) {
		super(context, attrs);

		//设置线性布局排列方式
		setOrientation(VERTICAL);
		//设置线性布局子元素的对其方式
		setGravity(Gravity.CENTER);


		//实例化子元素
		ivIcon = new ImageView(context);
		ivIcon.setImageResource(R.drawable.bbb);
		//
		tvTitle = new TextView(context);
		tvTitle.setText("GYX");
		tvTitle.setTextSize(30);
		tvTitle.setTypeface(Typeface.DEFAULT_BOLD);
		//
		//将子元素添加到复合控件中
		addView(ivIcon, new LinearLayout.LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT));
		addView(tvTitle, new LinearLayout.LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT));

	}
}
