package com.gyx.myservicedemo;

import android.content.Intent;
import android.os.Message;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
	private ImageView img;
	private Button btButton;
	private Button btStop;
	private int origHeight;
	private ListView listview;
	private RelativeLayout re;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);


		re = (RelativeLayout) findViewById(R.id.re);

		img = (ImageView) findViewById(R.id.img);


		btButton = (Button) findViewById(R.id.bt_button);
		btStop = (Button) findViewById(R.id.bt_stop);


		listview = (ListView) findViewById(R.id.listview);

		final Intent intent = new Intent(this, ForegroundService.class);

		re.post(new Runnable() {
			@Override
			public void run() {
				origHeight = re.getHeight();
			}
		});
		btButton.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				intent.putExtra("cmd", 0);//0开启服务，1关闭服务
				startService(intent);

				HiddenAnimUtils.newInstance(MainActivity.this, re, null, 180, origHeight,true).toggle();

			}
		});



		btStop.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				intent.putExtra("cmd", 0);//0开启服务，1关闭服务
				stopService(intent);
				HiddenAnimUtils.newInstance(MainActivity.this, re, null, 180,origHeight,false).toggle();
			}
		});
		ArrayList<String> strings = new ArrayList<>();
		for (int i = 0; i < 100; i++) {
			strings.add("item" + i);

		}
		listview.setAdapter(new MyAdapter(strings));
	}

	private class MyAdapter extends BaseAdapter {
		private List<String> mList;


		public MyAdapter(ArrayList<String> strings) {
			mList = strings;
		}

		@Override
		public int getCount() {
			return mList.size();
		}

		@Override
		public Object getItem(int position) {
			return mList.get(position);
		}

		@Override
		public long getItemId(int position) {
			return position;
		}

		@Override
		public View getView(int position, View convertView, ViewGroup parent) {
			View inflate = View.inflate(MainActivity.this, R.layout.item, null);
			TextView textView = (TextView) inflate.findViewById(R.id.item_textview);
			textView.setText(mList.get(position));

			return inflate;
		}
	}
























}
