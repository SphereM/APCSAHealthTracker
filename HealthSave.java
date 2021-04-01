import java.util.Scanner;
import javax.lang.model.util.ElementScanner6;
import java.util.ArrayList;
import java.util.Random;
import java.io.*;

public class HealthSave {
    
    
    public void editFile(String fileToEdit) throws IOException {
    
   
        Scanner userScan;
        File file;
        Scanner fileScan;
        String oldContent = "";
        BufferedReader reader = null;
        FileWriter writer = null;

        
        // int selection;

        

        try {

            userScan = new Scanner(System.in);

            
                System.out.println("What file would you like to edit?\t");
                String fileName = userScan.nextLine();
                reader = new BufferedReader(new FileReader(fileName));
                String line = reader.readLine();
                String edit = "";

                while (line != null){
                    oldContent = oldContent + line + System.lineSeparator();

                    line = reader.readLine();
                    }

                            // keep track of water stuff
                System.out.println("Enter the amount of water in ounces: \n");
                int water_intake = userScan.nextInt();

                int total_water = water_intake; // use the value of total_water later on, so that you can add onto it
                    //System.out.println(total_water);
                edit = edit + "Water in ounces:" + total_water+"\n";


                            // keep track of calories stuff
                System.out.println("Enter the amount of calories: \n");
                int calorie_intake = userScan.nextInt();
                int total_calorie = calorie_intake; // use the value of total_water later on, so that you can add onto it
                //System.out.println(total_calorie);
                    
                edit = edit + "Calories:" + total_calorie+"\n";

                String newContent = oldContent.replaceAll(oldContent, edit);
                writer = new FileWriter(fileName);
                writer.write(newContent);
                    
                    //selection = 5;

                    //fw.close();
                reader.close();
                writer.close();
            } catch(IOException e) {
                
            }

    }
}