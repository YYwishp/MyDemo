package com.example.circle_line_progressbar.View;

import android.content.Context;
import android.content.SharedPreferences;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.BitmapShader;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.LinearGradient;
import android.graphics.Paint;
import android.graphics.RadialGradient;
import android.graphics.Shader;
import android.graphics.SweepGradient;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.View;

import com.example.circle_line_progressbar.R;

/**
 *
 * 颜色渐变，三种模式，都是画笔的设置
 * LinearGradient
 * SweepGradient
 * RadialGradient
 *
 *
 * Created by gyx on 2018/1/4.
 */
public class LinearShaderView extends View {


	private static final int RECT_SIZE = 300;// 矩形尺寸的一半
	private int left, top, right, bottom;// 矩形坐上右下坐标
	private Paint mPaint;

	public LinearShaderView(Context context) {
		super(context);
	}

	public LinearShaderView(Context context, @Nullable AttributeSet attrs) {
		super(context, attrs);




		// 获取屏幕中点坐标
		int screenX = 720 / 2;
		int screenY = 1280 / 2;

// 计算矩形左上右下坐标值
		left = screenX - RECT_SIZE;
		top = screenY - 500;
		right = screenX + RECT_SIZE;
		bottom = screenY + RECT_SIZE;
		//实例化画笔
		mPaint = new Paint(Paint.ANTI_ALIAS_FLAG | Paint.DITHER_FLAG);
		//获取位
//		Bitmap bitmap = BitmapFactory.decodeResource(getResources(), R.drawable.abc);

		//设置着色器
//		mPaint.setShader(new LinearGradient(left,top,left+100,top+100, Color.RED,Color.YELLOW,Shader.TileMode.REPEAT));
		/*多种颜色设置
		int[] colors = {Color.RED, Color.YELLOW, Color.GREEN, Color.CYAN, Color.BLUE};
		float[] positions = {0f, 0.2F, 0.4F, 0.6F, 0.8F};
		mPaint.setShader(new LinearGradient(left,top+300,left+300,top+300, colors, positions,Shader.TileMode.REPEAT));*/
		/*梯度渐变，类似雷达扫描
		mPaint.setShader(new SweepGradient(360,360,Color.GREEN,Color.YELLOW));*/
//		梯度渐变,多种颜色
//		mPaint.setShader(new SweepGradient(360, 500, new int[]{Color.RED, Color.GREEN, Color.BLUE}, null));


//		径向渐变，径向渐变说的简单点就是个圆形中心向四周渐变的效果
//		mPaint.setShader(new RadialGradient(360, 500, 200, Color.RED, Color.YELLOW, Shader.TileMode.REPEAT));
//		//多色彩径向，渐变
		mPaint.setShader(new RadialGradient(360, 500, 200,
				new int[]{Color.RED, Color.YELLOW, Color.GREEN, Color.CYAN, Color.BLUE},
				new float[]{0f, 0.2F, 0.4F, 0.6F, 0.8F},
				Shader.TileMode.REPEAT));





	}

	public LinearShaderView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
		super(context, attrs, defStyleAttr);
	}

	@Override
	protected void onDraw(Canvas canvas) {
		super.onDraw(canvas);
		//绘制矩形
		canvas.drawRect(left, top, right, bottom, mPaint);
		mPaint.setTextSize(50);
		canvas.drawText("dfdfsdfsdfdfsdfsdff", 100, 140, mPaint);

	}
}
