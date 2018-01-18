package com.example.circle_line_progressbar.View;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;

/**
 * Created by gyx on 2018/1/18.
 */
public class CustomLayout extends ViewGroup {
	public CustomLayout(Context context, AttributeSet attrs) {
		super(context, attrs);
	}

	@Override
	protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
		super.onMeasure(widthMeasureSpec, heightMeasureSpec);
		/**
		 * 如果有子元素
		 */
		if (getChildCount()>0) {
			//对子元素进行测量
			measureChildren(widthMeasureSpec, heightMeasureSpec);
		}

	}

	@Override
	protected void onLayout(boolean changed, int l, int t, int r, int b) {
		//获取父容器内边距
		int parentPaddingLeft = getPaddingLeft();
		int parentPaddingRight = getPaddingRight();
		int parentPaddingTop = getPaddingTop();
		int parentPaddingBottom = getPaddingBottom();





		/**
		 * 如果有子元素
		 */
		if (getChildCount()>0) {
			// 声明一个临时变量存储高度倍增值
			int mutilHeight = 0;
			//那么遍历子元素并对其进行定位布局
			for (int i = 0; i < getChildCount(); i++) {
				//获取一个子元素
				View child = getChildAt(i);
				//通知子元素进行布局
				child.layout(parentPaddingLeft, mutilHeight+parentPaddingTop, child.getMeasuredWidth()+parentPaddingLeft, child.getMeasuredHeight()+mutilHeight+parentPaddingBottom);
				//累计高度
				mutilHeight = mutilHeight + child.getMeasuredHeight();
			}
		}



	}





}
