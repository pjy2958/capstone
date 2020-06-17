package com.example.test1;

import android.content.Intent;
import android.os.Bundle;
import android.text.Layout;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.toolbox.Volley;
import com.google.android.material.bottomsheet.BottomSheetDialog;

import org.json.JSONException;
import org.json.JSONObject;

public class RegisterActivity extends AppCompatActivity {

    private EditText et_id, et_pass, et_name, et_age;
    private Button btn_reg;
    private RadioGroup radioGroup;
    private RadioButton rb_man, rb_woman;
    private String result;
    private ImageButton btn_search;
    private TextView tv_uni;

    @Override
    protected void onCreate(Bundle savedInstanceState) { //액티비티 실행시 처음으로 시작
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        //학교찾기
        btn_search = (ImageButton)findViewById(R.id.btn_search);
        tv_uni = (TextView)findViewById(R.id.tv_uni);

        btn_search.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final BottomSheetDialog bottomSheetDialog = new BottomSheetDialog(
                        RegisterActivity.this,R.style.BottomSheetDialogTheme
                );
                View bottomSheetView = LayoutInflater.from(getApplicationContext())
                        .inflate(
                                R.layout.activity_course,
                                (LinearLayout)findViewById(R.id.bottomSheetContainer)
                        );
                bottomSheetView.findViewById(R.id.btn_ok).setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Toast.makeText(RegisterActivity.this,"success",Toast.LENGTH_SHORT).show();
                        bottomSheetDialog.dismiss();
                    }
                });
                bottomSheetDialog.setContentView(bottomSheetView);
                bottomSheetDialog.show();
            }
        });


        //아이디값 찾아주기
        et_id = findViewById(R.id.et_id);
        et_pass = findViewById(R.id.et_pass);
        et_name = findViewById(R.id.et_name);
        et_age = findViewById(R.id.et_age);
        radioGroup = findViewById(R.id.radioGroup);
        rb_woman = findViewById(R.id.rb_woman);
        rb_man = findViewById(R.id.rb_man);
        btn_reg = findViewById(R.id.btn_reg);

        radioGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int i) {
                if(i == R.id.rb_man) {
                    Toast.makeText(RegisterActivity.this, "남자",Toast.LENGTH_SHORT).show();
                    result = rb_man.getText().toString();
                } else if (i == R.id.rb_woman) {
                    Toast.makeText(RegisterActivity.this, "여자",Toast.LENGTH_SHORT).show();
                    result = rb_woman.getText().toString();
                }
            }
        });

        //회원가입 버튼 클릭시 수행
        btn_reg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                //성별 공란 시
                if (result == null) {
                    Toast.makeText(RegisterActivity.this, "성별을 선택해 주세요.", Toast.LENGTH_SHORT).show();
                }

                //현재 입력된 값  get 해오기
                String userID = et_id.getText().toString();
                String userPass = et_pass.getText().toString();
                String userName = et_name.getText().toString();
                int userAge = Integer.parseInt(et_age.getText().toString());
                String userGender = result;

                Response.Listener<String> responseListener = new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        try {
                            JSONObject jsonObject = new JSONObject(response);
                            boolean success = jsonObject.getBoolean("success");
                            if (success) { //회원등록 성공
                                Toast.makeText(getApplicationContext(), "회원등록에 성공하셨습니다.",Toast.LENGTH_SHORT).show();
                                Intent intent = new Intent(RegisterActivity.this, LoginActivity.class);
                                startActivity(intent);
                            } else{ //등록 실패
                                Toast.makeText(getApplicationContext(), "회원등록에 실패하셨습니다.",Toast.LENGTH_SHORT).show();
                                return;
                            }
                        } catch (JSONException e) {
                            e.printStackTrace();
                        }

                    }
                };
                //서버로 volley 이용해 요청함
                RegisterRequest registerRequest = new RegisterRequest(userID, userPass,userName,userAge,userGender,responseListener);
                RequestQueue queue = Volley.newRequestQueue(RegisterActivity.this);
                queue.add(registerRequest);
            }
        });
    }
}