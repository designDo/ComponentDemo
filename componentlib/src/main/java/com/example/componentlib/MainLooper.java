package com.example.componentlib;

import android.os.Handler;
import android.os.Looper;

/**
 * Created by apple on 2019/2/27.
 */
public class MainLooper extends Handler {

  private static MainLooper instance = new MainLooper(Looper.getMainLooper());

  protected MainLooper(Looper looper) {
    super(looper);
  }

  public static MainLooper getInstance() {
    return instance;
  }

  public static void runOnUiThread(Runnable runnable) {
    if (Looper.getMainLooper().equals(Looper.myLooper())) {
      runnable.run();
    } else {
      instance.post(runnable);
    }
  }
}
