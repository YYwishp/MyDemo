package com.example.circle_line_progressbar.View;

import android.content.Context;
import android.graphics.Canvas;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.util.Log;
import android.view.View;

/**
 * Created by gyx on 2018/2/5.
 */
public class LifeCycleView extends View {
	private static final String TAG = "gyx";

	public LifeCycleView(Context context) {
		super(context);
		Log.e(TAG, "Construction with single parameter");
	}

	/**
	 * 《1》
	 * @param context
	 * @param attrs
	 */
	public LifeCycleView(Context context, @Nullable AttributeSet attrs) {
		super(context, attrs);
		Log.e(TAG, "Construction with two parameters");
	}

	public LifeCycleView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
		super(context, attrs, defStyleAttr);
		Log.e(TAG, "Construction with three parameters");
	}

	/**
	 * 《2》
	 * 这个方法当xml布局中我们的View被解析完成后则会调用，具体的实现在LayoutInflater的rInflate方法中
	 * 也就是说如果我们不从xml布局文件中解析的话，该方法就不会被调用
	 */
	@Override
	protected void onFinishInflate() {
		super.onFinishInflate();
		Log.e(TAG, "onFinishInflate");
	}

	/**
	 * 《3》
	 * 此时表示我们的View已被创建并添加到了窗口Window中，
	 * 该方法后紧接着一般会调用onWindowVisibilityChanged方法，
	 * 只要我们当前的Window窗口中View的可见状态发生改变都会被触发
	 */
	@Override
	protected void onAttachedToWindow() {
		super.onAttachedToWindow();
		Log.e(TAG, "onAttachedToWindow");
	}

	/**
	 * 《4》
	 * 只要我们当前的Window窗口中View的可见状态发生改变都会被触发,
	 * 这时View是被显示了，随后就会开始调用onMeasure方法对View进行测量
	 *
	 * @param visibility
	 */
	@Override
	protected void onWindowVisibilityChanged(int visibility) {
		super.onWindowVisibilityChanged(visibility);
		Log.e(TAG, "onWindowVisibilityChanged");
	}

	/**
	 * 《5》
	 * 这时View是被显示了，随后就会开始调用onMeasure方法对View进行测量
	 * 如果测量结果被确定则会先调用onSizeChanged方法通知View尺寸大小发生了改变
	 *
	 *
	 * @param widthMeasureSpec
	 * @param heightMeasureSpec
	 */
	@Override
	protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
		super.onMeasure(widthMeasureSpec, heightMeasureSpec);
		Log.e(TAG, "onMeasure");
	}

	/**
	 * 《6》
	 * 如果测量结果被确定则会先调用onSizeChanged方法通知View尺寸大小发生了改变，
	 *
	 *
	 *
	 * @param w
	 * @param h
	 * @param oldw
	 * @param oldh
	 */
	@Override
	protected void onSizeChanged(int w, int h, int oldw, int oldh) {
		super.onSizeChanged(w, h, oldw, oldh);
		Log.e(TAG, "onSizeChanged");

	}

	/**
	 * 《7》
	 * 紧跟着便会调用onLayout方法对子元素进行定位布局，
	 *  然后再次调用onMeasure方法对View进行二次测量，
	 *  如果测量值与上一次相同则不再调用onSizeChanged方法，接着再次调用onLayout方法，如果测量过程结束，则会调用onDraw方法绘制View。
	 * @param changed
	 * @param left
	 * @param top
	 * @param right
	 * @param bottom
	 */
	@Override
	protected void onLayout(boolean changed, int left, int top, int right, int bottom) {
		super.onLayout(changed, left, top, right, bottom);
		Log.e(TAG, "onLayout");
	}

	/**
	 * 《8》
	 *  如果测量过程结束，则会调用onDraw方法绘制View。
	 * @param canvas
	 */
	@Override
	protected void onDraw(Canvas canvas) {
		super.onDraw(canvas);
		Log.e(TAG, "onDraw");
	}

	@Override
	protected void onDetachedFromWindow() {
		super.onDetachedFromWindow();
		Log.e(TAG, "onDetachedFromWindow");
	}
}

