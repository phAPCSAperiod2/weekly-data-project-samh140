/**
 * SleepHoursData.java
 * Author: Sam Ho
 * Collaborator: CoPilot
 * 
 * This class represents weekly sleep tracking data. It stores and analyzes
 * seven days of sleep hours using an internal array and provides methods to
 * calculate statistical measures including total, average, minimum, and maximum
 * sleep hours for the week. All data is stored internally and protected from
 * external modification through deep copy implementation.
 */

public class SleepHoursData {

    // Instance variable that stores sleep hours for each day of the week
    // Using double[] to support decimal values (e.g., 7.5 hours)
    private double[] sleepHours;


    /**
     * Constructor that initializes a SleepHoursData object with an array of sleep hours.
     * Creates a deep copy of the input array to prevent external modifications from
     * affecting the internal data.
     *
     * @param array an array of sleep hours representing 7 days of data (in hours)
     */
    public SleepHoursData(double[] array) {
        // Create a new array with the same length as input
        sleepHours = new double[array.length];
        // Deep copy each value from input into the internal array
        // This prevents aliasing - external changes to the input array won't affect our data
        for (int i = 0; i < array.length; i++) {
            sleepHours[i] = array[i];
        }
    }



    /**
     * Calculates the total sleep hours for the entire week.
     * Iterates through all days and sums up the sleep hours.
     *
     * @return the sum of all sleep hours in the week
     */
    public double getTotal() {
        // Initialize total to zero and accumulate all sleep hours
        double total = 0.0;
        for (double value : sleepHours) {
            total += value;
        }
        return total;
    }


    /**
     * Calculates the average (mean) sleep hours per night for the week.
     * Returns 0.0 if the array is empty to avoid division by zero.
     *
     * @return the average sleep hours per night, or 0.0 if no data exists
     */
    public double getAverage() {
        // Handle empty array case by returning 0.0
        if (sleepHours.length == 0) {
            return 0.0;
        }
        // Divide total hours by number of days to get average
        double average = getTotal() / sleepHours.length;
        System.out.println("Average sleep hours: " + average);
        // Provide personalized feedback based on average sleep hours
        if (average < 6) {
            System.out.println("You should try to get more sleep next week!");
        } else if (average <= 9) {
            System.out.println("You got the optimal amount of sleep this week! Keep it up!");
        } else {
            System.out.println("You slept a lot this week! Make sure you are using your time wisely!");
        }
        return average;
    }


    /**
     * Finds the maximum (highest) sleep hours recorded during the week.
     * Returns 0.0 if the array is empty to prevent index errors.
     *
     * @return the highest sleep hours value from the week
     */
    public double getMax() {
        // Handle empty array case
        if (sleepHours.length == 0) {
            return 0.0;
        }
        // Initialize max with first value and compare against all others
        double max = sleepHours[0];
        for (double value : sleepHours) {
            if (value > max) {
                max = value;
            }
        }
        System.out.println("Maximum sleep hours: " + max);
        // Provide personalized feedback based on maximum sleep hours
        if (max > 12) {
            System.out.println("You are oversleeping! Please make sure you aren't procrastinating or being too lazy!");
        } else if (max >= 7) {
            System.out.println("Great job on getting enough sleep!");
        } else {
            System.out.println("Try to get more sleep on your best days!");
        }
        return max;
    }


    /**
     * Finds the minimum (lowest) sleep hours recorded during the week.
     * Returns 0.0 if the array is empty to prevent index errors.
     *
     * @return the lowest sleep hours value from the week
     */
    public double getMin() {
        // Handle empty array case
        if (sleepHours.length == 0) {
            System.out.println("This is really dangerous!!! Go to sleep now!");
            return 0.0;
        }
        // Initialize min with first value and compare against all others
        double min = sleepHours[0];
        for (double value : sleepHours) {
            if (value < min) {
                min = value;
            }
        }
        System.out.println("Minimum sleep hours: " + min);
        // Provide personalized feedback based on minimum sleep hours
        if (min < 4) {
            System.out.println("This is very unhealthy. Try managing your time better");
        } else if (min <= 7) {
            System.out.println("Try getting more sleep on your low days.");
        } else {
            System.out.println("Nice job, you are maintaining a good sleep schedule!");
        }
        
        return min;
    }


    // -------------------------------------------------------------
    // toString
    // -------------------------------------------------------------
    /**
     * Returns a formatted string representation of the week's sleep data.
     * Each day is displayed on its own line with the format "Day X: hours".
     *
     * @return a multi-line formatted string showing all days and their sleep hours
     */
    @Override
    public String toString() {
        // Use StringBuilder for efficient string concatenation
        StringBuilder sb = new StringBuilder();
        // Iterate through each day and append formatted output
        for (int i = 0; i < sleepHours.length; i++) {
            sb.append("Day ").append(i + 1).append(": ").append(sleepHours[i]).append("\n");
        }
        System.out.println("Here is your sleep data for the week:\nTry and find patterns in your sleep!");
        System.out.println(sb.toString());
        return sb.toString();
    }
}
