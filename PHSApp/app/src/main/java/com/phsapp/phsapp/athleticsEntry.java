package com.phsapp.phsapp;

class athleticsEntry{
    private String title;
    private String category;
    private String imgLink;
    private String link;

    //constructor
    athleticsEntry(String title, String imgLink, String category, String link){
        this.title = title;
        this.imgLink = imgLink;
        this.category = category;
        this.link = link;
}
    // getter
    public String getTitle() { return title; }
    public String getCategory(){return category;}
    public String getImgLink(){return imgLink;}
    public String getLink(){return link;}

    // setter
    void setTitle(String title) { this.title = title; }
    void setCategory(String category){this.category = category;}
    void setImgLink(String imgLink){this.imgLink= imgLink;}
    void setLink(String link){this.link = link;}

}
