package com.example.searchcomponent;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Toast;

public class SearchActivity extends AppCompatActivity {

  @Override protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_search);
    if (getIntent() != null) {
      String key = getIntent().getStringExtra("key");
      Toast.makeText(this, key, Toast.LENGTH_LONG).show();
    }
  }
}
