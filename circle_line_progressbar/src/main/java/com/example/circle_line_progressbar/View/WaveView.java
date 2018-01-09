package com.example.circle_line_progressbar.View;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Path;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.View;

/**
 * 水波纹
 * Created by gyx on 2018/1/9.
 */
public class WaveView extends View {
	private Paint mPaint;
	private Path mPath;
	private int vWidth, vHeight;// 控件宽高
	private float waveY;// 整个Wave顶部两端点的Y坐标，该坐标与控制点的Y坐标增减幅一致
	private float ctrX, ctrY;// 控制点的xy坐标
	private boolean isInc;// 判断控制点是该右移还是左移

	public WaveView(Context context, @Nullable AttributeSet attrs) {
		super(context, attrs);
		//实例化画笔并设置参数
		mPaint = new Paint(Paint.ANTI_ALIAS_FLAG | Paint.DITHER_FLAG);
		mPaint.setStyle(Paint.Style.FILL);
		mPaint.setColor(0xffa2d6ae);
		//实例化路径
		mPath = new Path();
	}

	@Override
	protected void onSizeChanged(int w, int h, int oldw, int oldh) {
		super.onSizeChanged(w, h, oldw, oldh);
		//获取控件宽高
		vWidth = w;
		vHeight = h;
		//计算端点Y坐标
		waveY = 1 / 8F * vHeight;
		//计算控制点Y坐标
		ctrY = 3 / 8F * vHeight;
	}

	@Override
	protected void onDraw(Canvas canvas) {
		super.onDraw(canvas);
		/**
		 设置Path起点
		 * 注意我将Path的起点设置在了控件的外部看不到的区域
		 * 如果我们将起点设置在控件左端x=0的位置会使得贝塞尔曲线变得生硬
		 * 至于为什么刚才我已经说了
		 * 所以我们稍微让起点往“外”走点
		 */
		mPath.moveTo(-1 / 4F * vWidth, waveY);
		/**
		 * 以二阶曲线的方式通过控制点连接位于控件右边的终点
		 * 终点的位置也是在控件外部
		 * 我们只需不断让ctrX的大小变化即可实现“浪”的效果
		 */
		mPath.quadTo(ctrX, ctrY, vWidth + 1 / 4F * vWidth, waveY);


		//围绕控件闭合曲线
		mPath.lineTo(vWidth + 1 / 4F * vWidth, vHeight);
		mPath.lineTo(-1 / 4F * vWidth, vHeight);
		mPath.close();
		canvas.drawPath(mPath, mPaint);
		//
		/**
		 * 当控制点的X坐标大于或等于终点X坐标的时候，更改标识值
		 */
		if (ctrX >= vWidth + 1 / 4F * vWidth) {
			isInc = false;
		}
		/**
		 * 当控制点的X坐标大于等于左边X坐标的时候，改变标识值
		 *
		 */
		else if (ctrX <= -1 / 4F * vWidth) {
			isInc = true;
		}


		//根据标识值判断当前的控制点X坐标是该加，还是该减少
		ctrX = isInc ? ctrX + 10 : ctrX - 10;
		/**
		 * 让水不断减少
		 */
		if (waveY<=vHeight) {
			ctrY+=5;
			waveY+=5;
		}


		mPath.reset();
		//重绘
		invalidate();


	}
}

















































