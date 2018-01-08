package com.example.circle_line_progressbar.View;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.BitmapShader;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Shader;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.View;

import com.example.circle_line_progressbar.R;

/**
 * 图片着色
 * Created by gyx on 2018/1/4.
 */
public class ShaderView_2 extends View {
	private static final int RECT_SIZE = 200;// 矩形尺寸的一半
	private int left, top, right, bottom;// 矩形坐上右下坐标
	private Paint mPaint;
	private int screenX;
	private int screenY;

	public ShaderView_2(Context context) {
		super(context);
	}

	public ShaderView_2(Context context, @Nullable AttributeSet attrs) {
		super(context, attrs);
// 获取屏幕中点坐标
		screenX = 720 / 2;
		screenY = 1280 / 2;
// 计算矩形左上右下坐标值
		left = screenX - RECT_SIZE;
		top = screenY - RECT_SIZE;
		right = screenX + RECT_SIZE;
		bottom = screenY + RECT_SIZE;
		//实例化画笔
		mPaint = new Paint(Paint.ANTI_ALIAS_FLAG | Paint.DITHER_FLAG);
		//获取位图
		Bitmap bitmap = BitmapFactory.decodeResource(getResources(), R.drawable.abc);
		//设置着色器
		BitmapShader bitmapShader = new BitmapShader(bitmap, Shader.TileMode.CLAMP, Shader.TileMode.CLAMP);
		//实例一个矩阵对象
		Matrix matrix = new Matrix();
		//设置变换矩阵，类似改变起点坐标
		matrix.setTranslate(left, top);
		bitmapShader.setLocalMatrix(matrix);
		//设置着色器
		mPaint.setShader(bitmapShader);
	}

	public ShaderView_2(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
		super(context, attrs, defStyleAttr);
	}

	@Override
	protected void onDraw(Canvas canvas) {
		super.onDraw(canvas);
		//绘制矩形
//		canvas.drawRect(left, top, right, bottom, mPaint);
		canvas.drawRect(left, top, screenX * 2, screenY * 2, mPaint);
//		canvas.drawRect(0, 0, screenX * 2, screenY * 2, mPaint);
	}
}
