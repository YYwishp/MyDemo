package com.example.circle_line_progressbar.View;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Rect;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.View;

/**
 * Created by gyx on 2018/1/9.
 */
public class CanvasView extends View {
	private  Rect mRect;

	public CanvasView(Context context, @Nullable AttributeSet attrs) {
		super(context, attrs);
		mRect = new Rect(0, 0, 500, 500);
		//矩形区域的相交区域
//		mRect.intersect(250, 250, 750, 750);
		//矩形区域的所有并集的区域，并不是真正意义上的并集，两个顶角区域的大矩形
		mRect.union(250, 250, 750, 750);
	}

	@Override
	protected void onDraw(Canvas canvas) {
		super.onDraw(canvas);
		canvas.drawColor(Color.BLUE);
		canvas.clipRect(mRect);
		canvas.drawColor(Color.RED);

	}
}
