/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ai.geneticAlgorithms.songs;

import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Henry Paz
 */
public class SongsExample {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        try {
            TestSongFitness test = new TestSongFitness();
            test.initialize("latin-pop");
            test.testSelectFittestSongs();
        } catch (Exception ex) {
            Logger.getLogger(SongsExample.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

}
