/*import java.net.MalformedURLException;
import java.net.URL;
//import javazoom.jlgui.basicplayer.BasicPlayer;
//import javazoom.jlgui.basicplayer.BasicPlayerException;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import java.util.Properties;
import java.io.*;
import java.net.*;

import java.util.Scanner;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
*/

import java.io.*; 
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.UnsupportedAudioFileException;
import java.io.File;
import java.io.IOException;

public class Song 
{
    // song variables
    private String title;
    private String artist;
    private double length;
    private String genre;
    private String filePath; 
    private File songFile; 

    // constructor
    public Song(String name, String singer, String gen, String path, File f) 
    {
        title = name;
        artist = singer;
        genre = gen;
        length = calcDuration();
        filePath = path; 
        songFile = f; 
    }

    public double calcDuration() 
    {
        try 
        {
            AudioInputStream audioInputStream = AudioSystem.getAudioInputStream(songFile);
            long durationMicroseconds = audioInputStream.getFrameLength() * 1000000 / audioInputStream.getFormat().getFrameRate();
           
            return (double) (durationMicroseconds / 1000000);
        } catch (UnsupportedAudioFileException | IOException e) 
        {
            e.printStackTrace();
        }
        return 0.0;
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

    public String getFilePath()
    {
        return filePath;
    }

    public File getSongFile()
    {
        return songFile; 
    }
}
