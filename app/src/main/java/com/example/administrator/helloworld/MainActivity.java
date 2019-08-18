package com.example.administrator.helloworld;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;


public class MainActivity extends AppCompatActivity {








    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        findViews();
    }
    private Button mBtn01;
    private EditText mEdt01;
    private EditText mEdt02;
    private TextView mTv03;
    private TextView mTv04;

        private void findViews() {
        mEdt02 = findViewById(R.id.et02);

        mEdt01 = findViewById(R.id.et01);
        mBtn01 = findViewById(R.id.btn_login);
            mBtn01.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    String name = mEdt01.getText().toString();
                    System.out.println(name);
                    String pass = mEdt02.getText().toString();
                    System.out.println(pass);

                    Log.i("TAG",name+"_"+pass);
                    UserService uService = new UserService(MainActivity.this);
                    boolean flag = uService.login(name, pass);

                    if(flag){
                        Log.i("TAG","登录成功");
                        Toast.makeText(MainActivity.this, "登录成功", Toast.LENGTH_LONG).show();
                        Intent intent = new Intent(MainActivity.this,EndActivity.class);
                        startActivity(intent);
                    }else{
                        Log.i("TAG","登录失败");
                        Toast.makeText(MainActivity.this, "登录失败", Toast.LENGTH_LONG).show();
                        return;
                    }
                }
            });
        mTv03 = findViewById(R.id.tv03);
        mTv03.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this,WangMiActivity.class);
                startActivity(intent);
            }
        });
        mTv04 = findViewById(R.id.tv04);
        mTv04.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this,ZhuCeActivity.class);
                startActivity(intent);
            }
        });
    }
}
