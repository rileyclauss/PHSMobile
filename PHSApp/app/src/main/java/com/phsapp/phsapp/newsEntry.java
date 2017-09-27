package com.phsapp.phsapp;

class newsEntry {
    private String title;
    private String category;
    private String imgLink;
    private String link;

    //constructor
    newsEntry(String title, String imgLink, String category, String link){
        this.title = title;
        this.imgLink = imgLink;
        this.category = category;
        this.link = link;
}
    // getter
    String getTitle() { return title; }
    String getCategory(){return category;}
    String getImgLink(){return imgLink;}
    String getLink(){return link;}

    void setImgLink(String newImgLink){ this.imgLink = newImgLink;}
    void setTitle(String newTitle){this.title = newTitle;}
    void setCategory(String newCategory){this.category = newCategory;}
    void setLink(String newLink){this.link = newLink;}
}
