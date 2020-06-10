package com.example.myapplication;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import androidx.appcompat.app.AppCompatActivity;

public class CourseActivity extends AppCompatActivity {

    private Spinner Areaspinner;
    private Spinner Univspinner;
    private Spinner Majorspinner;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_course);

        Areaspinner = (Spinner)findViewById(R.id.spinner);
        Univspinner = (Spinner)findViewById(R.id.spinner2);
        Majorspinner = (Spinner)findViewById(R.id.spinner3);

        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this, R.array.Area, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        Areaspinner.setAdapter(adapter);

        Areaspinner.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String str_season = Areaspinner.getSelectedItem().toString();
                Intent it3 = new Intent(CourseActivity.this,RegisterActivity.class);
                it3.putExtra("it3_season", str_season);//it3_season 이라는 스트링으로 str_season 값을 넘긴다.
                startActivity(it3);

            }

        });


    }
}