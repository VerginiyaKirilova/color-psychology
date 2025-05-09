package com.colors.model;

public class Color {
    private String name;
    private String meaning;

    public Color() {
    }

    public Color(String name, String meaning){
        this.name = name;
        this.meaning = meaning;
    }

    public String getName(){
        return name;
    }

    public void setName(String name){
        this.name = name;

    }
    public String getMeaning() {
        return meaning;
    }

    public void setMeaning(String meaning){
        this.meaning = meaning;
    }
}
