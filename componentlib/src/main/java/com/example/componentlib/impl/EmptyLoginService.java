package com.example.componentlib.impl;

import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import com.example.componentlib.service.ILoginService;

/**
 * Created by apple on 2019/2/26.
 */
public class EmptyLoginService implements ILoginService {
  @Override public void launch(Context context, String targetClass) {

  }

  @Override
  public Fragment getUserInfoFragment(FragmentManager fragmentManager, int viewId, Bundle bundle) {
    return null;
  }
}
