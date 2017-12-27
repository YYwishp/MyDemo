package com.example.dialogedittext_input;

import android.app.Dialog;
import android.content.Context;
import android.os.Bundle;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.EditText;
import android.widget.TextView;

/**
 * 普通的dialog
 * Created by xiaoDD on 2017/3/6.
 */
public class CommonDialog extends Dialog {
	public CommonDialog(Context context) {

		super(context, R.style.mystyle);
	}

	public CommonDialog(Context context, int themeResId) {
		super(context, themeResId);
	}

	protected CommonDialog(Context context, boolean cancelable, OnCancelListener cancelListener) {
		super(context, cancelable, cancelListener);
	}

	public void setText(String string) {
		content.setText(string);
	}

	private Context mContext;
	private TextView title;
	private EditText content;

	/**
	 * 设置内容
	 *
	 * @param contentString
	 * @return
	 */
	public void setContent(String contentString) {
		content.setText(contentString);
	}

//	public CommonDialog build() {
//		LayoutInflater mInflater = (LayoutInflater) mContext.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
//		final CommonDialog commonDialog = new CommonDialog(mContext);
//		commonDialog.requestWindowFeature(Window.FEATURE_NO_TITLE);//没有标题
//		View inflate = mInflater.inflate(R.layout.dialog_common, null);
//		title = (TextView) inflate.findViewById(R.id.title);
//		content = (EditText) inflate.findViewById(R.id.content);
//		commonDialog.getWindow().setWindowAnimations(R.style.mystyle);
//		commonDialog.setContentView(inflate);
//		return commonDialog;
//	}



	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		requestWindowFeature(Window.FEATURE_NO_TITLE);
		//设置对话框使用的布局文件
//		LayoutInflater mInflater = (LayoutInflater) mContext.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
//		final CommonDialog commonDialog = new CommonDialog(mContext);
//		commonDialog.requestWindowFeature(Window.FEATURE_NO_TITLE);//没有标题
//		View inflate = mInflater.inflate(R.layout.dialog_common, null);
//		title = (TextView) inflate.findViewById(R.id.title);
//		content = (EditText) inflate.findViewById(R.id.content);
//		commonDialog.getWindow().setWindowAnimations(R.style.mystyle);
//		commonDialog.setContentView(inflate);


		LayoutInflater inflater = getLayoutInflater();
		View inflate = inflater.inflate(R.layout.dialog_common, null);
		Window window = getWindow();
		//window.setGravity(Gravity.BOTTOM);
		title = (TextView) inflate.findViewById(R.id.title);
		content = (EditText) inflate.findViewById(R.id.content);
//		commonDialog.getWindow().setWindowAnimations(R.style.mystyle);
//		commonDialog.setContentView(inflate);
		setContentView(inflate);
	}
}
