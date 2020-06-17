package com.example.test1;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

    public class CustomRoomAdapter extends RecyclerView.Adapter<CustomRoomAdapter.CustomViewHolder> {
        private ArrayList<Room> arrayList;
        private Context context;

    public CustomRoomAdapter(ArrayList<Room> arrayList, Context context) {
        this.arrayList = arrayList;
        this.context = context;
    }

    @NonNull
    @Override
    public CustomViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.room_item, parent, false);
        CustomViewHolder holder = new CustomViewHolder(view);
        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull CustomViewHolder holder, int position) {
        holder.tv_roomtitle.setText(arrayList.get(position).getRoomname());
    }

    @Override
    public int getItemCount() {
        return (arrayList != null ? arrayList.size() : 0);
    }

    public class CustomViewHolder extends RecyclerView.ViewHolder {
        TextView tv_roomtitle;
        Button enter_room;
        Button exit_room;

        public CustomViewHolder(@NonNull View itemView) {
            super(itemView);
            this.tv_roomtitle = itemView.findViewById(R.id.roomtitle);
            this.enter_room = itemView.findViewById(R.id.enter_room);
            this.exit_room = itemView.findViewById(R.id.exit_room);
        }
    }
}
