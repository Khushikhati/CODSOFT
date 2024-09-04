import java.util.ArrayList;
import java.util.Scanner;

// Class representing an individual student
class Student {
    private String name;
    private int rollNumber;
    private String grade;

    // Constructor to initialize Student object
    public Student(String name, int rollNumber, String grade) {
        this.name = name;
        this.rollNumber = rollNumber;
        this.grade = grade;
    }

    // Getter methods for student attributes
    public String getName() {
        return name;
    }

    public int getRollNumber() {
        return rollNumber;
    }

    public String getGrade() {
        return grade;
    }

    // Overriding toString() method for better output
    @Override
    public String toString() {
        return "Student Name: " + name + ", Roll Number: " + rollNumber + ", Grade: " + grade;
    }
}

// Class to manage the collection of students
class StudentManagementSystem {
    private ArrayList<Student> students;

    // Constructor to initialize StudentManagementSystem
    public StudentManagementSystem() {
        students = new ArrayList<>();
    }

    // Method to add a new student
    public void addStudent(Student student) {
        students.add(student);
        System.out.println("Student added successfully.");
    }

    // Method to remove a student by roll number
    public void removeStudent(int rollNumber) {
        boolean removed = false;
        for (Student student : students) {
            if (student.getRollNumber() == rollNumber) {
                students.remove(student);
                System.out.println("Student removed successfully.");
                removed = true;
                break;
            }
        }
        if (!removed) {
            System.out.println("Student with Roll Number " + rollNumber + " not found.");
        }
    }

    // Method to search for a student by name
    public Student searchStudent(String name) {
        for (Student student : students) {
            if (student.getName().equalsIgnoreCase(name)) {
                return student;
            }
        }
        return null;
    }

    // Method to display all students
    public void displayAllStudents() {
        if (students.isEmpty()) {
            System.out.println("No students in the system.");
        } else {
            for (Student student : students) {
                System.out.println(student);
            }
        }
    }

    // Method to display the menu and handle user inputs
    public void showMenu() {
        Scanner scanner = new Scanner(System.in);
        int choice;
        do {
            System.out.println("\nStudent Management System Menu:");
            System.out.println("1. Add Student");
            System.out.println("2. Remove Student");
            System.out.println("3. Search Student");
            System.out.println("4. Display All Students");
            System.out.println("5. Exit");
            System.out.print("Enter your choice: ");
            choice = scanner.nextInt();
            scanner.nextLine(); // Consume newline left-over

            switch (choice) {
                case 1:
                    System.out.print("Enter student name: ");
                    String name = scanner.nextLine();
                    System.out.print("Enter roll number: ");
                    int rollNumber = scanner.nextInt();
                    scanner.nextLine(); // Consume newline left-over
                    System.out.print("Enter grade: ");
                    String grade = scanner.nextLine();
                    addStudent(new Student(name, rollNumber, grade));
                    break;
                case 2:
                    System.out.print("Enter roll number to remove: ");
                    int rollToRemove = scanner.nextInt();
                    removeStudent(rollToRemove);
                    break;
                case 3:
                    System.out.print("Enter student name to search: ");
                    String searchName = scanner.nextLine();
                    Student foundStudent = searchStudent(searchName);
                    if (foundStudent != null) {
                        System.out.println("Student found: " + foundStudent);
                    } else {
                        System.out.println("Student not found.");
                    }
                    break;
                case 4:
                    displayAllStudents();
                    break;
                case 5:
                    System.out.println("Exiting the system. Goodbye!");
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        } while (choice != 5);
        scanner.close();
    }
}

// Main class to run the Student Management System
public class StudentManagementsystemtask5 {
    public static void main(String[] args) {
        // Create an instance of StudentManagementSystem
        StudentManagementSystem sms = new StudentManagementSystem();

        // Display the menu to interact with the system
        sms.showMenu();
    }
}
