package com.example.circle_line_progressbar.View;

import android.content.Context;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.View;
import android.view.WindowManager;

/**
 * 自定义图标
 * Created by gyx on 2018/1/17.
 */
public class IconView extends View {




	private float mTextSize;// 画笔的文本尺寸






	public IconView(Context context, @Nullable AttributeSet attrs) {
		super(context, attrs);
		//计算参数
		calArgs(context);
		//初始化
		init();
	}

	/**
	 * 计算参数
	 * @param context
	 */
	private void calArgs(Context context) {
		//获取屏幕
		WindowManager wm = (WindowManager) context.getSystemService(Context.WINDOW_SERVICE);
		int width = wm.getDefaultDisplay().getWidth();
		int height = wm.getDefaultDisplay().getHeight();
		//计算文本尺寸
		mTextSize = width * 1 / 10F;
	}

	/**
	 * 初始化
	 */
	private void init() {

	}

}































































































































