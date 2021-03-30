import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class GUIManager extends JFrame implements ActionListener {
    private JPanel home = new JPanel();
    private JPanel newFile = new JPanel();

    private void initWindow() { // Maybe separate methods for UIs
        setSize(new Dimension(720, 480));
        setTitle("Health App");
        setLocationRelativeTo(null); 
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        
        initHomeUI();
    }

    private void initHomeUI() {
        // uses FlowLayout by default and it's fine as is
        JButton newFileButton = new JButton("Create a new file");
        JButton existingFileButton = new JButton("Use existing file");

        newFileButton.setPreferredSize(new Dimension(250, 250));
        existingFileButton.setPreferredSize(new Dimension(250, 250));

        newFileButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                initNewFileUI();
                setContentPane(newFile);
                invalidate();
                validate();
            }
        });

        home.add(newFileButton);
        home.add(existingFileButton);

        setContentPane(home); // inital setting 
    }

    private void initNewFileUI() {
        GroupLayout gl = new GroupLayout(newFile);
        newFile.setLayout(gl);
        
        gl.setAutoCreateGaps(true);
        gl.setAutoCreateContainerGaps(true);

        JLabel title = new JLabel("Create a new file", SwingConstants.CENTER);
        JLabel date = new JLabel("Input Date (mm/dd/yy):", SwingConstants.RIGHT);
        JLabel water = new JLabel("Input water consumed (in oz):", SwingConstants.RIGHT);
        JLabel error = new JLabel("", SwingConstants.CENTER);
        JTextField inputDate = new JTextField();
        JTextField inputWater = new JTextField();
        JButton submitButton = new JButton("Submit");

        submitButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String dateValue = inputDate.getText();
                double waterValue = Double.parseDouble(inputWater.getText()); // assume value is always a number

                // Save debugging for later
                // try {
                //     double waterValue = Double.parseDouble(inputWater.getText());
                // } catch (NumberFormatException error) {
                //     error.setText("Error: Given values are not in correct format");
                // }

                // send date to tracker for saving
            }
        });

        gl.setHorizontalGroup(gl.createParallelGroup(GroupLayout.Alignment.CENTER)
            .addComponent(title, 100, getWidth(), Short.MAX_VALUE)
            .addGroup(gl.createSequentialGroup()
                .addGroup(gl.createParallelGroup(GroupLayout.Alignment.TRAILING)
                    .addComponent(date)
                    .addComponent(water))
                .addGroup(gl.createParallelGroup(GroupLayout.Alignment.LEADING)
                    .addComponent(inputDate)
                    .addComponent(inputWater)))
            .addComponent(submitButton)
            .addComponent(error)
        );

        gl.setVerticalGroup(gl.createSequentialGroup()
            .addComponent(title)
            .addGroup(gl.createParallelGroup(GroupLayout.Alignment.BASELINE)
                .addComponent(date)
                .addComponent(inputDate))
            .addGroup(gl.createParallelGroup(GroupLayout.Alignment.BASELINE)
                .addComponent(water)
                .addComponent(inputWater))
            .addComponent(submitButton)
            .addComponent(error)
        );
    }

    public GUIManager() {
        initWindow();
    }
    
    public void start() {
        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        // Can't compile without
    }
}


