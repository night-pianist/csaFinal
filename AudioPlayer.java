import javax.sound.sampled.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;
import java.util.Scanner;

public class AudioPlayer{
    private Clip clip;
    private JButton playButton;
    private JButton pauseButton;
    private JButton stopButton;

    public void load(String filePath) throws UnsupportedAudioFileException, IOException, LineUnavailableException {
        File audioFile = new File(filePath);

        AudioInputStream audioStream = AudioSystem.getAudioInputStream(audioFile);
        AudioFormat format = audioStream.getFormat();
        DataLine.Info info = new DataLine.Info(Clip.class, format);

        clip = (Clip) AudioSystem.getLine(info);
        clip.open(audioStream);
    }

    public void play() {
        if (clip != null && !clip.isRunning()) {
            clip.start();
        }
    }

    public void pause() {
        if (clip != null && clip.isRunning()) {
            clip.stop();
        }
    }

    public void stop() {
        if (clip != null) {
            clip.stop();
            clip.setFramePosition(0);
        }
    }

    public boolean isPlaying() {
        return clip != null && clip.isRunning();
    }

    public void createAndShowGUI() {
        JFrame frame = new JFrame("Audio Player");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        playButton = new JButton("Play");
        playButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                play();
            }
        });

        pauseButton = new JButton("Pause");
        pauseButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                pause();
            }
        });

        stopButton = new JButton("Stop");
        stopButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                stop();
            }
        });

        JPanel buttonPanel = new JPanel();
        buttonPanel.add(playButton);
        buttonPanel.add(pauseButton);
        buttonPanel.add(stopButton);

        frame.getContentPane().add(buttonPanel, BorderLayout.CENTER);
        frame.pack();
        frame.setVisible(true);
    }

    public static void main(String[] args) {
        AudioPlayer player = new AudioPlayer();
        Song poweroflove = new Song("Power of Love", "Huey Lewis and the News", "Rock", "C:/Users/Masroor Siddiqui/OneDrive/Pictures/Documents/Desktop2/Desktop/csaFinal-main/The Power Of Love- Huey Lewis And The News.wav");
        Song arabella = new Song("Arabella", "Arctic Monkeys", "Rock", "C:/Users/Masroor Siddiqui/OneDrive/Pictures/Documents/Desktop2/Desktop/csaFinal-main/Arabella.wav");
        Playlist rockPlaylist = new Playlist("Rock");
        rockPlaylist.addSong(arabella);
        rockPlaylist.addSong(poweroflove);

        // Scanner myObj = new Scanner(System.in);  // Create a Scanner object
        // System.out.println("Type the song you would like to listen to");
        // String songRequest = myObj.nextLine();
        

        try {
            player.load(poweroflove.getFilePath());
        } catch (Exception e) {
            e.printStackTrace();
            return;
        }

        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                player.createAndShowGUI(); 
            }
        });
    }
}
