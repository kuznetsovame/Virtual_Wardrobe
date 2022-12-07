package com.example.virtualwardrobe.model;

public class Clothes {
    public Clothes(String name, String image, String description, String category) {
        this.name = name;
        this.image = image;
        this.description = description;
        this.category = category;
    }

    public String name;
    public String image;
    public String description;
    public String category;
}
