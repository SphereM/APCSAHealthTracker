import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class GUIManager extends JFrame {
    private JPanel home = new JPanel();
    private JPanel newFile = new JPanel();

    private void initWindow() { // Maybe separate methods for UIs
        setSize(new Dimension(720, 480));
        setTitle("Health App");
        setLocationRelativeTo(null); 
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        
        initHomeUI();
    }

    private void initHomeUI() {
        HomeUI homeUI = new HomeUI();
        setContentPane(homeUI);
    }

    private void initNewFileUI() {
        NewFileUI newFileUI = new NewFileUI();
        setContentPane(newFileUI);
    }

    public GUIManager() {
        initWindow();
    }
    
    public void start() {
        setVisible(true);
    }
}


