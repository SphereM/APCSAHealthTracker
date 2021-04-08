import javax.swing.*;
import java.awt.*;
import java.io.IOException;

public class GUIManager extends JFrame {
    JPanel home, newFile, editFile, waterTracker, calorieTracker;
    boolean isWaterTracker;
    Tracker tracker;

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

    public void initEditFileUI() {
        editFile = new FileEditUI(this);
        setContentPane(editFile);
        revalidate();
    }

    public void initTrackerUIs(String fileNameInput, String ageInput, String weightInput, String heightInput, String nameInput, String dateInput, String waterInput, String caloriesInput) {        
        try {
            tracker = new Tracker(fileNameInput, dateInput, nameInput, Double.parseDouble(weightInput), Integer.parseInt(ageInput), Double.parseDouble(heightInput), Double.parseDouble(waterInput), Double.parseDouble(caloriesInput));
        } catch (IOException e) {
            System.err.println(e);
        }

        waterTracker = new WaterTrackerUI(this, tracker);
        calorieTracker = new CalorieTrackerUI(this, tracker);
        isWaterTracker = true;
        setContentPane(waterTracker);
        revalidate();
    }

    public void switchTracker() { 
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


