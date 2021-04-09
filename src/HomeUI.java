import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class HomeUI extends JPanel {
    public HomeUI(GUIManager manager) {
        // Defaults to FlowLayout, fine as is
        JButton newFileButton = new JButton("Create New File");
        JButton editFileButton = new JButton("Update File");

        newFileButton.setPreferredSize(new Dimension(250, 250));
        editFileButton.setPreferredSize(new Dimension(250, 250));

        newFileButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                manager.initNewFileUI();
            }
        });
        editFileButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                manager.initFileSelectUI();
            }
        });

        newFileButton.setBackground(new Color(102, 162, 114));
        newFileButton.setForeground(Color.WHITE);
        newFileButton.setFocusPainted(false);
        newFileButton.setFont(new Font("Roboto", Font.BOLD, 20));
        editFileButton.setBackground(new Color(102, 162, 114));
        editFileButton.setForeground(Color.WHITE);
        editFileButton.setFocusPainted(false);
        editFileButton.setFont(new Font("Roboto", Font.BOLD, 20));

        add(newFileButton);
        add(editFileButton);
    }
}
