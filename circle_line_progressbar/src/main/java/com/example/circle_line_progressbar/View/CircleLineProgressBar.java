package com.example.circle_line_progressbar.View;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.View;

/**
 * 圆圈不停的放大
 * Created by gyx on 2017/12/27.
 */
public class CircleLineProgressBar extends View implements Runnable{

	private Paint mPaint;

	private int radiu;// 圆环半径
	public CircleLineProgressBar(Context context) {
		super(context);
	}

	public CircleLineProgressBar(Context context, @Nullable AttributeSet attrs) {
		super(context, attrs);
		// 初始化画笔
		initPaint();
	}


	public CircleLineProgressBar(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
		super(context, attrs, defStyleAttr);
	}


	private void initPaint() {
		// 实例化画笔并打开抗锯齿
		mPaint = new Paint(Paint.ANTI_ALIAS_FLAG);


		/*
     * 设置画笔样式为描边，圆环嘛……当然不能填充不然就么意思了
     *
     * 画笔样式分三种：
     * 1.Paint.Style.STROKE：描边
     * 2.Paint.Style.FILL_AND_STROKE：描边并填充
     * 3.Paint.Style.FILL：填充
     */
		mPaint.setStyle(Paint.Style.STROKE);

		// 设置画笔颜色为浅灰色
		mPaint.setColor(Color.RED);

    /*
     * 设置描边的粗细，单位：像素px
     * 注意：当setStrokeWidth(0)的时候描边宽度并不为0而是只占一个像素
     */
		mPaint.setStrokeWidth(10);
	}


	@Override
	protected void onDraw(Canvas canvas) {
		super.onDraw(canvas);

		// 绘制圆环
		canvas.drawCircle(350, 640, radiu, mPaint);


	}


//	public synchronized void setRadiu(int radiu) {
//		this.radiu = radiu;
//
//		// 重绘
//		invalidate();
//	}

	@Override
	public void run() {




		/*
                 * 确保线程不断执行不断刷新界面
                 */
		while (true) {
			try {
                        /*
                         * 如果半径小于200则自加否则大于200后重置半径值以实现往复
                         */
				if (radiu <= 250) {
					radiu += 5;

					postInvalidate();
				} else {
					radiu = 0;
				}

				// 每执行一次暂停40毫秒
				Thread.sleep(20);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}

	}





}
