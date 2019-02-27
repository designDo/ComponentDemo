package com.example.logincomponent;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;
import com.alibaba.android.arouter.facade.annotation.Autowired;
import com.alibaba.android.arouter.facade.annotation.Route;
import com.alibaba.android.arouter.launcher.ARouter;

@Route(path = "/loginComponent/LoginActivity") public class LoginActivity
    extends AppCompatActivity {

  private TextView infoTextView;

  @Autowired() String name;
  @Autowired(name = "pwd") String password;
  @Autowired() UserInfo userInfo;

  @Override protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_login);
    ARouter.getInstance().inject(this);
    infoTextView = findViewById(R.id.info);
    infoTextView.setText(
        "name:" + name + ",password:" + password + ",UserInfo:" + userInfo.toString());
  }
}
