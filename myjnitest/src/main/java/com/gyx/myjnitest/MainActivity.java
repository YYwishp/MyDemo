package com.gyx.myjnitest;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
	private TextView text;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		text = (TextView) findViewById(R.id.text);
		text.setText(JniTest.getPackname());
		int a = 100;
		int b = 200;
		swap(a, b);
		Log.e("test--", a + "----" + b);
	}

	public void swap(int x, int y) {
		int temp;
		temp = x;
		x = y;
		y = temp;
	}
}