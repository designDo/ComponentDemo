package com.example.logincomponent;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import com.example.componentlib.service.ILoginService;

/**
 * Created by apple on 2019/2/26.
 */
public class LoginService implements ILoginService {
  @Override public void launch(Context context, String targetClass) {
    Intent intent = new Intent(context, LoginActivity.class);
    context.startActivity(intent);
  }

  @Override
  public Fragment getUserInfoFragment(FragmentManager fragmentManager, int viewId, Bundle bundle) {
    UserInfoFragment userInfoFragment = new UserInfoFragment();
    userInfoFragment.setArguments(bundle);
    fragmentManager.beginTransaction().add(viewId, userInfoFragment).commit();
    return userInfoFragment;
  }
}
