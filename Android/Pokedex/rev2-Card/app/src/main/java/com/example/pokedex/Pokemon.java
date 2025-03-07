package com.example.pokedex;

public class Pokemon {
    private String name;
    private int number;
    private String url;

    public Pokemon(String name, int number, String url){
        this.name = name;
        this.number = number;
        this.url = url;
    }

    public Pokemon(String name, int number){
        this.name=name;
        this.number=number;
    }

    public Pokemon(String name, String url){
        this.name=name;
        this.url=url;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    @Override
    public String toString() {
        return "Pokemon{" +
                "name='" + name + '\'' +
                ", number=" + number +
                '}';
    }
}
