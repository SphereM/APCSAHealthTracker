import java.io.*;
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

        pw.write("Date: " + date + "\n");
        pw.write("Name: " + name + "\n");
        pw.write("Weight: " + weight + "\n");
        pw.write("Height: " + height + "\n");
        pw.write("Age: " + age + "\n");
        pw.write("Water Consumed: " + waterConsumed + "\n");
        pw.write("Calories Consumed: " + caloriesConsumed + "\n");

        pw.close();    
    }

    // Water Math
    public double getWaterGoal() {
        return roundOne(((weight/2.2)*age)/28.3);
    }

    public double getWaterRemaining() {
        return roundOne(getWaterGoal() - waterConsumed);
    }
    
    public boolean waterGoalReached() { 
        return (getWaterGoal()-waterConsumed) <= 0;
    }

    // Calories Math
    public double getCaloriesGoal() {
        return roundOne((10*(weight/2.205) + 6.25*(height*2.54) - 5*age + 5) * 1.55);
    }

    public double getCaloriesRemaining() {
        return roundOne(getCaloriesGoal() - caloriesConsumed);
    }

    public boolean goalCaloriesReached() { 
        return (getCaloriesGoal()-getCaloriesRemaining()) <= 0;
    }
  
    // assisting method
    private double roundOne(double num) {
        return Math.round(num*10.0)/10.0;
    }

    // Getters
    public String getDate() { return date; }
    public String getName() { return name; }
    public double getWeight() { return roundOne(weight); }
    public double getHeight() { return roundOne(height); }
    public int getAge() { return age; }
    public double getWaterConsumed() { return roundOne(waterConsumed); }
    public double getCaloriesConsumed() { return roundOne(caloriesConsumed);}

    // Setters
    
}