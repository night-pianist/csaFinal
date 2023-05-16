import javax.swing.*; 
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import java.awt.*;

public class GUI extends JFrame
{
    private JFrame frame;
    private JLabel currentSongLabel;

    public void initialize()
    {
        // the GUI
        frame = new JFrame("Music Player");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(900,700);
        
        JPanel panel = new JPanel();

        JButton playButton = new JButton("Play");
        JButton pauseButton = new JButton("Pause");
        JButton skipButton = new JButton("Skip");
        JButton backwardsButton = new JButton("Backwards");

        currentSongLabel = new JLabel("Current Song: None");

        panel.add(playButton);
        panel.add(pauseButton);
        panel.add(skipButton);
        panel.add(backwardsButton);
        panel.add(currentSongLabel);

        frame.getContentPane().add(panel);

        setVisible(true);

    }
}
