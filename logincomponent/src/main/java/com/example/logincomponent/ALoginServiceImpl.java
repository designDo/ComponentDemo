package com.example.logincomponent;

import android.content.Context;
import android.widget.Toast;
import com.alibaba.android.arouter.facade.annotation.Route;

/**
 * Created by apple on 2019/2/27.
 */
@Route(path = "/loginComponent/isLogin") public class ALoginServiceImpl implements ALoginService {

  private Context mContext;

  @Override public void init(Context context) {
    mContext = context;
  }

  @Override public void isLogin(String name) {
    Toast.makeText(mContext, "Hello" + name, Toast.LENGTH_LONG).show();
  }
}
