[![Review Assignment Due Date](https://classroom.github.com/assets/deadline-readme-button-22041afd0340ce965d47ae6ef1cefeee28c7c493a6346c4f15d667ab976d596c.svg)](https://classroom.github.com/a/jLmsEuC8)
[![Open in Codespaces](https://classroom.github.com/assets/launch-codespace-2972f46106e565e64193e422d61a12cf1da4916b45550586e14ef0a7c637dd04.svg)](https://classroom.github.com/open-in-codespaces?assignment_repo_id=22208180)

# Sleep Hours Tracker

A Java application for tracking and analyzing weekly sleep patterns. This program allows users to input their daily sleep hours and provides comprehensive statistics including total sleep time, average sleep per night, and insights into sleep habits.

## Features

- **Data Input**: Interactive input for 7 days of sleep data with validation
- **Statistical Analysis**: Calculates total, average, minimum, and maximum sleep hours
- **Data Visualization**: Displays all daily sleep hours in a clear format
- **User-Friendly Interface**: Menu-driven system for easy navigation
- **Object-Oriented Design**: Encapsulated data class with deep copy protection
- **Input Validation**: Ensures only valid (non-negative) sleep hours are accepted

## Prerequisites

- Java Development Kit (JDK) 8 or higher
- Command line interface for compilation and execution

## Installation

1. Clone the repository:
   ```bash
   git clone https://github.com/phAPCSAperiod2/phapcsaperiod2-classroom-6ecf6a-weekly-data-project-APCSA_Weekly_Data-Project.git
   cd weekly-data-project-samh140
   ```

2. Compile the Java files:
   ```bash
   javac src/*.java
   ```

## Usage

Run the program:
```bash
java -cp src App
```

Follow the prompts to:
1. Enter sleep hours for each of the 7 days
2. Choose from the menu options to view statistics:
   - Total sleep hours
   - Average sleep hours
   - Minimum sleep hours
   - Maximum sleep hours
   - Display all daily data

### Example Output

```
Welcome to this program! We will help you analyze your sleep patterns over the week.
Please enter your sleep hours for this day 1: 8.5
Please enter your sleep hours for this day 2: 7.0
...
Weekly Summary:
Total Sleep: 52.5 hours
Average Sleep: 7.5 hours per night
Highest Day: 9.0 hours
Lowest Day: 6.0 hours
```

## Project Structure

- `src/App.java`: Main application class with user interface
- `src/SleepHoursData.java`: Data class for sleep analysis
- `src/WeeklyDataTest.java`: Unit tests for the data class

## Author

**Sam Ho**

## License

This project is part of an AP Computer Science A course assignment.



