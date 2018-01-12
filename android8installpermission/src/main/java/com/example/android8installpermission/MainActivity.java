package com.example.android8installpermission;

import android.Manifest;
import android.content.Intent;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.os.Environment;
import android.support.annotation.NonNull;
import android.support.v4.content.FileProvider;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.TextView;

import java.io.File;
import java.util.List;

import pub.devrel.easypermissions.AfterPermissionGranted;
import pub.devrel.easypermissions.EasyPermissions;

public class MainActivity extends AppCompatActivity implements EasyPermissions.PermissionCallbacks {
	private TextView text;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		text = (TextView) findViewById(R.id.text);
		cameraTask();
	}

	@Override
	public void onRequestPermissionsResult(int requestCode, String[] permissions, int[] grantResults) {
		super.onRequestPermissionsResult(requestCode, permissions, grantResults);
		// Forward results to EasyPermissions
		EasyPermissions.onRequestPermissionsResult(requestCode, permissions, grantResults, this);
	}

	@Override
	public void onPermissionsGranted(int requestCode, @NonNull List<String> perms) {
	}

	@Override
	public void onPermissionsDenied(int requestCode, @NonNull List<String> perms) {
	}

	/**
	 * 请求CAMERA权限码
	 */
	public static final int REQUEST_READ_WRITE = 102;

	@AfterPermissionGranted(REQUEST_READ_WRITE)
	public void cameraTask() {
		if (EasyPermissions.hasPermissions(this, Manifest.permission.READ_EXTERNAL_STORAGE, Manifest.permission.WRITE_EXTERNAL_STORAGE)) {
			// Have permission, do the thing!
			installApp();
		} else {
			// Ask for one permission
			EasyPermissions.requestPermissions(this, "获取读写权限", REQUEST_READ_WRITE, Manifest.permission.READ_EXTERNAL_STORAGE, Manifest.permission.WRITE_EXTERNAL_STORAGE);
		}
	}

	private void installApp() {
		text.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				File file = new File(Environment.getExternalStorageDirectory().getPath(), "app_coinwall.apk");
				Intent intent = new Intent(Intent.ACTION_VIEW);
				// 由于没有在Activity环境下启动Activity,设置下面的标签
				intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);


				if (Build.VERSION.SDK_INT >= 24) { //判读版本是否在7.0以上
					//参数1 上下文, 参数2 Provider主机地址 和配置文件中保持一致   参数3  共享的文件
					Uri apkUri = FileProvider.getUriForFile(MainActivity.this, MainActivity.this.getPackageName() + ".fileprovider", file);
					//添加这一句表示对目标应用临时授权该Uri所代表的文件
					intent.addFlags(Intent.FLAG_GRANT_READ_URI_PERMISSION);
					intent.setDataAndType(apkUri, "application/vnd.android.package-archive");
				} else {
					intent.setDataAndType(Uri.fromFile(file), "application/vnd.android.package-archive");
				}


				startActivity(intent);
			}
		});
	}
}
