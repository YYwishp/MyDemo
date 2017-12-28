package com.example.circle_line_progressbar;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Handler;
import android.os.Message;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import com.example.circle_line_progressbar.View.CircleLineProgressBar;

public class MainActivity extends AppCompatActivity {


	private CircleLineProgressBar customView;



	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);




		customView = (CircleLineProgressBar) findViewById(R.id.custom_view);
		new Thread(customView).start();




	}

	public void epenCustomView(View view) {
		Intent intent = new Intent(this, ColorMatrixActivity.class);
		startActivity(intent);
	}

	public void Open_DuffColorFilter(View view) {

		startActivity(new Intent(this,Open_DuffColorFilterActivity.class));



	}
}
