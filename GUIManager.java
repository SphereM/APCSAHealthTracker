import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class GUIManager extends JFrame implements ActionListener {
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
        // uses FlowLayout by default
        JButton newFileButton = new JButton("Create a new file");
        JButton existingFileButton = new JButton("Use existing file");

        newFileButton.setPreferredSize(new Dimension(250, 250));
        existingFileButton.setPreferredSize(new Dimension(250, 250));

        newFileButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                initNewFileUI();
                setContentPane(newFile);
                invalidate();
                validate();
            }
        });

        home.add(newFileButton);
        home.add(existingFileButton);

        setContentPane(home);
    }

    private void initNewFileUI() {
        JTextField title = new JTextField("Create a new file");

        JButton button = new JButton("Hola");
        button.setPreferredSize(new Dimension(250, 250));
        newFile.add(button);
    }

    public GUIManager() {
        initWindow();
    }
    
    public void start() {
        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        // Can't compile without
    }
}


