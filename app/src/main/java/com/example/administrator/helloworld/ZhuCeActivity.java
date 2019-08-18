package com.example.administrator.helloworld;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.util.jar.Attributes;

public class ZhuCeActivity extends AppCompatActivity {
    EditText mEt01;
    EditText mEt02;
    EditText mEt03;
    Button mRegister;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_zhu_ce);
        mEt01 = findViewById(R.id.et01);
        mEt02 = findViewById(R.id.et02);
        mEt03 = findViewById(R.id.et03);
        mRegister = findViewById(R.id.register);


        mRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String name = mEt01.getText().toString().trim();
                String pass1 = mEt02.getText().toString().trim();
                String pass2 = mEt03.getText().toString().trim();
                Log.i("TAG",name+"_"+""+pass1+""+pass2+"");
                UserService uService = new UserService(ZhuCeActivity.this);
                boolean flag = uService.name(name);
                if (!flag)
                {
                    if((pass1.equals(pass2))==false)
                    {
                        Toast.makeText(ZhuCeActivity.this, "两次密码输入不一致", Toast.LENGTH_SHORT).show();
                        return;

                    }
                    else
                    {
                        Toast.makeText(ZhuCeActivity.this,"注册成功",Toast.LENGTH_SHORT).show();
                        Log.i("TAG",name+""+pass1+""+pass2+"");

                        User user = new User();
                        user.setUsername(name);
                        user.setPassword1(pass1);
                        uService.register(user);
                    }

                Intent intent = new Intent(ZhuCeActivity.this,MainActivity.class);
                startActivity(intent);}
                else {
                    Toast.makeText(ZhuCeActivity.this, "用户已存在", Toast.LENGTH_SHORT).show();
                    return;
                       }
            }
        });


    }

}

