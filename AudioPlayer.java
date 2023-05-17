import javax.sound.sampled.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;
import java.util.Scanner;

public class AudioPlayer{
    // variable for audio clip
    private Clip clip;

    // buttons for GUI
    private JButton playButton;
    private JButton pauseButton;
    private JButton stopButton;

    // loads the clip where the audio will come from
    public void load(String filePath) throws UnsupportedAudioFileException, IOException, LineUnavailableException {
        File audioFile = new File(filePath);

        AudioInputStream audioStream = AudioSystem.getAudioInputStream(audioFile);
        AudioFormat format = audioStream.getFormat();
        DataLine.Info info = new DataLine.Info(Clip.class, format);

        clip = (Clip) AudioSystem.getLine(info);
        clip.open(audioStream);
    }

    // plays the clip if it's not null and if it's not already playing
    public void play() {
        if (clip != null && !clip.isRunning()) {
            clip.start();
        }
    }

    // pauses the clip if it's not null and if it's currently playing
    public void pause() {
        if (clip != null && clip.isRunning()) {
            clip.stop();
        }
    }

    // stops the clip if it's not null; resets the clip to the start
    public void stop() {
        if (clip != null) {
            clip.stop();
            clip.setFramePosition(0);
        }
    }

    // returns whether the clip is not null and playing
    public boolean isPlaying() {
        return clip != null && clip.isRunning();
    }

    // the GUI
    public void createAndShowGUI(String name) {
        // creates new frame
        JFrame frame = new JFrame(name);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // creates play button 
        playButton = new JButton("Play");
        playButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                play();
            }
        });

        // creates pause button
        pauseButton = new JButton("Pause");
        pauseButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                pause();
            }
        });

        // creates stop button
        stopButton = new JButton("Stop");
        stopButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                stop();
            }
        });

        // adds the created buttons to the panel
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
        AudioPlayer player2 = new AudioPlayer();
        AudioPlayer player3 = new AudioPlayer();
        Song poweroflove = new Song("Power of Love", "Huey Lewis and the News", "Rock", "C:/Users/Masroor Siddiqui/OneDrive/Pictures/Documents/Desktop2/Desktop/csaFinal-main/The Power Of Love- Huey Lewis And The News.wav");
        Song arabella = new Song("Arabella", "Arctic Monkeys", "Rock", "C:/Users/Masroor Siddiqui/OneDrive/Pictures/Documents/Desktop2/Desktop/csaFinal-main/Arabella.wav");
        Song theArtofWar = new Audiobook("The Art of War", "Sun Tzu", "C:/Users/Masroor Siddiqui/OneDrive/Pictures/Documents/Desktop2/Desktop/csaFinal-main/The Art of War by Sun Tzu： Entire Unabridged Audiobook.wav");

        try {
            player.load(poweroflove.getFilePath());
        } catch (Exception e) {
            e.printStackTrace();
            return;
        }
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                player.createAndShowGUI("Power of Love"); 
            }
        });

        try {
            player2.load(arabella.getFilePath());
        } catch (Exception e) {
            e.printStackTrace();
            return;
        }
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                player2.createAndShowGUI("Arabella"); 
            }
        });

        try {
            player3.load(theArtofWar.getFilePath());
        } catch (Exception e) {
            e.printStackTrace();
            return;
        }
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                player3.createAndShowGUI("The Art of War"); 
            }
        });

        
        // SwingUtilities.invokeLater(new Runnable() {
        //     public void run() {
        //         player.createAndShowGUI(); 
        //     }
        // });
    }
}
