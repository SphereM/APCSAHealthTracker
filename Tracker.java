import java.util.Scanner;
import javax.lang.model.util.ElementScanner6;
import java.util.ArrayList;
import java.util.Random;
import java.io.*;
import java.lang.NumberFormatException;

public class Tracker {
    
    public static void main(String[] args) throws IOException  {
        Scanner userScan;
        File file;
        Scanner fileScan;
        PrintWriter output;


        System.out.println("Welcome to the Health Tracker! Please select a button on the menu!");

        try {

            userScan = new Scanner(System.in);

            Menu();
            int selection = Integer.parseInt(userScan.nextLine());

            while (selection < 4 && selection > 0) {
                
                if (selection == 1) {
                    System.out.println("What would you like to save the file as?\t");
                    String fileName = userScan.nextLine();
                    PrintWriter pw = new PrintWriter(fileName); // takes the file name entered and creates the file

                    System.out.println("Enter the date you want the data to be saved on: \n");
                    String nameGame = userScan.nextLine(); 

                    pw.write("Date: " + nameGame + "\n"); // puts the date into the file

                            System.out.println("Enter the amount of water in ounces: \t");
                            long water_intake = userScan.nextLong();

                            long total_water = water_intake;
                            // use the value of total_water later on, so that you can add onto it
                            // when they want to edit the file
                            // System.out.println(total_water);
                        
                            pw.write("Water in ounces: " + total_water); // enters the number of calories into the file

                            pw.write("\n"); // adds a line

                            System.out.println("Enter the amount of calories: \t");
                            long calorie_intake = userScan.nextLong();

                            long total_calorie = calorie_intake;
                            // use the value of total_water later on, so that you can add onto it
                            // when they want to edit the file
                            // System.out.println(total_calorie);
                        
                            pw.write("Calories:" + total_calorie); // enters the number of calories into the file

                    

                    pw.close();
                    

                }


                Menu();
                selection = Integer.parseInt(userScan.nextLine());
                

            }



        } catch (FileNotFoundException e) {
            System.out.println("** ERROR: File not found **");
            System.exit(0);

        } catch (NumberFormatException e) {
            System.out.println("NumberFormatException - Data is saved in the file.");
            
        }
    }


    public static void Menu() {
        System.out.println("\n ~~ MENU: ~~ \n(1) Create new file \n(2) Validate saved file \n(3) Edit an existing file \n(4) Quit game \n");
    }
}