package com.phsapp.phsapp;

import java.util.List;

class newsEntry {
    private String title;
    private List<String> category;
    private String imgLink;
    private String link;

    //constructor
    newsEntry(String title, String imgLink, List<String> category, String link){
        this.title = title;
        this.imgLink = imgLink;
        this.category = category;
        this.link = link;
}
    // getter
    String getTitle() { return title; }
    List<String> getCategory(){return category;}
    String getImgLink(){return imgLink;}
    String getLink(){return link;}

    void setImgLink(String newImgLink){ this.imgLink = newImgLink;}
    void setTitle(String newTitle){this.title = newTitle;}
    void setCategory(List<String> newCategory){this.category = newCategory;}
    void setLink(String newLink){this.link = newLink;}
}
