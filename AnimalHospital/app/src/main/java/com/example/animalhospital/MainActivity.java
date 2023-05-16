package com.example.animalhospital;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    Button btn_login;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btn_login = findViewById(R.id.btn_login);
        btn_login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //Toast.makeText(MainActivity.this, "로그인 버튼 클릭", Toast.LENGTH_SHORT).show();
                //아이디 : 30311, 패스워드 : 1234567890
                EditText userid, passwd;
                userid = findViewById(R.id.userid);
                passwd = findViewById(R.id.passwd);
                String str_userid = userid.getText().toString();
                String str_passwd = passwd.getText().toString();
                Log.d("MSG", str_userid);
                Log.d("MSG", str_passwd);

                if(str_userid.length() != 5){
                    Toast.makeText(MainActivity.this, "아이디는 5자리로 입력해주세요", Toast.LENGTH_SHORT).show();
                    return;
                }
                else if(str_passwd.length() < 4 || str_passwd.length() > 12) {
                    Toast.makeText(MainActivity.this, "비밀번호는 9~12자리로 입력해주세요", Toast.LENGTH_SHORT).show();
                    return;
                }
                else if(str_userid.equals("30311") && str_passwd.equals("1234567890")){
                    Toast.makeText(MainActivity.this, "환영합니다.", Toast.LENGTH_SHORT).show();
                    //다음화면으로 이동
                }
                else{
                    Toast.makeText(MainActivity.this, "다시 입력하세요.", Toast.LENGTH_SHORT).show();
                    return;
                }
            }
        });

        //간략하게 쓰기
        findViewById(R.id.btn_info).setOnClickListener(this);
        findViewById(R.id.btn_guide).setOnClickListener(this);
        findViewById(R.id.btn_call).setOnClickListener(this);
        findViewById(R.id.btn_shop).setOnClickListener(this);
    }


    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.btn_info:
                Intent intent = new Intent(MainActivity.this, InfoActivity.class);
                intent.putExtra("title", "안전하고 깨끗한 의료시설");
                startActivity(intent);
                break;
            case R.id.btn_guide:
                Intent intent1 = new Intent(MainActivity.this, GuideActivity.class);
                startActivity(intent1);
                break;
            case R.id.btn_call:
                Intent intent2 = new Intent(MainActivity.this, CallActivity.class);
                startActivity(intent2);
                break;
            case R.id.btn_shop:
                Intent intent3 = new Intent(MainActivity.this, ShopActivity.class);
                startActivity(intent3);
                break;
        }
    }
}