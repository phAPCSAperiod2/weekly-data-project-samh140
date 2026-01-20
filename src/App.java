import java.util.Scanner;
import java.util.InputMismatchException;

/**
 * Instructions:
 * - Complete the WeeklyData.java class first.
 * - Use this App class to collect user input and test your WeeklyData methods.
 * - Follow all TODOs carefully.
 * - Do NOT hard-code values — use loops and method calls.
 */
public class App {

    public static void main(String[] args) {

        // -------------------------------------------------------------
        // TODO 1: Create a Scanner for user input
        // -------------------------------------------------------------
        Scanner scanner = new Scanner(System.in);

        // -------------------------------------------------------------
        // TODO 2: Give information about your program
        //         Ask the user about their goals (if applicable)
        // -------------------------------------------------------------
        System.out.println("Welcome");

        // -------------------------------------------------------------
        // TODO 3: Create an array to hold 7 days of data
        //         Use an appropriate data type (int or double)
        //         Name the array weekData
        // -------------------------------------------------------------
            double[] weekData = new double[7];

        // -------------------------------------------------------------
        // TODO 4: Use a for loop to collect data for each day of the week
        //         Prompt example:
        //         "Enter <data type> for day X: "
        //
        //         Include input validation:
        //         - Use a while loop to prevent negative values
        //         - Re-prompt if the value is invalid
        // -------------------------------------------------------------
        for (int i = 0; i < weekData.length; i++) {
            System.out.print("Enter sleep hours for day " + (i + 1) + ": ");
            double value = scanner.nextDouble();
            while (value < 0) {
                System.out.print("Invalid input. Please enter a non-negative value for day " + (i + 1) + ": ");
                value = scanner.nextDouble();
            }
            weekData[i] = value;
        }

        // -------------------------------------------------------------
        // TODO 5: Create a WeeklyData object
        //         Pass the weekData array into the constructor
        // -------------------------------------------------------------
        WeeklyData data = new WeeklyData(weekData);

        // -------------------------------------------------------------
        // TODO 6: Display the results of the analysis
        //         Call methods from WeeklyData to display:
        //         - Total
        //         - Average
        //         - Minimum
        //         - Maximum
        //
        //         Use clear labels and formatted output if needed
        // -------------------------------------------------------------

        System.out.println("What data would you like to see?");
        System.out.println("1. Total sleep hours\n2. Average sleep hours\n3. Minimum sleep hours\n4. Maximum sleep hours\n5. Quit\nEnter your choice (1-5):");
        int choice = scanner.nextInt();
        if (choice == 1) {
            System.out.printf("Total sleep hours: %.2f\n", data.getTotal());
        } else if (choice == 2) {
            System.out.printf("Average sleep hours: %.2f\n", data.getAverage());
        } else if (choice == 3) {
            System.out.printf("Minimum sleep hours: %.2f\n", data.getMin());
        } else if (choice == 4) {
            System.out.printf("Maximum sleep hours: %.2f\n", data.getMax());
        } else if (choice == 5) {
            System.out.println("Goodbye!");
        } else {
            System.out.println("Invalid choice.");
        }

        // -------------------------------------------------------------
        // TODO 7: Display the full week of data
        //         Use the toString() method from WeeklyData
        // -------------------------------------------------------------
        System.out.println("Here is your sleep data for the week:");
        System.out.println(data.toString());

        // -------------------------------------------------------------
        // TODO 8: Give the user insights about their week
        //         --> "You need to drink more water next week!"
        //         --> "You were very hydrated this week!"
        //         --> etc.
        // -------------------------------------------------------------


    }
}
