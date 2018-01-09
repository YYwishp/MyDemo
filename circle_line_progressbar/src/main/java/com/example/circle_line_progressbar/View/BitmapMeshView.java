package com.example.circle_line_progressbar.View;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.View;

import com.example.circle_line_progressbar.R;

/**
 * Created by gyx on 2018/1/9.
 */
public class BitmapMeshView extends View {
	private  Bitmap mBitmap;
	private static final int WIDTH = 19;// 横向分割成的网格数量
	private static final int HEIGHT = 19;// 纵向分割成的网格数量
	private static final int COUNT = (WIDTH + 1) * (HEIGHT + 1);// 横纵向网格交织产生的点数量
	private float[] verts;// 交点的坐标数组
	public BitmapMeshView(Context context, @Nullable AttributeSet attrs) {

		super(context, attrs);
		//获取位图资源
		mBitmap = BitmapFactory.decodeResource(getResources(), R.drawable.abc);
		//实例化数组
		verts = new float[COUNT * 2];
		/**
		 * 生成各个焦点坐标
		 */
		int index = 0;
		float multiple = mBitmap.getWidth();
		for (int y = 0; y <= HEIGHT; y++) {
			int fy = mBitmap.getHeight() * y / HEIGHT;
			for (int x = 0; x <= WIDTH; x++) {
				//Y轴往右平移
//				float fx = mBitmap.getWidth() * x / WIDTH + ((HEIGHT - y) * 1.0F / HEIGHT * multiple);
				//Y轴不平移，图片不会变化
				float fx = mBitmap.getWidth() * x / WIDTH;
				setXY(fx, fy, index);
				index+=1;
			}
		}
	}


	/**
	 * 将计算后的交点坐标存入数组
	 *
	 * @param fx
	 *            x坐标
	 * @param fy
	 *            y坐标
	 * @param index
	 *            标识值
	 */
	private void setXY(float fx, float fy, int index) {
		verts[index * 2 + 0] = fx;
		verts[index * 2 + 1] = fy;
	}

	@Override
	protected void onDraw(Canvas canvas) {
		super.onDraw(canvas);
		//绘制网格位图
		canvas.drawBitmapMesh(mBitmap, WIDTH, HEIGHT, verts, 0, null, 0, null);
	}
}



















