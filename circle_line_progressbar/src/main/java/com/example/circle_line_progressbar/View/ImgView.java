package com.example.circle_line_progressbar.View;

import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.View;
import android.widget.ImageView;

import com.example.circle_line_progressbar.R;

/**
 * Created by gyx on 2018/1/17.
 */
public class ImgView extends View {
	private  Bitmap mBitmap;
	private Paint mPaint;// 画笔
	public ImgView(Context context, @Nullable AttributeSet attrs) {
		super(context, attrs);
		mBitmap = BitmapFactory.decodeResource(getResources(), R.drawable.abc);
// 实例化画笔并打开抗锯齿
		mPaint = new Paint(Paint.ANTI_ALIAS_FLAG);
	}

	@Override
	protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
		super.onMeasure(widthMeasureSpec, heightMeasureSpec);

		//声明一个临时变量来存储计算出的测量值
		int resultWidth = 0;
		//获取宽度测量规格中的mode
		int modeWidth = MeasureSpec.getMode(widthMeasureSpec);
		//获取宽度测量规格中的size
		int sizeWidth = MeasureSpec.getSize(widthMeasureSpec);
		/**
		 * 如果爹心里有数
		 */
		if (modeWidth == MeasureSpec.EXACTLY) {
			//那么儿子也不要让爹为难，就取爹给的大小吧
			resultWidth = sizeWidth;
		}
		/**
		 * 如果爹心里没数
		 */
		else {
			//那么儿子可是要自己看看自己需要多大了
			resultWidth = mBitmap.getWidth()+getPaddingLeft()+getPaddingRight();
			/**
			 * 如果爹给儿子的是一个限制值
			 */
			if (modeWidth == MeasureSpec.AT_MOST) {
				//那么儿子自己的需求就要跟爹的限制比比看谁最小
				resultWidth = Math.min(resultWidth, sizeWidth);
			}
		}



		int resultHeight = 0;
		int modeHeight = MeasureSpec.getMode(heightMeasureSpec);
		int sizeHeight = MeasureSpec.getSize(heightMeasureSpec);

		if (modeHeight == MeasureSpec.EXACTLY) {
			resultHeight = sizeHeight;
		} else {
			resultHeight = mBitmap.getHeight()+getPaddingTop()+getPaddingBottom();
			if (modeHeight == MeasureSpec.AT_MOST) {
				resultHeight = Math.min(resultHeight, sizeHeight);
			}
		}

		//设置测量尺寸
		setMeasuredDimension(resultWidth, resultHeight);




	}

	@Override
	protected void onDraw(Canvas canvas) {
		super.onDraw(canvas);
		canvas.drawBitmap(mBitmap, getPaddingLeft(), getPaddingTop(), mPaint);
	}
}































