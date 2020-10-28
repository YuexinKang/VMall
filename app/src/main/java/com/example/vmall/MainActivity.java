package com.example.vmall;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;


public class MainActivity extends AppCompatActivity {
    //1.定义控件对象
    private EditText etUsername;
    private EditText etPassword;
    private CheckBox cbAutoLogin;
    private Button btnLogin;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //初始化控件对象
        etUsername=findViewById(R.id.et_username);
        etPassword=findViewById(R.id.et_password);
        cbAutoLogin=findViewById(R.id.cb_auto_login);
        btnLogin=findViewById(R.id.btn_login);
        //3.设置按钮的监听器
        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                login();
            }
        });

    }
    private void login() {
        //3.1获取用户名和密码的值
        String username=etUsername.getText().toString().trim();
        String password=etPassword.getText().toString();
        if(TextUtils.isEmpty(username)||TextUtils.isEmpty(password)){
            Toast.makeText(this,"用户名与密码都不能为空",Toast.LENGTH_LONG).show();
            return;
        }
        //比较用户名密码是否正确，然后给出提示
        if("android".equals(username)&&"123456".equals(password)){
            Toast.makeText(this,"登录成功",Toast.LENGTH_LONG).show();
            Intent intent =new Intent(this,HomeActivity.class);
            intent.putExtra("username",username);
            startActivity(intent);
        }else{
            Toast.makeText(this,"用户名和密码不正确",Toast.LENGTH_LONG).show();
        }
    }
}