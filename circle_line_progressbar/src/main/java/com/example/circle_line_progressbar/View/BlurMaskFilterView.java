package com.example.circle_line_progressbar.View;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.BlurMaskFilter;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.view.View;

import com.example.circle_line_progressbar.R;

/**
 * Created by gyx on 2018/1/4.
 */
public class BlurMaskFilterView extends View {
	private Paint shadowPaint;// 画笔
	private Context mContext;// 上下文环境引用
	private Bitmap srcBitmap, shadowBitmap;// 位图和阴影位图

	private int x, y;// 位图绘制时左上角的起点坐标

	public BlurMaskFilterView(Context context) {
		this(context, null);
	}

	public BlurMaskFilterView(Context context, AttributeSet attrs) {
		super(context, attrs);
		mContext = context;
		// 记得设置模式为SOFTWARE
		setLayerType(LAYER_TYPE_SOFTWARE, null);

		// 初始化画笔
		initPaint();

		// 初始化资源
		initRes(context);
	}

	/**
	 * 初始化画笔
	 */
	private void initPaint() {
		// 实例化画笔
		shadowPaint = new Paint(Paint.ANTI_ALIAS_FLAG | Paint.DITHER_FLAG);
		shadowPaint.setColor(Color.DKGRAY);
		shadowPaint.setMaskFilter(new BlurMaskFilter(10, BlurMaskFilter.Blur.NORMAL));
	}

	/**
	 * 初始化资源
	 */
	private void initRes(Context context) {
		// 获取位图
		srcBitmap = BitmapFactory.decodeResource(context.getResources(), R.drawable.abc);

		// 获取位图的Alpha通道图
		shadowBitmap = srcBitmap.extractAlpha();

        /*
         * 计算位图绘制时左上角的坐标使其位于屏幕中心
         */
		x = 100;
		y =400;
	}

	@Override
	protected void onDraw(Canvas canvas) {
		super.onDraw(canvas);
		// 先绘制阴影
		canvas.drawBitmap(shadowBitmap, x, y, shadowPaint);

		// 再绘制位图
		canvas.drawBitmap(srcBitmap, x, y, null);
	}


}
