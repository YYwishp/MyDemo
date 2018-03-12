package com.gyx.bugly_test;

import com.tencent.tinker.loader.app.TinkerApplication;
import com.tencent.tinker.loader.shareutil.ShareConstants;

/**
 * Created by gyx on 2018/3/12.
 */
public class MyApplication extends TinkerApplication {

	public MyApplication() {
		super(ShareConstants.TINKER_ENABLE_ALL, "com.gyx.bugly_test.SampleApplicationLike",
				"com.tencent.tinker.loader.TinkerLoader", false);
	}

}
