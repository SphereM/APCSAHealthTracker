import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class NewFileUI extends JPanel {
    public NewFileUI(JFrame frame) {
        GroupLayout gl = new GroupLayout(this);
        setLayout(gl);
        
        gl.setAutoCreateGaps(true);
        gl.setAutoCreateContainerGaps(true);

        JLabel title = new JLabel("Create a new file", SwingConstants.CENTER);
        JLabel date = new JLabel("Input Date (mm/dd/yy):", SwingConstants.RIGHT);
        JLabel age = new JLabel("Input Age:", SwingConstants.RIGHT);
        JLabel height = new JLabel("Input Height (in)", SwingConstants.RIGHT);
        JLabel weight = new JLabel("Input Weight (lbs)", SwingConstants.RIGHT);
        JLabel water = new JLabel("Input water consumed (fl oz):", SwingConstants.RIGHT);
        JLabel calories = new JLabel("Input calories consumed:", SwingConstants.RIGHT);
        JLabel file = new JLabel("Input Save File Name:", SwingConstants.RIGHT);
        // JLabel error = new JLabel("", SwingConstants.CENTER);
        
        JTextField inputDate = new JTextField();
        JTextField inputAge = new JTextField();
        JTextField inputHeight = new JTextField();
        JTextField inputWeight = new JTextField();
        JTextField inputWater = new JTextField();
        JTextField inputCalories = new JTextField();
        JTextField inputFileName = new JTextField();

        JButton submitButton = new JButton("Submit");

        submitButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String dateValue = inputDate.getText();
                String ageValue = inputAge.getText();
                String heightValue = inputHeight.getText();
                String weightValue = inputWeight.getText();
                String waterValue = inputWater.getText();
                String calorieValue = inputCalories.getText(); 
                String fileName = inputFileName.getText();

                System.out.println(
                    "Date: " + dateValue + 
                    "\nAge:" + ageValue + 
                    "\nHeight " + heightValue + " in." +
                    "\nWeight: " + weightValue + " lbs" +
                    "\nWater Consumed: " + waterValue + " fl oz." + 
                    "\nCalories Consumed: " + calorieValue + " cal" +
                    "\nFile Name: " + fileName + ".txt"
                );

                // Save debugging for later
                // try {
                //     double waterValue = Double.parseDouble(inputWater.getText());
                // } catch (NumberFormatException error) {
                //     error.setText("Error: Given values are not in correct format");
                // }
            }
        });

        gl.setHorizontalGroup(gl.createParallelGroup(GroupLayout.Alignment.CENTER) // Align to center
            .addComponent(title)
            .addGroup(gl.createSequentialGroup()
                .addGroup(gl.createParallelGroup(GroupLayout.Alignment.TRAILING) // Align to right
                    .addComponent(date)
                    .addComponent(age)
                    .addComponent(height)
                    .addComponent(weight)
                    .addComponent(water)
                    .addComponent(calories)
                    .addComponent(file))
                .addGroup(gl.createParallelGroup(GroupLayout.Alignment.LEADING) // Align to left
                    .addComponent(inputDate)
                    .addComponent(inputAge)
                    .addComponent(inputHeight)
                    .addComponent(inputWeight)
                    .addComponent(inputWater)
                    .addComponent(inputCalories)
                    .addComponent(inputFileName)))
            .addComponent(submitButton)
            // .addComponent(error)
        );

        gl.setVerticalGroup(gl.createSequentialGroup()
            .addComponent(title)
            .addGroup(gl.createParallelGroup(GroupLayout.Alignment.BASELINE)
                .addComponent(date)
                .addComponent(inputDate))
            .addGroup(gl.createParallelGroup(GroupLayout.Alignment.BASELINE)
                .addComponent(age)
                .addComponent(inputAge))
            .addGroup(gl.createParallelGroup(GroupLayout.Alignment.BASELINE)
                .addComponent(height)
                .addComponent(inputHeight))
            .addGroup(gl.createParallelGroup(GroupLayout.Alignment.BASELINE)
                .addComponent(weight)
                .addComponent(inputWeight))
            .addGroup(gl.createParallelGroup(GroupLayout.Alignment.BASELINE)
                .addComponent(water)
                .addComponent(inputWater))
            .addGroup(gl.createParallelGroup(GroupLayout.Alignment.BASELINE)
                .addComponent(calories)
                .addComponent(inputCalories))
            .addGroup(gl.createParallelGroup(GroupLayout.Alignment.BASELINE)
                .addComponent(file)
                .addComponent(inputFileName))
            .addComponent(submitButton)
            // .addComponent(error)
        );
    }    
}
