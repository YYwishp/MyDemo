package com.example.circle_line_progressbar.View;

import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Matrix;
import android.graphics.PointF;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.WindowManager;
import android.widget.ImageView;

import com.example.circle_line_progressbar.R;

/**
 * Created by GYX on 2018/1/8.
 */
@SuppressLint("AppCompatCustomView")
public class MatrixImageView extends ImageView {
	private static final int MODE_NONE = 0x00123;// 默认的触摸模式
	private static final int MODE_DRAG = 0x00321;// 拖拽模式
	private static final int MODE_ZOOM = 0x00132;// 缩放or旋转模式
	private Matrix currentMatrix;
	private Matrix saveMatrix;
	private PointF start;// 起点
	private PointF mid;//中点
	private int mode;
	private float[] preEventCoor;// 上一次各触摸点的坐标集合
	private float preMove = 1F;// 上一次手指移动的距离
	private float saveRotate = 0F;// 保存了的角度值
	private float rotate;
	
	public MatrixImageView(Context context, @Nullable AttributeSet attrs) {
		super(context, attrs);
		//初始化
		init(context);
	}
	
	/**
	 * 初始化
	 *
	 * @param context
	 */
	private void init(Context context) {
		//初始化对象
		currentMatrix = new Matrix();
		saveMatrix = new Matrix();
		start = new PointF();
		mid = new PointF();
		//初始化模式
		mode = MODE_NONE;
		//设置图片资源
		Bitmap bitmap = BitmapFactory.decodeResource(getResources(), R.drawable.abc);
		WindowManager wm = (WindowManager) context.getSystemService(Context.WINDOW_SERVICE);
		int width = wm.getDefaultDisplay().getWidth();
		int height = wm.getDefaultDisplay().getHeight();
		bitmap = Bitmap.createScaledBitmap(bitmap, width, height, true);
		setImageBitmap(bitmap);
	}
	
	@Override
	public boolean onTouchEvent(MotionEvent event) {
		switch (event.getAction() & MotionEvent.ACTION_MASK) {
			//单点触摸时
			case MotionEvent.ACTION_DOWN:
				saveMatrix.set(currentMatrix);
				start.set(event.getX(), event.getY());
				mode = MODE_DRAG;//触摸模设
				preEventCoor = null;
				break;
			//第二个点触摸屏幕的时候
			case MotionEvent.ACTION_POINTER_DOWN:
				preMove = calSpacing(event);//计算两点之间距离
				if (preMove>10f) {
					saveMatrix.set(currentMatrix);
					calMidPoint(mid, event);
					mode = MODE_ZOOM;//缩放or旋转模式
				}
				preEventCoor = new float[4];
				preEventCoor[0] = event.getX(0);
				preEventCoor[1] = event.getX(1);
				preEventCoor[2] = event.getY(0);
				preEventCoor[3] = event.getY(1);
				saveRotate  = calRotation(event);
				break;
			//单点离开屏幕的时候
			case MotionEvent.ACTION_UP:
			
			//第二个点离开屏幕的时候
			case MotionEvent.ACTION_POINTER_UP:
				mode = MODE_NONE;
				preEventCoor = null;
				break;
			//触摸移动的时候
			case MotionEvent.ACTION_MOVE:
				/**
				 * 单点触控拖拽平移
				 */
				if (mode== MODE_DRAG) {
					currentMatrix.set(saveMatrix);
					float dx = event.getX() - start.x;
					float dy = event.getY() - start.y;
					currentMatrix.setTranslate(dx, dy);
					
				}
				/**
				 * 两点触控拖放旋转
				 */
				else if (mode == MODE_ZOOM && event.getPointerCount() == 2) {
					float currentMove = calSpacing(event);
					currentMatrix.set(saveMatrix);
					/**
					 * 指尖移动的距离大于10F就缩放
					 */
					if (currentMove>10F) {
						float scale = currentMove / preMove;
						//设置缩放，前两个是起始坐标，后两个是中点坐标
						currentMatrix.postScale(scale, scale, mid.x, mid.y);
					}
					/**
					 * 保持两点旋转
					 */
					if (preEventCoor != null) {
						rotate = calRotation(event);
						float r = rotate - saveRotate;
						currentMatrix.postRotate(r, getMeasuredWidth() / 2, getMeasuredHeight() / 2);
					}
				}
				
				
				
				
				break;
		}
		setImageMatrix(currentMatrix);
		return true;
	}
	
	/**
	 * 计算两个触摸点间的距离
	 */
	private float calSpacing(MotionEvent event) {
		float x = event.getX(0) - event.getX(1);
		float y = event.getY(0) - event.getY(1);
		return (float) Math.sqrt(x * x + y * y);
	}
	/**
	 * 计算两个触摸点的中点坐标
	 */
	private void calMidPoint(PointF point, MotionEvent event) {
		float x = event.getX(0) + event.getX(1);
		float y = event.getY(0) + event.getY(1);
		point.set(x / 2, y / 2);
	}
	/**
	 * 计算旋转角度
	 *
	 * @param  event 事件对象
	 * @return 角度值
	 */
	private float calRotation(MotionEvent event) {
		double deltaX = (event.getX(0) - event.getX(1));
		double deltaY = (event.getY(0) - event.getY(1));
		double radius = Math.atan2(deltaY, deltaX);
		return (float) Math.toDegrees(radius);
	}
}



















































































