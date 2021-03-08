package com.example.gamingproject;

public class Game {
    private int id;
    private String name;
    private String series;
    private int year;
    private String company;
    private String desc;
    private String genre;

    @Override
    public String toString() {
        return name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSeries() {
        return series;
    }

    public void setSeries(String series) {
        this.series = series;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }



    public Game() {
    }

    public Game(int id, String name, String series, int year, String desc,String company,String genre) {
        this.id = id;
        this.name = name;
        this.series = series;
        this.year = year;
        this.desc = desc;
        this.company=company;
        this.genre=genre;
    }


    public String getCompany() {
        return company;
    }

    public void setCompany(String company) {
        this.company = company;
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }
}
