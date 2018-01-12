package com.example.circle_line_progressbar.View;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.RectF;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.View;

import java.nio.channels.OverlappingFileLockException;

/**
 *
 * Created by gyx on 2018/1/9.
 */
public class PathView_2 extends View {
	private  Path mPath;
	private  Paint mTextPaint;
	private  Paint mPaint;

	public PathView_2(Context context, @Nullable AttributeSet attrs) {
		super(context, attrs);
		/**
		 * 实例化画笔设置属性
		 */
		mPaint = new Paint(Paint.ANTI_ALIAS_FLAG | Paint.DITHER_FLAG);
		mPaint.setStyle(Paint.Style.STROKE);
		mPaint.setColor(Color.CYAN);
		mPaint.setStrokeWidth(5);
		//
		mTextPaint = new Paint(Paint.ANTI_ALIAS_FLAG | Paint.DITHER_FLAG | Paint.LINEAR_TEXT_FLAG);
		mTextPaint.setColor(Color.DKGRAY);
		mTextPaint.setTextSize(50);
		//实例化路径
		mPath = new Path();
		//添加一条弧线到path路径中
		RectF oval = new RectF(100, 100, 300, 400);
		//Path.Direction.CW:外围顺时针
		//Path.Direction.CCW:内围逆时针
		mPath.addOval(oval, Path.Direction.CW);

	}

	@Override
	protected void onDraw(Canvas canvas) {
		super.onDraw(canvas);
		//绘制路径
		canvas.drawPath(mPath, mPaint);
		//绘制路径上的文字
		canvas.drawTextOnPath("123456789", mPath, 0, 0, mTextPaint);







	}
}
