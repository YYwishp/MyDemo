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
 * Created by gyx on 2018/1/4.
 */
public class ECGView extends View {
	private Paint mPaint;
	private Path mPath;

	private float initX;// 初始X轴坐标
	private float transX, moveX;// 画布移动的距离
	private boolean isCanvasMove;// 画布是否需要平移
	private int screenW;
	private int screenH;
	private float x, y;// 路径初始坐标
	private float initScreenW;// 屏幕初始宽度

	public ECGView(Context context) {
		super(context);
	}

	public ECGView(Context context, @Nullable AttributeSet attrs) {
		super(context, attrs);
		/**
		 * 实例化画笔并设置属性
		 */
		//抗锯齿，抗抖动
		mPaint = new Paint(Paint.ANTI_ALIAS_FLAG | Paint.DITHER_FLAG);
		mPaint.setColor(Color.GREEN);
		mPaint.setStrokeWidth(5);
		//设置我们画笔的笔触风格
		mPaint.setStrokeCap(Paint.Cap.SQUARE);
		//用于设置结合处的形态
		mPaint.setStrokeJoin(Paint.Join.ROUND);
		mPaint.setStyle(Paint.Style.STROKE);
		//为我们绘制的图形添加一个阴影层效果
		mPaint.setShadowLayer(7, 0, 0, Color.GREEN);
		mPath = new Path();
		transX = 0;
		isCanvasMove = false;

	}

	public ECGView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
		super(context, attrs, defStyleAttr);
	}

	@Override
	protected void onSizeChanged(int w, int h, int oldw, int oldh) {
		/*
         * 获取屏幕宽高
         */
		screenW = w;
		screenH = h;

		/*
         * 设置起点坐标
         */
		x = 0;
		y = (screenH / 2) ;

		// 屏幕初始宽度
		initScreenW = screenW;

		// 初始X轴坐标
		initX = ((screenW / 2) + (screenW / 4));

		moveX = (screenW / 24);

		mPath.moveTo(x, y);
	}

	@Override
	protected void onDraw(Canvas canvas) {
		super.onDraw(canvas);
		canvas.drawColor(Color.BLACK);
		mPath.lineTo(x, y);
		//向左平移画布
		canvas.translate(-transX, 0);
		//计算坐标
		calCoors();
		//绘制路径
		canvas.drawPath(mPath, mPaint);
		invalidate();

	}

	private void calCoors() {
		if (isCanvasMove == true) {
			transX += 4;
		}

		if (x < initX) {
			x += 8;
		} else {
			if (x < initX + moveX) {
				x += 2;
				y -= 8;
			} else {
				if (x < initX + (moveX * 2)) {
					x += 2;
					y += 14;
				} else {
					if (x < initX + (moveX * 3)) {
						x += 2;
						y -= 12;
					} else {
						if (x < initX + (moveX * 4)) {
							x += 2;
							y += 6;
						} else {
							if (x < initScreenW) {
								x += 8;
							} else {
								isCanvasMove = true;
								initX = initX + initScreenW;
							}
						}
					}
				}
			}

		}
	}
}



























































