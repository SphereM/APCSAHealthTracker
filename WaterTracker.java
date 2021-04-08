import java.io.*;
import java.lang.Math;

public class WaterTracker { // extend from Tracker.java later
    String fileName, date, name;
    double weight, consumed;
    int age;

    public WaterTracker(String fileName, String date, String name, double weight, int age, double consumed) throws IOException {
        this.fileName = fileName;
        this.date = date;
        this.name = name;
        this.weight = weight;
        this.age = age;
        this.consumed = consumed;

        PrintWriter pw = new PrintWriter(new File(fileName + ".txt"));

        pw.write("Date: " + date + "\n");
        pw.write("Name: " + name + "\n");
        pw.write("Age: " + age + " years old.\n");
        pw.write("Weight (lbs.): " + weight + "\n");
        pw.write("Water Goal: " + getWaterGoal() + "\n");
        pw.write("Water Consumed (oz.): " + consumed + "\n");
        pw.write("Calories Consumed: " + consumed + "\n");

        pw.close();    
    }
    
    public double getWaterGoal() {
        return roundOne(((weight/2.2)*age)/28.3);
    }

    public double getWaterRemaining() {
        return roundOne(getWaterGoal() - consumed);
    }

    public boolean goalReached() { 
        return (getWaterGoal()-getWaterRemaining()) <= 0;
    }
    
    public double roundOne(double num) {
        return Math.round(num*10.0)/10.0;
    }

}