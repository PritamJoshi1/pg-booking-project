package com.example.android.entities;

public class Amenities {
    Integer amLogo;
    String amName;

    public Amenities(Integer amLogo, String amName) {
        this.amLogo = amLogo;
        this.amName = amName;
    }

    public Integer getAmLogo() {
        return amLogo;
    }

    public void setAmLogo(Integer amLogo) {
        this.amLogo = amLogo;
    }

    public String getAmName() {
        return amName;
    }

    public void setAmName(String amName) {
        this.amName = amName;
    }
}
