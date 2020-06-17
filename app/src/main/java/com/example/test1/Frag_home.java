package com.example.test1;

import android.graphics.Color;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ListView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import java.util.ArrayList;
import java.util.List;

public class Frag_home<String> extends Fragment {

    ListView listView;
    listAdapter adapter;


    private View view;


    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.frag_home, container, false);

        ArrayList<HomeData> list = new ArrayList<>();
        list.add(new HomeData(0, "방1(남자가 만들었을시)", "소속학교1 / 소속학과1"));
        list.add(new HomeData(1, "방2(여자가 만들었을시)", "소속학교2 / 소속학과2"));
        list.add(new HomeData(0, "방3(남자가 만들었을시)", "소속학교3 / 소속학과3"));
        list.add(new HomeData(1, "방4(여자가 만들었을시)", "소속학교4 / 소속학과4"));
        list.add(new HomeData(0, "방5(남자가 만들었을시)", "소속학교5 / 소속학과5"));

        listView = view.findViewById(R.id.listview);
        adapter = new listAdapter(list);

        listView.setAdapter(adapter);

        return view;
    }

    class listAdapter extends BaseAdapter{
        List<HomeData> lists;

        public listAdapter(List<HomeData> lists) {
            this.lists = lists;
        }

        @Override
        public int getCount() {
            return lists.size();
        }

        @Override
        public Object getItem(int i) {
            return lists.get(i);
        }

        @Override
        public long getItemId(int i) {
            return i;
        }

        @Override
        public View getView(int i, View view, ViewGroup viewGroup) {
            View v = view;
            if(v == null){
                LayoutInflater inflater = (LayoutInflater) getContext().getSystemService(getContext().LAYOUT_INFLATER_SERVICE);
                v = inflater.inflate(R.layout.list_room,null);
            }

            TextView Title = v.findViewById(R.id.title);
            TextView Content = v.findViewById(R.id.content);

            HomeData homeData = lists.get(i);

            Title.setText(homeData.getTitle());
            Content.setText(homeData.getContent());

            if(homeData.getCategory() == 0){
                Title.setBackgroundColor(Color.parseColor("#87CEFA"));
                Content.setBackgroundColor(Color.parseColor("#87CEFA"));
            } else {
                Title.setBackgroundColor(Color.parseColor("#F08080"));
                Content.setBackgroundColor(Color.parseColor("#F08080"));
            }

            return v;
        }
    }
}
