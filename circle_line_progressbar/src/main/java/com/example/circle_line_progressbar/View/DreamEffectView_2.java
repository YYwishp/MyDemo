package com.example.circle_line_progressbar.View;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.ColorMatrixColorFilter;
import android.graphics.Paint;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffXfermode;
import android.graphics.RadialGradient;
import android.graphics.Shader;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.View;
import android.view.WindowManager;

import com.example.circle_line_progressbar.R;

/**
 * Created by gyx on 2018/1/5.
 */
public class DreamEffectView_2 extends View {

	private Bitmap mBitmap;
	private PorterDuffXfermode mXfermode;
	private int x, y;// 位图起点坐标
	private int screenW, screenH;// 屏幕宽高
	private Paint mBitmapPaint;
	private Paint mShaderPaint;

	public DreamEffectView_2(Context context, @Nullable AttributeSet attrs) {

		super(context, attrs);


		// 初始化资源
		initRes(context);

		// 初始化画笔
		initPaint();

	}



	private void initRes(Context context) {


		// 获取位图
		mBitmap = BitmapFactory.decodeResource(getResources(), R.drawable.abc);
		//实例化混合模式
		mXfermode = new PorterDuffXfermode(PorterDuff.Mode.SCREEN);
		WindowManager wm = (WindowManager) context.getSystemService(Context.WINDOW_SERVICE);
		int width = wm.getDefaultDisplay().getWidth();
		int height = wm.getDefaultDisplay().getHeight();
		screenW = width;
		screenH = height;
		x = screenW / 2 - mBitmap.getWidth() / 2;
		y = screenH / 2 - mBitmap.getHeight() / 2;
	}


	private void initPaint() {

		//实例化画笔
		mBitmapPaint = new Paint(Paint.ANTI_ALIAS_FLAG);
		//去饱和，提亮，色相矫正
		ColorMatrixColorFilter colorMatrixColorFilter = new ColorMatrixColorFilter(new float[]{
				0.8587F, 0.2940F, -0.0927F, 0, 6.79F,
				0.0821F, 0.9145F, 0.0634F, 0, 6.79F,
				0.2019F, 0.1097F, 0.7483F, 0, 6.79F,
				0, 0, 0, 1, 0});
		mBitmapPaint.setColorFilter(colorMatrixColorFilter);



		//实例化shader图形画笔
		mShaderPaint = new Paint();
		//设置径向渐变，渐变中心当然是图片的中心也是屏幕中心，渐变半径我们直接那图片的高度但是要稍微小一点
		// 中心颜色为透明而边缘颜色为黑色
		mShaderPaint.setShader(
				new RadialGradient(screenW / 2, screenH / 2, mBitmap.getHeight() * 7 / 8, Color.TRANSPARENT, Color.BLACK, Shader.TileMode.CLAMP));

	}

	@Override
	protected void onDraw(Canvas canvas) {
		super.onDraw(canvas);
		//新建图层
		int saveLayer = canvas.saveLayer(x, y, x + mBitmap.getWidth(), y + mBitmap.getHeight(), null, Canvas.ALL_SAVE_FLAG);

		//绘制混合颜色，
		//canvas.drawColor(0xcc1c093e);
		//设置混合模式
		mBitmapPaint.setXfermode(mXfermode);
		//绘制位图
		canvas.drawBitmap(mBitmap, x, y, mBitmapPaint);
		//还原混合模式
		mBitmapPaint.setXfermode(null);
		//还原画布
		canvas.restoreToCount(saveLayer);
		//绘制一个和图片大小一样的矩形
		canvas.drawRect(x, y, x + mBitmap.getWidth(), y + mBitmap.getHeight(), mShaderPaint);







	}


































}
