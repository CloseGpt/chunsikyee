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
import java.net.ServerSocket;
import java.net.Socket;

public class HomeFragment extends Fragment {

    final static int PORT = 10002;
    ServerSocket serverSocket;

    public HomeFragment() {
        // Required empty public constructor
        new Server().execute();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_home, container, false);
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


    private class Server extends AsyncTask<Void,Void,Void> {
        @Override
        protected Void doInBackground(Void... params) {

            while (true){
                try {
                    serverSocket = new ServerSocket(PORT);

                    // 클라이언트와 연결될때까지 대기
                    Socket clientSocket = serverSocket.accept();
                    if (clientSocket == null){
                        Log.v("클라이언트 소켓 수신실패", null);
                    }
                    // 소켓 수신
                    InputStreamReader inputStreamReader = new InputStreamReader(clientSocket.getInputStream());
                    BufferedReader bufferedReader = new BufferedReader(inputStreamReader);

                    String data = bufferedReader.readLine();
                    if (data == null){
                        Log.v("데이터 소켓수신실패", null);
                    }

                        Log.v("소켓수신", data);


                    // 소켓 송신
                    OutputStream out = clientSocket.getOutputStream();
                    byte outputMessage = 1;
                    out.write(outputMessage);
                    out.flush();

                    clientSocket.close();
                    serverSocket.close();
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }

            }

        }
    }


}
