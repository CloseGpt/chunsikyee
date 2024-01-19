package com.example.chunsik_project;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

public class MypageFragment extends Fragment {

    private Button ableTicketBtn;
    private Button usedTicketBtn;
    private Button userInfoBtn;
    private Button notiSettingBtn;
    private Button csBtn;
    private SqlHelper sqlHelper;
    private SQLiteDatabase sqlDB;
    private String user_id;
    private TextView user_name;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_mypage, container, false);

        ableTicketBtn = view.findViewById(R.id.ableTicketBtn);
        usedTicketBtn = view.findViewById(R.id.usedTicketBtn);
        userInfoBtn = view.findViewById(R.id.userInfoBtn);
        notiSettingBtn = view.findViewById(R.id.notiSetting);
        csBtn = view.findViewById(R.id.csBtn);
        user_name = view.findViewById(R.id.user_name);

        sqlHelper = new SqlHelper(getContext());
        sqlDB = sqlHelper.getReadableDatabase();
        user_id = this.getArguments().getString("user_id");
        String used_ticket = "";
        String able_ticket = "";

        String select_sql = String.format("select used_ticket, remain_ticket, user_name from Users where user_id = '%s'", user_id);
        Cursor cursor = sqlDB.rawQuery(select_sql, null);
        while (cursor.moveToNext()){

            usedTicketBtn.setText("  " + cursor.getString(0) + " 장");
            ableTicketBtn.setText("  " + cursor.getString(1) + " 장");
            user_name.setText(cursor.getString(2));

        }
        // 버튼에 대한 OnClickListener 설정
        ableTicketBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // remainingTickets 변수가 실제로 남은 티켓 수를 보유하는 정수 변수라고 가정합니다.
                //int remainingTickets = getRemainingTickets(); // 실제 로직으로 대체하세요.
                String message = "남은 식권은 " + "       " + "개 입니다.";
                Toast.makeText(getActivity(), message, Toast.LENGTH_SHORT).show();
            }
        });



        usedTicketBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //int remainingTickets = getRemainingTickets(); // 실제 로직으로 대체하세요.
                String message = "사용된 식권은 " + "usedTickets" + "개 입니다.";
                Toast.makeText(getActivity(), message, Toast.LENGTH_SHORT).show();
            }
        });

        userInfoBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String message = "내 정보 실행";
                Toast.makeText(getActivity(), message, Toast.LENGTH_SHORT).show();
            }
        });

        notiSettingBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String message = "알림 설정";
                Toast.makeText(getActivity(), message, Toast.LENGTH_SHORT).show();
            }
        });

        csBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String message = "고객센터 실행";
                Toast.makeText(getActivity(), message, Toast.LENGTH_SHORT).show();
            }
        });

        // 인플레이트된 뷰 반환
        return view;
    }
    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        ImageButton homeBtn = view.findViewById(R.id.homeBtn);
        ImageButton mypageBtn = view.findViewById(R.id.mypageBtn);
        ImageButton ticketBtn = view.findViewById(R.id.ticketBtn);

        homeBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                FragmentTransaction transaction = getFragmentManager().beginTransaction();
                transaction.replace(R.id.fragment_container, new HomeFragment());
                transaction.addToBackStack(null); // 이전 프래그먼트로 돌아갈 수 있도록 스택에 추가
                transaction.commit();
            }
        });

        mypageBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                FragmentTransaction transaction = getFragmentManager().beginTransaction();
                transaction.replace(R.id.fragment_container, new MypageFragment());
                transaction.addToBackStack(null); // 이전 프래그먼트로 돌아갈 수 있도록 스택에 추가
                transaction.commit();
            }
        });

        ticketBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                FragmentTransaction transaction = getFragmentManager().beginTransaction();
                transaction.replace(R.id.fragment_container, new TicketBoxFragment());
                transaction.addToBackStack(null); // 이전 프래그먼트로 돌아갈 수 있도록 스택에 추가
                transaction.commit();
            }
        });
    }
}
