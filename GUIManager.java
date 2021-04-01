import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class GUIManager extends JFrame {
    private void initWindow() {
        setSize(new Dimension(720, 480));
        setTitle("Health App");
        setLocationRelativeTo(null); 
        setDefaultCloseOperation(EXIT_ON_CLOSE);

        initHomeUI();
    }

    private void initHomeUI() {
        JPanel home = new HomeUI(this);
        setContentPane(home);
    }

    // public void initNewFileUI() {
    //     JPanel newFile = new NewFileUI();
    //     setContentPane(newFile);
    //     revalidate();
    // }

    public GUIManager() {
        initWindow();
    }
    
    public void start() {
        setVisible(true);
    }
}


