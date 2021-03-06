package com.example.circle_line_progressbar;

import android.content.Intent;
import android.os.Bundle;
import android.os.SystemClock;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;

import com.example.circle_line_progressbar.R;
import com.example.circle_line_progressbar.View.CircleLineProgressBar;
import com.example.circle_line_progressbar.activity.BezierViewActivity;
import com.example.circle_line_progressbar.activity.BitmapMeshViewActivity;
import com.example.circle_line_progressbar.activity.BlurMaskFilterViewActivity;
import com.example.circle_line_progressbar.activity.BreakLineActivity;
import com.example.circle_line_progressbar.activity.BrickViewActivity;
import com.example.circle_line_progressbar.activity.CanvasViewActivity;
import com.example.circle_line_progressbar.activity.ColorMatrixActivity;
import com.example.circle_line_progressbar.activity.Complex2Activity;
import com.example.circle_line_progressbar.activity.ComplexActivity;
import com.example.circle_line_progressbar.activity.CustomCheckBoxActivity;
import com.example.circle_line_progressbar.activity.DreamEffectViewActivity;
import com.example.circle_line_progressbar.activity.DreamEffectView_2Activity;
import com.example.circle_line_progressbar.activity.DreamEffectView_3Activity;
import com.example.circle_line_progressbar.activity.EcgViewActivity;
import com.example.circle_line_progressbar.activity.IconViewActivity;
import com.example.circle_line_progressbar.activity.ImgViewActivity;
import com.example.circle_line_progressbar.activity.LayerViewActivity;
import com.example.circle_line_progressbar.activity.LayerView_2Activity;
import com.example.circle_line_progressbar.activity.LifeCycleViewActivity;
import com.example.circle_line_progressbar.activity.LinearShaderViewActivity;
import com.example.circle_line_progressbar.activity.MaskFilterActivity;
import com.example.circle_line_progressbar.activity.MatrixImageViewActivity;
import com.example.circle_line_progressbar.activity.MatrixViewActivity;
import com.example.circle_line_progressbar.activity.Open_DuffColorFilterActivity;
import com.example.circle_line_progressbar.activity.PathEffectViewActivity;
import com.example.circle_line_progressbar.activity.PathViewActivity;
import com.example.circle_line_progressbar.activity.PathView_2Activity;
import com.example.circle_line_progressbar.activity.ReflectViewActivity;
import com.example.circle_line_progressbar.activity.ShaderViewActivity;
import com.example.circle_line_progressbar.activity.ShaderView_2Activity;
import com.example.circle_line_progressbar.activity.ShowTextActivity;
import com.example.circle_line_progressbar.activity.SquareActivity;
import com.example.circle_line_progressbar.activity.WaveViewActivity;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

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

	public void LayerView_2(View view) {



		startActivity(new Intent(this, LayerView_2Activity.class));

	}

	public void ImgView(View view) {

		startActivity(new Intent(this, ImgViewActivity.class));



	}

	public void IconView(View view) {

		startActivity(new Intent(this, IconViewActivity.class));
	}

	public void Square(View view) {

		startActivity(new Intent(this, SquareActivity.class));


	}

	public void LifeCycleView(View view) {
		startActivity(new Intent(this,LifeCycleViewActivity.class));

	}

	public void ComplexView(View view) {

		startActivity(new Intent(this,ComplexActivity.class));


	}
	public void ComplexView2(View view) {

		startActivity(new Intent(this,Complex2Activity.class));


	}

	public void CustomCheckBox(View view) {

		startActivity(new Intent(this,CustomCheckBoxActivity.class));


	}
}





































