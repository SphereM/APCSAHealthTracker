import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

import static javax.swing.GroupLayout.Alignment.BASELINE;
import static javax.swing.GroupLayout.Alignment.TRAILING;

public class GUIManager extends JFrame implements ActionListener {
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


