import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.lang.NumberFormatException;

public class NewFileUI extends JPanel {
    JLabel title, name, date, age, height, weight, water, calories, file, errorMessage;
    JTextField inputName, inputDate, inputAge, inputHeight, inputWeight, inputWater, inputCalories, inputFileName;
    JButton submitButton;
    String nameValue, dateValue, ageValue, heightValue, weightValue, waterValue, calorieValue, fileName;

    public NewFileUI(GUIManager manager) {
        GroupLayout gl = new GroupLayout(this);
        setLayout(gl);
        
        gl.setAutoCreateGaps(true);
        gl.setAutoCreateContainerGaps(true);

        title = new JLabel("Create a New File", SwingConstants.CENTER);
        title.setFont(new Font("Roboto", Font.BOLD, 16));
        name = new JLabel("Name: ", SwingConstants.RIGHT);
        date = new JLabel("Date: ", SwingConstants.RIGHT);
        age = new JLabel("Age: ", SwingConstants.RIGHT);
        height = new JLabel("Height (in):  ", SwingConstants.RIGHT);
        weight = new JLabel("Weight (lbs): ", SwingConstants.RIGHT);
        water = new JLabel("Water Consumed (oz): ", SwingConstants.RIGHT);
        calories = new JLabel("Calories Consumed: ", SwingConstants.RIGHT);
        file = new JLabel("Save FIle Name: ", SwingConstants.RIGHT);
        errorMessage = new JLabel("", SwingConstants.CENTER);
        
        inputName = new JTextField();
        inputDate = new JTextField();
        inputAge = new JTextField();
        inputHeight = new JTextField();
        inputWeight = new JTextField();
        inputWater = new JTextField();
        inputCalories = new JTextField();
        inputFileName = new JTextField();

        submitButton = new JButton("Submit");
        submitButton.setBackground(new Color(102, 162, 114));
        submitButton.setForeground(Color.WHITE);
        submitButton.setFocusPainted(false);
        submitButton.setFont(new Font("Roboto", Font.BOLD, 20));

        submitButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent event) {
                if (inputName.getText().isEmpty() || 
                    inputDate.getText().isEmpty() || 
                    inputAge.getText().isEmpty() || 
                    inputHeight.getText().isEmpty() || 
                    inputWeight.getText().isEmpty() || 
                    inputWater.getText().isEmpty() || 
                    inputCalories.getText().isEmpty() ||
                    inputFileName.getText().isEmpty())   // if any fields are empty
                {
                    errorMessage.setText("One or more fields are empty"); 
                } else {         
                    try {
                
                    } catch (NumberFormatException e) {
                        errorMessage.setText("Error: Given values are not in correct format");
                        System.err.println(e);
                    }
                    nameValue = inputName.getText();
                    dateValue = inputDate.getText();
                    ageValue = inputAge.getText();
                    heightValue = inputHeight.getText();
                    weightValue = inputWeight.getText();
                    waterValue = inputWater.getText();
                    calorieValue = inputCalories.getText(); 
                    fileName = inputFileName.getText(); 
                    
                    manager.initTrackerUIs(fileName, ageValue, weightValue, heightValue, nameValue, dateValue, waterValue, calorieValue);
                }



            }
        });

        gl.setHorizontalGroup(gl.createParallelGroup(GroupLayout.Alignment.CENTER) // Align to center
            .addComponent(title)
            .addGroup(gl.createSequentialGroup()
                .addGroup(gl.createParallelGroup(GroupLayout.Alignment.TRAILING) // Align to right
                    .addComponent(name)
                    .addComponent(date)
                    .addComponent(age)
                    .addComponent(height)
                    .addComponent(weight)
                    .addComponent(water)
                    .addComponent(calories)
                    .addComponent(file))
                .addGroup(gl.createParallelGroup(GroupLayout.Alignment.LEADING) // Align to left
                    .addComponent(inputName)
                    .addComponent(inputDate)
                    .addComponent(inputAge)
                    .addComponent(inputHeight)
                    .addComponent(inputWeight)
                    .addComponent(inputWater)
                    .addComponent(inputCalories)
                    .addComponent(inputFileName)))
            .addComponent(submitButton)
            .addComponent(errorMessage)
        );

        gl.setVerticalGroup(gl.createSequentialGroup()
            .addComponent(title)
            .addGroup(gl.createParallelGroup(GroupLayout.Alignment.BASELINE)
                .addComponent(name)
                .addComponent(inputName))
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
            .addComponent(errorMessage)
        );
    }    
}
