/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package test5;

/**
 *
 * @author BayMaxx
 */
public class Song {
    String songName ; 
    String Artist; 
    int rated; 

    public Song() {
    }

    public Song(String songName, String Artist, int rated) {
        this.songName = songName;
        this.Artist = Artist;
        this.rated = rated;
    }

    public String getSongName() {
        return songName;
    }

    public void setSongName(String songName) {
        this.songName = songName;
    }

    public String getArtist() {
        return Artist;
    }

    public void setArtist(String Artist) {
        this.Artist = Artist;
    }

    public int getRated() {
        return rated;
    }

    public void setRated(int rated) {
        this.rated = rated;
    }

    @Override
    public String toString() {
        return "Song{" + "songName=" + songName + ", Artist=" + Artist + ", rated=" + rated + '}';
    }
    
}
