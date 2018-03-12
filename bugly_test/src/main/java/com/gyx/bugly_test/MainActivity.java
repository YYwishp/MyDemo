package com.gyx.bugly_test;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {


	private TextView text;
	private TextView text2;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);

		text = (TextView) findViewById(R.id.text);
		text.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				Toast.makeText(MainActivity.this, "bug已被修复", Toast.LENGTH_SHORT).show();
			}
		});
		text.setText("bugfixed");
		
	
		
		text2 = (TextView) findViewById(R.id.text2);

		text2.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {

				Toast.makeText(MainActivity.this, "啦啦啦啦", Toast.LENGTH_SHORT).show();
			}
		});
	}
}
