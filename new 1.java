import java.util.Scanner;

class Employee {
    private int employeeId;
    private String name;
    private double basicSalary;
    private int performanceRating;

    // Constructor
    public Employee(int employeeId, String name, double basicSalary, int performanceRating) {
        this.employeeId = employeeId;
        this.name = name;
        this.basicSalary = basicSalary;
        setPerformanceRating(performanceRating);
    }

    // Setter to ensure valid performance rating (1 to 5)
    public void setPerformanceRating(int rating) {
        if (rating < 1 || rating > 5) {
            throw new IllegalArgumentException("Performance rating must be between 1 and 5.");
        }
        this.performanceRating = rating;
    }

    // Method to calculate bonus based on performance rating
    public double calculateBonus() {
        double bonusPercentage = 0.0;
        switch (performanceRating) {
            case 5:
                bonusPercentage = 0.20;
                break;
            case 4:
                bonusPercentage = 0.15;
                break;
            case 3:
                bonusPercentage = 0.10;
                break;
            case 2:
                bonusPercentage = 0.05;
                break;
            case 1:
                bonusPercentage = 0.00;
                break;
        }
        return basicSalary * bonusPercentage;
    }

    // Method to calculate total salary (basic salary + bonus)
    public double calculateTotalSalary() {
        return basicSalary + calculateBonus();
    }

    // Method to display employee details
    public void displayEmployeeDetails() {
        System.out.println("Employee Details: ");
        System.out.println("Employee ID: " + employeeId);
        System.out.println("Name: " + name);
        System.out.printf("Basic Salary: ", basicSalary);
        System.out.println("Performance Rating: " + performanceRating);
        System.out.printf("Bonus: ", calculateBonus());
        System.out.printf("Total Salary: ", calculateTotalSalary());
    }
}

public class Main {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        // Taking user input
        System.out.print("Enter Employee ID: ");
        int id = input.nextInt();
        input.nextLine();  // Consume newline

        System.out.print("Enter Employee Name: ");
        String name = input.nextLine();

        System.out.print("Enter Basic Salary: ");
        double salary = input.nextDouble();

        System.out.print("Enter Performance Rating (1-5): ");
        int rating = input.nextInt();

        // Creating an Employee object
        try {
            Employee employee = new Employee(id, name, salary, rating);
            employee.displayEmployeeDetails();
        } catch (IllegalArgumentException e) {
            System.out.println("Error: " + e.getMessage());
        }

    }
}
