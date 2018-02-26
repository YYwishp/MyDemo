package com.gyx.android_animation.activity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.gyx.android_animation.R;
import com.gyx.android_animation.view.MyPointView;

public class ValueAnimatorWithMyOfObjectActivity extends AppCompatActivity {

	private TextView text;
	private MyPointView mypointview;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_value_animator_with_my_of_object);




		text = (TextView) findViewById(R.id.text);


		mypointview = (MyPointView) findViewById(R.id.mypointview);

	}

	public void startAnimation(View view) {
		mypointview.doPointAnim();



	}

	public void cancelAnimation(View view) {




	}
}
