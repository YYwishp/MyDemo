package com.example.circle_line_progressbar.View;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Path;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.View;

/**
 * 贝塞尔曲线
 * Created by gyx on 2018/1/9.
 */
public class BezierView extends View {


	private Path mPath;
	private Paint mPaint;

	public BezierView(Context context, @Nullable AttributeSet attrs) {

		super(context, attrs);



/**
 * 实例化画笔
 */
		mPaint = new Paint(Paint.ANTI_ALIAS_FLAG | Paint.DITHER_FLAG);
		mPaint.setStyle(Paint.Style.STROKE);
		mPaint.setColor(Color.CYAN);
		mPaint.setStrokeWidth(5);
		//实例化路径
		mPath = new Path();
		//移动到（100，100）
		mPath.moveTo(100,100);
		//连接路径到点
		/*二阶贝塞尔：quadTo的前两个参数为控制点的坐标，后两个参数为终点坐标
		mPath.quadTo(200, 200, 300, 100);*/


		//三阶贝塞尔：cubicTo前四个参数表示两个控制点，最后两个参数表示终点
		mPath.cubicTo(200, 200, 300, 0, 400, 100);




	}

	@Override
	protected void onDraw(Canvas canvas) {
		super.onDraw(canvas);
		//画出路径
		canvas.drawPath(mPath, mPaint);
	}
}
