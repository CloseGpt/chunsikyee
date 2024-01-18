package com.example.chunsik_project;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;

public class LoginActivity extends AppCompatActivity {

    EditText login_id;
    EditText login_pw;
    Button login_btn;
    Button signup_text;

    SqlHelper sqlHelper;
    SQLiteDatabase sqlDB;
    Cursor cursor;

    @Override
    public void onCreate( Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        login_id = findViewById(R.id.login_ID);
        login_pw = findViewById(R.id.login_PassWord);
        login_btn = findViewById(R.id.login_Button);
        signup_text = findViewById(R.id.signup_Btn);

        sqlHelper = new SqlHelper(getApplicationContext());

        login_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                sqlDB = sqlHelper.getReadableDatabase();
                String input_id = login_id.getText().toString();
                String input_pw = login_pw.getText().toString();

                cursor = sqlDB.rawQuery("select * from Users;", null);

                while (cursor.moveToNext()) {

                    if (cursor.getString(1).equals(input_id) && cursor.getString(2).equals(input_pw)) {

                        Intent naviIntent = new Intent(getApplicationContext(), NaviActivity.class);//김택준:NaviActivity->HomeFragment
                        naviIntent.putExtra("user_id", input_id);
                        naviIntent.putExtra("user_pw", input_pw);

                        Toast.makeText(getApplicationContext(), "로그인 성공", Toast.LENGTH_SHORT).show();

                        startActivity(naviIntent);
                        sqlDB.close();
                        break;
                    }

                }

            }
        });

        signup_text.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent signupIntent = new Intent(getApplicationContext(), SignUpActivity.class);
                startActivity(signupIntent);
            }
        });
    }
}

