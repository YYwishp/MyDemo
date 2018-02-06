package com.example.circle_line_progressbar.View;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.circle_line_progressbar.R;

/**
 * Created by gyx on 2018/2/6.
 */
public class ComplexView extends FrameLayout {
	private final ImageView ivIcon;
	private final TextView tvTitle;

	public ComplexView(@NonNull Context context, @Nullable AttributeSet attrs) {
		super(context, attrs);
		//加载布局文件
		LayoutInflater layoutInflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
		layoutInflater.inflate(R.layout.view_complex, this);

		//获取控件
		ivIcon = findViewById(R.id.view_complex_image_iv);
		tvTitle = findViewById(R.id.view_complex_title_tv);
	}
}
