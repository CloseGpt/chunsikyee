package com.example.chunsik_project;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.activity.ComponentActivity;
import androidx.annotation.Nullable;

public class SignUpActivity extends ComponentActivity {

    EditText signup_name;
    EditText signup_party;
    EditText signup_sNum;
    EditText signup_id;
    EditText signup_pw;
    Button signup_btn;

    SqlHelper sqlHelper;
    SQLiteDatabase sqlDB;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.signup);
        signup_btn = findViewById(R.id.signup_Button);
        signup_id = findViewById(R.id.signup_id);
        signup_pw = findViewById(R.id.signup_pw);
        signup_sNum = findViewById(R.id.signup_sNum);
        signup_name = findViewById(R.id.signup_name);
        signup_party = findViewById(R.id.signup_party);

        sqlHelper = new SqlHelper(getApplicationContext());


        signup_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                sqlDB = sqlHelper.getWritableDatabase();
                sqlDB.execSQL("INSERT INTO Users(user_id, user_pw, user_name, user_uid, isAdmin, user_organization) VALUES (" +
                        "'" + signup_id.getText().toString() + "'," +
                        "'" + signup_pw.getText().toString() + "'," +
                        "'" + signup_name.getText().toString() + "'," +
                        "'" + signup_sNum.getText().toString() + "'," +
                        "0," +
                        "'" + signup_party.getText().toString() + "')");
                Intent loginIntent = new Intent(getApplicationContext(), LoginActivity.class);
                startActivity(loginIntent);

                //test code
//                SQLiteDatabase temp = sqlHelper.getReadableDatabase();
//                Cursor cursor = temp.rawQuery("select user_id from Users", null);
//                while (cursor.moveToNext()){
//                    Toast.makeText(getApplicationContext(), cursor.getString(0), Toast.LENGTH_SHORT).show();
//                }

                sqlDB.close();
            }
        });



    }
}
