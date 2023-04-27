package com.example.android.entities;

public class Locality {

    int localityImgs;
    String localities;

    public Locality() {
    }

    public Locality(int localityImgs, String localities) {
        this.localityImgs = localityImgs;
        this.localities = localities;
    }

    public int getLocalityImgs() {
        return localityImgs;
    }

    public void setLocalityImgs(int localityImgs) {
        this.localityImgs = localityImgs;
    }

    public String getLocalities() {
        return localities;
    }

    public void setLocalities(String localities) {
        this.localities = localities;
    }

    @Override
    public String toString() {
        return "Locality{" +
                "localityImgs=" + localityImgs +
                ", localities='" + localities + '\'' +
                '}';
    }
}
