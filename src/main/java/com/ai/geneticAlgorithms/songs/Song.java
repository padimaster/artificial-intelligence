/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ai.geneticAlgorithms.songs;

import java.util.List;

/**
 *
 * @author Henry Paz
 */
public class Song {

    private String name;
    private List genre;

    private double imdbRating;
    private String year;
    private String author;
    private String album;

    public String getYear() {
        return year;
    }

    public void setYear(String year) {
        this.year = year;
    }

    public double getImdbRating() {
        return imdbRating;
    }

    public void setImdbRating(double imdbRating) {
        this.imdbRating = imdbRating;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List getGenre() {
        return genre;
    }

    public void setGenre(List genre) {
        this.genre = genre;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String director) {
        this.author = director;
    }

    public String getAlbum() {
        return album;
    }

    public void setAlbum(String plot) {
        this.album = plot;
    }

    @Override
    public String toString() {
        return "Película [Nombre=" + name + ", Genero=" + genre
                + ", Rating=" + imdbRating + ", año=" + year
                + "]";
    }
}
