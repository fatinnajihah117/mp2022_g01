package com.example.tranquiltrip;

public class ConfirmBooking {
    public String fullName;
    public String phoneNo;
    public String roomType;
    public String date;
    public String guest;
    public String total;

    public ConfirmBooking(String fullName, String phoneNo, String roomType, String date, String guest, String total) {
        this.fullName = fullName;
        this.phoneNo = phoneNo;
        this.roomType = roomType;
        this.date = date;
        this.guest = guest;
        this.total = total;
    }

    public ConfirmBooking() {
    }

    public String getFullName() {
        return fullName;
    }

    public String getPhoneNo() {
        return phoneNo;
    }

    public String getRoomType() {
        return roomType;
    }

    public String getDate() {
        return date;
    }

    public String getGuest() {
        return guest;
    }

    public String getTotal() {
        return total;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public void setPhoneNo(String phoneNo) {
        this.phoneNo = phoneNo;
    }

    public void setRoomType(String roomType) {
        this.roomType = roomType;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public void setGuest(String guest) {
        this.guest = guest;
    }

    public void setTotal(String total) {
        this.total = total;
    }
}
