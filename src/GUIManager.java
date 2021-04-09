import javax.swing.*;
import java.awt.*;
import java.io.IOException;
import java.io.*;

public class GUIManager extends JFrame {
    JPanel home, newFile, selectFile, updateFile, waterTracker, calorieTracker;
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

    public void initFileSelectUI() {
        selectFile = new FileSelectUI(this);
        setContentPane(selectFile);
        revalidate();
    }

    public void initFileUpdateUI(File file) {
        updateFile = new UpdateFileUI(this, file);
        setContentPane(updateFile);
        revalidate();
    }

    public void initTrackerUIs(String fileNameInput, int ageInput, double weightInput, double heightInput, String nameInput, String dateInput, double waterInput, double caloriesInput) {        
        try {
            tracker = new Tracker(fileNameInput, dateInput, nameInput, weightInput, ageInput, heightInput, waterInput, caloriesInput);
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


