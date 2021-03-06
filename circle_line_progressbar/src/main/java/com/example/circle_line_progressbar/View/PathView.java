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

/**
 *
 * 路径path
 * Created by gyx on 2018/1/9.
 */
public class PathView extends View {
	private  Path mPath;
	private  Paint mPaint;
	private  RectF rectF;

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
		/*
		//移动到（100，100）
		mPath.moveTo(100,100);
		//连接路径到（100，100）
		mPath.lineTo(300, 100);
		mPath.lineTo(300, 400);
		mPath.lineTo(200, 400);
		//闭合曲线
		mPath.close();
		*/





		/*//画一个圆弧
		mPath.moveTo(300, 300);
		rectF = new RectF(0, 0, 200, 200);
		//true就不显示连接的直线
		mPath.arcTo(rectF, 0, 109,false);
		mPath.close();
        */



		mPath.moveTo(100, 100);
		mPath.lineTo(200, 200);
		rectF = new RectF(100, 100, 300, 400);
		mPath.addArc(rectF, 0, 109);








	}

	@Override
	protected void onDraw(Canvas canvas) {
		super.onDraw(canvas);
		//绘制路径
		canvas.drawRect(rectF,mPaint);
		canvas.drawPath(mPath, mPaint);
	}
}


























