package com.example.imageviewer;

import java.io.Serializable;

public class ImageData implements Serializable {
    private String uri;
    private String name;

    public void setImage(String uri, String name){
        this.uri = uri;
        this.name = name;
    }

    public void setImage(String uri) {
        this.uri = uri;
    }
    
    public String getImage() {
        return this.uri;
    }

    public String getName() {
        return this.name;
    }
}
