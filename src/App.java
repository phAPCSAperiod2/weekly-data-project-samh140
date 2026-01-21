import java.util.Scanner;
import java.util.InputMismatchException;

/**
 * App.java
 * Author: Sam Ho
 * Collaborator: CoPilot
 * 
 * This is the main application class for the Sleep Hours Analyzer program.
 * It provides an interactive menu-driven interface for users to input their
 * daily sleep hours throughout the week and view various sleep statistics
 * including total, average, minimum, and maximum sleep hours. The program
 * also provides personalized feedback based on sleep data.
 */
public class App {

    public static void main(String[] args) {
        // Create a Scanner object to read user input from the console
        Scanner scanner = new Scanner(System.in);

        // Display welcome message and explain program purpose to user
        System.out.println("Welcome to this program! We will help you analyze your sleep patterns over the week.");

        // Initialize an array to store sleep hours for 7 days of the week
        double[] weekData = new double[7];

        // Loop through each day of the week to collect sleep data
        // Includes input validation to ensure only non-negative values are accepted
        for (int i = 0; i < weekData.length; i++) {
            System.out.print("Please enter your sleep hours for this day " + (i + 1) + ": ");
            double value = scanner.nextDouble();
            // Validate input - re-prompt user if negative value is entered
            while (value < 0) {
                System.out.print("Invalid input. Please enter a non-negative value for day " + (i + 1) + ": ");
                value = scanner.nextDouble();
            }
            weekData[i] = value;
        }

        // Create a SleepHoursData object and pass the weekly sleep data
        // The constructor creates a deep copy to protect the internal data
        SleepHoursData data = new SleepHoursData(weekData);

        // Interactive menu loop that allows user to view different sleep statistics
        // and receive personalized feedback based on their sleep data
        while (true) {
            System.out.println("What data would you like to see?");
            System.out.println("1. Total sleep hours\n2. Average sleep hours\n3. Minimum sleep hours\n4. Maximum sleep hours\n5. Show Data\n6. Quit\nEnter your choice (1-6):");
            int choice = scanner.nextInt();
            // Option 1: Display total sleep hours for the week
            if (choice == 1) {
                System.out.println("Total sleep hours: " + data.getTotal());
            } else if (choice == 2) {
                // Option 2: Display average sleep hours and provide health feedback
                System.out.println("Average sleep hours: " + data.getAverage());
                // Personalized message based on average sleep hours
                if (data.getAverage() < 6) {
                    System.out.println("You should try to get more sleep next week!");
                } else if (data.getAverage() <= 9) {
                    System.out.println("You got the optimal amount of sleep this week! Keep it up!");
                } else {
                    System.out.println("You slept a lot this week! Make sure you are using your time wisely!");
                }
            } else if (choice == 3) {
                // Option 3: Display minimum sleep hours and provide feedback on lowest night
                System.out.println("Minimum sleep hours: " + data.getMin());
                // Personalized message based on lowest sleep night
                if (data.getMin() < 4) {
                    System.out.println("This is very unhealthy. Try managing your time better");
                } else if (data.getMin() <= 7) {
                    System.out.println("Try getting more sleep on your low days.");
                } else {
                    System.out.println("Nice job, you are maintaining a good sleep schedule!");
                }

            } else if (choice == 4) {
                // Option 4: Display maximum sleep hours and provide feedback on best night
                System.out.println("Maximum sleep hours: " + data.getMax());
                // Personalized message based on highest sleep night
                if (data.getMax() > 12) {
                    System.out.println("You are oversleeping! Please make sure you aren't procrasinating or being too lazy!");
                } else if (data.getMax() >= 7) {
                    System.out.println("Great job on getting enough sleep!");
                } else {
                    System.out.println("Try to get more sleep on your best days!");
                }
            } else if (choice == 5) {
                // Option 5: Display all sleep data for the week in formatted view
                System.out.println("Here is your sleep data for the week:\nTry and find patterns in your sleep!");
                System.out.println(data.toString());
            } else if (choice == 6) {
                // Option 6: Exit the program
                System.out.println("Goodbye!");
                break;
            } else {
                // Handle invalid menu choices
                System.out.println("Invalid choice.");
            }

        }
    }
}
