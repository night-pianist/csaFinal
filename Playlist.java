import java.util.ArrayList;

public class Playlist {
    // data structure for playlist
    private ArrayList<Song> songs;
    private String playlistTitle;

    // constructor
    public Playlist() {
        songs = new ArrayList<Song>();
        playlistTitle = "My Playlist";
    }

    // constructor with playlist title
    public Playlist(String title) {
        songs = new ArrayList<Song>();
        playlistTitle = title;
    }

    // setter for multiple songs
    public void addSongs(Song[] other) {
        for (Song s : other) {
            songs.add(s);
        }
        System.out.println("All songs from " + other + " has been added to the playlist."); 
    }

    // setters for single songs
    public void addSong(Song song) {
        songs.add(song);
        System.out.println(song + " has been added to the playlist."); 
    }

    // remove a song
    public void removeSong(Song song) {
        // checks if the song is in the playlist
        for (int i = 0; i < songs.size(); i++) {
            Song temp = songs.get(i);
            if (temp.equals(song))
            {
                songs.remove(song);
                System.out.println(song + " has been removed from the playlist."); 
            }
        }
    }

    // replaces a song
    public void replaceSong(int index, Song song) {
        if (index >= 0 && index < songs.size()) {
            songs.set(index, song);
            System.out.println("Replaced song at index " + index + " with '" + song.getTitle() + "'.");
        } else
            System.out.println("Invalid index. Cannot replace song.");
    }

    // clears playlist
    public void clearList() {
        for (int i = 0; i < songs.size(); i++) {
            songs.remove(songs.get(i));
        }
        System.out.println("List has been cleared.");
    }

    // setter for title
    public void setTitle(String title) {
        playlistTitle = title;
        System.out.println("The playlist title has been changed to " + title);
    }

    // getters
    public String getTitle() {
        return playlistTitle;
    }

    public ArrayList<Song> getPlaylist() {
        return songs;
    }

    // toString method
    public String toString() {
        String str = playlistTitle + ":\n";
        for (int i = 0; i < songs.size(); i++) {
            str += (i + 1) + ". " + songs.get(i).toString() + "\n";
        }
        return str;
    }
}
