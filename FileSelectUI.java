import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.*;

public class FileSelectUI extends JPanel {
    public FileSelectUI(GUIManager manager) {
        GroupLayout gl = new GroupLayout(this);
        setLayout(gl);

        gl.setAutoCreateGaps(true);
        gl.setAutoCreateContainerGaps(true);

        JFileChooser fc = new JFileChooser("lib/");
        JTextArea text = new JTextArea(10, 10);
        JLabel title = new JLabel("Select File", SwingConstants.CENTER);

        JButton readButton = new JButton("Open File");
        JButton confirmButton = new JButton("Confirm");
        confirmButton.setVisible(false);

        readButton.setBackground(new Color(102, 162, 114));
        readButton.setForeground(Color.WHITE);
        readButton.setFocusPainted(false);
        confirmButton.setFont(new Font("Roboto", Font.BOLD, 16));
        confirmButton.setBackground(new Color(102, 162, 114));
        confirmButton.setForeground(Color.WHITE);
        confirmButton.setFocusPainted(false);
        confirmButton.setFont(new Font("Roboto", Font.BOLD, 16));
        
        readButton.addActionListener(ev -> {
            int returnVal = fc.showOpenDialog(this);

            if (returnVal == JFileChooser.APPROVE_OPTION) {
                File file = fc.getSelectedFile();
              
                try {
                  BufferedReader input = new BufferedReader(new InputStreamReader(
                      new FileInputStream(file)));
        
                      text.read(input, "READING FILE :-)");
                      confirmButton.setVisible(true);
                      confirmButton.addActionListener(new ActionListener() {
                        @Override
                        public void actionPerformed(ActionEvent e) {
                            manager.initFileUpdateUI(file);
                        }
                    });
                } catch (Exception e) {
                  e.printStackTrace();
                }
            } else  {
                System.out.println("Operation is CANCELLED :(");
            }
        });

        

        gl.setHorizontalGroup(gl.createParallelGroup(GroupLayout.Alignment.CENTER)
            .addComponent(title)
            .addComponent(text)
            .addGroup(gl.createSequentialGroup()
                .addComponent(readButton)
                .addComponent(confirmButton)));

        gl.setVerticalGroup(gl.createSequentialGroup()
            .addComponent(title)
            .addComponent(text)
            .addGroup(gl.createParallelGroup(GroupLayout.Alignment.BASELINE)
                .addComponent(readButton)
                .addComponent(confirmButton)));
    }    
}
