package com.example.imageviewer;

import android.net.Uri;

import java.io.Serializable;

public class ImageData implements Serializable {
    private String uri;
    private String name;

    public void setImage(Uri uri, String name){
        this.uri = uri.toString();
        this.name = name;
    }

    public void setImage(Uri uri) {
        this.uri = uri.toString();
    }

    public Uri getImage() {
        return Uri.parse(this.uri);
    }

    public String getName() {
        return this.name;
    }
}
