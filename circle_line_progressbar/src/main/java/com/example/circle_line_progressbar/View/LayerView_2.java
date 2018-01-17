package com.example.circle_line_progressbar.View;

import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.View;

import com.example.circle_line_progressbar.R;

/**
 * Created by gyx on 2018/1/15.
 */
public class LayerView_2 extends View {
	private  Bitmap mBitmap;
	private int mViewWidth, mViewHeight;// 控件宽高
	private Paint mPaint;

	public LayerView_2(Context context, @Nullable AttributeSet attrs) {
		super(context, attrs);
		//从资源中获取位图对象
		mBitmap = BitmapFactory.decodeResource(getResources(), R.drawable.abc);

	}

	@Override
	protected void onSizeChanged(int w, int h, int oldw, int oldh) {
		super.onSizeChanged(w, h, oldw, oldh);
		/**
		 * 获取控件宽高
		 */

		mViewHeight = h;
		mViewWidth = w;
		//缩放位图与控件一致
		mBitmap = Bitmap.createScaledBitmap(mBitmap, mViewWidth, mViewHeight, true);
		mPaint = new Paint(Paint.ANTI_ALIAS_FLAG);
		mPaint.setStyle(Paint.Style.STROKE);
		mPaint.setColor(Color.RED);
		mPaint.setStrokeWidth(5);
	}

	@SuppressLint("WrongConstant")
	@Override
	protected void onDraw(Canvas canvas) {
		super.onDraw(canvas);
		canvas.save(Canvas.MATRIX_SAVE_FLAG);
		canvas.drawRect(0,0,100,100,mPaint);
		//缩放
//		canvas.scale(0.6f, 0.3f,0,0);
		//错切
		canvas.skew(0.0f,1.0f);

//		Matrix matrix = new Matrix();
//		matrix.setScale(0.8f, 0.5f);
////		matrix.postTranslate(100, 100);
//		canvas.setMatrix(matrix);

//		canvas.drawBitmap(mBitmap, 0, 0, null);

		mPaint.setColor(Color.BLUE);
		canvas.drawRect(0,0,100,100,mPaint);
		canvas.skew(0f,1f);
		mPaint.setColor(Color.CYAN);
		canvas.drawRect(0,0,100,100,mPaint);
		canvas.skew(0f,1f);
		mPaint.setColor(Color.GREEN);
		canvas.drawRect(0,0,100,100,mPaint);
		canvas.restore();
	}

	@Override
	protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
		super.onMeasure(widthMeasureSpec, heightMeasureSpec);

	}
}















































