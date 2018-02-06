package com.example.circle_line_progressbar.View;

import android.content.Context;
import android.content.res.TypedArray;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;

import com.example.circle_line_progressbar.R;

/**
 * Created by gyx on 2018/2/6.
 */
public class CustomCheckBox extends FrameLayout {
	private ImageView ivCheckOn;
	private ImageView ivCheckOff;
	private boolean isCheck;
	private CustomCheckBoxChangeListener customCheckBoxChangeListener;

	public CustomCheckBox(@NonNull Context context) {
		this(context, null);

	}

	public CustomCheckBox(@NonNull Context context, @Nullable AttributeSet attrs) {
		this(context, attrs, 0);
	}

	public CustomCheckBox(@NonNull Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
		super(context, attrs, defStyleAttr);

		//设置布局文件
		LayoutInflater.from(context).inflate(R.layout.view_custom_check_box, this);
		ivCheckOn = findViewById(R.id.view_custom_check_box_on);
		ivCheckOff = findViewById(R.id.view_custom_check_box_off);
		//设置两个imageview的点击事件
		ivCheckOn.setOnClickListener(new ClickListener());
		ivCheckOff.setOnClickListener(new ClickListener());
		//读取xml中设置的资源属性ID
		TypedArray typedArray = context.obtainStyledAttributes(attrs, R.styleable.CustomCheckBox);
		int imageOnResId = typedArray.getResourceId(R.styleable.CustomCheckBox_imageOn, -1);
		int imageOffResId = typedArray.getResourceId(R.styleable.CustomCheckBox_imageOff, -1);
		//设置显示资源
		setOnImage(imageOnResId);
		setOffImage(imageOffResId);

		//资源回收
		typedArray.recycle();
		//默认显示的是没有选中的状态
		setCheckOff();
	}

	/**
	 * 设置关闭时候的图片
	 * @param imageOffResId
	 */
	private void setOffImage(int imageOffResId) {
		ivCheckOff.setImageResource(imageOffResId);

	}

	/**
	 * 设置开启状态显示的图片
	 *
	 * @param imageOnResId
	 */
	private void setOnImage(int imageOnResId) {
		ivCheckOn.setImageResource(imageOnResId);
	}

	/**
	 * 设置CustomCheckBox为关闭状态
	 */
	private void setCheckOff() {
		isCheck = false;
		ivCheckOn.setVisibility(GONE);
		ivCheckOff.setVisibility(VISIBLE);
	}

	/**
	 * 设置CustomCheckbox为开启状态
	 */
	private void setCheckOn() {
		isCheck = true;
		ivCheckOn.setVisibility(VISIBLE);
		ivCheckOff.setVisibility(GONE);
	}

	/**
	 * 返回是否选中
	 * @return
	 */
	public boolean isCheck() {
		return isCheck;
	}

	/**
	 * 状态改变接口
	 */
	public interface CustomCheckBoxChangeListener {
		void customCheckBoxOn();

		void customCheckBoxOff();
	}

	/**
	 * 为CustomCheckbox设置监听
	 * @param customCheckBoxChangeListener
	 */
	public void setCustomCheckBoxChangeListener(CustomCheckBoxChangeListener customCheckBoxChangeListener) {
		this.customCheckBoxChangeListener = customCheckBoxChangeListener;
	}


	private class ClickListener implements OnClickListener {
		@Override
		public void onClick(View v) {
			switch (v.getId()) {
				case R.id.view_custom_check_box_on:
					setCheckOff();
					if (customCheckBoxChangeListener!=null) {
						customCheckBoxChangeListener.customCheckBoxOff();
					}

					break;
				case R.id.view_custom_check_box_off:
					setCheckOn();
					if (customCheckBoxChangeListener != null) {

						customCheckBoxChangeListener.customCheckBoxOn();
					}

					break;

			}


		}
	}
}








































































