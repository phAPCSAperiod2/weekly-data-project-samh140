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
        System.out.println("Welcome to this program! We will help you analyze your sleep patterns over the week.");

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
            System.out.print("Please enter your sleep hours for this day " + (i + 1) + ": ");
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
        while (true) {
            System.out.println("What data would you like to see?");
            System.out.println("1. Total sleep hours\n2. Average sleep hours\n3. Minimum sleep hours\n4. Maximum sleep hours\n5. Show Data\n6. Quit\nEnter your choice (1-6):");
            int choice = scanner.nextInt();
            if (choice == 1) {
                System.out.println("Total sleep hours: " + data.getTotal());
            } else if (choice == 2) {
                System.out.println("Average sleep hours: " + data.getAverage());
                            if (data.getAverage() < 6) {
                                System.out.println("You should try to get more sleep next week!");
                            }
                            else if (data.getAverage() <= 9) {
                                System.out.println("You got the optimal amount of sleep this week! Keep it up!");
                            }
                            else {
                                System.out.println("You slept a lot this week! Make sure you are using your time wisely!");
                            }
            } else if (choice == 3) {
                System.out.println("Minimum sleep hours: " + data.getMin());
                            if (data.getMin() < 4) {
                                System.out.println("This is very unhealthy. Try managing your time better");
                            }
                            else if (data.getMin() <= 7) {
                                System.out.println("Try getting more sleep on your low days.");
                            }
                            else {
                                System.out.println("Nice job, you are maintaining a good sleep schedule!");
                            }

            } else if (choice == 4) {
                System.out.println("Maximum sleep hours: " + data.getMax());
                            if (data.getMax() > 12){
                                System.out.println("You are oversleeping! Please make sure you aren't procrasinating or being too lazy!");
                            }
                            else if (data.getMax() >= 7) {
                                System.out.println("Great job on getting enough sleep!");
                            }
                            else {
                                System.out.println("Try to get more sleep on your best days!");
                            }
            } else if (choice == 5) {
                System.out.println("Here is your sleep data for the week:\nTry and find patterns in your sleep!");
                System.out.println(data.toString());
            } else if (choice == 6) {
                System.out.println("Goodbye!");
                break;
            } else {
                System.out.println("Invalid choice.");
            }

        }

        // -------------------------------------------------------------
        // TODO 7: Display the full week of data
        //         Use the toString() method from WeeklyData
        // -------------------------------------------------------------
        //System.out.println();
        //System.out.println("Here is your sleep data for the week:");
        //System.out.println(data.toString());
        //System.out.println();

        // -------------------------------------------------------------
        // TODO 8: Give the user insights about their week
        //         --> "You need to drink more water next week!"
        //         --> "You were very hydrated this week!"
        //         --> etc.
        // -------------------------------------------------------------
        
        
        // insights were given after each method was called!

    }
}
