package com.example.componentdemo;

import android.app.Application;
import com.alibaba.android.arouter.launcher.ARouter;
import com.example.componentlib.AppConfig;
import com.example.componentlib.IAppComponent;

/**
 * Created by apple on 2019/2/26.
 * 让所有的组件都可以使用 MainApp 的 this
 */
public class MainApp extends Application implements IAppComponent {

  private static MainApp application;

  public static MainApp getApplication() {
    return application;
  }

  private boolean isDebugARouter = true;

  @Override public void onCreate() {
    super.onCreate();
    initial(this);
    if (isDebugARouter){
      ARouter.openLog();
      ARouter.openDebug();
    }
    ARouter.init(MainApp.this);
  }

  @Override public void initial(Application app) {
    application = (MainApp) app;
    for (String component : AppConfig.COMPONENT) {
      try {
        Class<?> clazz = Class.forName(component);
        Object object = clazz.newInstance();
        if (object instanceof IAppComponent) {
          ((IAppComponent) object).initial(this);
        }
      } catch (Exception e) {
        e.printStackTrace();
      }
    }
  }
}
