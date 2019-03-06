package com.example.recyclerview.Model;

import java.util.List;

public class RestCalendarResponse {

    private String date ;
    private List<Calendar> items;

    //Les getters
    public String getDate() { return date; }
    public List<Calendar> getItems() { return items; }

    //Les setters
    public void setDate(String date) { this.date = date; }
    public void setItems(List<Calendar> items) { this.items = items; }
}
