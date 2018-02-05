package com.example.circle_line_progressbar.View;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;

import com.example.circle_line_progressbar.R;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by gyx on 2018/1/25.
 */
public class SquareLayout extends ViewGroup {
	private int mOrientation;//排列方向
	private static final int ORIENTATION_HORIZONTAL = 0, ORIENTATION_VERTICAL = 1;// 排列方向的常量标识值
	private static final int DEFAULT_MAX_ROW = Integer.MAX_VALUE, DEFAULT_MAX_COLUMN = Integer.MAX_VALUE;// 最大行列默认值
	private int mMaxRow = DEFAULT_MAX_ROW;// 最多多少行
	private int mMaxColumn = DEFAULT_MAX_COLUMN;// 最多多少列
	private View childAt;

	public SquareLayout(Context context, AttributeSet attrs) {
		super(context, attrs);
		//初始化一行一列最大多少个子view
		mMaxRow = 5;
		mMaxColumn = 1;
		/**
		 * 获取xml对应属性
		 */
		TypedArray typedArray = context.obtainStyledAttributes(attrs, R.styleable.SquareLayout);
		//垂直还是水平
		mOrientation = typedArray.getInteger(R.styleable.SquareLayout_orientation, 0);
		typedArray.recycle();
	}

	@Override
	protected LayoutParams generateDefaultLayoutParams() {
		return new MarginLayoutParams(LayoutParams.MATCH_PARENT, LayoutParams.MATCH_PARENT);
	}

	@Override
	protected LayoutParams generateLayoutParams(LayoutParams p) {
		return new MarginLayoutParams(p);
	}

	@Override
	public LayoutParams generateLayoutParams(AttributeSet attrs) {
		return new MarginLayoutParams(getContext(), attrs);
	}

	@Override
	protected boolean checkLayoutParams(android.view.ViewGroup.LayoutParams p) {
		return p instanceof MarginLayoutParams;
	}

	@Override
	protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
		super.onMeasure(widthMeasureSpec, heightMeasureSpec);
		/**
		 * 声明临时变量存储父容器的期望值
		 */
		int parentDesireWidth = 0;
		int parentDesireHeight = 0;
		/**
		 * 声明临时变量存储子元素的测量状态
		 *
		 */
		int childMeasureState = 0;
		/**
		 * 如果父容器中有子元素
		 *
		 */
		if (getChildCount() > 0) {
			// 声明两个一维数组存储子元素宽高数据
			int[] childWidths = new int[getChildCount()];
			int[] childHeights = new int[getChildCount()];
			for (int i = 0; i < getChildCount(); i++) {
				//获取遍历下标的子元素
				View child = getChildAt(i);
				/**
				 * 如果该子元素不是GONE，就要计算宽高，进行测量
				 */
				if (child.getVisibility() != GONE) {
					//测量子元素并考量其外边距
					measureChildWithMargins(child, widthMeasureSpec, 0, heightMeasureSpec, 0);
					//比较子元素测量宽高并比较取其交大的值
					int childMeasureSize = Math.max(child.getMeasuredWidth(), child.getMeasuredHeight());
					//重新封装子元素测量规格
					int childMeasureSpec = MeasureSpec.makeMeasureSpec(childMeasureSize, MeasureSpec.EXACTLY);
					//重新测量子元素
					child.measure(childMeasureSpec, childMeasureSpec);
					//获取子元素布局参数
					MarginLayoutParams layoutParams = (MarginLayoutParams) child.getLayoutParams();
					/**
					 * 考量外边距计算子元素的实际宽高,并将数据存入数组
					 */
					childWidths[i] = child.getMeasuredWidth() + layoutParams.leftMargin + layoutParams.rightMargin;
					childHeights[i] = child.getMeasuredHeight() + layoutParams.topMargin + layoutParams.bottomMargin;
//
					//合并子元素的测量状态
					childMeasureState = combineMeasuredStates(childMeasureState, child.getMeasuredState());
				}
			}
			//声明临时变量存储行列宽高
			int indexMultiWidth = 0, indexMultiHeight = 0;
			/**
			 * 如果是横向排列
			 */
			if (mOrientation == ORIENTATION_HORIZONTAL) {
				//如果子元素数量大于限定值则进行换行运算
				if (getChildCount() > mMaxColumn) {
					//计算产生的行数
					int row = getChildCount() / mMaxColumn;
					//计算余数
					int remainder = getChildCount() % mMaxColumn;
					//声明临时变量存储子元素宽高数组下标值
					int index = 0;
					/**
					 * 遍历数组计算父容器期望款高值
					 */
					for (int x = 0; x < row; x++) {
						for (int y = 0; y < mMaxColumn; y++) {
							//单行宽度累加
							indexMultiWidth += childWidths[index];
							//单行高度取最大值
							indexMultiHeight = Math.max(indexMultiHeight, childHeights[index++]);
						}
						// 每一行遍历完后，将该行宽度与上一行宽度比较取最大值
						parentDesireWidth = Math.max(parentDesireHeight, indexMultiWidth);
						// 每一行遍历玩后，累加各行的高度
						parentDesireHeight = parentDesireHeight + indexMultiHeight;
						// 重置参数
						indexMultiWidth = 0;
						indexMultiHeight = 0;
					}
					/**
					 * 如果有余数，说明最后有一行不满足一行
					 */
					if (remainder != 0) {
						/**
						 * 遍历剩下的这些子元素，将其宽高计算到父容器期望值
						 */
						for (int i = getChildCount() - remainder; i < getChildCount(); i++) {
							//宽度累加
							indexMultiWidth = indexMultiWidth + childWidths[i];
							//高度找最大的一个
							indexMultiHeight = Math.max(indexMultiHeight, childHeights[i]);
						}
						//最后一行与上面的求最大的宽度
						parentDesireWidth = Math.max(parentDesireWidth, indexMultiWidth);
						//最后一行与上面的累加高度
						parentDesireHeight += indexMultiHeight;
						indexMultiWidth = 0;
						indexMultiHeight = 0;
					}

				} else {
					/**
					 * 如果子元素数量还没限制值大，那么就直接计算不需要换行
					 */
					for (int i = 0; i < getChildCount(); i++) {
						//累加子元素的实际高度
						parentDesireHeight += childHeights[i];
						//获取子元素中宽度最大值
						parentDesireWidth = Math.max(parentDesireWidth, childWidths[i]);

					}

				}

			}
			/**
			 * 如果为竖向排列
			 */
			else if (mOrientation == ORIENTATION_VERTICAL) {
				if (getChildCount() > mMaxRow) {
					//计算有多少列
					int column = getChildCount() / mMaxRow;
					//计算余数
					int remainder = getChildCount() % mMaxRow;
					int index = 0;
					//遍历循环计算
					for (int x = 0; x < column; x++) {
						for (int y = 0; y < mMaxRow; y++) {
							//累计计算高度
							indexMultiHeight += childHeights[index];
							//计算最大的宽度
							indexMultiWidth = Math.max(indexMultiWidth, childWidths[index++]);
							//
						}
						// 获取一列中最高的高度
						parentDesireHeight = Math.max(parentDesireHeight, indexMultiHeight);
						// 父容器宽度累加
						parentDesireWidth += indexMultiWidth;
						//数据重置
						indexMultiHeight = 0;
						indexMultiWidth = 0;

					}
					//如果余数不为0，意味着有单独一个不完全的一行
					if (remainder != 0) {
						for (int i = getChildCount() - remainder; i < getChildCount(); i++) {
							indexMultiHeight += childHeights[i];
							indexMultiWidth = Math.max(indexMultiWidth, childWidths[i]);

						}
						parentDesireHeight = Math.max(parentDesireHeight, indexMultiHeight);
						parentDesireWidth += indexMultiWidth;
						//数据重置
						indexMultiHeight = 0;
						indexMultiWidth = 0;
					}




				}
				/**
				 *  如果子元素没有限制的值大那么就直接计算，不需要另起一列
				 */
				else  {
					for (int i = 0; i < getChildCount(); i++) {

						//累加子元素的实际高度
						parentDesireHeight += childHeights[i];
						//获取当前列中的最大宽度
						parentDesireWidth = Math.max(parentDesireHeight, childWidths[i]);
					}
				}

			}


			/**
			 * 考量父容器内边距将其累加到期望值
			 */
			parentDesireWidth = parentDesireWidth + getPaddingLeft() + getPaddingRight();
			parentDesireHeight = parentDesireHeight + getPaddingTop() + getPaddingBottom();
			/**
			 * 尝试比较父容器期望值与Android建议的最大值大小，并取较大的值
			 */
			parentDesireWidth = Math.max(parentDesireWidth, getSuggestedMinimumWidth());
			parentDesireHeight = Math.max(parentDesireHeight, getSuggestedMinimumHeight());
		}
		/**
		 * 确定父容器的测量宽高
		 * resolveSizeAndState：使用resolveSizeAndState再次对计算得出的宽高进行解算
		 *
		 *
		 */
		setMeasuredDimension(resolveSizeAndState(parentDesireWidth, widthMeasureSpec, childMeasureState),
				resolveSizeAndState(parentDesireHeight, heightMeasureSpec, childMeasureState << MEASURED_HEIGHT_STATE_SHIFT));
	}

	@Override
	protected void onLayout(boolean changed, int l, int t, int r, int b) {
		//如果父容器下有子元素
		if (getChildCount() > 0) {
			//声明临时变量存储宽高倍增值
			int multi = 0;
			//指数倍增值
			int indexMulti =1;
			//声明临时变量存储行/列宽高
			int indexMultiWidth = 0;
			int indexMultiHeight = 0;
			//声明临时变量存储行/列临时宽高
			int tempHeight = 0;
			int tempWidth = 0;
			/**
			 * 遍历子元素
			 */
			for (int i = 0; i < getChildCount(); i++) {
				View child = getChildAt(i);
				/**
				 * 如果该子View不是GONE
				 */
				if (child.getVisibility() != GONE) {
					//获取子view的布局参数
					MarginLayoutParams layoutParams = (MarginLayoutParams) child.getLayoutParams();
					//获取子View的宽度
					int childActualSize = child.getMeasuredWidth();//child.getMeasureHeight()
					/**
					 * 如果是横向排列
					 */
					if (mOrientation == ORIENTATION_HORIZONTAL) {
						/**
						 * 如果当前子元素数量比限定值大
						 */
						if (getChildCount() > mMaxColumn) {
							//根据当前子元素进行布局
							if (i < mMaxColumn * indexMulti) {
								child.layout(getPaddingLeft() + layoutParams.leftMargin + indexMultiWidth,
										getPaddingTop() + layoutParams.topMargin + indexMultiHeight,
										getPaddingLeft() + childActualSize + layoutParams.leftMargin + indexMultiWidth,
										childActualSize + getPaddingTop() + layoutParams.topMargin + indexMultiHeight);
								//累加宽度
								indexMultiWidth += childActualSize + layoutParams.leftMargin + layoutParams.rightMargin;
								//获取当前行里面的最大高度
								tempHeight = Math.max(tempHeight, childActualSize) + layoutParams.topMargin + layoutParams.bottomMargin;
								/**
								 *如果下一次遍历到的子元素下标值大于限定值
								 */
								if (i + 1 >= mMaxColumn * indexMulti) {
									//那么累加高度到高度的倍增值
									indexMultiHeight += tempHeight;
									//宽度的倍增值重置
									indexMultiWidth = 0;
									indexMulti++;
								}
							}
						} else {
							//子元素的数量小于限定值
							child.layout(getPaddingLeft() + layoutParams.leftMargin + multi,
									getPaddingTop() + layoutParams.topMargin,
									getPaddingLeft() + childActualSize + layoutParams.leftMargin + multi,
									getPaddingBottom() + childActualSize + layoutParams.bottomMargin);
							//累加倍增值
							multi += childActualSize + layoutParams.leftMargin + layoutParams.rightMargin;
						}
					}
					/**
					 * 如果是竖向排列
					 */
					else if (mOrientation == ORIENTATION_VERTICAL) {
						if (getChildCount() > mMaxRow) {
							if (i < mMaxRow * indexMulti) {
								child.layout(getPaddingLeft() + layoutParams.leftMargin + indexMultiWidth,
										getPaddingTop() + layoutParams.topMargin + indexMultiHeight,
										getPaddingLeft() + layoutParams.leftMargin + childActualSize + indexMultiWidth,
										getPaddingTop() + layoutParams.topMargin + childActualSize + indexMultiHeight
								);
								//改变增加量
								indexMultiHeight += childActualSize + layoutParams.topMargin + layoutParams.bottomMargin;
								//计算最大的高度
								tempWidth = Math.max(tempWidth, childActualSize) + layoutParams.leftMargin + layoutParams.rightMargin;
								/**
								 * 如果下一个遍历的子元素的下标大于限定值,就代表是下一列
								 */
								if (i + 1 >= mMaxRow * indexMulti) {
									//代表有下一列，就把宽度赋值给indexMultiWidth
									indexMultiWidth += tempWidth;
									//代表有下一列，那么高度的倍增值就先轻空
									indexMultiHeight = 0;
									//代表下一列
									indexMulti++;
								}
							}
						} else {
							/**
							 * 子view的数量，没有一列最大值多，说明就只有一列
							 */
							child.layout(getPaddingLeft() + layoutParams.leftMargin,
									getPaddingTop() + layoutParams.topMargin + multi,
									getPaddingLeft() + layoutParams.leftMargin + childActualSize,
									getPaddingTop() + childActualSize + layoutParams.topMargin + multi);
							//累加倍增值
							multi += childActualSize + layoutParams.topMargin + layoutParams.bottomMargin;
						}


					}
				}


			}
		}
	}
}













































