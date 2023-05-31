package com.ai.geneticAlgorithms.songs;

import org.jgap.FitnessFunction;
import org.jgap.IChromosome;
import org.jgap.impl.IntegerGene;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

public class SongFitnessFunction extends FitnessFunction {

    private List<Song> songs;
    private List<String> genres;

    public SongFitnessFunction(List<Song> songs, List<String> genres) {
        this.songs = songs;
        this.genres = genres;
    }

    @Override
    protected double evaluate(IChromosome chromosome) {
        double score = 0;
        double imdbScore = 0;

        List dups = new ArrayList();
        int badSolution = 1;

        for (int i = 0; i < chromosome.size(); i++) {

            IntegerGene agene = (IntegerGene) chromosome.getGene(i);
            int index = (Integer) chromosome.getGene(i).getAllele();

            if (dups.contains(index)) {
                badSolution = 0;
            } else {
                dups.add(index);
            }

            Song song = (Song) songs.get(index);
            double genreScore = getGenreScore(song);
            if (genreScore == 0) {
                badSolution = 0;
            }

            score = (score + song.getImdbRating()) + (genreScore);
//            System.out.println(movie + " socore: " + score);
        }
        return (score * badSolution);
    }

    private double getGenreScore(Song song) {
        double genreScore = 0;
        Iterator it = this.genres.iterator();

        while (it.hasNext()) {
            String genre = (String) it.next();
            if (song.getGenre().contains(genre)) {
                genreScore = genreScore + 1;
            }
        }
        return genreScore;
    }
}
