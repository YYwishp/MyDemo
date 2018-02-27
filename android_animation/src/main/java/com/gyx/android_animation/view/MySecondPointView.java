package com.gyx.android_animation.view;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.View;

/**
 * Created by gyx on 2018/2/27.
 */
public class MySecondPointView extends View {
	private  Paint mPaint;
	private MyPoint currentPoint = new MyPoint(10);
	public MySecondPointView(Context context, @Nullable AttributeSet attrs) {

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


	public void setPointRadius(int radius) {
		currentPoint.setRadius(radius);
		invalidate();

	}
}
