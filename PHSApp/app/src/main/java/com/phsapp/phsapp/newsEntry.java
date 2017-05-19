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

    // setter
    void setTitle(String title) { this.title = title; }
    void setCategory(String category){this.category = category;}
    void setImgLink(String imgLink){this.imgLink= imgLink;}
    void setLink(String link){this.link = link;}

}
