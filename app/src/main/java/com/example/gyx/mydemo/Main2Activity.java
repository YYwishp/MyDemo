package com.example.gyx.mydemo;

import android.os.Parcelable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Toast;

import java.util.ArrayList;

public class Main2Activity extends AppCompatActivity {
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main2);
		ArrayList<Parcelable> apple = getIntent().getParcelableArrayListExtra("apple");
		Toast.makeText(this, "apple.size():" + apple.size(), Toast.LENGTH_SHORT).show();


	}



}
