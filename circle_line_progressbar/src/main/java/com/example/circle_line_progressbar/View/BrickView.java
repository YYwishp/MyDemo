package com.example.circle_line_progressbar.View;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.BitmapShader;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Shader;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;

import com.example.circle_line_progressbar.R;

/**
 * Created by gyx on 2018/1/4.
 */
public class BrickView extends View {
	private Paint mStrokepaint;
	private Paint mFillPaint;
	private BitmapShader mBitmapShader;
	private float posX;
	private float posY;
	private Bitmap mBitmap;

	public BrickView(Context context) {
		super(context);
	}

	public BrickView(Context context, @Nullable AttributeSet attrs) {
		super(context, attrs);


		//初始化画笔
		initPaint();

	}

	private void initPaint() {
		/**
		 * 实例化描边画笔并设置参数
		 *
		 */
		mStrokepaint = new Paint(Paint.ANTI_ALIAS_FLAG | Paint.DITHER_FLAG);
		mStrokepaint.setColor(0xff000000);
		mStrokepaint.setStyle(Paint.Style.STROKE);
		mStrokepaint.setStrokeWidth(5);
		/**
		 * 实例化填充画笔
		 */
		mFillPaint = new Paint();
		/**
		 * 生成BitmapShader
		 *
		 */
		mBitmap = BitmapFactory.decodeResource(getResources(), R.drawable.abc);
		mBitmapShader = new BitmapShader(mBitmap, Shader.TileMode.REPEAT, Shader.TileMode.REPEAT);
		mFillPaint.setShader(mBitmapShader);

	}

	public BrickView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
		super(context, attrs, defStyleAttr);
	}

	@Override
	public boolean onTouchEvent(MotionEvent event) {
		/**
		 * 手指移动时获取触摸点坐标，并刷新视图
		 */
		if (event.getAction()== MotionEvent.ACTION_MOVE) {
			posX = event.getX();
			posY = event.getY();
			invalidate();
		}


		return true;
	}

	@Override
	protected void onDraw(Canvas canvas) {
		super.onDraw(canvas);
		//设置画笔背景颜色
		canvas.drawColor(Color.DKGRAY);
		/**
		 * 绘制圆和描边
		 */

		canvas.drawCircle(posX, posY, 100, mFillPaint);
		canvas.drawCircle(posX, posY, 100, mStrokepaint);

	}
}

































