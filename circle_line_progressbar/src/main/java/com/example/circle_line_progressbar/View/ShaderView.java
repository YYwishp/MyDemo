package com.example.circle_line_progressbar.View;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.BitmapShader;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.LinearGradient;
import android.graphics.Paint;
import android.graphics.Shader;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.View;

import com.example.circle_line_progressbar.R;

/**
 * Created by gyx on 2018/1/4.
 */
public class ShaderView extends View {

	private static final int RECT_SIZE = 400;// 矩形尺寸的一半
	private int left, top, right, bottom;// 矩形坐上右下坐标
	private Paint mPaint;

	public ShaderView(Context context) {
		super(context);
	}

	public ShaderView(Context context, @Nullable AttributeSet attrs) {
		super(context, attrs);
// 获取屏幕中点坐标
		int screenX = 720 / 2;
		int screenY = 1280 / 2;

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
		mPaint.setShader(new BitmapShader(bitmap, Shader.TileMode.MIRROR, Shader.TileMode.CLAMP));





	}

	public ShaderView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
		super(context, attrs, defStyleAttr);
	}

	@Override
	protected void onDraw(Canvas canvas) {
		super.onDraw(canvas);
		//绘制矩形
		canvas.drawRect(left, top, right, bottom, mPaint);
	}
}
