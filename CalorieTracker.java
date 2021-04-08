import java.io.*;
import java.lang.Math;

public class CalorieTracker { // extend from Tracker.java later
    String fileName, date, name;
    double consumed, height, weight;
    int age;

    public CalorieTracker(String fileName, String date, String name, int age, double height, double weight, double consumed) throws IOException {
        this.fileName = fileName;
        this.date = date;
        this.name = name;
        this.age = age;
        this.height = height;
        this.weight = weight;
        this.consumed = consumed;

        PrintWriter pw = new PrintWriter(new File(fileName + ".txt"));

        pw.write("Date: " + date + "\n");
        pw.write("Name: " + name + "\n");
        pw.write("Age: " + age + " years old.\n");
        pw.write("Height (in.): " + height + "\n");
        pw.write("Weight (lbs.): " + weight + "\n");
        pw.write("Calories Goal: " + getCaloriesGoal() + "\n");
        pw.write("Water Consumed (oz.): " + consumed + "\n");
        pw.write("Calories Consumed: " + consumed + "\n");

        pw.close();
    }

    // Calories math  
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
     
    public double roundOne(double num) {
        return Math.round(num*10.0)/10.0; 
    }

    public double caloriesMin(double num) {
        if (consumed < 1200) {
            return getCaloriesGoal() - consumed;
        }

        return consumed;
    }


}