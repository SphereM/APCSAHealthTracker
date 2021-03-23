import java.util.Scanner;
import javax.lang.model.util.ElementScanner6;
import java.util.ArrayList;
import java.util.Random;
import java.io.*;

public class Tracker {
    
    public static void main(String[] args) throws IOException {
        Scanner userScan;
        File file;
        Scanner fileScan;
        PrintWriter output;

        int selection;

        System.out.println("Welcome to the Health Tracker! Select a button on the menu!");

        try {

            userScan = new Scanner(System.in);

            Menu();
            int selection = Integer.parseInt(userScan.nextLine());

            while (selection < 4 && selection > 0) {
                
                if (selection == 1) {
                    System.out.println("What would you like to save the file as?\t");
                    String fileName = userScan.nextLine();
                    PrintWriter pw = new PrintWriter(fileName);

                    pw.write("Your selection number is : " + selection + "\n");
                    
                    long water_remaining = 0;
                    long existing_water = 0;

                    long calorie_intake = 0;
                    long calorie_remaining = 0;
                    long exisitng_calorie = 0;

                    System.out.println("Enter the date you want the data to be saved on: \n");
                    String nameGame = userScan.nextLine();
                    pw.write("Date : " + nameGame + "\n");

                    System.out.println("Enter the data you want to enter: \n");
                    System.out.println("| Water | Calories |\n");
                    String type = userScan.nextLine();

                    if (type.equals("Water")) {
                        // keep track of water stuff
                        System.out.println("Enter the amount of water in ounces: \n");
                        long water_intake = userScan.nextLine();

                        long total_water = water_intake; // use the value of total_water later on, so that you can add onto it
                        System.out.println(total_water);
                        
                        // 


                    } else if (type.equals("Calories")) {
                        // keep track of calories stuff

                        
                    }

                    pw.close();

                }

                Menu();
                selection = Integer.parseInt(userScan.nextLine());

            }



        } catch (FileNotFoundException e) {
            System.out.println("**Error: File not found.**");
            System.exit(0);
        }
    }


    public static void Menu() {
        System.out.println("\n ~~ MENU: ~~ \n(1) Create new file \n(2) Validate saved file \n(3) Edit an existing file \n(4) Quit game \n");
    }
}