package com.HsgsStudent.Data;

import java.util.ArrayList;

public class Data {
    private String firstname;
    private ArrayList<String> midname;
    private String lastname;
    private String day;
    private String month;
    private String year;
    private String lop;
    private String hechuyen;

    public String convertListtoString(ArrayList<String> listname) {
        StringBuilder s = new StringBuilder();
        for (int i = 0; i < listname.size(); i++) {
            if (i != listname.size() - 1) {
                s.append(listname.get(i)).append(" ");
            } else {
                s.append(listname.get(i));
            }
        }
        return s.toString();
    }

    public String getFirstname() {
        return firstname;
    }

    public ArrayList<String> getMidname() {
        return midname;
    }

    public String getLastname() {
        return lastname;
    }

    public String getDay() {
        return day;
    }

    public String getMonth() {
        return month;
    }

    public String getYear() {
        return year;
    }

    public String getLop() {
        return lop;
    }

    public String getHechuyen() {
        return hechuyen;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public void setMidname(ArrayList<String> midname) {
        this.midname = midname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public void setDay(String day) {
        this.day = day;
    }

    public void setMonth(String month) {
        this.month = month;
    }

    public void setYear(String year) {
        this.year = year;
    }

    public void setLop(String lop) {
        this.lop = lop;
    }

    public void setHechuyen(String hechuyen) {
        this.hechuyen = hechuyen;
    }
}