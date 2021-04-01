import javax.swing.*;
import java.awt.*;

public class GUIManager extends JFrame {
    private void initWindow() {
        setSize(new Dimension(720, 480));
        setTitle("Health App");
        setLocationRelativeTo(null); 
        setDefaultCloseOperation(EXIT_ON_CLOSE);

        initHomeUI();
    }

    private void initHomeUI() {
        JPanel home = new HomeUI(this);
        setContentPane(home);
    }

    public void initNewFileUI() {
        JPanel newFile = new NewFileUI(this);
        setContentPane(newFile);
        revalidate();
    }

    public void initWaterTrackerUI(String fileNameInput, String ageInput, String weightInput, String nameInput, String dateInput, String consumedInput) {
        JPanel waterTracker = new WaterTrackerUI(this, fileNameInput, ageInput, weightInput, nameInput, dateInput, consumedInput);
        setContentPane(waterTracker);
        revalidate();
    }

    // public void switchPanel(JPanel panel) {
    //     setContentPane(panel);
    //     revalidate();
    // }

    public GUIManager() {
        initWindow();
    }
    
    public void start() {
        setVisible(true);
    }
}


