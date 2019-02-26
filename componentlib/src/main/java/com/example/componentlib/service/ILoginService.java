package com.example.componentlib.service;

import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;

/**
 * Created by apple on 2019/2/26.
 */
public interface ILoginService {
  void launch(Context context, String targetClass);

  Fragment getUserInfoFragment(FragmentManager fragmentManager, int viewId, Bundle bundle);
}
