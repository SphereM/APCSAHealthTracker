import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.IOException;

public class WaterTrackerUI extends JPanel {
    public WaterTrackerUI(GUIManager manager, String fileNameInput, String ageInput, String weightInput, String nameInput, String dateInput, String consumedInput) {
        Tracker tracker = null;
        
        try {
            tracker = new Tracker(fileNameInput, dateInput, nameInput, Double.parseDouble(weightInput), Integer.parseInt(ageInput), Double.parseDouble(consumedInput));
        } catch (IOException e) {
            System.err.println(e);
        }

        GroupLayout gl = new GroupLayout(this);
        setLayout(gl);

        gl.setAutoCreateGaps(true);
        gl.setAutoCreateContainerGaps(true);

        JLabel age = new JLabel("Age: " + ageInput, SwingConstants.CENTER);
        JLabel weight = new JLabel("Weight: " + weightInput + " lbs", SwingConstants.CENTER);
        JLabel name = new JLabel(nameInput, SwingConstants.LEFT);
        JLabel date = new JLabel(dateInput, SwingConstants.RIGHT);
        JLabel waterConsumed = new JLabel("Water consumed: " + tracker.roundOne(consumedInput) + " oz", SwingConstants.CENTER);
        JLabel waterGoal = new JLabel("Water Goal: " + tracker.getWaterGoal() + " oz", SwingConstants.CENTER);
        JLabel waterRemaining= new JLabel("Water Remaining: " + tracker.getWaterRemaining() + " oz", SwingConstants.CENTER);
        // it is the same math for the calories tracker except for the original equation used -> gonna close the sessions -> 
        // sounds good, need to add another line for the water math to say how much is left,
        // sine line 20 is about the goal, not how much of the goal is left

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
