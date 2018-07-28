package com.example.gyx.mydemo;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
	private TextView text;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);


		text = (TextView) findViewById(R.id.text);





	}

	public void getTime(View view) {
		long l = System.currentTimeMillis();

//		text.append(l+"\n");

		writeFileData(this,"test111","你好你好-------");
		ArrayList<AppleBean> appleBeans = new ArrayList<AppleBean>();
		new AppleBean("red", "good");
		for (int i = 0; i < 10; i++) {
			AppleBean good = new AppleBean("red" + i, "good");
			appleBeans.add(good);
		}



		Intent intent = new Intent(this, Main2Activity.class);

		intent.putParcelableArrayListExtra("apple",appleBeans);

		startActivity(intent);

	}


	//向指定的文件中写入指定的数据
	public static void writeFileData(Context context, String filename, String content) {
		try {
//			File file = new File(context.getFilesDir().toString() + filename);
//			if (!file.exists()) {
//				//文件不存在，就创建一个新文件
//				file.createNewFile();
//			}
			FileOutputStream fos = context.openFileOutput(filename, MODE_PRIVATE);//获得FileOutputStream
			//将要写入的字符串转换为byte数组
			byte[] bytes = content.getBytes();
			fos.write(bytes);//将byte数组写入文件
			fos.close();//关闭文件输出流
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	//打开指定文件，读取其数据，返回字符串对象
	public  String readFileData(Context context, String fileName) {
		String result = "";
		try {
			File file = new File( getFilesDir().getPath().toString()+"/"+fileName);
			if (!file.exists()) {
				//文件不存在，就创建一个新文件
				file.createNewFile();
			}
			FileInputStream fis = context.openFileInput(fileName);
			//获取文件长度
			int lenght = fis.available();
			byte[] buffer = new byte[lenght];
			fis.read(buffer);

			//将byte数组转换成指定格式的字符串
			result = new String(buffer, "UTF-8");
		} catch (Exception e) {
			e.printStackTrace();
		}
		return result;
	}

	public void read(View view) {
		String test111 = readFileData(this, "test111");
		text.setText(test111);

	}
}
