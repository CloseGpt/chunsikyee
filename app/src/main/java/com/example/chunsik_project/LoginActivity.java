package com.example.chunsik_project;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.activity.ComponentActivity;
import androidx.annotation.Nullable;

public class LoginActivity extends ComponentActivity {

    EditText login_id;
    EditText login_pw;
    Button login_btn;
    Button signup_text;

    SqlHelper sqlHelper;
    SQLiteDatabase sqlDB;
    Cursor cursor;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.login_activity);

        login_id = findViewById(R.id.login_ID);
        login_pw = findViewById(R.id.login_PassWord);
        login_btn = findViewById(R.id.login_Button);
        signup_text = findViewById(R.id.signup_Text);

        sqlHelper = new SqlHelper(getApplicationContext());

        login_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                sqlDB = sqlHelper.getReadableDatabase();
                String input_id = login_id.getText().toString();
                String input_pw = login_pw.getText().toString();

                cursor = sqlDB.rawQuery("select * from Users;", null);

                while (cursor.moveToNext()) {
                    if (cursor.getString(0) == input_id && cursor.getString(1) == input_pw) {
                        Intent homeIntent = new Intent(getApplicationContext(), HomeFragment.class);
                        homeIntent.putExtra("user_id", input_id);
                        homeIntent.putExtra("user_pw", input_pw);

                        startActivity(homeIntent);
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
