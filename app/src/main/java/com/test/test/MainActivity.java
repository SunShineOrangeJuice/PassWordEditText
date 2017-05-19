package com.test.test;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private TextView tv_pwd;
    private LayoutPwdView lp_pwd;
    private Button btn;
    private String pwd;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();
        lp_pwd.setListener(new LayoutPwdView.SixPwdListener() {
            @Override
            public void onInputComplete(String passWord) {
                pwd = passWord;
            }
        });

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                tv_pwd.setText(pwd+"");
            }
        });
    }

    private void initView() {
        tv_pwd = (TextView)findViewById(R.id.text_pwd_out);
        lp_pwd = (LayoutPwdView)findViewById(R.id.text_pwd);
        btn = (Button)findViewById(R.id.btn_get);
    }
}
