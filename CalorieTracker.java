import java.util.Scanner;
import javax.lang.model.util.ElementScanner6;
import java.util.ArrayList;
import java.util.Random;
import java.io.*;
import java.lang.NumberFormatException;
import java.lang.Math;

public class CalorieTracker { // extend from Tracker.java later
    String fileName, date, name;
    double consumed, height, weight; // minCalories
    int age;

    public CalorieTracker(String fileName, String date, String name, int age, double height, double weight, double consumed) throws IOException {
        this.fileName = fileName;
        this.date = date;
        this.name = name;
        this.age = age;
        this.height = height;
        this.weight = weight;
        this.consumed = consumed;
        // this.minCalories = minCalories;

        PrintWriter pw = new PrintWriter(new File(fileName + ".txt"));

        // Only write relevant information for demo
        pw.write("Date: " + date + "\n");
        pw.write("Name: " + name + "\n");
        pw.write("Age: " + age + "\n");
        pw.write("Height (in.): " + height + "\n");
        pw.write("Weight (lbs.): " + weight + "\n");
        pw.write("Goal: " + getCaloriesGoal() + "\n");
        pw.write("Water Consumed (oz.): " + consumed + "\n");
        pw.write("Calories Consumed: " + consumed + "\n");

        pw.close();
    }


    public double getCaloriesGoal() {
        if (roundTwo(10*(weight/2.205) + 6.25*(height*2.54) - 5*age + 5) * 1.55 < 1200) {
            return 1200;
        } else {
            return roundTwo(10*(weight/2.205) + 6.25*(height*2.54) - 5*age + 5) * 1.55;
        }
    }

    public double getCaloriesRemaining() {
        return roundTwo(getCaloriesGoal() - consumed);
    }

    public boolean goalCaloriesReached() { 
        return (getCaloriesGoal()-getCaloriesRemaining()) <= 0;
    }

    // calories math   
    public double roundTwo(double num) {
        return Math.round(num*10.0)/10.0; 
    }

    public double caloriesMin(double num) {
        if (consumed < 1200) {
            // minCalories = getCaloriesGoal() - consumed;
            // return minCalories;
            return getCaloriesGoal() - consumed; // no need for variable - sounds good
        }

        return consumed;
    }


}