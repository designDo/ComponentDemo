package com.example.componentdemo;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.net.Uri;
import com.alibaba.android.arouter.facade.Postcard;
import com.alibaba.android.arouter.facade.annotation.Interceptor;
import com.alibaba.android.arouter.facade.callback.InterceptorCallback;
import com.alibaba.android.arouter.facade.template.IInterceptor;
import com.alibaba.android.arouter.launcher.ARouter;
import com.example.componentlib.MainLooper;
import com.example.logincomponent.UserInfo;

/**
 * Created by apple on 2019/2/27.
 */
@Interceptor(priority = 1) public class TestInterceptor implements IInterceptor {
  Context mContext;

  @Override public void process(final Postcard postcard, final InterceptorCallback callback) {
    if ("/searchComponent/SearchActivity".equals(postcard.getPath())) {
      final AlertDialog.Builder ab = new AlertDialog.Builder(MainActivity.getThis());
      ab.setCancelable(false);
      ab.setTitle("温馨提示");
      ab.setMessage("触发了SearchInterceptor拦截器");
      ab.setNegativeButton("继续", new DialogInterface.OnClickListener() {
        @Override public void onClick(DialogInterface dialog, int which) {
          callback.onInterrupt(null);
          ARouter.getInstance()
              .build("/loginComponent/LoginActivity")
              .withString("name", "TY")
              .withString("distance",postcard.getPath())
              .withString("pwd", "123456")
              .withParcelable("userInfo", new UserInfo("TangSan", 1))
              .navigation();
        }
      });
      ab.setNeutralButton("算了", new DialogInterface.OnClickListener() {
        @Override public void onClick(DialogInterface dialog, int which) {
          callback.onInterrupt(null);
        }
      });
      ab.setPositiveButton("加点儿料", new DialogInterface.OnClickListener() {
        @Override public void onClick(DialogInterface dialog, int which) {
          postcard.withString("extra", "我是拦截器中的参数");
          callback.onContinue(postcard);
        }
      });
      MainLooper.runOnUiThread(new Runnable() {
        @Override public void run() {
          ab.create().show();
        }
      });
    } else {
      callback.onContinue(postcard);
    }
  }

  @Override public void init(Context context) {
    mContext = context;
  }
}
