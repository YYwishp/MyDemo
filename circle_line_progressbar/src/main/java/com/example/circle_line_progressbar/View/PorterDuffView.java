package com.example.circle_line_progressbar.View;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffXfermode;
import android.util.AttributeSet;
import android.view.View;

import com.example.circle_line_progressbar.R;

/**
 *
 * 图像混合
 * 比较复杂
 * Created by gyx on 2017/12/28.
 */
public class PorterDuffView extends View {
	private Paint mPaint;// 画笔
	private Bitmap bitmapSrc;// 位图
	private PorterDuffXfermode porterDuffXfermode;// 图形混合模式

	private int x, y;// 位图绘制时左上角的起点坐标
	private int screenW, screenH;// 屏幕尺寸

	public PorterDuffView(Context context) {
		this(context, null);
	}

	public PorterDuffView(Context context, AttributeSet attrs) {
		super(context, attrs);

		// 实例化混合模式
		porterDuffXfermode = new PorterDuffXfermode(PorterDuff.Mode.SCREEN);

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
		mPaint = new Paint(Paint.ANTI_ALIAS_FLAG);
	}

	/**
	 * 初始化资源
	 */
	private void initRes(Context context) {
		// 获取位图
		bitmapSrc = BitmapFactory.decodeResource(context.getResources(), R.drawable.abc);

		// 获取包含屏幕尺寸的数组
		int[] screenSize = {720, 1280};

		// 获取屏幕尺寸
		screenW = screenSize[0];
		screenH = screenSize[1];

        /*
         * 计算位图绘制时左上角的坐标使其位于屏幕中心
         * 屏幕坐标x轴向左偏移位图一半的宽度
         * 屏幕坐标y轴向上偏移位图一半的高度
         */
		x = screenW / 2 - bitmapSrc.getWidth() / 2;
		y = screenH / 2 - bitmapSrc.getHeight() / 2;

	}

	@Override
	protected void onDraw(Canvas canvas) {
		super.onDraw(canvas);
		canvas.drawColor(Color.YELLOW);

        /*
         * 将绘制操作保存到新的图层（更官方的说法应该是离屏缓存）我们将在1/3中学习到Canvas的全部用法这里就先follow me
         */
		int sc = canvas.saveLayer(0, 0, screenW, screenH, null, Canvas.ALL_SAVE_FLAG);

		// 先绘制一层带透明度的颜色
//		canvas.drawColor(0xaaff00ff);
		Paint paint = new Paint();

		paint.setColor(0xffff00ff);
		canvas.drawRect(x+150,y-100,x+bitmapSrc.getWidth()+50,y+bitmapSrc.getHeight()+100,paint);

//		// 设置混合模式
		mPaint.setXfermode(porterDuffXfermode);
//
//		// 再绘制src源图
		canvas.drawBitmap(bitmapSrc, x, y, mPaint);

		// 还原混合模式
		mPaint.setXfermode(null);

		// 还原画布
		canvas.restoreToCount(sc);
	}
}























