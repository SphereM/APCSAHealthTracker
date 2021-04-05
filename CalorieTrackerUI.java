import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.IOException;

public class CalorieTrackerUI extends JPanel {

    public CalorieTrackerUI(GUIManager manager, String fileNameInput, String ageInput, String weightInput, String nameInput, String dateInput, String heightInput, String consumedInput) {
        Tracker tracker = null;
        
        try { // Redlining: CalorieTracker cannot be resolved to a type
            tracker = new CalorieTracker(fileNameInput, dateInput, nameInput, Double.parseDouble(weightInput), Integer.parseInt(ageInput), Double.parseDouble(heightInput), Double.parseDouble(consumedInput));
        } catch (IOException e) {
            System.err.println(e);
        }

        GroupLayout gl = new GroupLayout(this);
        setLayout(gl);

        gl.setAutoCreateGaps(true);
        gl.setAutoCreateContainerGaps(true);

        JLabel age = new JLabel("Age: " + ageInput, SwingConstants.CENTER);
        JLabel weight = new JLabel("Weight: " + weightInput + " lbs", SwingConstants.CENTER);
        JLabel height = new JLabel("Height: " + heightInput + " lbs", SwingConstants.CENTER);
        JLabel name = new JLabel(nameInput, SwingConstants.LEFT);
        JLabel date = new JLabel(dateInput, SwingConstants.RIGHT);
        JLabel waterConsumed = new JLabel("Calories Consumed: " + tracker.roundTwo(Double.parseDouble(consumedInput)) + " oz", SwingConstants.CENTER);
        JLabel waterGoal = new JLabel("Calories Goal: " + tracker.getCaloriesGoal() + " oz", SwingConstants.CENTER);
        JLabel waterRemaining = new JLabel("Calories Remaining: " + tracker.getCaloriesRemaining() + " oz", SwingConstants.CENTER);

        // JButton switchButton = new JButton("Switch Trackers");
        
        gl.setHorizontalGroup(gl.createParallelGroup(GroupLayout.Alignment.CENTER)
            .addGroup(gl.createSequentialGroup()
                // additional parameters for centering on window
                .addComponent(name, 0, manager.getWidth(), Short.MAX_VALUE)
                .addComponent(age, 0, manager.getWidth(), Short.MAX_VALUE)
                .addComponent(date, 0, manager.getWidth(), Short.MAX_VALUE))
            .addComponent(weight)
            .addComponent(waterConsumed)
            .addComponent(waterGoal)
            .addComponent(waterRemaining));

        gl.setVerticalGroup(gl.createSequentialGroup()
            .addGroup(gl.createParallelGroup(GroupLayout.Alignment.BASELINE)
                .addComponent(name)
                .addComponent(age)
                .addComponent(date))
            .addComponent(weight)
            .addComponent(waterConsumed)
            .addComponent(waterGoal)
            .addComponent(waterRemaining));
    }
}
