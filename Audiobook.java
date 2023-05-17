public class Audiobook extends AudioPlayer{
    private String title;
    private String author;
    private int length;
    
    public Audiobook(String title, String author, int len) {
        this.title = title;
        this.author = author;
        this.length = len;
    }
    
    public void play() {
        System.out.println("Audiobook: Playing - " + title);
        super.play();
    }

    public void pause()
    {
        System.out.println("Audiobook: Pausing - " + title);
        super.pause();
    }
    
    public void stop() {
        System.out.println("Audiobook: Stopping - " + title);
        super.stop();
    }
    
    public static void main(String[] args) {
        Audiobook audiobook = new Audiobook("The Great Gatsby", "F. Scott Fitzgerald", 180);
        audiobook.play();
        audiobook.stop();
    }
}
