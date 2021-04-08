import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class WaterTrackerUI extends JPanel {
    public WaterTrackerUI(GUIManager manager, Tracker tracker) {
        GroupLayout gl = new GroupLayout(this);
        setLayout(gl);

        gl.setAutoCreateGaps(true);
        gl.setAutoCreateContainerGaps(true);

        JLabel title = new JLabel("Water Tracker", SwingConstants.CENTER);
        title.setFont(new Font("Roboto", Font.BOLD, 16));
        JLabel age = new JLabel("Age: " + tracker.getAge() + " years old", SwingConstants.CENTER);
        JLabel weight = new JLabel("Weight: " + tracker.getWeight() + " lbs", SwingConstants.CENTER);
        JLabel name = new JLabel(tracker.getName(), SwingConstants.CENTER);
        JLabel date = new JLabel(tracker.getDate(), SwingConstants.CENTER);
        JLabel waterConsumed = new JLabel("Water Consumed: " + tracker.getWaterConsumed() + " oz", SwingConstants.CENTER);
        JLabel waterGoal = new JLabel("Water Goal: " + tracker.getWaterGoal() + " oz", SwingConstants.CENTER);
        JLabel goalMessage = tracker.waterGoalReached() ? 
            new JLabel("Nice Job! You drank " + Math.abs(tracker.getWaterRemaining()) + " oz over your goal! :)", SwingConstants.CENTER) : 
            new JLabel("You're getting there! " + tracker.getWaterRemaining() + " oz left to drink!", SwingConstants.CENTER);

        JButton switchButton = new JButton("Switch Trackers");
        switchButton.setBackground(new Color(102, 162, 114));
        switchButton.setForeground(Color.WHITE);
        switchButton.setFocusPainted(false);
        switchButton.setFont(new Font("Roboto", Font.BOLD, 20));

        switchButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                manager.switchTracker();
            }
        });
        
        gl.setHorizontalGroup(gl.createParallelGroup(GroupLayout.Alignment.CENTER)
            .addGroup(gl.createSequentialGroup()
                .addComponent(title))
            .addGroup(gl.createSequentialGroup()
                .addComponent(name, 0, manager.getWidth()/4, Short.MAX_VALUE)
                .addComponent(age, 0, manager.getWidth()/4, Short.MAX_VALUE)
                .addComponent(date, 0, manager.getWidth()/4, Short.MAX_VALUE)
                .addComponent(switchButton))
            .addComponent(weight)
            .addComponent(waterConsumed)
            .addComponent(waterGoal)
            .addComponent(goalMessage));

        gl.setVerticalGroup(gl.createSequentialGroup()
            .addGroup(gl.createParallelGroup(GroupLayout.Alignment.BASELINE))
            .addGroup(gl.createParallelGroup(GroupLayout.Alignment.BASELINE)
                .addComponent(name)
                .addComponent(age)
                .addComponent(date)
                .addComponent(switchButton))
            .addComponent(weight)
            .addComponent(waterConsumed)
            .addComponent(waterGoal)
            .addComponent(goalMessage));
    }

}
