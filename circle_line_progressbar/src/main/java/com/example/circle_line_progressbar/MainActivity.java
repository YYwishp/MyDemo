package com.example.circle_line_progressbar;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Handler;
import android.os.Message;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import com.example.circle_line_progressbar.View.CircleLineProgressBar;
import com.example.circle_line_progressbar.View.ShaderViewActivity;
import com.example.circle_line_progressbar.View.ShowTextActivity;

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

	public void Open_Text(View view) {
		startActivity(new Intent(this,ShowTextActivity.class));
	}

	public void line_break(View view) {

		startActivity(new Intent(this,BreakLineActivity.class));



	}

	public void MaskFilterView(View view) {
		startActivity(new Intent(this,MaskFilterActivity.class));
	}

	public void BlurMaskFilterView(View view) {
		startActivity(new Intent(this,BlurMaskFilterViewActivity.class));
	}

	public void PathEffectView(View view) {
		startActivity(new Intent(this,PathEffectViewActivity.class));
	}

	public void ECGView(View view) {
		startActivity(new Intent(this,EcgViewActivity.class));
	}

	public void ShaderView(View view) {
		startActivity(new Intent(this,ShaderViewActivity.class));

	}

	public void BrickView(View view) {
		startActivity(new Intent(this,BrickViewActivity.class));
	}

	public void LinearShaderView(View view) {
		startActivity(new Intent(this,LinearShaderViewActivity.class));

	}

	public void ReflectView(View view) {
		startActivity(new Intent(this,ReflectViewActivity.class));
	}
}
