package com.example.android.entities;

import java.io.Serializable;
import java.util.List;

public class Pg implements Serializable {
    int pg_id;
    String name;
    String email;
    String pg_password;
    String pg_mobile;
    String owner_name;
    String locality;
    String address;
    String pg_description;
    String auth_status;
    List<String> images;

    public Pg() {
    }

    public Pg(int pg_id, String name, String email, String pg_password, String pg_mobile, String owner_name, String locality, String address, String pg_description, String auth_status, List<String> images) {
        this.pg_id = pg_id;
        this.name = name;
        this.email = email;
        this.pg_password = pg_password;
        this.pg_mobile = pg_mobile;
        this.owner_name = owner_name;
        this.locality = locality;
        this.address = address;
        this.pg_description = pg_description;
        this.auth_status = auth_status;
        this.images = images;
    }

    public int getPg_id() {
        return pg_id;
    }

    public void setPg_id(int pg_id) {
        this.pg_id = pg_id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPg_password() {
        return pg_password;
    }

    public void setPg_password(String pg_password) {
        this.pg_password = pg_password;
    }

    public String getPg_mobile() {
        return pg_mobile;
    }

    public void setPg_mobile(String pg_mobile) {
        this.pg_mobile = pg_mobile;
    }

    public String getOwner_name() {
        return owner_name;
    }

    public void setOwner_name(String owner_name) {
        this.owner_name = owner_name;
    }

    public String getLocality() {
        return locality;
    }

    public void setLocality(String locality) {
        this.locality = locality;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPg_description() {
        return pg_description;
    }

    public void setPg_description(String pg_description) {
        this.pg_description = pg_description;
    }

    public String getAuth_status() {
        return auth_status;
    }

    public void setAuth_status(String auth_status) {
        this.auth_status = auth_status;
    }

    public List<String> getImage() {
        return images;
    }

    public void setImage(List<String> image) {
        this.images = image;
    }

    @Override
    public String toString() {
        return "Pg{" +
                "pg_id=" + pg_id +
                ", name='" + name + '\'' +
                ", email='" + email + '\'' +
                ", pg_password='" + pg_password + '\'' +
                ", pg_mobile='" + pg_mobile + '\'' +
                ", owner_name='" + owner_name + '\'' +
                ", locality='" + locality + '\'' +
                ", address='" + address + '\'' +
                ", pg_description='" + pg_description + '\'' +
                ", auth_status='" + auth_status + '\'' +
                ", image=" + images +
                '}';
    }
}
