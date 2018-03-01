package com.gyx.myjnitest;

/**
 * Created by gyx on 2018/3/1.
 */
public class JniTest {
	/**
	 * 将用C++代码实现，在android代码中调用的方法：获取当前app的包名
	 * @param
	 * @return
	 */
	public static native String getPackname();



	static {
		System.loadLibrary("JNI_ANDROID_TEST");

	}
}
