//Child class of Parent Song Class
public class Audiobook extends Song{
    private String title;
    private String author;
    private String path;
    
    //Constructor
    public Audiobook(String title, String writer, String direction) {
        super(title, writer, "Book", direction);
        author = writer;
        path = direction;
    }

    // getter methods
    public String getTitle() {
        return title;
    }

    public String getAuthor() {
        return super.getArtist();
    }

    public String getFilePath() {
        return path;
    }
}
