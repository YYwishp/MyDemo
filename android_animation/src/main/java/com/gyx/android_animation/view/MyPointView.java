package com.gyx.android_animation.view;

import android.animation.PointFEvaluator;
import android.animation.ValueAnimator;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.View;
import android.view.animation.BounceInterpolator;

import com.gyx.android_animation.evalutor.PointEvaluator;

/**
 * Created by gyx on 2018/2/26.
 */
public class MyPointView extends View {
	private Paint mPaint;
	private MyPoint currentPoint;

	public MyPointView(Context context) {
		super(context);
	}

	public MyPointView(Context context, @Nullable AttributeSet attrs) {
		super(context, attrs);
		mPaint = new Paint();
		mPaint.setColor(Color.RED);
		mPaint.setStyle(Paint.Style.FILL);
		mPaint.setAntiAlias(true);
		mPaint.setDither(true);


	}

	@Override
	protected void onDraw(Canvas canvas) {
		super.onDraw(canvas);
		if (currentPoint!=null) {

		canvas.drawCircle(300, 300, currentPoint.getRadius(), mPaint);
		}



	}

	public void doPointAnim() {
		ValueAnimator valueAnimator = ValueAnimator.ofObject(new PointEvaluator(), new MyPoint(30), new MyPoint(300));
		valueAnimator.setDuration(1000);
		valueAnimator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {


			@Override
			public void onAnimationUpdate(ValueAnimator animation) {
				currentPoint = (MyPoint) animation.getAnimatedValue();
				//重绘
				invalidate();
			}
		});
		valueAnimator.setInterpolator(new BounceInterpolator());

		valueAnimator.start();
	}
}


































