package com.example.chunsik_project;

import android.os.AsyncTask;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import java.io.BufferedReader;
import java.io.IOException;

import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.InetSocketAddress;
import java.net.ServerSocket;
import java.net.Socket;

public class HomeFragment extends Fragment {

    final static int PORT = 5002;
    final static String HOST = "192.168.0.67";
    String user_id;
    String user_pw;

    public HomeFragment() {
        // Required empty public constructor
        new Server().execute();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_home, container, false);
         user_id = this.getArguments().getString("user_id");
         user_pw = this.getArguments().getString("user_pw");

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
                Bundle result = new Bundle();
                result.putString("user_id", user_id);
                result.putString("user_pw", user_pw);

                HomeFragment homeFragment = new HomeFragment();
                homeFragment.setArguments(result);

                FragmentTransaction transaction = getFragmentManager().beginTransaction();
                transaction.replace(R.id.fragment_container, homeFragment);
                transaction.addToBackStack(null); // 이전 프래그먼트로 돌아갈 수 있도록 스택에 추가
                transaction.commit();
            }
        });

        mypageBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Bundle result = new Bundle();
                result.putString("user_id", user_id);
                result.putString("user_pw", user_pw);

                MypageFragment mypageFragment = new MypageFragment();
                mypageFragment.setArguments(result);

                FragmentTransaction transaction = getFragmentManager().beginTransaction();

                transaction.replace(R.id.fragment_container, mypageFragment);
                transaction.addToBackStack(null); // 이전 프래그먼트로 돌아갈 수 있도록 스택에 추가
                transaction.commit();
            }
        });

        ticketBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Bundle result = new Bundle();
                result.putString("user_id", user_id);
                result.putString("user_pw", user_pw);

                TicketBoxFragment ticketBoxFragment = new TicketBoxFragment();
                ticketBoxFragment.setArguments(result);

                FragmentTransaction transaction = getFragmentManager().beginTransaction();
                transaction.replace(R.id.fragment_container,  ticketBoxFragment);
                transaction.addToBackStack(null); // 이전 프래그먼트로 돌아갈 수 있도록 스택에 추가
                transaction.commit();
            }
        });
    }


    private class Server extends AsyncTask<Void,Void,Void> {
        @Override
        protected Void doInBackground(Void... params) {

            while (true){
                try (Socket clientSocket = new Socket(HOST,PORT)){

                    Log.w("서버 연결여부 : ", "서버 연결됨");


                    // String 값 소켓 수신
                    BufferedReader reader = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
                    String result = reader.readLine();
                    Log.w("결과 값 소켓 수신", result);

                    // byte 값 소켓 송신
                    byte hasTicket = 0;
                    OutputStream out = clientSocket.getOutputStream();
                    out.write(hasTicket);
                    out.flush();
                    Log.w("데이터 소켓 송신","완료");


                } catch (IOException e) {
                    throw new RuntimeException(e);
                }

            }

        }
    }


}
