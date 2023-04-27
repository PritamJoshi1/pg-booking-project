package com.example.android.entities;

public class Customers {
    int c_id;
    String c_name;
    String email;
    String c_password;
    String c_mobile;
    String c_emergency_mobile;
    String c_gender;
    String c_address;
    String c_occupation;


    public Customers() {
    }

    public Customers(int c_id, String c_name, String email, String c_password, String c_mobile, String c_emergency_mobile, String c_gender, String c_address, String c_occupation) {
        this.c_id = c_id;
        this.c_name = c_name;
        this.email = email;
        this.c_password = c_password;
        this.c_mobile = c_mobile;
        this.c_emergency_mobile = c_emergency_mobile;
        this.c_gender = c_gender;
        this.c_address = c_address;
        this.c_occupation = c_occupation;
    }

    public int getC_id() {
        return c_id;
    }

    public void setC_id(int c_id) {
        this.c_id = c_id;
    }

    public String getC_name() {
        return c_name;
    }

    public void setC_name(String c_name) {
        this.c_name = c_name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getC_password() {
        return c_password;
    }

    public void setC_password(String c_password) {
        this.c_password = c_password;
    }

    public String getC_mobile() {
        return c_mobile;
    }

    public void setC_mobile(String c_mobile) {
        this.c_mobile = c_mobile;
    }

    public String getC_emergency_mobile() {
        return c_emergency_mobile;
    }

    public void setC_emergency_mobile(String c_emergency_mobile) {
        this.c_emergency_mobile = c_emergency_mobile;
    }

    public String getC_gender() {
        return c_gender;
    }

    public void setC_gender(String c_gender) {
        this.c_gender = c_gender;
    }

    public String getC_address() {
        return c_address;
    }

    public void setC_address(String c_address) {
        this.c_address = c_address;
    }

    public String getC_occupation() {
        return c_occupation;
    }

    public void setC_occupation(String c_occupation) {
        this.c_occupation = c_occupation;
    }

    @Override
    public String toString() {
        return "Customers{" +
                "c_id=" + c_id +
                ", c_name='" + c_name + '\'' +
                ", email='" + email + '\'' +
                ", c_password='" + c_password + '\'' +
                ", c_mobile='" + c_mobile + '\'' +
                ", c_emergency_mobile='" + c_emergency_mobile + '\'' +
                ", c_gender='" + c_gender + '\'' +
                ", c_address='" + c_address + '\'' +
                ", c_occupation='" + c_occupation + '\'' +
                '}';
    }
}




