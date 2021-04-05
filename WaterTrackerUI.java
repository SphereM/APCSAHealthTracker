import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.IOException;

public class WaterTrackerUI extends JPanel {
    public WaterTrackerUI(GUIManager manager, String fileNameInput, String ageInput, String weightInput, String nameInput, String dateInput, String consumedInput) {
        Tracker tracker = null;

        try {
            tracker = new Tracker(fileNameInput, dateInput, nameInput, Double.parseDouble(weightInput), 0, Integer.parseInt(ageInput), Double.parseDouble(consumedInput), 0);
        } catch (IOException e) {
            System.err.println(e);
        }

        GroupLayout gl = new GroupLayout(this);
        setLayout(gl);

        gl.setAutoCreateGaps(true);
        gl.setAutoCreateContainerGaps(true);

        JLabel age = new JLabel("Age: " + ageInput + " years old", SwingConstants.CENTER);
        JLabel weight = new JLabel("Weight: " + weightInput + " lbs", SwingConstants.CENTER);
        JLabel name = new JLabel(nameInput, SwingConstants.LEFT);
        JLabel date = new JLabel(dateInput, SwingConstants.RIGHT);
        JLabel waterConsumed = new JLabel("Water Consumed: " + tracker.roundTwo(Double.parseDouble(consumedInput)) + " oz", SwingConstants.CENTER);
        JLabel waterGoal = new JLabel("Water Goal: " + tracker.getWaterGoal() + " oz", SwingConstants.CENTER);
        JLabel goalMessage = tracker.goalReached() ? 
            new JLabel("Nice Job! You drank " + Math.abs(tracker.getWaterRemaining()) + " oz over your goal! :)", SwingConstants.CENTER) : 
            new JLabel("You're getting there! " + tracker.getWaterRemaining() + " oz left to drink!", SwingConstants.CENTER);

        JButton switchButton = new JButton("Switch Trackers");
// time to go now
        switchButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                manager.switchTracker(this);
            }
        });
        
        gl.setHorizontalGroup(gl.createParallelGroup(GroupLayout.Alignment.CENTER)
            .addGroup(gl.createParallelGroup(GroupLayout.Alignment.LEADING)
                // additional parameters for centering on window
                .addComponent(name, 0, manager.getWidth(), Short.MAX_VALUE)
                .addComponent(age, 0, manager.getWidth(), Short.MAX_VALUE)
                .addComponent(date, 0, manager.getWidth(), Short.MAX_VALUE))
            .addComponent(weight)
            .addComponent(waterConsumed)
            .addComponent(waterGoal)
            .addComponent(goalMessage));

        gl.setVerticalGroup(gl.createSequentialGroup()
            .addGroup(gl.createParallelGroup(GroupLayout.Alignment.BASELINE)
                .addComponent(name)
                .addComponent(age)
                .addComponent(date))
            .addComponent(weight)
            .addComponent(waterConsumed)
            .addComponent(waterGoal)
            .addComponent(goalMessage));
    }
}
