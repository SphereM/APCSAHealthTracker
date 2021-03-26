import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

import static javax.swing.GroupLayout.Alignment.BASELINE;
import static javax.swing.GroupLayout.Alignment.CENTER;

public class GUIManager extends JFrame implements ActionListener {
    private void initUI() {
        setSize(new Dimension(720, 480));
        setTitle("Health Tracker");
        setLocationRelativeTo(null);    
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        
        var window = getContentPane();
        var gl = new GroupLayout(window);
        window.setLayout(gl);

        gl.setAutoCreateGaps(true);
        gl.setAutoCreateContainerGaps(true);

        JButton newFileButton = new JButton("Create a new file");
        JButton existingFileButton = new JButton("Use existing file");

        newFileButton.addActionListener(this);
        existingFileButton.addActionListener(this);

        gl.setHorizontalGroup(gl.createSequentialGroup()
            .addComponent(newFileButton, 250, 250, 250)
            .addComponent(existingFileButton)
        );

        gl.setVerticalGroup(gl.createSequentialGroup()
            .addGroup(gl.createParallelGroup(BASELINE)
                .addComponent(newFileButton)
                .addComponent(existingFileButton))
        );

        gl.linkSize(newFileButton, existingFileButton);
    }

    public GUIManager() {
        initUI();
    }
    
    public void start() {
        EventQueue.invokeLater(() -> {
            GUIManager manager = new GUIManager();
            manager.setVisible(true);
        });
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        System.out.println("Hola");
    }
}


