package com.example.apinews;

public class News {
    private String title;
    private String author;
    private String description;
    private String publishedAt;
    private String urlToImage;

    public News() {
    }

    public News(String urlToImage, String title, String description, String publishedAt, String author) {
        this.title = title;
        this.author = author;
        this.description = description;
        this.publishedAt = publishedAt;
        this.urlToImage = urlToImage;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getPublishedAt() {
        return publishedAt;
    }

    public void setPublishedAt(String publishedAt) {
        this.publishedAt = publishedAt;
    }

    public String getUrlToImage() {
        return urlToImage;
    }

    public void setUrlToImage(String urlToImage) {
        this.urlToImage = urlToImage;
    }
}
