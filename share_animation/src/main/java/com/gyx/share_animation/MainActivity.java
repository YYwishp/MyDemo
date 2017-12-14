package com.gyx.share_animation;

import android.app.ActivityOptions;
import android.content.Intent;
import android.os.Build;
import android.support.annotation.RequiresApi;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.transition.Fade;
import android.transition.Slide;
import android.transition.TransitionInflater;
import android.util.Pair;
import android.view.View;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity {
	private View img4;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);

		if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
			getWindow().setAllowEnterTransitionOverlap(false);
			getWindow().setAllowReturnTransitionOverlap(false);
			getWindow().setExitTransition(new Slide().setDuration(1000));
//
		}
		setContentView(R.layout.activity_main);
	}

	@RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
	public void img_1(View view) {
		Intent intent = new Intent(this, SecondActivity.class);
		intent.putExtra("flag", "img_1");
		startActivity(intent, ActivityOptions.makeSceneTransitionAnimation(this).toBundle());

	}

	@RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
	public void img_2(View view) {
		Intent intent = new Intent(this, SecondActivity.class);
		intent.putExtra("flag", "img_2");
		startActivity(intent, ActivityOptions.makeSceneTransitionAnimation(this).toBundle());

	}

	@RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
	public void img_3(View view) {
		Intent intent = new Intent(this, SecondActivity.class);
		intent.putExtra("flag", "img_3");
		startActivity(intent, ActivityOptions.makeSceneTransitionAnimation(this).toBundle());

	}

	/**
	 * 创建单个共享元素
	 * @param view
	 */
	@RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
	public void img_4(View view) {
		Intent intent = new Intent(this, SecondActivity.class);
		intent.putExtra("flag", "img_4");
		startActivity(intent, ActivityOptions.makeSceneTransitionAnimation(this, view,"img_4").toBundle());

	}

	/**
	 * 创建多个共享元素
	 * @param view
	 */
	@RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
	public void img_5(View view) {


		img4 = (View) findViewById(R.id.img_4);

		Intent intent = new Intent(this, SecondActivity.class);
		intent.putExtra("flag", "img_5");
		startActivity(intent,
				ActivityOptions.makeSceneTransitionAnimation(
						this,
						Pair.create(view,"img_5"),
						Pair.create(img4,"img_4")).toBundle());
	}
}






































