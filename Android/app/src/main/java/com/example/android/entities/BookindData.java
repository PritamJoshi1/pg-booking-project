package com.example.android.entities;

import java.util.Date;

public class BookindData {
    int pg_id;
    int c_id;
    Date movinn_date;
    String photo_id;

    public BookindData() {

    }

    public BookindData(int pg_id, int c_id) {
        this.pg_id = pg_id;
        this.c_id = c_id;
    }

    public BookindData(int pg_id, int c_id, Date movinn_date, String photo_id) {
        this.pg_id = pg_id;
        this.c_id = c_id;
        this.movinn_date = movinn_date;
        this.photo_id = photo_id;
    }

    public int getPg_id() {
        return pg_id;
    }

    public void setPg_id(int pg_id) {
        this.pg_id = pg_id;
    }

    public int getC_id() {
        return c_id;
    }

    public void setC_id(int c_id) {
        this.c_id = c_id;
    }

    public Date getMovinn_date() {
        return movinn_date;
    }

    public void setMovinn_date(Date movinn_date) {
        this.movinn_date = movinn_date;
    }

    public String getPhoto_id() {
        return photo_id;
    }

    public void setPhoto_id(String photo_id) {
        this.photo_id = photo_id;
    }

    @Override
    public String toString() {
        return "BookindData{" +
                "pg_id=" + pg_id +
                ", c_id=" + c_id +
                ", movinn_date=" + movinn_date +
                ", photo_id='" + photo_id + '\'' +
                '}';
    }
}
