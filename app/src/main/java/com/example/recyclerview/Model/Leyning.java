package com.example.recyclerview.Model;

import com.google.gson.annotations.SerializedName;

public class Leyning {

    private String torah;
    @SerializedName("1")
        private String un;
    @SerializedName("2")
        private String deux;
    @SerializedName("3")
        private String trois;
    @SerializedName("4")
        private String quatre;
    @SerializedName("5")
        private String cinq;
    @SerializedName("6")
        private String six;
    @SerializedName("7")
        private String sept;

    private String maftir;
    private String haftarah;

    //Les Getters
    public String getTorah() { return torah; }
    public String getUn() { return un; }
    public String getDeux() { return deux; }
    public String getTrois() { return trois; }
    public String getQuatre() { return quatre; }
    public String getCinq() { return cinq; }
    public String getSix() { return six; }
    public String getSept() { return sept; }
    public String getMaftir() { return maftir; }
    public String getHaftarah() { return haftarah; }
}
