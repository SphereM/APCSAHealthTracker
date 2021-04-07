import javax.swing.*;
import java.awt.event.*;
import java.io.IOException;

public class CalorieTrackerUI extends JPanel {

    public CalorieTrackerUI(GUIManager manager, String fileNameInput, String ageInput, String heightInput, String nameInput, String dateInput, String consumedInput) {
        Tracker tracker = null;
        
        try {
            tracker = new Tracker(fileNameInput, dateInput, nameInput, -1, Integer.parseInt(ageInput), Double.parseDouble(heightInput), -1, Double.parseDouble(consumedInput));
            //                    fileName,      date,      name,      weight, age,                      height,                          waterConsumed, caloriesConsumed
        } catch (IOException e) {
            System.err.println(e);
        }

        GroupLayout gl = new GroupLayout(this);
        setLayout(gl);

        gl.setAutoCreateGaps(true);
        gl.setAutoCreateContainerGaps(true);

        JLabel title = new JLabel("Calorie Tracker", SwingConstants.CENTER);
        JLabel age = new JLabel("Age: " + ageInput + " years old", SwingConstants.CENTER);
        JLabel height = new JLabel("Height: " + heightInput + " lbs", SwingConstants.CENTER);
        JLabel name = new JLabel(nameInput, SwingConstants.LEFT);
        JLabel date = new JLabel(dateInput, SwingConstants.RIGHT);
        JLabel caloriesConsumed = new JLabel("Calories Consumed: " + tracker.roundTwo(Double.parseDouble(consumedInput)) + " cal", SwingConstants.CENTER);
        JLabel caloriesGoal = new JLabel("Calories Goal: " + tracker.getCaloriesGoal() + " cal", SwingConstants.CENTER);
        JLabel goalMessage = tracker.goalCaloriesReached() ? 
            new JLabel("Nice Job! You consumed " + Math.abs(tracker.getCaloriesRemaining()) + " calories over your goal! :)", SwingConstants.CENTER) : 
            new JLabel("You're getting there! " + tracker.getCaloriesRemaining() + " calories left to consume!", SwingConstants.CENTER);

        JButton switchButton = new JButton("Switch Trackers");

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
            .addComponent(caloriesConsumed)
            .addComponent(caloriesGoal)
            .addComponent(goalMessage));
    }
}
