package com.example.logincomponent;

import android.app.Application;
import com.example.componentlib.IAppComponent;
import com.example.componentlib.ServiceFactory;

/**
 * Created by apple on 2019/2/26.
 */
public class LoginApp extends Application implements IAppComponent {

  private static Application application;

  public static Application getApplication() {
    return application;
  }

  @Override public void onCreate() {
    super.onCreate();
    initial(this);
  }

  @Override public void initial(Application app) {
    application = app;
    ServiceFactory.getInstance().setmLoginService(new LoginService());
  }
}
