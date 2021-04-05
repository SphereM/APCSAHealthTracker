import java.util.Scanner;
import javax.lang.model.util.ElementScanner6;
import java.util.ArrayList;
import java.util.Random;
import java.io.*;
import java.lang.NumberFormatException;
import java.lang.Math;

public class Tracker {
    String fileName, date, name;
    double weight, height, waterConsumed, caloriesConsumed;
    int age;

    public Tracker(String fileName, String date, String name, double weight, int age, double height, double waterConsumed, double caloriesConsumed) throws IOException {
        this.fileName = fileName;
        this.date = date;
        this.name = name;
        this.weight = weight;
        this.age = age;
        this.height = height;
        this.waterConsumed = waterConsumed;
        this.caloriesConsumed = caloriesConsumed;

        PrintWriter pw = new PrintWriter(new File(fileName + ".txt"));

        // Only write relevant information for demo
        pw.write("Date: " + date + "\n");
        pw.write("Name: " + name + "\n");
        pw.write("Weight: " + weight + "\n");
        pw.write("Age: " + age + "\n");
        pw.write("Height: " + height + "\n");
        pw.write("Water Goal: " + getWaterGoal() + "\n");
        pw.write("Calories Goal: " + getCaloriesGoal() + "\n");
        pw.write("Water Consumed (Oz): " + waterConsumed + "\n");
        pw.write("Calories Consumed: " + caloriesConsumed + "\n");

        pw.close();    
    }

    
    public double getWaterGoal() {
        return roundTwo(((weight/2.2)*age)/28.3);
    }

    public double getCaloriesGoal() {
        return roundTwo((10*(weight/2.205) + 6.25*(height*2.54) - 5*age + 5) * 1.55);
    }

    public double getWaterRemaining() {
        return roundTwo(getWaterGoal() - waterConsumed);
    }

    public double getCaloriesRemaining() {
        return roundTwo(getCaloriesGoal() - caloriesConsumed);
    }

    public boolean waterGoalReached() { 
        return (getWaterGoal()-waterConsumed) <= 0;
    }

    public boolean goalCaloriesReached() { 
        return (getCaloriesGoal()-getCaloriesRemaining()) <= 0;
    }
    
    // Round to 2 decimal spaces
    public double roundTwo(double num) {
        return Math.round(num*10.0)/10.0;
    }

    // public static void main(String[] args) throws IOException  {
    //     Scanner userScan;
    //     File file;
    //     Scanner fileScan;
    //     PrintWriter output;


    //     System.out.println("Welcome to the Health Tracker! Please select a button on the menu!");

    //     try {

    //         userScan = new Scanner(System.in);

    //         Menu();
    //         int selection = Integer.parseInt(userScan.nextLine());

    //         while (selection < 4 && selection > 0) {
                
    //             if (selection == 1) {
    //                 System.out.println("What would you like to save the file as?\t");
    //                 String fileName = userScan.nextLine();
    //                 PrintWriter pw = new PrintWriter(fileName); // takes the file name entered and creates the file
    //                 // if you enter in the same file name, it overwrites the original data in the file

    //                 System.out.println("Enter the date you want the data to be saved on: \t");
    //                 String nameGame = userScan.nextLine(); 

    //                 pw.write("Date: " + nameGame + "\n"); // puts the date into the file

    //                 System.out.println("Please enter your name: \t");
    //                 String name = userScan.nextLine(); 

    //                 pw.write("\nName: " + name); // puts the name into the file



    //                         System.out.println("\nPlease enter your weight in pounds: ");
    //                         double weight = userScan.nextDouble();
    //                         pw.write("\nWeight: " + weight);

    //                         System.out.println("\nPlease enter your height in inches: ");
    //                         double height = userScan.nextDouble();
    //                         pw.write("\nHeight: " + height);

    //                         System.out.println("\nPlease enter your age: \t");
    //                         long age = userScan.nextLong();
    //                         pw.write("\nAge: " + age);


    //                         double water_goal = ((weight/2.2)*age)/28.3;
    //                         System.out.println("Healthy goal for water consumption: \t" + water_goal);
    //                         pw.write("\nHealthy goal for water consumption: " + water_goal);
                    

    //                         double calorie_goal = (10 * (weight / 2.205) + 6.25 * (height * 2.54) - 5 * age + 5) * 1.55;
    //                         System.out.println("Healthy goal for calories consumption: \t" + calorie_goal);
    //                         pw.write("\nHealthy goal for calorie consumption: " + calorie_goal);

                            
    //                         System.out.println("Enter the amount of water in ounces: \t");
    //                         long water_intake = userScan.nextLong();

    //                         long total_water = water_intake;
        
                        
    //                         pw.write("Water in ounces: " + total_water); // enters the number of water oz into the file

    //                         double water_goal_reached = water_goal - total_water;
    //                         pw.write("\n"); // adds a line

    //                         System.out.println("\nOunces of Water left to reach healthy goal: " + water_goal_reached);
    //                         pw.write("\nOunces of Water left to reach healthy goal: " + water_goal_reached);

    //                         System.out.println("Enter the amount of calories: \t");
    //                         long calorie_intake = userScan.nextLong();

    //                         long total_calorie = calorie_intake;

    //                         pw.write("Calories: " + total_calorie); // enters the number of water oz into the file

    //                         double calorie_goal_reached = water_goal - total_water;
    //                         pw.write("\n"); // adds a line

    //                         System.out.println("\nCalories left to reach healthy goal: " + calorie_goal_reached);
    //                         pw.write("Calories left to reach healthy goal: " + calorie_goal_reached);
                            
                        
    //                         // pw.write("Calories:" + total_calorie); // enters the number of calories into the file

                    

    //                 pw.close();
                    

    //             }


    //             Menu();
    //             selection = Integer.parseInt(userScan.nextLine());
                

    //         }



    //     } catch (FileNotFoundException e) {
    //         System.out.println("** ERROR: File not found **");
    //         System.exit(0);

    //     } catch (NumberFormatException e) {
    //         System.out.println("NumberFormatException - Data is saved in the file.");
            
    //     }
    // }


    // public static void Menu() {
    //     System.out.println("\n ~~ MENU: ~~ \n(1) Create new file \n(2) Validate saved file \n(3) Edit an existing file \n(4) Quit game \n");
    // }
}