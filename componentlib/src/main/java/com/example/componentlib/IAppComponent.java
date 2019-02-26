package com.example.componentlib;

import android.app.Application;

/**
 * Created by apple on 2019/2/26.
 * 组件化初始化接口，让组件的上下文都使用 MainApp的上下文
 */
public interface IAppComponent {

  void initial(Application application);
}
