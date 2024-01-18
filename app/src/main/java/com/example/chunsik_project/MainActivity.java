package com.example.chunsik_project;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentTransaction;

import android.content.Intent;
import android.os.Bundle;

public class MainActivity extends AppCompatActivity {

    Intent intent;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        intent = getIntent();
        String user_id = intent.getStringExtra("user_id");
        String user_pw = intent.getStringExtra("user_pw");


        Bundle result = new Bundle();
        result.putString("user_id", user_id);
        result.putString("user_pw", user_pw);

        // HomeFragment 인스턴스 생성
        HomeFragment homeFragment = new HomeFragment();

        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
        homeFragment.setArguments(result);

        transaction.replace(R.id.fragment_container, homeFragment);
        transaction.commit();


    }
}
