import javax.swing.JTextArea;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.Scanner;
import java.io.*;

public class UpdateFileUI extends JPanel {
    JLabel title, comment, height, weight, water, calories, file, errorMessage;
    JTextArea inputHeight, inputWeight, inputWater, inputCalories;
    JButton submitButton;

    public UpdateFileUI(GUIManager manager, File file) {
        GroupLayout gl = new GroupLayout(this);
        setLayout(gl);

        gl.setAutoCreateGaps(true);
        gl.setAutoCreateContainerGaps(true);

        title = new JLabel("Update File", SwingConstants.CENTER);
        title.setFont(new Font("Roboto", Font.BOLD, 16));
    }
}
