package com.example.circle_line_progressbar.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import com.example.circle_line_progressbar.R;
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
		startActivity(new Intent(this, Open_DuffColorFilterActivity.class));
	}

	public void Open_Text(View view) {
		startActivity(new Intent(this, ShowTextActivity.class));
	}

	public void line_break(View view) {
		startActivity(new Intent(this, BreakLineActivity.class));
	}

	public void MaskFilterView(View view) {
		startActivity(new Intent(this, MaskFilterActivity.class));
	}

	public void BlurMaskFilterView(View view) {
		startActivity(new Intent(this, BlurMaskFilterViewActivity.class));
	}

	public void PathEffectView(View view) {
		startActivity(new Intent(this, PathEffectViewActivity.class));
	}

	public void ECGView(View view) {
		startActivity(new Intent(this, EcgViewActivity.class));
	}

	public void ShaderView(View view) {
		startActivity(new Intent(this, ShaderViewActivity.class));
	}

	public void BrickView(View view) {
		startActivity(new Intent(this, BrickViewActivity.class));
	}

	public void LinearShaderView(View view) {
		startActivity(new Intent(this, LinearShaderViewActivity.class));
	}

	public void ReflectView(View view) {
		startActivity(new Intent(this, ReflectViewActivity.class));
	}

	public void DreamEffectView(View view) {
		startActivity(new Intent(this, DreamEffectViewActivity.class));
	}

	public void DreamEffectView_2(View view) {
		startActivity(new Intent(this, DreamEffectView_2Activity.class));
	}

	public void DreamEffectView_3(View view) {
		startActivity(new Intent(this, DreamEffectView_3Activity.class));
	}

	public void ShaderView_2(View view) {
		startActivity(new Intent(this, ShaderView_2Activity.class));

	}

	public void MatrixView(View view) {

		startActivity(new Intent(this, MatrixViewActivity.class));
	}
	
	public void MatrixImageView(View view) {
		startActivity(new Intent(this, MatrixImageViewActivity.class));
	}

	public void BitmapMeshView(View view) {
		startActivity(new Intent(this, BitmapMeshViewActivity.class));
	}

	public void CanvasView(View view) {


		startActivity(new Intent(this, CanvasViewActivity.class));

	}

	public void PathView(View view) {

		startActivity(new Intent(this, PathViewActivity.class));
	}

	public void BezierView(View view) {
		startActivity(new Intent(this, BezierViewActivity.class));
	}

	public void WaveView(View view) {

		startActivity(new Intent(this, WaveViewActivity.class));

	}

	public void PathView_2(View view) {


		startActivity(new Intent(this, PathView_2Activity.class));
	}

	public void LayerView(View view) {
		startActivity(new Intent(this, LayerViewActivity.class));



	}
}





































