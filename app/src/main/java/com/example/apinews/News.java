package com.example.apinews;

public class News {
    private String title,author,description,publishedAt,urlToImage;

    public News(String title,String author, String description, String publishedAt, String urlToImage){
        this.title=title;
        this.author=author;
        this.description=description;
        this.publishedAt=publishedAt;
        this.urlToImage=urlToImage;
    }

    public String getTitle() {
        return title;
    }

    public String getAuthor() {
        return author;
    }

    public String getDescription() {
        return description;
    }

    public String getPublishedAt() {
        return publishedAt;
    }
    public String getUrlToImage() {
        return urlToImage;
    }
}
