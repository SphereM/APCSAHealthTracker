import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class WaterTrackerUI extends JPanel {
    public WaterTrackerUI(GUIManager manager, String ageInput, String weightInput, String nameInput, String dateInput, String consumedInput) {
        // display Age, weight, name, date, 
        JLabel age = new JLabel("Age: " + ageInput);
        JLabel weight = new JLabel("Weight (in lbs): " + weightInput);
        JLabel name = new JLabel(nameInput);
        JLabel date = new JLabel(dateInput);
        JLabel waterConsumed = new JLabel("Water consumed: " + consumedInput);
        JLabel waterRemaining = new JLabel("Water remaining: ");

        GroupLayout gl = new GroupLayout(this);
        setLayout(gl);

        gl.setAutoCreateGaps(true);
        gl.setAutoCreateContainerGaps(true);

        gl.setHorizontalGroup(gl.createParallelGroup(GroupLayout.Alignment.CENTER)
            .addGroup(gl.createSequentialGroup()
                .addComponent(name)
                .addComponent(age)
                .addComponent(date))
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
