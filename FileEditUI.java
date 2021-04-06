import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.IOException;
import java.io.*;

public class FileEditUI extends JPanel {
    public FileEditUI(GUIManager manager) {
        GroupLayout gl = new GroupLayout(this);
        setLayout(gl);
        JFileChooser fc = new JFileChooser();
        JFrame frame = new JFrame();
        JTextArea text = new JTextArea(10, 10);
        gl.setAutoCreateGaps(true);
        gl.setAutoCreateContainerGaps(true);
        JButton readButton = new JButton("OPEN FILE");
        readButton.addActionListener(ev -> {
          int returnVal = fc.showOpenDialog(frame);

          if (returnVal == JFileChooser.APPROVE_OPTION) {
            File file = fc.getSelectedFile();
            
            try {
              BufferedReader input = new BufferedReader(new InputStreamReader(
                  new FileInputStream(file)));
              text.read(input, "READING FILE :-)");
            } catch (Exception e) {
              e.printStackTrace();
            }
          } else {
            System.out.println("Operation is CANCELLED :(");
          }
        });
    
        frame.getContentPane().add(text, BorderLayout.CENTER);
        frame.getContentPane().add(readButton, BorderLayout.PAGE_END);
        frame.pack();
        frame.setVisible(true);

        
       
    }    
}
