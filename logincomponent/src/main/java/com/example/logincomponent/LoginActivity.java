package com.example.logincomponent;

import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
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

    findViewById(R.id.login_bt).setOnClickListener(new View.OnClickListener() {
      @Override public void onClick(View v) {
        ARouter.getInstance().build(Uri.parse(getIntent().getStringExtra("distance"))).navigation();
      }
    });
  }
}
