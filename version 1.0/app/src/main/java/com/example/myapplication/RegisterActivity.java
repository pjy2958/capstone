package com.example.myapplication;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.toolbox.Volley;

import org.json.JSONException;
import org.json.JSONObject;

public class RegisterActivity extends AppCompatActivity {

    private EditText et_id, et_pass, et_name, et_age;
    private Button btn_reg;

    @Override
    protected void onCreate(Bundle savedInstanceState) { //액티비티 실행시 처음으로 시작
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        //아이디값 찾아주기
        et_id = findViewById(R.id.et_id);
        et_pass = findViewById(R.id.et_pass);
        et_name = findViewById(R.id.et_name);
        et_age = findViewById(R.id.et_age);

        //회원가입 버튼 클릭시 수행
        btn_reg = findViewById(R.id.btn_reg);
        btn_reg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //현재 입력된 값  get 해오기
                String userID = et_id.getText().toString();
                String userPass = et_pass.getText().toString();
                String userName = et_name.getText().toString();
                int userAge = Integer.parseInt(et_age.getText().toString());

                Response.Listener<String> responseListener = new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        try {
                            JSONObject jsonObject = new JSONObject(response);
                            boolean success = jsonObject.getBoolean("success");
                            if (success) { //회원등록 성공
                                Toast.makeText(getApplicationContext(), "회원등록에 성공하셨습니다.",Toast.LENGTH_SHORT).show();
                                //Intent intent = new Intent(RegisterActivity.this, LoginActivity.class)
                                //startActivity(intent);
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
                RegisterRequest registerRequest = new RegisterRequest(userID, userPass,userName,userAge,responseListener);
                RequestQueue queue = Volley.newRequestQueue(RegisterActivity.this);
                queue.add(registerRequest);
            }
        });
    }
}
