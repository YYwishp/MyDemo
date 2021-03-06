package com.example.circle_line_progressbar.View;

import android.content.Context;
import android.graphics.BlurMaskFilter;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.view.View;

/**
 *
 * 遮罩滤镜，
 * BlurMaskFilter（4种模式）
 * 1，BlurMaskFilter.Blur.SOLID：边缘
	2，BlurMaskFilter.Blur.NORMAL:整个模糊了
	3，BlurMaskFilter.Blur.INNER:INNER则会在图像内部产生模糊：
 	4，BlurMaskFilter.Blur.OUTER:OUTER会在Alpha边界外产生一层阴影且会将原本的图像变透明
 *
 *
 * Created by gyx on 2018/1/4.
 */
public class MaskFilterView extends View {
	private static final int RECT_SIZE = 800;
	private Paint mPaint;// 画笔
	private Context mContext;// 上下文环境引用

	private int left, top, right, bottom;//

	public MaskFilterView(Context context) {
		this(context, null);
	}

	public MaskFilterView(Context context, AttributeSet attrs) {
		super(context, attrs);
		mContext = context;

		// 初始化画笔
		initPaint();

		// 初始化资源
		initRes(context);

		setLayerType(LAYER_TYPE_SOFTWARE, null);
	}

	/**
	 * 初始化画笔
	 */
	private void initPaint() {
		// 实例化画笔
		mPaint = new Paint(Paint.ANTI_ALIAS_FLAG | Paint.DITHER_FLAG);
		mPaint.setStyle(Paint.Style.FILL);
		mPaint.setColor(0xFF603811);

		// 设置画笔遮罩滤镜
//		BlurMaskFilter.Blur.SOLID：边缘
//		BlurMaskFilter.Blur.NORMAL:整个模糊了
//		BlurMaskFilter.Blur.INNER:INNER则会在图像内部产生模糊：
//		BlurMaskFilter.Blur.OUTER:OUTER会在Alpha边界外产生一层阴影且会将原本的图像变透明

		mPaint.setMaskFilter(new BlurMaskFilter(20, BlurMaskFilter.Blur.INNER));
	}

	/**
	 * 初始化资源
	 */
	private void initRes(Context context) {
        /*
         * 计算位图绘制时左上角的坐标使其位于屏幕中心
         */
//		left = MeasureUtil.getScreenSize((Activity) mContext)[0] / 2 - RECT_SIZE / 2;
//		top = MeasureUtil.getScreenSize((Activity) mContext)[1] / 2 - RECT_SIZE / 2;
//		right = MeasureUtil.getScreenSize((Activity) mContext)[0] / 2 + RECT_SIZE / 2;
//		bottom = MeasureUtil.getScreenSize((Activity) mContext)[1] / 2 + RECT_SIZE / 2;
		left = 100;
		top = 200;
		right = 600;
		bottom = 700;
	}

	@Override
	protected void onDraw(Canvas canvas) {
		super.onDraw(canvas);
		canvas.drawColor(Color.GRAY);

		// 画一个矩形
		canvas.drawRect(left, top, right, bottom, mPaint);
	}
}
































