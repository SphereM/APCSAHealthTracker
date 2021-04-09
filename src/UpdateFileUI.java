import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.Scanner;
import java.io.*;

public class UpdateFileUI extends JPanel {
    JLabel title, comment, water, calories, errorMessage;
    JTextField inputWater, inputCalories;
    JButton submitButton;
    String dateValue, nameValue;
    String[] line;
    double weightValue, heightValue, waterValue, calorieValue;
    int ageValue;
    Scanner scanner;

    public UpdateFileUI(GUIManager manager, File file) {
        GroupLayout gl = new GroupLayout(this);
        setLayout(gl);

        gl.setAutoCreateGaps(true);
        gl.setAutoCreateContainerGaps(true);

        title = new JLabel("Update File", SwingConstants.CENTER);
        title.setFont(new Font("Roboto", Font.BOLD, 16));
        comment = new JLabel("Leave space blank if no changes have been made", SwingConstants.CENTER);
        water = new JLabel("Add Water Consumed: ", SwingConstants.RIGHT);
        calories = new JLabel("Add Calories Consumed: ", SwingConstants.RIGHT);
        errorMessage = new JLabel("", SwingConstants.CENTER);

        inputWater = new JTextField();
        inputCalories = new JTextField(); 
        
        submitButton = new JButton("Submit");

        submitButton.setBackground(new Color(102, 162, 114));
        submitButton.setForeground(Color.WHITE);
        submitButton.setFocusPainted(false);
        submitButton.setFont(new Font("Roboto", Font.BOLD, 20));

        submitButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent event) {
                if (inputWater.getText().isEmpty() && inputCalories.getText().isEmpty()) {
                    errorMessage.setText("Please input something");
                }  else {
                    try {
                        scanner = new Scanner(file);
    
    
                        while (scanner.hasNextLine()) {
                            line = scanner.nextLine().split(" ");
    
                            switch (line[0]) {
                                case "Date:":
                                    dateValue = line[1];
                                    break;
                                case "Name:":
                                    nameValue = line[1];
                                    break;
                                case "Weight:":
                                    weightValue = Double.parseDouble(line[1]);
                                    break;
                                case "Height:":
                                    heightValue = Double.parseDouble(line[1]);
                                    break;
                                case "Age:":
                                    ageValue = Integer.parseInt(line[1]);
                                    break;
                                case "Water:":
                                    waterValue = Double.parseDouble(line[1]);
                                    break;
                                case "Calories:":
                                    calorieValue = Double.parseDouble(line[1]);
                            }
                        }    
                        
                        if (!inputWater.getText().isEmpty()) { waterValue += Double.parseDouble(inputWater.getText()); }
                        if (!inputCalories.getText().isEmpty()) { calorieValue += Double.parseDouble(inputCalories.getText()); }

                        manager.initTrackerUIs(file.getName().substring(0, file.getName().length()-4), ageValue, weightValue, heightValue, nameValue, dateValue, waterValue, calorieValue);
                    } catch (IOException e) {
                        System.err.println(e);
                    } catch (NumberFormatException e) {
                        errorMessage.setText("Error: Given values are not in correct format");
                    }
                }
            }
        });

        gl.setHorizontalGroup(gl.createParallelGroup(GroupLayout.Alignment.CENTER)
            .addComponent(title)
            .addComponent(comment)
            .addGroup(gl.createSequentialGroup()
                .addGroup(gl.createParallelGroup(GroupLayout.Alignment.TRAILING)
                    .addComponent(water)
                    .addComponent(calories))
                .addGroup(gl.createParallelGroup(GroupLayout.Alignment.LEADING)
                    .addComponent(inputWater)
                    .addComponent(inputCalories)))
            .addComponent(submitButton)
            .addComponent(errorMessage));

        gl.setVerticalGroup(gl.createSequentialGroup()
            .addComponent(title)
            .addComponent(comment)
            .addGroup(gl.createParallelGroup(GroupLayout.Alignment.BASELINE)
                .addComponent(water)
                .addComponent(inputWater))
            .addGroup(gl.createParallelGroup(GroupLayout.Alignment.BASELINE)
                .addComponent(calories)
                .addComponent(inputCalories))
            .addComponent(submitButton)
            .addComponent(errorMessage));
    }
}
