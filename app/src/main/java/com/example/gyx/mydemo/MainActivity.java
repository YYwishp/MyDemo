package com.example.gyx.mydemo;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
	private TextView text;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);


		text = (TextView) findViewById(R.id.text);

	}

	public void getTime(View view) {
		long l = System.currentTimeMillis();

		text.append(l+"\n");
	}
}
