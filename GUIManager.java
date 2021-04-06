import javax.swing.*;
import java.awt.*;

public class GUIManager extends JFrame {
    JPanel home, newFile, editFile, waterTracker, calorieTracker;
    boolean isWaterTracker;

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

    public void editFileUI() {
        editFile = new FileEditUI(this);
        setContentPane(editFile);
        revalidate();
    }

    public void initTrackerUIs(String fileNameInput, String ageInput, String weightInput, String heightInput, String nameInput, String dateInput, String waterInput, String caloriesInput) {
        waterTracker = new WaterTrackerUI(this, fileNameInput, ageInput, weightInput, nameInput, dateInput, waterInput);
        calorieTracker = new CalorieTrackerUI(this, fileNameInput, ageInput, heightInput, nameInput, dateInput, caloriesInput);
        isWaterTracker = true;
        setContentPane(waterTracker);
        revalidate();
    }

    // // // fancy stuff maybe idk
    public void switchTracker() { // probably bad practice but whatever
        if (isWaterTracker) {
            setContentPane(calorieTracker);
            isWaterTracker = false;
        } else {
            setContentPane(waterTracker);
            isWaterTracker = true;
        }

        revalidate();
    }

    public GUIManager() {
        initWindow();
    }
    
    public void start() {
        setVisible(true);
    }
}


