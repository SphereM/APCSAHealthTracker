import javax.swing.*;
import java.awt.*;

public class GUIManager extends JFrame {
    JPanel home, newFile, waterTracker, calorieTracker;

    private void initWindow() {
        setSize(new Dimension(720, 480));
        setTitle("Health App");
        setLocationRelativeTo(null); 
        setDefaultCloseOperation(EXIT_ON_CLOSE);

        initHomeUI();
    }

    private void initHomeUI() {
        home = new HomeUI(this);
        setContentPane(home);
    }

    public void initNewFileUI() {
        newFile = new NewFileUI(this);
        setContentPane(newFile);
        revalidate();
    }

    public void initTrackerUIs(String fileNameInput, String ageInput, String weightInput, String nameInput, String dateInput, String consumedInput) {
        waterTracker = new WaterTrackerUI(this, fileNameInput, ageInput, weightInput, nameInput, dateInput, consumedInput);
        // JPanel calorieTracker = new CalorieTrackerUI();
        setContentPane(waterTracker);
        revalidate();
    }

    // // // fancy stuff maybe idk
    // public void switchTracker(JPanel tracker) { // probably bad practice but whatever
    //     if (tracker.equals(waterTracker)) { setContentPane(calorieTracker); } 
    //     else if (tracker.equals(calorieTracker)) { setContentPane(waterTracker); }

    //     revalidate();
    // }

    public GUIManager() {
        initWindow();
    }
    
    public void start() {
        setVisible(true);
    }
}


