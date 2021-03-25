import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Tester extends JFrame {
    public static void main(String[] args) {
        EventQueue.invokeLater(() -> {
            GUIManager manager = new GUIManager();
            manager.setVisible(true);
        });
    }

    public GUIManager() {
        initUI();
    }
    
    private void initUI() {
        setPreferredSize(new Dimension(1280, 720));
        setTitle("Health Tracker");
        setLocationRelativeTo(null);
        setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);
    }

    private void initHomeUI() {
        var window = getContentPane();
        var gl = new GroupLayout(window);
        window.setLayout(gl);

        gl.setAutoCreateGaps(true);
        gl.setAutoCreateContainerGaps(true);


    }
}
