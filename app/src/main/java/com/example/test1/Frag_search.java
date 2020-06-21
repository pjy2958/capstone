package com.example.test1;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.Spinner;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import org.w3c.dom.Text;

public class Frag_search extends Fragment {
    private View view;


    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.frag_search, container, false);
//
//        super.onCreate(savedInstanceState);
//
//        final TextView result_room_name = (TextView) view.findViewById(R.id.result_room_name);
//        final TextView result_area = (TextView) view.findViewById(R.id.result_area);
//        final TextView result_univ = (TextView) view.findViewById(R.id.result_univ);
//        final TextView result_course = (TextView) view.findViewById(R.id.result_course);
//
//        ImageButton search_search = (ImageButton) view.findViewById(R.id.search_search);
//        Button gum_saek = (Button) view.findViewById(R.id.gum_saek);
//
//        search_search.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                CustomDialog customDialog = new CustomDialog(getActivity());
//                customDialog.callFunction(result_room_name);
//            }
//        });
        return view;
    }
}
