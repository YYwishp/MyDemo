package com.example.circle_line_progressbar.View;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.ComposePathEffect;
import android.graphics.CornerPathEffect;
import android.graphics.DashPathEffect;
import android.graphics.DiscretePathEffect;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.PathDashPathEffect;
import android.graphics.PathEffect;
import android.graphics.SumPathEffect;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.View;

/**
 *
 *
 * 路径效果
 * //弯曲角度型 :CornerPathEffect
 *
 * //离散路径效果 :DiscretePathEffect
 *
 * 	//虚线的路径效果:DashPathEffect
 *
 * 	//增强的虚线路径效果:PathDashPathEffect
 *
 *  //组合路径效果:ComposePathEffect,SumPathEffect
 *
 *
 *
 *
 * Created by gyx on 2018/1/4.
 */
public class PathEffectView extends View {
	private Paint mPaint;
	private Path mPath;
	private PathEffect[] mEffects;

	private float mPhase;// 偏移值
	public PathEffectView(Context context) {
		super(context);
	}

	public PathEffectView(Context context, @Nullable AttributeSet attrs) {
		super(context, attrs);
		mPaint = new Paint();
		mPaint.setStyle(Paint.Style.STROKE);
		mPaint.setStrokeWidth(5);
		mPaint.setColor(Color.RED);
		//
		mPath = new Path();
		//定义起始起点
		mPath.moveTo(0, 0);
		//定义路径的各个点
		for (int i = 0; i < 30; i++) {
			mPath.lineTo(i * 45, (float) (Math.random() * 100));

		}
		//创建路径效果的数组
		mEffects = new PathEffect[7];
	}

	public PathEffectView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
		super(context, attrs, defStyleAttr);
	}

	@Override
	protected void onDraw(Canvas canvas) {
		super.onDraw(canvas);
		/**
		 * 实例化个特效类
		 *
		 */

		mEffects[0] = null;
		//弯曲角度型
		mEffects[1] = new CornerPathEffect(1);
		//离散路径效果
		mEffects[2] = new DiscretePathEffect(3.0f, 20.0f);
		//虚线的路径效果
		mEffects[3] = new DashPathEffect(new float[]{20,10,},mPhase);
		//增强的虚线路径效果
		Path path = new Path();
		path.addCircle(0, 0, 8,  Path.Direction.CCW);
		//advance:间距
		mEffects[4] = new PathDashPathEffect(path, 32, mPhase, PathDashPathEffect.Style.TRANSLATE);
		//组合路径效果
		mEffects[5] = new ComposePathEffect(mEffects[2], mEffects[4]);
		mEffects[6] = new SumPathEffect(mEffects[3], mEffects[4]);
		/**
		 * 绘制路径
		 */
		for (int i = 0; i < mEffects.length; i++) {
			mPaint.setPathEffect(mEffects[i]);
			canvas.drawPath(mPath, mPaint);
			//每绘制一条将画布向下平移250个像素
			canvas.translate(0, 150);
		}
		//刷新偏移值并重绘视图实现动画效果
		mPhase+=1;
		invalidate();

	}
}





























