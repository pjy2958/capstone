package com.example.test1;

public class Room {
    private String roomname;

    public Room(){ }
    public Room(String roomname){
        this.roomname = roomname;
    }


    public String getRoomname() {
        return roomname;
    }

    public void setRoomname(String roomname) {
        this.roomname = roomname;
    }
}
