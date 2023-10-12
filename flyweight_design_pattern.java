package flyweight_design_pattern;

import java.util.HashMap;
import java.util.Random;

// Interface defining methods that all concrete employees must implement.
interface Employee {
    public void assignSkill(String skill);
    public void task();
}

// Concrete implementation of an employee - Developer.
class Developer implements Employee {
    private final String JOB; // Developer's task (constant).
    private String skill; // Developer's skill.

    public Developer() {
        JOB = "Fix the issue"; // Set the developer's task.
    }

    @Override
    public void assignSkill(String skill) {
        this.skill = skill; // Set the developer's skill.
    }

    @Override
    public void task() {
        System.out.println("Developer with skill: " + this.skill + " with Job: " + JOB); // Print information about the developer's task and skill.
    }
}

// Concrete implementation of an employee - Tester.
class Tester implements Employee {
    private final String JOB; // Tester's task (constant).
    private String skill; // Tester's skill.

    public Tester() {
        JOB = "Test the issue"; // Set the tester's task.
    }

    @Override
    public void assignSkill(String skill) {
        this.skill = skill; // Set the tester's skill.
    }

    @Override
    public void task() {
        System.out.println("Tester with Skill: " + this.skill + " with Job: " + JOB); // Print information about the tester's task and skill.
    }
}

// Employee factory using the Flyweight pattern.
class EmployeeFactory {
    private static HashMap<String, Employee> employees = new HashMap<String, Employee>();

    public static Employee getEmployee(String type) {
        Employee employee = employees.get(type); // Try to get an employee from the cache.

        if (employee == null) {
            // If the employee with the given type does not exist, create it and put it in the cache.
            switch (type) {
                case "Developer":
                    System.out.println("Developer Created");
                    employee = new Developer();
                    break;
                case "Tester":
                    System.out.println("Tester Created");
                    employee = new Tester();
                    break;
                default:
                    System.out.println("No Such Employee");
            }
            employees.put(type, employee);
        }

        return employee;
    }
}

public class FlyweightPattern {
    private static String employeeTypes[] = {"Developer", "Tester"};
    private static String skills[] = {"Java", "C++", ".Net", "Python"};

    public static void main(String[] args) {
        for (int i = 0; i < 10; i++) {
            // Get a random employee from the factory.
            Employee employee = EmployeeFactory.getEmployee(getRandomEmployeeType());
            // Assign a random skill to the employee.
            employee.assignSkill(getRandomSkill());
            // Perform the employee's task.
            employee.task();
        }
    }

    public static String getRandomEmployeeType() {
        Random random = new Random();
        int randomIndex = random.nextInt(employeeTypes.length);
        return employeeTypes[randomIndex]; // Return a random employee type.
    }

    public static String getRandomSkill() {
        Random random = new Random();
        int randomIndex = random.nextInt(skills.length);
        return skills[randomIndex]; // Return a random skill.
    }
}
