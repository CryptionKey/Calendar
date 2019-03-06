package com.example.recyclerview.Model;


public class Calendar {

    private String category;
    private String title;
    private String date;
    private String hebrew;
    private String link;
    private String memo;

    //Les getters
    public String getCategory() { return category; }
    public String getTitle() { return title; }
    public String getDate() { return date; }
    public String getHebrew() { return hebrew; }
    public String getLink() { return link; }
    public String getMemo() { return memo; }


    //Les setters
    public void setCategory(String category) { this.category = category; }
    public void setTitle(String title) { this.title = title; }
    public void setDate(String date) { this.date = date; }
    public void setHebrew(String hebrew) { this.hebrew = hebrew; }
    public void setMemo(String memo) { this.memo = memo; }
    public void setLink(String link) { this.link = link; }

}




