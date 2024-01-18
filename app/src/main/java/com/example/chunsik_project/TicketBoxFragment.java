package com.example.chunsik_project;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageButton;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

public class TicketBoxFragment extends Fragment {

    private Button ticketOp1Btn;
    private Button ticketOp2Btn;
    private Button ticketOp3Btn;
    private Button buyBtn;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_ticket_box, container, false);

        ticketOp1Btn = view.findViewById(R.id.ticketOp1Btn);
        ticketOp2Btn = view.findViewById(R.id.ticketOp2Btn);
        ticketOp3Btn = view.findViewById(R.id.ticketOp3Btn);
        buyBtn = view.findViewById(R.id.buyBtn);

        ticketOp1Btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // ticketOp1Btn 클릭 이벤트 처리
                // 원하는 동작을 여기에 추가하세요.
            }
        });

        ticketOp2Btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // ticketOp2Btn 클릭 이벤트 처리
                // 원하는 동작을 여기에 추가하세요.
            }
        });

        ticketOp3Btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // ticketOp3Btn 클릭 이벤트 처리
                // 원하는 동작을 여기에 추가하세요.
            }
        });

        buyBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // buyBtn 클릭 이벤트 처리
                // 원하는 동작을 여기에 추가하세요.
            }
        });

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
