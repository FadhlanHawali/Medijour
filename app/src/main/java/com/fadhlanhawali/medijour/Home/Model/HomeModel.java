package com.fadhlanhawali.medijour.Home.Model;

public class HomeModel {

    private String title;
    private String URL;
    private String textContent;

    public HomeModel(String title, String URL, String textContent) {
        this.title = title;
        this.URL = URL;
        this.textContent = textContent;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getURL() {
        return URL;
    }

    public void setURL(String URL) {
        this.URL = URL;
    }

    public String getTextContent() {
        return textContent;
    }

    public void setTextContent(String textContent) {
        this.textContent = textContent;
    }
}
