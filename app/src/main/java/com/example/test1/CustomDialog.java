package com.example.test1;

import android.app.Dialog;
import android.content.Context;
import android.graphics.Point;
import android.graphics.drawable.ColorDrawable;
import android.view.Display;
import android.view.View;
import android.view.Window;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;

import androidx.annotation.NonNull;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class CustomDialog extends Dialog {
    private Context mcontext;
    private ListView listView;
    private ArrayAdapter arrayAdapter;
    private FirebaseDatabase database;
    private DatabaseReference databaseReference;
    private String strcount;
    private static Integer count = 0;
    static final String[] list_menu = {"1 : 1", "2 : 2", "3 : 3", "4 : 4"};

    public CustomDialog(@NonNull Context context){
        super(context);
        mcontext = context;
    }
    public void callFunction(){
        final Dialog dig = new Dialog(mcontext);
        dig.setContentView(R.layout.custom_room_dialog);
        arrayAdapter = new ArrayAdapter(getContext(), android.R.layout.simple_list_item_1, list_menu);
        listView = (ListView) dig.findViewById(R.id.list);
        listView.setAdapter(arrayAdapter);

        Display display = getWindow().getWindowManager().getDefaultDisplay();
        Point size = new Point();
        display.getSize(size);
        Window window = dig.getWindow();
        int x = (int)(size.x * 0.8f);
        int y = (int)(size.y * 0.7f);
        dig .getWindow().setBackgroundDrawable(new ColorDrawable(android.graphics.Color.TRANSPARENT));
        window.setLayout(x, y);
        dig.show();
        database = FirebaseDatabase.getInstance();
        databaseReference = database.getReference("Room");
        final EditText editText = (EditText) dig.findViewById(R.id.edit_roomname);
        final Button makeroom = (Button) dig.findViewById(R.id.makeroom);
        makeroom.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                count ++;
                strcount = Integer.toString(count);
                Room room = new Room(editText.getText().toString());
                databaseReference.child("Room"+count).setValue(room);
                dig.dismiss();
            }
        });
        final Button exit = (Button) dig.findViewById(R.id.exit);
        exit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dig.dismiss();
            }
        });
    }
}