import javax.swing.*; 
import java.awt.*;

public class GUI extends JFrame
{
    public void initialize()
    {
        // the GUI
        setTitle("Music Player");
        setSize(900,700);
        setMinimumSize(new Dimension(600,400));
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setVisible(true);

        // labels 
        JLabel lbl = new JLabel("test Label");
        add(lbl, BorderLayout.NORTH);

        // buttons 
        JButton btn = new JButton("test button");
        btn.setBounds(250,300, 100,100);
        add(btn);
    }
}
