package com.example.circle_line_progressbar.View;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.LightingColorFilter;
import android.graphics.Paint;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffColorFilter;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.View;

import com.example.circle_line_progressbar.R;

/**
 * Created by gyx on 2017/12/28.
 */
public class CustomView_3 extends View {

	private Paint mPaint;// 画笔


	private boolean isClick;// 用来标识控件是否被点击过

	public CustomView_3(Context context) {
		super(context);
	}

	public CustomView_3(Context context, @Nullable AttributeSet attrs) {
		super(context, attrs);


		// 初始化画笔
		initPaint();
		//初始化资源
		initRes(context);

		setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {

/*
                 * 判断控件是否被点击过
                 */
				if (isClick) {
					// 如果已经被点击了则点击时设置颜色过滤为空还原本色
					mPaint.setColorFilter(new PorterDuffColorFilter(Color.YELLOW, PorterDuff.Mode.DARKEN));
					isClick = false;
				} else {
					// 如果未被点击则点击时设置颜色过滤后为黄色
					mPaint.setColorFilter(new PorterDuffColorFilter(Color.BLUE, PorterDuff.Mode.DARKEN));
					isClick = true;
				}

				// 记得重绘
				invalidate();


			}
		});





	}



	public CustomView_3(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
		super(context, attrs, defStyleAttr);
	}








	/**
	 * 初始化画笔
	 */
	private void initPaint() {
		// 实例化画笔并打开抗锯齿
		mPaint = new Paint(Paint.ANTI_ALIAS_FLAG);

        /*
         * 设置画笔样式为描边，圆环嘛……当然不能填充不然就么意思了
         *
         * 画笔样式分三种：
         * 1.Paint.Style.STROKE：描边
         * 2.Paint.Style.FILL_AND_STROKE：描边并填充
         * 3.Paint.Style.FILL：填充
         */
//		mPaint.setStyle(Paint.Style.FILL);
//
//		// 设置画笔颜色为自定义颜色
//		 mPaint.setColor(Color.argb(255, 255, 128, 103));
//		// 生成色彩矩阵
//		ColorMatrix colorMatrix = new ColorMatrix(new float[]{
//				1.438F, -0.122F, -0.016F, 0, -0.03F,
//				-0.062F, 1.378F, -0.016F, 0, 0.05F,
//				-0.062F, -0.122F, 1.483F, 0, -0.02F,
//				0, 0, 0, 1, 0,
//		});
//		mPaint.setColorFilter(new ColorMatrixColorFilter(colorMatrix));



		// 设置颜色过滤,这个构造方法也接受两个值，一个是16进制表示的颜色值这个很好理解，而另一个是PorterDuff内部类Mode中的一个常量值，
		// 这个值表示混合模式。那么什么是混合模式呢？混合混合必定是有两种东西混才行，第一种就是我们设置的color值而第二种当然就是我们画布上的元素了！，
		// 比如这里我们把Color的值设为红色，而模式设为PorterDuff.Mode.DARKEN变暗
		mPaint.setColorFilter(new PorterDuffColorFilter(Color.RED, PorterDuff.Mode.DARKEN));
//
//        /*
//         * 设置描边的粗细，单位：像素px 注意：当setStrokeWidth(0)的时候描边宽度并不为0而是只占一个像素
//         */
//		mPaint.setStrokeWidth(10);
	}


	private Bitmap bitmap;// 位图
	private void initRes(Context context) {
		// 获取位图
		bitmap = BitmapFactory.decodeResource(context.getResources(), R.drawable.abc);
	}
	@Override
	protected void onDraw(Canvas canvas) {
		super.onDraw(canvas);

		// 绘制圆形
//		canvas.drawCircle(350, 640, 200, mPaint);
		// 绘制位图
		canvas.drawBitmap(bitmap, 100, 0, mPaint);
	}
}


















































