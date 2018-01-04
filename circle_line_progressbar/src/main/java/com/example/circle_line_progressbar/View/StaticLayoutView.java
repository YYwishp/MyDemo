package com.example.circle_line_progressbar.View;

import android.content.Context;
import android.graphics.BlurMaskFilter;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Typeface;
import android.text.Layout;
import android.text.StaticLayout;
import android.text.TextPaint;
import android.util.AttributeSet;
import android.view.View;

/**
 *
 * 自动换行的view
 * Created by gyx on 2017/12/29.
 */
public class StaticLayoutView extends View {
	private static final String TEXT = "This is used by widgets to control text layout. You should not need to use this class directly unless you are implementing your own widget or custom display object, or would be tempted to call Canvas.drawText() directly.";
	private TextPaint mTextPaint;// 文本的画笔
	private StaticLayout mStaticLayout;// 文本布局

	public StaticLayoutView(Context context) {
		this(context, null);
	}

	public StaticLayoutView(Context context, AttributeSet attrs) {
		super(context, attrs);

		// 初始化画笔
		initPaint();
	}

	/**
	 * 初始化画笔
	 */
	private void initPaint() {
		// 实例化画笔
		mTextPaint = new TextPaint(Paint.ANTI_ALIAS_FLAG);
		mTextPaint.setTextSize(50);
		mTextPaint.setColor(Color.BLACK);
		//更改字体，Typeface.SERIF：衬线体，Typeface.NORMAL：一般粗细
//		mTextPaint.setTypeface(Typeface.create(Typeface.SERIF, Typeface.NORMAL));
		//Typeface.MONOSPACE:等宽字体
		mTextPaint.setTypeface(Typeface.create(Typeface.MONOSPACE, Typeface.NORMAL));
		/*从资源文件获取字体并设置画笔字体
		Typeface typeface = Typeface.createFromAsset(context.getAssets(), "kt.ttf");
		mTextPaint.setTypeface(typeface);*/
		//亚像素
		mTextPaint.setSubpixelText(true);

		//文本删除线
		mTextPaint.setStrikeThruText(true);
		/**
		 * 设置是否打开线性文本标识，这玩意对大多数人来说都很奇怪不知道这玩意什么意思。
		 * 想要明白这东西你要先知道文本在Android中是如何进行存储和计算的。在Android中文本的绘制需要使用一个bitmap作为单个字符的缓存，
		 * 既然是缓存必定要使用一定的空间，我们可以通过setLinearText (true)告诉Android我们不需要这样的文本缓存。
		 */
		mTextPaint.setLinearText(true);
		//设置文本仿粗体
		mTextPaint.setFakeBoldText(true);

		// 设置画笔遮罩滤镜
		mTextPaint.setMaskFilter(new BlurMaskFilter(2, BlurMaskFilter.Blur.SOLID));



	}

	@Override
	protected void onDraw(Canvas canvas) {
		super.onDraw(canvas);
		//spacingmull:相对行间距，相对字体大小，1.5f表示行间距为1.5倍的字体高度。
		//spacingadd:.在基础行距上添加多少(不是字体高度比),实际行间距等于这两者的和。
		mStaticLayout = new StaticLayout(TEXT, mTextPaint, canvas.getWidth(), Layout.Alignment.ALIGN_NORMAL, 1.0F, 0.0F, false);
		mStaticLayout.draw(canvas);
		canvas.restore();
	}
}












































