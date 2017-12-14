package com.gyx.share_animation;

import android.os.Build;
import android.support.annotation.RequiresApi;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.transition.Explode;
import android.transition.Fade;
import android.transition.Slide;
import android.view.Window;

public class SecondActivity extends AppCompatActivity {
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		//getWindow().requestFeature(Window.FEATURE_CONTENT_TRANSITIONS);


		setContentView(R.layout.activity_second);
		if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
			getWindow().setAllowEnterTransitionOverlap(false);
			getWindow().setAllowReturnTransitionOverlap(false);
			//可以放在setContentView（）后面写
			String flag = getIntent().getExtras().getString("flag");
			switch (flag) {
				case "img_1":
					getWindow().setEnterTransition(new Explode());
					break;
				case "img_2":
					getWindow().setEnterTransition(new Slide());
					break;
				case "img_3":
					getWindow().setEnterTransition(new Fade());

					break;
				case "img_4":
					Explode explode = new Explode();
					explode.setDuration(2000);
					getWindow().setEnterTransition(explode);
					getWindow().setExitTransition(explode);
					break;
				case "img_5":
					getWindow().setEnterTransition(new Fade());
					getWindow().setExitTransition(new Fade());
					break;

			}
		}

	}
}