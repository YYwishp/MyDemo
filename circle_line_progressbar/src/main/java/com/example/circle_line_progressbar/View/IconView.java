package com.example.circle_line_progressbar.View;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Typeface;
import android.provider.MediaStore;
import android.support.annotation.Nullable;
import android.text.TextPaint;
import android.util.AttributeSet;
import android.view.View;
import android.view.WindowManager;

import com.example.circle_line_progressbar.R;

/**
 * 自定义图标
 * Created by gyx on 2018/1/17.
 */
public class IconView extends View {
	private float mTextSize;// 画笔的文本尺寸
	private Bitmap mBitmap;// 位图
	private String mStr;// 绘制的文本
	private TextPaint mPaint;

	/**
	 * 宽高枚举类
	 */
	private enum Ratio {
		WIDTH, HEIGHT
	}

	public IconView(Context context, @Nullable AttributeSet attrs) {
		super(context, attrs);
		//计算参数
		calArgs(context);
		//初始化
		init();
	}

	/**
	 * 计算参数
	 *
	 * @param context
	 */
	private void calArgs(Context context) {
		//获取屏幕
		WindowManager wm = (WindowManager) context.getSystemService(Context.WINDOW_SERVICE);
		int width = wm.getDefaultDisplay().getWidth();
		int height = wm.getDefaultDisplay().getHeight();
		//计算文本尺寸
		mTextSize = width / 15F;
	}

	/**
	 * 初始化
	 */
	private void init() {
		/**
		 * 获取Bitmap
		 */
		if (null == mBitmap) {
			mBitmap = BitmapFactory.decodeResource(getResources(), R.drawable.ic_launcher);
		}
		/**
		 * 为mStr赋值
		 */
		if (null == mStr || mStr.length() == 0) {
			mStr = "MacBookPro";
		}
		/**
		 * 初始化画笔，并设置参数
		 */
		mPaint = new TextPaint(Paint.ANTI_ALIAS_FLAG | Paint.DITHER_FLAG | Paint.LINEAR_TEXT_FLAG);
		mPaint.setColor(Color.LTGRAY);
		mPaint.setTextSize(mTextSize);
		mPaint.setTextAlign(Paint.Align.CENTER);
		mPaint.setTypeface(Typeface.DEFAULT_BOLD);
	}

	@Override
	protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
		// 设置测量后的尺寸
		setMeasuredDimension(getMeasureSize(widthMeasureSpec, Ratio.WIDTH), getMeasureSize(heightMeasureSpec, Ratio.HEIGHT));
	}

	/**
	 * 获取测量后的尺寸
	 *
	 * @param measureSpec 测量规格
	 * @param ratio       宽高标识
	 * @return 宽或高的测量值
	 */
	private int getMeasureSize(int measureSpec, Ratio ratio) {
		// 声明临时变量保存测量值
		int result = 0;
		/**
		 * 获取mode和size
		 */
		int mode = MeasureSpec.getMode(measureSpec);
		int size = MeasureSpec.getSize(measureSpec);
		/**
		 * 判断mode的具体值
		 */
		switch (mode) {
			//EXACTLY时直接赋值
			case MeasureSpec.EXACTLY:
				result = size;
				break;
			//默认情况下将UNSPECIFIED和AT_MOST一并处理
			default:
				if (ratio == Ratio.WIDTH) {
					float textWidth = mPaint.measureText(mStr);
					result = ((int) (textWidth >= mBitmap.getWidth() ? textWidth : mBitmap.getWidth())) + getPaddingLeft() + getPaddingRight();
				} else if (ratio == Ratio.HEIGHT) {
					result = (int) (((mPaint.descent() - mPaint.ascent())*2+mBitmap.getHeight())+ getPaddingTop() + getPaddingBottom());
				}
				/**
				 * AT_MOST时，判断size和result的大小取最小值
				 */
				if (mode == MeasureSpec.AT_MOST) {
					result = Math.min(result, size);
				}




				break;
		}
		return result;
	}

	@Override
	protected void onDraw(Canvas canvas) {
		/**
		 * 绘制
		 * 参数就不做单独处理了，因为只会draw一次不会频繁调用
		 */
		canvas.drawBitmap(mBitmap, getWidth() / 2 - mBitmap.getWidth() / 2, getHeight() / 2 - mBitmap.getHeight() / 2, null);
//		canvas.drawText(mStr, getWidth() / 2, mBitmap.getHeight() + getHeight() / 2 - mBitmap.getHeight() / 2 - mPaint.ascent(), mPaint);
		canvas.drawText(mStr, getWidth()/2, getHeight() / 2+mBitmap.getHeight()/2-mPaint.ascent(), mPaint);






	}
}































































































































