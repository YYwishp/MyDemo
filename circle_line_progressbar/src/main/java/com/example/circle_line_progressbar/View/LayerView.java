package com.example.circle_line_progressbar.View;

import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.util.Log;
import android.view.View;

/**
 * 图层
 * Created by gyx on 2018/1/10.
 */
public class LayerView extends View {
	private  Paint mPaint;
	private int mViewWidth, mViewHeight;// 控件宽高
	public LayerView(Context context, @Nullable AttributeSet attrs) {
		super(context, attrs);

		// 实例化画笔对象，并设置其标识值
		mPaint = new Paint(Paint.ANTI_ALIAS_FLAG | Paint.DITHER_FLAG);
	}

	@Override
	protected void onSizeChanged(int w, int h, int oldw, int oldh) {
		super.onSizeChanged(w, h, oldw, oldh);
		/**
		 * 获取控件宽高
		 */
		mViewWidth = w;
		mViewHeight = h;





	}

	@Override
	protected void onDraw(Canvas canvas) {
		super.onDraw(canvas);
		/*
		*//**
		 *
		 *  绘制一个红色矩形
		 *//*
		mPaint.setColor(Color.RED);
		canvas.drawRect(mViewWidth/2F-200,mViewHeight/2F-200,mViewWidth/2F+200,mViewHeight/2F+200,mPaint);
		*//**
		 * 保存画布并绘制一个蓝色矩形
		 *//*

//		canvas.saveLayer(mViewWidth / 2F - 100, mViewHeight / 2F - 100, mViewWidth / 2F + 100, mViewHeight / 2F + 100, null, Canvas.ALL_SAVE_FLAG);
		canvas.saveLayerAlpha(mViewWidth / 2F - 100, mViewHeight / 2F - 100, mViewWidth / 2F + 100, mViewHeight / 2F + 100, 0x55, Canvas.ALL_SAVE_FLAG);
		// 旋转画布
		canvas.rotate(5);

		mPaint.setColor(Color.BLUE);


		canvas.drawRect(mViewWidth / 2F - 100, mViewHeight / 2F - 100, mViewWidth / 2F + 100, mViewHeight / 2F + 100, mPaint);
		canvas.restore();
		*/




		Log.e("save数量-----", canvas.getSaveCount() + "");
		/**
		 * 保存 并裁剪画布填充黄色
		 */
		@SuppressLint("WrongConstant")
		int saveID1 = canvas.save(Canvas.ALL_SAVE_FLAG);
		Log.e("save数量------", canvas.getSaveCount()+"");
		canvas.clipRect(mViewWidth / 2F - 300, mViewHeight / 2F - 300, mViewWidth / 2F + 300, mViewHeight / 2F + 300);
		canvas.drawColor(Color.YELLOW);
		canvas.restore();
		/**
		 * 保存并填充画布填充绿色
		 */
		@SuppressLint("WrongConstant")
		int saveID2 = canvas.save(Canvas.ALL_SAVE_FLAG);
		Log.e("save数量------", canvas.getSaveCount()+"");
		canvas.clipRect(mViewWidth / 2F - 200, mViewHeight / 2F - 200, mViewWidth / 2F + 200, mViewHeight / 2F + 200);
		canvas.drawColor(Color.GREEN);
		canvas.restore();
		/**
		 * 保存画布，并旋转后绘制一个蓝色的矩形
		 */
		@SuppressLint("WrongConstant")
		int saveID3 = canvas.save(Canvas.ALL_SAVE_FLAG);
		Log.e("save数量-----", canvas.getSaveCount() + "");
		//旋转画布
		canvas.rotate(5);
		mPaint.setColor(Color.BLUE);
		canvas.drawRect(mViewWidth / 2F - 100, mViewHeight / 2F - 100, mViewWidth / 2F + 100, mViewHeight / 2F + 100, mPaint);
		canvas.restore();
		Log.e("save数量-----", canvas.getSaveCount() + "");
		//
		mPaint.setColor(Color.CYAN);
		canvas.drawRect(mViewWidth / 2f, mViewHeight / 2f, mViewWidth / 2f + 400, mViewHeight / 2f + 400, mPaint);


//		canvas.clipRect(mViewWidth / 2F - 300, mViewHeight / 2F + 300, mViewWidth / 2F + 300, mViewHeight / 2F + 300);
//		canvas.clipRect(mViewWidth / 2F - 250, mViewHeight / 2F-200 , mViewWidth / 2F + 250, mViewHeight / 2F + 300);
//
//		canvas.drawColor(Color.YELLOW);

	}
}






























