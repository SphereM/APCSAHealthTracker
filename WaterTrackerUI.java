import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class WaterTrackerUI extends JPanel {
    public WaterTrackerUI(GUIManager manager, String ageInput, String weightInput, String nameInput, String dateInput, String consumedInput) {
        Tracker tracker = new Tracker();
        
        GroupLayout gl = new GroupLayout(this);
        setLayout(gl);

        gl.setAutoCreateGaps(true);
        gl.setAutoCreateContainerGaps(true);

        JLabel age = new JLabel("Age: " + ageInput, SwingConstants.CENTER);
        JLabel weight = new JLabel("Weight (in lbs): " + weightInput, SwingConstants.CENTER);
        JLabel name = new JLabel(nameInput, SwingConstants.LEFT);
        JLabel date = new JLabel(dateInput, SwingConstants.RIGHT);
        JLabel waterConsumed = new JLabel("Water consumed: " + consumedInput, SwingConstants.CENTER);
        JLabel waterRemaining = new JLabel("Water remaining: ", SwingConstants.CENTER);

        // JButton switchButton = new JButton("Switch Trackers");

        gl.setHorizontalGroup(gl.createParallelGroup(GroupLayout.Alignment.CENTER)
            .addGroup(gl.createSequentialGroup()
                // additional parameters for centering on window
                .addComponent(name, 0, manager.getWidth(), Short.MAX_VALUE)
                .addComponent(age, 0, manager.getWidth(), Short.MAX_VALUE)
                .addComponent(date, 0, manager.getWidth(), Short.MAX_VALUE))
            .addComponent(weight)
            .addComponent(waterConsumed)
            .addComponent(waterRemaining));

        gl.setVerticalGroup(gl.createSequentialGroup()
            .addGroup(gl.createParallelGroup(GroupLayout.Alignment.BASELINE)
                .addComponent(name)
                .addComponent(age)
                .addComponent(date))
            .addComponent(weight)
            .addComponent(waterConsumed)
            .addComponent(waterRemaining));
    }
}
