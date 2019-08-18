package com.example.administrator.helloworld;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class WangMiActivity extends AppCompatActivity {
    EditText mEt01;
    EditText mEt02;
    EditText mEt03;
    Button mLogin;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_wang_mi);
        mEt01 = findViewById(R.id.et01);
        mEt02 = findViewById(R.id.et02);
        mEt03 = findViewById(R.id.et03);
        mLogin = findViewById(R.id.btn_login);
        mLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String name = mEt01.getText().toString();
                String pass1 = mEt02.getText().toString().trim();
                String pass2 = mEt03.getText().toString().trim();
                Log.i("TAG",name+"_"+""+pass1+""+pass2+"");
                UserService uService = new UserService(WangMiActivity.this);
                boolean flag = uService.name(name);
                if (flag)
                {

                    if((pass1.equals(pass2))==false)
                    {
                        Toast.makeText(WangMiActivity.this, "两次密码输入不一致", Toast.LENGTH_SHORT).show();
                        return;

                    }
                    else
                    {

                        uService.update(name,pass1);
                        Toast.makeText(WangMiActivity.this,"修改成功",Toast.LENGTH_SHORT).show();
                    }
                }
                else
                    {
                        Toast.makeText(WangMiActivity.this, "无此用户", Toast.LENGTH_SHORT).show();
                        return;
                    }

                Intent intent = new Intent(WangMiActivity.this,MainActivity.class);
                startActivity(intent);
            }
        });
    }
}
