package com.example.componentlib;

import com.example.componentlib.impl.EmptyLoginService;
import com.example.componentlib.impl.EmptySearchService;
import com.example.componentlib.service.ILoginService;
import com.example.componentlib.service.ISearchService;

/**
 * Created by apple on 2019/2/26.
 */
public class ServiceFactory {

  private static ServiceFactory instance = new ServiceFactory();

  public static ServiceFactory getInstance() {
    return instance;
  }

  private ILoginService mLoginService;
  private ISearchService mSearchService;

  public ILoginService getmLoginService() {
    //防止组件被移除
    if (mLoginService == null) {
      mLoginService = new EmptyLoginService();
    }
    return mLoginService;
  }

  public void setmLoginService(ILoginService mLoginService) {
    this.mLoginService = mLoginService;
  }

  public ISearchService getmSearchService() {
    if (mSearchService == null) {
      mSearchService = new EmptySearchService();
    }
    return mSearchService;
  }

  public void setmSearchService(ISearchService mSearchService) {
    this.mSearchService = mSearchService;
  }
}
