package com.example.logincomponent;

import com.alibaba.android.arouter.facade.template.IProvider;

/**
 * Created by apple on 2019/2/27.
 */
public interface ALoginService extends IProvider {

  void isLogin(String name);
}
