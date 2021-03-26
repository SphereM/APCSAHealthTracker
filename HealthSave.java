import java.util.Scanner;
import javax.lang.model.util.ElementScanner6;
import java.util.ArrayList;
import java.util.Random;
import java.io.*;

public class HealthSave {
    
    public static void main(String[] args) throws IOException {
        Scanner userScan;
        File file;
        Scanner fileScan;
        PrintWriter output;

        
        // int selection;

        System.out.println("Welcome to the Health Tracker! Select a button on the menu!");

        try {

            userScan = new Scanner(System.in);

            Menu();
            int selection = Integer.parseInt(userScan.nextLine());
            
            while (selection < 4 && selection > 0) {
                
                if (selection == 3) {
                    System.out.println("What file would you like to edit?\t");
                    String fileName = userScan.nextLine();
                    FileWriter fw = new FileWriter(fileName);

                            // keep track of water stuff
                    System.out.println("Enter the amount of water in ounces: \n");
                    int water_intake = userScan.nextInt();

                    long total_water = water_intake; // use the value of total_water later on, so that you can add onto it
                    //System.out.println(total_water);
                    fw.write("Water in ounces:" + total_water);


                            // keep track of calories stuff
                    System.out.println("Enter the amount of calories: \n");
                    int calorie_intake = userScan.nextInt();
                    int total_calorie = calorie_intake; // use the value of total_water later on, so that you can add onto it
                    //System.out.println(total_calorie);
                    
                    fw.write("Calories:" + total_calorie);

                    }
                    selection = 5;

                    //fw.close();

                }

                Menu();
                selection = Integer.parseInt(userScan.nextLine());

            



        } catch (FileNotFoundException e) {
            System.out.println("**Error: File not found.**");
            System.exit(0);
        } catch (NumberFormatException e) {
            System.out.println("NumberFormatException - Data is saved in the file.");
        }
    }

    public static void Menu() {
        System.out.println("\n ~~ MENU: ~~ \n(1) Create new file \n(2) Validate saved file \n(3) Edit an existing file \n(4) Quit game \n");
    }
}