import java.io.*;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.UnsupportedAudioFileException;
import java.io.File;
import java.io.IOException;

public class Song {
    // song variables
    private String title;
    private String artist;
    private String genre;
    private String filePath;

    // constructor
    public Song(String name, String singer, String gen, String path) {
        title = name;
        artist = singer;
        genre = gen;
        filePath = path;
    }

    // toString method
    public String toString() {
        return "\"" + title + "\" by " + artist;
    }

    // getter methods
    public String getTitle() {
        return title;
    }

    public String getArtist() {
        return artist;
    }

    public String getGenre() {
        return genre;
    }

    public String getFilePath() {
        return filePath;
    }
}
