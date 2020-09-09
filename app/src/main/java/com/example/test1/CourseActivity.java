package com.example.test1;

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
        list.add("경희대학교");
        list.add("고려대학교");
        list.add("삼육대학교");
        list.add("삼육보건대학교");
        list.add("서울대학교");
        list.add("서울여자간호대학교");
        list.add("서일대학교");
        list.add("성신여자대학교");
        list.add("연세대학교");
        list.add("이화여자대학교");
        list.add("중앙대학교");
        list.add("한국방송통신대학교");
        list.add("한국성서대학교");
        list.add("한양대학교");
        list.add("KC대학교");
        list.add("경남정보대학교");
        list.add("경성대학교");
        list.add("고신대학교");
        list.add("대동대학교");
        list.add("동명대학교");
        list.add("동서대학교");
        list.add("동의과학대학교");
        list.add("동아대학교");
        list.add("동의대학교");
        list.add("동주대학교");
        list.add("부경대학교");
        list.add("부산가톨릭대학교");
        list.add("부산과학기술대학교");
        list.add("부산대학교");
        list.add("부산여자대학교");
        list.add("신라대학교");
        list.add("인제대학교");
        list.add("가천대(메디컬)");
        list.add("경인여자대학교");
        list.add("인천가톨릭대학교(본교)");
        list.add("인천가톨릭대학교(송도)");
        list.add("인천재능대학교");
        list.add("인하대학교");
        list.add("건양대학교");
        list.add("대전과학기술대학교");
        list.add("대전대학교");
        list.add("대전보건대학교");
        list.add("배재대학교");
        list.add("우송대학교");
        list.add("우송정보대학");
        list.add("을지대학교");
        list.add("한남대학교");
        list.add("경북대학교");
        list.add("계명대학교");
        list.add("계명문화대학교");
        list.add("대구과학대학교");
        list.add("대구보건대학교");
        list.add("수성대학교");
        list.add("영남이공대학교");
        list.add("영진전문대학");
        list.add("울산과학대학교");
        list.add("울산대학교");
        list.add("춘해보건대학교");
        list.add("광주대학교");
        list.add("광주보건대학교");
        list.add("광주여자대학교");
        list.add("기독간호대학교");
        list.add("남부대학교");
        list.add("동강대학교");
        list.add("서영대학교");
        list.add("송원대학교");
        list.add("전남대학교");
        list.add("조선간호대학교");
        list.add("조선대학교");
        list.add("호남대학교");
        list.add("강동대학교");
        list.add("가천대학교");
        list.add("카톨릭대학교");
        list.add("경민대학교");
        list.add("경복대학교");
        list.add("대진대학교");
        list.add("동남보건대학교");
        list.add("두원공과대학교");
        list.add("부천대학교");
        list.add("서정대학교");
        list.add("수원과학대학교");
        list.add("수원대학교");
        list.add("수원여자대학교");
        list.add("신경대학교");
        list.add("신한대학교");
        list.add("아주대학교");
        list.add("안산대학교");
        list.add("여주대학교");
        list.add("용인송담대학교");
        list.add("을지대학교");
        list.add("차의과학대학교");
        list.add("평택대학교");
        list.add("한세대학교");
        list.add("가톨릭관동대학교");
        list.add("강릉영동대학교");
        list.add("강릉원주대학교");
        list.add("강원관광대학교");
        list.add("강원대학교");
        list.add("경동대학교");
        list.add("세경대학교");
        list.add("상지대학교");
        list.add("송곡대학교");
        list.add("송호대학교");
        list.add("연세대학교");
        list.add("한림대학교");
        list.add("한림성심대학교");
        list.add("한중대학교");
        list.add("건국대학교");
        list.add("대원대학교");
        list.add("극동대학교");
        list.add("꽃동네대학교");
        list.add("세명대학교");
        list.add("유원대학교");
        list.add("중원대학교");
        list.add("청주대학교");
        list.add("충북보건과학대학교");
        list.add("충청대학교");
        list.add("한국교통대학교");
        list.add("공주대학교");
        list.add("나사렛대학교");
        list.add("남서울대학교");
        list.add("단국대학교");
        list.add("백석대학교");
        list.add("백석문화대학교");
        list.add("상명대학교");
        list.add("선문대학교");
        list.add("순천향대학교");
        list.add("신성대학교");
        list.add("중부대학교");
        list.add("청운대학교");
        list.add("한서대학교");
        list.add("해전대학교");
        list.add("호서대학교");
        list.add("군산대학교");
        list.add("군산간호대학교");
        list.add("군장대학교");
        list.add("서남대학교");
        list.add("예수대학교");
        list.add("우석대학교");
        list.add("원광대학교");
        list.add("원광보건대학교");
        list.add("전복과학대학교");
        list.add("전북대학교");
        list.add("전주대학교");
        list.add("전주비전대학교");
        list.add("한일장신대학교");
        list.add("호원대학교");
        list.add("광양보건대학교");
        list.add("동신대학교");
        list.add("동아보건대학교");
        list.add("목포과학대학교");
        list.add("목포가톨릭대학교");
        list.add("목포대학교");
        list.add("세한대학교");
        list.add("순천대학교");
        list.add("순천제일대학교");
        list.add("전남과학대학교");
        list.add("청암대학교");
        list.add("초당대학교");
        list.add("한려대학교");
        list.add("한영대학");
        list.add("가톨링상지대학교");
        list.add("경북과학대학교");
        list.add("경북보건대학교");
        list.add("경북전문대학교");
        list.add("경운대학교");
        list.add("경일대학교");
        list.add("경주대학교");
        list.add("구미대학교");
        list.add("김천대학교");
        list.add("대경대학교");
        list.add("대구가톨릭대학");
        list.add("대구대학교");
        list.add("대구한의대학교");
        list.add("동국대학교");
        list.add("동양대학교");
        list.add("문경대학교");
        list.add("서라벌대학교");
        list.add("선린대학교");
        list.add("안동과학대학교");
        list.add("영남외국어대학");
        list.add("위덕대학교");
        list.add("포항대학교");
        list.add("호산대학교");
        list.add("가야대학교");
        list.add("거제대학교");
        list.add("경남과학기술대학교");
        list.add("경남대학교");
        list.add("경상대학교");
        list.add("경남도립거창대학");
        list.add("김해대학교");
        list.add("동원과학기술대학교");
        list.add("마산대학교");
        list.add("부산대학교");
        list.add("영산대학교");
        list.add("진주보건대학교");
        list.add("창신대학교");
        list.add("창원대학교");
        list.add("창원문성대학");
        list.add("한국국제대학교");
        list.add("제주도관광대학교");
        list.add("제주대학교");
        list.add("제주한라대학교");

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
                    Intent intent = new Intent(CourseActivity.this, com.example.test1.RegisterActivity.class);
                    intent.putExtra("userMajor", spinner.getSelectedItem().toString());
                    intent.putExtra("userUniv", u_result);
                    setResult(RESULT_OK,intent);
                    finish();
                }
            }
        });


    }
}