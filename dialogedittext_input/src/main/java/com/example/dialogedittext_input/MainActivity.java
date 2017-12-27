package com.example.dialogedittext_input;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
	private LinearLayout rootLayout;
	private CommonDialog commonDialog;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);


		rootLayout = (LinearLayout) findViewById(R.id.root_layout);




		final SoftKeyboardStateWatcher watcher = new SoftKeyboardStateWatcher(rootLayout, this);
		watcher.addSoftKeyboardStateListener(new SoftKeyboardStateWatcher.SoftKeyboardStateListener() {
			@Override
			public void onSoftKeyboardOpened(int keyboardHeightInPx) {
				if (null!=commonDialog) {
					commonDialog.setContent("打开打开打开打开");
				}
				Toast.makeText(MainActivity.this,"打开",Toast.LENGTH_SHORT).show();
			}

			@Override
			public void onSoftKeyboardClosed() {
				if (null!=commonDialog) {
					commonDialog.setContent("关闭关闭关闭关闭");
				}
				Toast.makeText(MainActivity.this,"关闭",Toast.LENGTH_SHORT).show();
			}
		});
	}

	public void open(View view) {
		commonDialog = new CommonDialog(this);
				//.setContent(context.getString(R.string.string_new_version_info))
//		commonDialog.build();
		commonDialog.show();
	}
}
