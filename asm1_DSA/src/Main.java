import java.util.List;
import java.util.Scanner;

public class Main {
    private static StudentManager manager = new StudentManager();
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        while (true) {
            int choice = displayMenuAndGetChoice();

            switch (choice) {
                case 1:
                    addStudent();
                    break;
                case 2:
                    getStudent();
                    break;
                case 3:
                    updateMarks();
                    break;
                case 4:
                    deleteStudent();
                    break;
                case 5:
                    sortStudentsByMarks();
                    break;
                case 6:
                    System.out.println("Exiting program...");
                    return;
                default:
                    System.out.println("Invalid option. Please try again.");
            }
        }
    }

    private static void sortStudentsByMarks() {
        List<Student> sortedStudents = manager.mergeSortStudentsByMarks(false);
        System.out.println("Sorted Students by Marks:");
        for (Student student : sortedStudents) {
            System.out.println(student);
        }
    }

    private static int displayMenuAndGetChoice() {
        System.out.println("Choose an option:");
        System.out.println("1. Add Student");
        System.out.println("2. Get Student");
        System.out.println("3. Update Marks");
        System.out.println("4. Delete Student");
        System.out.println("5. Sort Students by Marks");
        System.out.println("6. Exit");

        int choice;

        while (true) {
            try {
                choice = Integer.parseInt(scanner.nextLine());
                break;
            } catch (NumberFormatException e) {
                System.out.println("Invalid input. Please enter a number.");
            }
        }

        return choice;
    }

    private static void addStudent() {
        System.out.println("Enter ID:");
        String id = scanner.nextLine();

        System.out.println("Enter Name:");
        String name = scanner.nextLine();

        System.out.println("Enter Marks:");
        double marks;
        while (true) {
            try {
                marks = Double.parseDouble(scanner.nextLine());
                break;
            } catch (NumberFormatException e) {
                System.out.println("Invalid input. Please enter a number for marks.");
            }
        }

        if (manager.addStudent(id, name, marks)) {
            System.out.println("Student added successfully.");
        } else {
            System.out.println("Student with this ID already exists.");
        }
    }

    private static void getStudent() {
        System.out.println("Enter ID:");
        String id = scanner.nextLine();

        Student student = manager.getStudent(id);
        if (student != null) {
            System.out.println("Student Details: " + student);
        } else {
            System.out.println("Student not found.");
        }
    }

    private static void updateMarks() {
        System.out.println("Enter ID:");
        String id = scanner.nextLine();

        System.out.println("Enter new Marks:");
        double marks;
        while (true) {
            try {
                marks = Double.parseDouble(scanner.nextLine());
                break;
            } catch (NumberFormatException e) {
                System.out.println("Invalid input. Please enter a number for marks.");
            }
        }

        if (manager.updateMarks(id, marks)) {
            System.out.println("Marks updated successfully.");
        } else {
            System.out.println("Student not found.");
        }
    }

    private static void deleteStudent() {
        System.out.println("Enter ID:");
        String id = scanner.nextLine();

        if (manager.deleteStudent(id)) {
            System.out.println("Student deleted successfully.");
        } else {
            System.out.println("Student not found.");
        }
    }
}
