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


        // Create a SleepHoursData object and pass the weekly sleep data
        // The constructor creates a deep copy to protect the internal data
        SleepHoursData data = new SleepHoursData(collectSleepData());
        
        // Interactive menu loop that allows user to view different sleep statistics
        // and receive personalized feedback based on their sleep data
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("What data would you like to see?");
            System.out.println("1. Total sleep hours\n2. Average sleep hours\n3. Minimum sleep hours\n4. Maximum sleep hours\n5. Show Data\n6. Quit\nEnter your choice (1-6):");
            int choice = scanner.nextInt();

            if (choice == 1) {
                // Option 1: Display total sleep hours for the week
                System.out.println("Total sleep hours: " + data.getTotal());
            }
            else if (choice == 2) {
                // Option 2: Display average sleep hours and provide health feedback
                data.getAverage();
            }
            else if (choice == 3) {
                // Option 3: Display minimum sleep hours and provide feedback on low sleep nights
                data.getMin();
            }
            else if (choice == 4) {
                // Option 4: Display maximum sleep hours and provide feedback on high sleep nights
                data.getMax();
            }
            else if (choice == 5) {
                // Option 5: Display all sleep data for the week in formatted view
                data.toString();
            }
            else if (choice == 6) {
                // Option 6: Exit the program
                System.out.println("Goodbye!");
                break;
            }
            else {
                // Handle invalid menu choices
                System.out.println("Invalid choice.");
            }

        }
    }






    /**
     * Method that collects user data from user input. Initailizes and prepares an array
     * to be stored as a deep copy.
     * 
     * @return an array of doubles representing sleep hours for each day of the week
     */
    public static double[] collectSleepData() {
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

        return weekData;
    }
}
