package com.example.componentdemo;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import com.example.componentlib.ServiceFactory;

public class MainActivity extends AppCompatActivity {

  @Override protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_main);
    findViewById(R.id.login).setOnClickListener(new View.OnClickListener() {
      @Override public void onClick(View v) {
        ServiceFactory.getInstance().getmLoginService().launch(MainActivity.this, "");
      }
    });

    findViewById(R.id.go_search).setOnClickListener(new View.OnClickListener() {
      @Override public void onClick(View v) {
        ServiceFactory.getInstance().getmSearchService().launch(MainActivity.this,"SearchKey");
      }
    });

    findViewById(R.id.show_ui).setOnClickListener(new View.OnClickListener() {
      @Override public void onClick(View v) {
        ServiceFactory.getInstance()
            .getmLoginService()
            .getUserInfoFragment(getSupportFragmentManager(), R.id.container, new Bundle());
      }
    });
  }
}
