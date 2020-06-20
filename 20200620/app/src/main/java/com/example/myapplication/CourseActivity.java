package com.example.myapplication;

import android.annotation.SuppressLint;
import android.content.ContentValues;
import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ListView;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;

public class CourseActivity extends AppCompatActivity {

    ListView listview = null;
    private Spinner spinner;
    private TextView tv_result;
    private ImageButton btn_ok;
    private String u_result;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_course);

        final ArrayList<String> list = new ArrayList<String>();
        list.add("충북대학교");
        list.add("충남대학교");
        list.add("청주대학교");
        list.add("충청대학교");

        final ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1,list);
        listview = findViewById(R.id.listview1);
        listview.setAdapter(adapter);

        EditText editTextFilter = findViewById(R.id.editTextFilter);
        editTextFilter.addTextChangedListener(new TextWatcher() {

            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
            }

            @Override
                public void afterTextChanged(Editable edit) {
                    String filterText = edit.toString() ;
                    if (filterText.length() > 0) {
                        listview.setFilterText(filterText) ;
                    } else {
                        listview.clearTextFilter() ;
                    }
            }
        });

    listview. setOnItemClickListener(new AdapterView.OnItemClickListener() {
        @Override
        public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
            Toast.makeText(CourseActivity.this ,list.get(position),Toast.LENGTH_LONG).show();
            u_result = list.get(position).toString();
        }
    });



    spinner= findViewById(R.id.spinner);
    spinner.setPrompt("학과선택");
    tv_result= findViewById(R.id.tv_result);
    btn_ok=findViewById(R.id.btn_ok);

    spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
        @Override
        public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
            tv_result.setText(parent.getItemAtPosition(position).toString());
        }

        @Override
        public void onNothingSelected(AdapterView<?> parent) {

        }
    });

    btn_ok.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            if (tv_result != null) {
                Intent intent = new Intent(CourseActivity.this, RegisterActivity.class);
                intent.putExtra("userMajor", spinner.getSelectedItem().toString());
                intent.putExtra("userUniv", u_result);
                setResult(RESULT_OK,intent);
                finish();
            }
        }
    });


    }
}
