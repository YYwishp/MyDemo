package com.example.circle_line_progressbar.View;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Path;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.View;

/**
 *
 * 路径path
 * Created by gyx on 2018/1/9.
 */
public class PathView extends View {
	private  Path mPath;
	private  Paint mPaint;

	public PathView(Context context, @Nullable AttributeSet attrs) {

		super(context, attrs);
		/**
		 * 实例化画笔
		 */
		mPaint = new Paint(Paint.ANTI_ALIAS_FLAG | Paint.DITHER_FLAG);
		mPaint.setStyle(Paint.Style.STROKE);
		mPaint.setColor(Color.CYAN);
		mPaint.setStrokeWidth(5);
		//实例化路径
		mPath = new Path();
		//移动到（100，100）
		mPath.moveTo(100,100);
		//连接路径到（100，100）
		mPath.lineTo(300, 100);
		mPath.lineTo(300, 400);
		mPath.lineTo(200, 400);
		//闭合曲线
		mPath.close();
	}

	@Override
	protected void onDraw(Canvas canvas) {
		super.onDraw(canvas);
		//绘制路径
		canvas.drawPath(mPath, mPaint);
	}
}
