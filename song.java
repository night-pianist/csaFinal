import java.net.MalformedURLException;
import java.net.URL;
//import javazoom.jlgui.basicplayer.BasicPlayer;
//import javazoom.jlgui.basicplayer.BasicPlayerException;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import java.util.Properties;
import java.io.*;
import java.net.*;

public class Song 
{
    // song variables
    private String title;
    private String artist;
    private double length;
    private String genre;

    // constructor
    public Song(String name, String singer, String gen, double len) 
    {
        title = name;
        artist = singer;
        genre = gen;
        length = len;
    }

    // toString method
    public String toString() {
        return "\"" + title + "\" by " + artist + ": " + length + "min";
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

    public double getLength() {
        return length;
    }
    
}
