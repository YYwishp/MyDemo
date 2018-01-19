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
		//声明临时变量存储父容器的期望值
		int parentDesireWidth = 0;
		int parentDesireHeight = 0;




		/**
		 * 如果有子元素
		 */
		if (getChildCount()>0) {
			//对子元素进行测量
//			measureChildren(widthMeasureSpec, heightMeasureSpec);

			//那么遍历子元素并对其进行测量
			for (int i = 0; i < getChildCount(); i++) {
				//获取子元素
				View child = getChildAt(i);

				//获取子元素的布局参数
				CustomLayoutParams layoutParams = (CustomLayoutParams) child.getLayoutParams();

				//测量子元素并考虑外边距
				measureChildWithMargins(child, widthMeasureSpec, 0, heightMeasureSpec, 0);

				//计算父容器的期望值
				//孩子的宽度，加上外边距
				parentDesireWidth = parentDesireWidth + child.getMeasuredWidth() + layoutParams.leftMargin + layoutParams.rightMargin;
				parentDesireHeight = parentDesireHeight + child.getMeasuredHeight() + layoutParams.topMargin + layoutParams.bottomMargin;
			}

			//考虑父容器的内边距
			parentDesireWidth = parentDesireWidth + getPaddingLeft() + getPaddingRight();
			parentDesireHeight = parentDesireHeight + getPaddingTop() + getPaddingBottom();

			//尝试比较，建议最小值和期望值的大小并取大值
			parentDesireWidth = Math.max(parentDesireWidth, getSuggestedMinimumWidth());
			parentDesireHeight = Math.max(parentDesireHeight, getSuggestedMinimumHeight());


		}

		//设置最终测量值
		setMeasuredDimension(resolveSize(parentDesireWidth, widthMeasureSpec), resolveSize(parentDesireHeight, heightMeasureSpec));

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
				CustomLayoutParams layoutParams = (CustomLayoutParams) child.getLayoutParams();
				//通知子元素进行布局
				child.layout(parentPaddingLeft+layoutParams.leftMargin, mutilHeight+parentPaddingTop+layoutParams.topMargin, child.getMeasuredWidth()+parentPaddingLeft+layoutParams.leftMargin, child.getMeasuredHeight()+mutilHeight+parentPaddingTop+layoutParams.topMargin);
				//累计高度
				mutilHeight = mutilHeight + child.getMeasuredHeight()+layoutParams.topMargin+layoutParams.bottomMargin;
			}
		}



	}

	public static class CustomLayoutParams extends MarginLayoutParams {
		public CustomLayoutParams(Context c, AttributeSet attrs) {
			super(c, attrs);
		}

		public CustomLayoutParams(int width, int height) {
			super(width, height);
		}

		public CustomLayoutParams(MarginLayoutParams source) {
			super(source);
		}

		public CustomLayoutParams(LayoutParams source) {
			super(source);
		}
	}

	/**
	 * 生成默认的布局参数
	 * @return
	 */
	@Override
	protected LayoutParams generateDefaultLayoutParams() {
		return new CustomLayoutParams(LayoutParams.MATCH_PARENT, LayoutParams.MATCH_PARENT);
	}

	/**
	 * 生成布局参数
	 * 将布局参数包装成我们的
	 * @param p
	 * @return
	 */
	@Override
	protected LayoutParams generateLayoutParams(LayoutParams p) {
		return new CustomLayoutParams(p);
	}

	/**
	 * 生成布局参数
	 * 从属性配置中生成我们的布局参数
	 * @param attrs
	 * @return
	 */
	@Override
	public LayoutParams generateLayoutParams(AttributeSet attrs) {
		return new CustomLayoutParams(getContext(), attrs);
	}

	/**
	 * 检查当前布局参数是否是我们定义的类型，这在code声明布局参数时常常用到的
	 * @param p
	 * @return
	 */
	@Override
	protected boolean checkLayoutParams(LayoutParams p) {
		return p instanceof CustomLayoutParams;
	}



}




























