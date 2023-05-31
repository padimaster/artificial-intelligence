package com.ai.geneticAlgorithms.songs;

import org.jgap.Chromosome;
import org.jgap.Configuration;
import org.jgap.Gene;
import org.jgap.Genotype;
import org.jgap.IChromosome;
import org.jgap.impl.DefaultConfiguration;
import org.jgap.impl.IntegerGene;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

public class TestSongFitness {
    private Configuration conf;
    //    private SwappingMutationOperator swapper;
        private SongFitnessFunction fitnessFunction = null;
        public List songs = new ArrayList();
        public List genres = new ArrayList();
    
        private static final int MAX_ALLOWED_EVOLUTIONS = 15;
        private Chromosome songChromosome = null;
    

    public void initialize(String songGenre) throws Exception {
        StringTokenizer st = new StringTokenizer(songGenre);

        while (st.hasMoreElements()) {
            String genre = st.nextToken();
            genres.add(genre);
        }

        songs = this.loadSongs();

        conf = new DefaultConfiguration();

        conf.setPopulationSize(10);
//        conf.setKeepPopulationSizeConstant(false);

        fitnessFunction = new SongFitnessFunction(songs, genres);

        conf.setFitnessFunction(fitnessFunction);

        Gene[] songGenes = new Gene[1];

        songGenes[0] = new IntegerGene(conf, 0, songs.size() - 1);
//        movieGenes[1] = new IntegerGene(conf, 0, movies.size() - 1);
//        movieGenes[2] = new IntegerGene(conf, 0, movies.size() - 1);

        songGenes[0].setAllele(0);
//        movieGenes[1].setAllele(1);
//        movieGenes[2].setAllele(2);

        
        songChromosome = new Chromosome(conf, songGenes);
        
        conf.setSampleChromosome(songChromosome);
    }

    private List<Song> loadSongs() {
        List<Song> songs = new ArrayList<>();

        Song song1 = new Song();
        song1.setName("Despacito");
        song1.setImdbRating(7.8);
        List<String> genre1 = new ArrayList<>();
        genre1.add("salsa");
        genre1.add("reggaeton");
        song1.setGenre(genre1);
        song1.setYear("2017");
        song1.setAuthor("Luis Fonsi");
        song1.setAlbum("Vida");

        Song song2 = new Song();
        song2.setName("Bailando");
        song2.setImdbRating(8.2);
        List<String> genre2 = new ArrayList<>();
        genre2.add("salsa");
        genre2.add("latin-pop");
        song2.setGenre(genre2);
        song2.setYear("2014");
        song2.setAuthor("Enrique Iglesias");
        song2.setAlbum("Sex and Love");

        Song song3 = new Song();
        song3.setName("Vivir Mi Vida");
        song3.setImdbRating(9.1);
        List<String> genre3 = new ArrayList<>();
        genre3.add("salsa");
        genre3.add("latin-pop");
        song3.setGenre(genre3);
        song3.setYear("2013");
        song3.setAuthor("Marc Anthony");
        song3.setAlbum("3.0");

        Song song4 = new Song();
        song4.setName("Oye Como Va");
        song4.setImdbRating(8.5);
        List<String> genre4 = new ArrayList<>();
        genre4.add("salsa");
        genre4.add("latin-jazz");
        song4.setGenre(genre4);
        song4.setYear("1970");
        song4.setAuthor("Tito Puente");
        song4.setAlbum("Abraxas");

        Song song5 = new Song();
        song5.setName("La Vida Es Un Carnaval");
        song5.setImdbRating(8.9);
        List<String> genre5 = new ArrayList<>();
        genre5.add("salsa");
        genre5.add("cumbia");
        song5.setGenre(genre5);
        song5.setYear("1998");
        song5.setAuthor("Celia Cruz");
        song5.setAlbum("Mi Vida Es Cantar");

        Song song6 = new Song();
        song6.setName("Danza Kuduro");
        song6.setImdbRating(7.6);
        List<String> genre6 = new ArrayList<>();
        genre6.add("reggaeton");
        genre6.add("latin-pop");
        song6.setGenre(genre6);
        song6.setYear("2010");
        song6.setAuthor("Don Omar");
        song6.setAlbum("Meet the Orphans");

        Song song7 = new Song();
        song7.setName("La Gozadera");
        song7.setImdbRating(8.1);
        List<String> genre7 = new ArrayList<>();
        genre7.add("salsa");
        genre7.add("latin-pop");
        song7.setGenre(genre7);
        song7.setYear("2015");
        song7.setAuthor("Gente de Zona");
        song7.setAlbum("Visualízate");

        Song song8 = new Song();
        song8.setName("Pedro Navaja");
        song8.setImdbRating(7.9);
        List<String> genre8 = new ArrayList<>();
        genre8.add("salsa");
        genre8.add("latin-jazz");
        song8.setGenre(genre8);
        song8.setYear("1978");
        song8.setAuthor("Rubén Blades");
        song8.setAlbum("Siembra");

        Song song9 = new Song();
        song9.setName("Hoy Aprendí");
        song9.setImdbRating(7.5);
        List<String> genre9 = new ArrayList<>();
        genre9.add("salsa");
        song9.setGenre(genre9);
        song9.setYear("2000");
        song9.setAuthor("Adolescent's Orquesta");
        song9.setAlbum("Adoloscente's Orquesta");

        Song song10 = new Song();
        song10.setName("Periodico de Ayer");
        song10.setImdbRating(8.5);
        List<String> genre10 = new ArrayList<>();
        genre10.add("salsa");
        song10.setGenre(genre10);
        song10.setYear("1978");
        song10.setAuthor("Hector Lavoe");
        song10.setAlbum("Ayer");

        songs.add(song1);
        songs.add(song2);
        songs.add(song3);
        songs.add(song4);
        songs.add(song5);
        songs.add(song6);
        songs.add(song7);
        songs.add(song8);
        songs.add(song9);
        songs.add(song10);


        return songs;
    }

    public void testSelectFittestSongs() throws Exception {
        Genotype population = Genotype.randomInitialGenotype(conf);
        IChromosome bestSolutionSoFar = null;

        for (int i = 0; i < MAX_ALLOWED_EVOLUTIONS; i++) {
            population.evolve(10);
            IChromosome candidateBestSolution = population.getFittestChromosome();

            if (bestSolutionSoFar == null || candidateBestSolution.getFitnessValue() > bestSolutionSoFar.getFitnessValue()) {
                bestSolutionSoFar = candidateBestSolution;
            }
        }

        printSolution(bestSolutionSoFar);
    }

    public void printSolution(IChromosome solution) {
        System.out.println("#####################");
        System.out.println("Fitness Value: " + solution.getFitnessValue());

        for (int i = 0; i < solution.size(); i++) {
            int index = (Integer) solution.getGene(i).getAllele();
            Song song = (Song) songs.get(index);
            System.out.println(song.toString());
        }

        System.out.println("#####################");
    }
}
