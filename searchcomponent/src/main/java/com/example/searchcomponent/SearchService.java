package com.example.searchcomponent;

import android.content.Context;
import android.content.Intent;
import com.example.componentlib.service.ISearchService;

/**
 * Created by apple on 2019/2/26.
 */
public class SearchService implements ISearchService {
  @Override public void launch(Context context, String key) {
    Intent intent = new Intent(context, SearchActivity.class);
    intent.putExtra("key", key);
    context.startActivity(intent);
  }
}
