package com.example.chunsik_project;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import androidx.appcompat.app.AppCompatActivity;

public class MyInfo extends AppCompatActivity {
    private EditText inName, inParty, inNumber;
    private Button btnSave, btnLogout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.fragment_my_info);

        // XML 레이아웃에서 각 뷰 요소들을 찾아옵니다.
        inName = findViewById(R.id.myInfo_inName);
        inParty = findViewById(R.id.myInfo_inParty);
        inNumber = findViewById(R.id.myInfo_inNumber);
        btnSave = findViewById(R.id.myInfo_save);
        btnLogout = findViewById(R.id.logOutBtn);

        // 저장 버튼 클릭 시 동작을 정의합니다.
        btnSave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                saveInfo();
            }
        });

        // 로그아웃 버튼 클릭 시 동작을 정의합니다.
        btnLogout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                logout();
            }
        });
    }

    // 정보를 저장하는 메소드입니다.
    private void saveInfo() {
        String name = inName.getText().toString();
        String party = inParty.getText().toString();
        String number = inNumber.getText().toString();

        // TODO: 입력된 정보를 저장하는 로직을 구현합니다.
        // 예를 들어, 데이터베이스에 저장하는 등의 동작을 수행할 수 있습니다.
    }

    // 로그아웃을 처리하는 메소드입니다.
    private void logout() {
        // TODO: 로그아웃 동작을 구현합니다.
        // 예를 들어, 로그인 세션을 종료하고 로그인 화면으로 이동하는 등의 동작을 수행할 수 있습니다.
    }
}
