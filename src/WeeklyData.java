/**
 * The WeeklyData class stores and analyzes a week’s worth of numeric data.
 * This could represent steps taken, hours of sleep, money spent, screen time,
 * or any other measurable daily value.
 */
public class WeeklyData {

    // -------------------------------------------------------------
    // Instance Variables
    // -------------------------------------------------------------
    // TODO: Declare a private array to store the week’s data
    //       Choose an appropriate type (double[] or int[])
    //       Create other instance variables as necessary
    private double[] sleepHours;


    // -------------------------------------------------------------
    // Constructor
    // -------------------------------------------------------------
    /**
     * Constructs a WeeklyData object by taking in an array of values
     * and making a deep copy (element-by-element) into the internal array.
     *
     * @param input an array representing 7 days of data
     */

    public WeeklyData(double[] array) {
        sleepHours = new double[array.length];
        for (int i = 0; i < array.length; i++) {
            sleepHours[i] = array[i];
        }
    }
        // TODO: (Optional) Check if input is null and handle appropriately
        // TODO: Create a new array with the same length as input
        // TODO: Copy each value from input into the internal data array
        // NOTE: Do NOT do this.data = input; (that would create aliasing)



    // -------------------------------------------------------------
    // getTotal
    // -------------------------------------------------------------
    /**
     * Calculates and returns the total of all values in the week.
     *
     * @return the sum of all values in the data array
     */
    public double getTotal() {
        double total = 0.0;
        for (double value : sleepHours) {
            total += value;
        }
        return total;
    }


    // -------------------------------------------------------------
    // getAverage
    // -------------------------------------------------------------
    /**
     * Calculates and returns the average value for the week.
     *
     * @return the average of the values in the array,
     *         or 0.0 if the array is empty
     */
    public double getAverage() {
        if (sleepHours.length == 0) {
            return 0.0;
        }

        double average = 0.0;
        average = getTotal() / sleepHours.length;
        return average;
    }


    // -------------------------------------------------------------
    // getMax
    // -------------------------------------------------------------
    /**
     * Finds and returns the highest value in the data array.
     *
     * @return the maximum value
     */
    public double getMax() {
        if (sleepHours.length == 0) {
            return 0.0;
        }


        double max = sleepHours[0];
        for (double value : sleepHours) {
            if (value > max) {
                max = value;
            }
        }
        return max;
    }


    // -------------------------------------------------------------
    // getMin
    // -------------------------------------------------------------
    /**
     * Finds and returns the lowest value in the data array.
     *
     * @return the minimum value
     */
    public double getMin() {
        if (sleepHours.length == 0) {
            return 0.0;
        }

        double min = sleepHours[0];
        for (double value : sleepHours) {
            if (value < min) {
                min = value;
            }
        }
        
        return min;
    }


    // -------------------------------------------------------------
    // toString
    // -------------------------------------------------------------
    /**
     * Returns a formatted, multi-line String showing each day’s data.
     *
     * Example:
     * Day 1: 4500
     * Day 2: 6200
     * Day 3: 5100
     *
     * @return a formatted String representing the week’s data
     */
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder(); // TODO: Create a StringBuilder
        for (int i = 0; i < sleepHours.length; i++) { // TODO: Loop through the data array
            sb.append("Day ").append(i + 1).append(": ").append(sleepHours[i]).append("\n"); // TODO: Append each value with a day label (Day 1, Day 2, etc.)
        }
        return sb.toString();
    }
}
