package com.example.circle_line_progressbar.activity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.ViewGroup;
import android.widget.LinearLayout;

import com.example.circle_line_progressbar.R;
import com.example.circle_line_progressbar.View.ComplexView2;

public class Complex2Activity extends AppCompatActivity {
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_complex2);
		ComplexView2 complexView2 = new ComplexView2(this, null);
		addContentView(complexView2, new LinearLayout.LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT));

	}
}
