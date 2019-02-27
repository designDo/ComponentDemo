package com.example.componentdemo;

import android.content.Intent;
import android.net.Uri;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Toast;
import com.alibaba.android.arouter.facade.Postcard;
import com.alibaba.android.arouter.facade.callback.NavCallback;
import com.alibaba.android.arouter.launcher.ARouter;
import com.example.componentlib.ServiceFactory;
import com.example.logincomponent.ALoginService;
import com.example.logincomponent.UserInfo;

public class MainActivity extends AppCompatActivity {

  private static MainActivity activity;

  public static MainActivity getThis() {
    return activity;
  }

  @Override protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_main);
    activity = this;
    findViewById(R.id.login).setOnClickListener(new View.OnClickListener() {
      @Override public void onClick(View v) {
        ARouter.getInstance()
            .build("/loginComponent/LoginActivity")
            .withString("name", "TY")
            .withString("pwd", "123456")
            .withParcelable("userInfo", new UserInfo("TangSan", 18))
            .navigation();
        // ServiceFactory.getInstance().getmLoginService().launch(MainActivity.this, "");
      }
    });

    findViewById(R.id.user_info).setOnClickListener(new View.OnClickListener() {
      @Override public void onClick(View v) {
        Fragment fragment =
            (Fragment) ARouter.getInstance().build("/loginComponent/UserInfoFragment").navigation();
        getSupportFragmentManager().beginTransaction().add(R.id.container, fragment).commit();
      }
    });

    findViewById(R.id.go_search).setOnClickListener(new View.OnClickListener() {
      @Override public void onClick(View v) {
        Uri uri = Uri.parse("/searchComponent/SearchActivity");
        ARouter.getInstance().build(uri).withString("key", "searchKey").navigation();
        //ServiceFactory.getInstance().getmSearchService().launch(MainActivity.this, "SearchKey");
      }
    });

    findViewById(R.id.go_search_result).setOnClickListener(new View.OnClickListener() {
      @Override public void onClick(View v) {
        Uri uri = Uri.parse("/searchComponent/SearchActivity");
        ARouter.getInstance()
            .build(uri)
            .withString("key", "searchKey")
            .navigation(MainActivity.this, 1024, new NavCallback() {
              @Override public void onArrival(Postcard postcard) {
                Log.e("ARouter", "跳转完了");
              }

              @Override public void onFound(Postcard postcard) {
                Log.e("ARouter", "找到了");
              }

              @Override public void onLost(Postcard postcard) {
                Log.e("ARouter", "找不到了");
              }

              @Override public void onInterrupt(Postcard postcard) {
                Log.e("ARouter", "被拦截了");
              }
            });
      }
    });

    findViewById(R.id.test_interface).setOnClickListener(new View.OnClickListener() {
      @Override public void onClick(View v) {
        ARouter.getInstance().navigation(ALoginService.class).isLogin("TangSan");
        /*((ALoginService) ARouter.getInstance()
            .build("/loginComponent/isLogin")
            .navigation()).isLogin("TangSan");*/
      }
    });
  }

  @Override
  protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
    super.onActivityResult(requestCode, resultCode, data);
    if (requestCode == 1024) {
      Toast.makeText(MainActivity.this, "resultCode=" + resultCode, Toast.LENGTH_LONG).show();
    }
  }
}
