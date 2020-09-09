package com.example.test1;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AlertDialog;
import androidx.fragment.app.Fragment;

public class Frag_my extends Fragment {
    private View view;
    private TextView tv_iid, tv_name, tv_univ, tv_major;
    User user = new User();

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.frag_my, container, false);
        user = ((LoginActivity)LoginActivity.mcontext).user;

        tv_iid = view.findViewById(R.id.tv_iid);
        tv_name = view.findViewById(R.id.tv_name);
        tv_univ = view.findViewById(R.id.tv_univ);
        tv_major = view.findViewById(R.id.tv_major);

    /*    if (tv_iid == ){
            return view;}
*/

        tv_iid.setText(user.getUserID());
        tv_name.setText(user.getUserName());
        tv_univ.setText(user.getUserUniv());
        tv_major.setText(user.getUserMajor());
        return view;
    }
}
