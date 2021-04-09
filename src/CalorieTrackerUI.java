import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class CalorieTrackerUI extends JPanel {

    public CalorieTrackerUI(GUIManager manager, Tracker tracker) {
        GroupLayout gl = new GroupLayout(this);
        setLayout(gl);

        gl.setAutoCreateGaps(true);
        gl.setAutoCreateContainerGaps(true);

        JLabel title = new JLabel("Calorie Tracker", SwingConstants.CENTER);
        title.setFont(new Font("Roboto", Font.BOLD, 20));
        JLabel age = new JLabel(tracker.getAge() + " years old", SwingConstants.CENTER);
        JLabel height = new JLabel("Height: " + tracker.getHeight() + " in", SwingConstants.CENTER);
        JLabel weight = new JLabel("Weight: " + tracker.getWeight() + " lbs", SwingConstants.CENTER);
        JLabel name = new JLabel(tracker.getName(), SwingConstants.CENTER);
        JLabel date = new JLabel(tracker.getDate(), SwingConstants.CENTER);
        JLabel caloriesConsumed = new JLabel("Calories Consumed: " + tracker.getCaloriesConsumed() + " cal", SwingConstants.CENTER);
        JLabel caloriesGoal = new JLabel("Calories Goal: " + tracker.getCaloriesGoal() + " cal", SwingConstants.CENTER);
        JLabel goalMessage = tracker.goalCaloriesReached() ? 
            new JLabel("Nice Job! You consumed " + Math.abs(tracker.getCaloriesRemaining()) + " calories over your goal! :)", SwingConstants.CENTER) : 
            new JLabel("You're getting there! " + tracker.getCaloriesRemaining() + " calories left to consume!", SwingConstants.CENTER);
        goalMessage.setFont(new Font("Roboto", Font.BOLD, 14));

        JButton switchButton = new JButton("Switch Trackers");
        switchButton.setBackground(new Color(102, 162, 114));
        switchButton.setForeground(Color.WHITE);
        switchButton.setFocusPainted(false);
        switchButton.setFont(new Font("Roboto", Font.BOLD, 12));

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
                .addComponent(name, 0, manager.getWidth(), Short.MAX_VALUE)
                .addComponent(age, 0, manager.getWidth(), Short.MAX_VALUE)
                .addComponent(date, 0, manager.getWidth(), Short.MAX_VALUE)
                .addComponent(switchButton))
            .addComponent(height)
            .addComponent(weight)
            .addComponent(caloriesConsumed)
            .addComponent(caloriesGoal)
            .addComponent(goalMessage));

        gl.setVerticalGroup(gl.createSequentialGroup()
            .addGroup(gl.createParallelGroup(GroupLayout.Alignment.BASELINE)
                .addComponent(title))
            .addGroup(gl.createParallelGroup(GroupLayout.Alignment.BASELINE)
                .addComponent(name)
                .addComponent(age)
                .addComponent(date)
                .addComponent(switchButton))
            .addComponent(height)
            .addComponent(weight)
            .addComponent(caloriesConsumed)
            .addComponent(caloriesGoal)
            .addComponent(goalMessage));
    }
}
