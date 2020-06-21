package com.example.test1;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;
import android.view.MenuItem;
import android.widget.ListView;

import com.google.android.material.bottomnavigation.BottomNavigationView;

public class MainActivity extends AppCompatActivity {
    private ListView list;
    private BottomNavigationView bottomNavigationView;
    private FragmentManager fm;
    private FragmentTransaction ft;
    private Frag_home frag_home;
    private Frag_search frag_search;
    private Frag_room frag_room;
    private Frag_friend frag_friend;
    private Frag_my frag_my;
    private CustomDialog customdialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        bottomNavigationView = findViewById(R.id.bottomNavi);
        bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
                switch (menuItem.getItemId()){
                    case R.id.home:
                    setFrag(0);
                    break;

                    case R.id.search:
                        setFrag(1);
                        break;

                    case R.id.room:
                        customdialog = new CustomDialog(MainActivity.this);
                        customdialog.callFunction();
                        setFrag(2);
                        break;

                    case R.id.friend:
                        setFrag(3);
                        break;

                    case R.id.my:
                        setFrag(4);
                        break;
                }
                return true;
            }
        });
        frag_home = new Frag_home();
        frag_search = new Frag_search();
        frag_room = new Frag_room();
        frag_friend = new Frag_friend();
        frag_my = new Frag_my();
        setFrag(0); //첫 프래그먼트 화면 무엇으로 지정할것인지 선택
    }
    //프래그먼트 교체 실행문
    private void setFrag(int n){
        fm = getSupportFragmentManager();
        ft = fm.beginTransaction();

        switch(n){
            case 0:
                ft.replace(R.id.main_frame, frag_room);
                ft.commit();
                break;

            case 1:
                ft.replace(R.id.main_frame, frag_search);
                ft.commit();
                break;
            case 2:
                ft.replace(R.id.main_frame, frag_room);
                ft.commit();
                break;

            case 3:
                ft.replace(R.id.main_frame, frag_friend);
                ft.commit();
                break;

            case 4:
                ft.replace(R.id.main_frame, frag_my);
                ft.commit();
                break;
        }
    }

}
