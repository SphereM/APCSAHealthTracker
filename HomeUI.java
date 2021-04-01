import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class HomeUI extends JPanel {
    public HomeUI(JFrame frame) {
        // Defaults to FlowLayout, fine as is
        JButton newFileButton = new JButton("Create a new file");
        // JButton existingFileButton = new JButton("Use existing file");

        newFileButton.setPreferredSize(new Dimension(250, 250));
        // existingFileButton.setPreferredSize(new Dimension(250, 250));

        newFileButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JPanel newFileUI = new NewFileUI(frame);
                frame.setContentPane(newFileUI);
                frame.revalidate();
            }
        });

        add(newFileButton);
        // add(existingFileButton);
    }
}
