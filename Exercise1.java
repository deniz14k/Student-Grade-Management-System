package isp.lab6.exercise1;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Exercise1 {

    public static void main(String[] args) {

        Scanner read = new Scanner(System.in);
        ArrayList<Student> students = new ArrayList<Student>();
        boolean exit = false;


        while (!exit) {

            System.out.println("Enter choice ! ");
            System.out.println("1. Add Student");
            System.out.println("2. Remove Student");
            System.out.println("3. Update Student Information");
            System.out.println("4. Calculate Average Grade");
            System.out.println("5. Display List of Students");
            System.out.println("6. Add a grade : ");
            System.out.println("7. Remove a grade : ");
            System.out.println("0. Quit");

            try {
                int choice = read.nextInt();
                read.nextLine();

                switch (choice) {

                    case 1:
                        System.out.println("Enter student name : ");
                        String name = read.nextLine();

                        System.out.println("Enter student ID : ");
                        int id = read.nextInt();
                        read.nextLine();

                        Student student = new Student(name, id);
                        students.add(student);
                        System.out.println("Student added! ");
                        break;

                    case 2:
                        boolean removed = false;
                        System.out.println("Enter student ID to remove: ");
                        int idToRemove = read.nextInt();
                        read.nextLine();
                        for (int i = 0; i < students.size(); i++) {
                            if (students.get(i).getId() == idToRemove) {
                                students.remove(i);
                                removed = true;
                                break;
                            }
                        }
                        if (removed) {
                            System.out.println("The student was successfully removed!");
                        } else {
                            System.out.println("Student not found!");
                        }
                        break;


                    case 3:
                        boolean updated = false;
                        System.out.println("Enter student ID to update: ");
                        int idToUpdate = read.nextInt();
                        read.nextLine();
                        for (int i = 0; i < students.size(); i++) {
                            if (students.get(i).getId() == idToUpdate) {
                                System.out.println("Enter the new name for the student: ");
                                String newName = read.nextLine();
                                students.get(i).setName(newName);
                                updated = true;
                                break;
                            }
                        }
                        if (updated) {
                            System.out.println("The student information was successfully updated!");
                        } else {
                            System.out.println("Student not found!");
                        }
                        break;

                    case 4:
                        boolean found = false;
                        System.out.println("Enter student ID to calculate the average grade : ");
                        int idToCalculateAverageGrade = read.nextInt();
                        read.nextLine();
                        for (int i = 0; i < students.size(); i++) {
                            if (students.get(i).getId() == idToCalculateAverageGrade) {
                                double average = students.get(i).calculateAverageGrade();
                                found = true;
                                System.out.println("The average grade for this student is : " + average);
                                break;
                            }
                        }
                        if (found) {
                            System.out.println("The student average grade was calculated!");
                        } else {
                            System.out.println("Student not found!");
                        }
                        break;

                    case 5:
                        if (students.size() == 0) {
                            System.out.println("\nNo students found.");
                        } else {
                            System.out.println("\nList of students:");
                            for (Student s : students) {
                                System.out.println(s.toString());
                            }
                        }
                        break;


                    case 6:

                        boolean gradeAdded = false;
                        System.out.println("Enter student ID to add a grade : ");
                        int idToAddGrade = read.nextInt();
                        read.nextLine();
                        for (int i = 0; i < students.size(); i++) {

                            if (idToAddGrade == students.get(i).getId()) {
                                System.out.println("Enter the subject : ");
                                String subject = read.nextLine();
                                System.out.println("Enter the grade : ");
                                int grade = read.nextInt();
                                students.get(i).addGrade(subject, grade);
                                gradeAdded = true;
                            }
                        }
                        if (gradeAdded) System.out.println("The grade was added succesfully! ");
                        else System.out.println("Student not found ! ");
                        break;


                    case 7:

                        boolean gradeRemoved = false;
                        System.out.println("Enter student ID to remove a grade : ");
                        int idToRemoveGrade = read.nextInt();
                        read.nextLine();
                        for (int i = 0; i < students.size(); i++) {

                            if (idToRemoveGrade == students.get(i).getId()) {
                                System.out.println("Enter the subject : ");
                                String subject = read.nextLine();
                                students.get(i).removeGrade(subject);
                                gradeRemoved= true;
                            }
                        }
                        if (gradeRemoved) System.out.println("The grade was removed succesfully! ");
                        else System.out.println("Student not found ! ");
                        break;


                    case 0:
                        exit = true;
                        System.out.println("\nGoodbye!");
                        break;

                    default:
                        System.out.println("\nInvalid choice.");
                        break;
                }

            } catch (InputMismatchException e) {
                System.out.println("Invalid input format. Please enter an integer.");
                read.nextLine(); // Consume the invalid input
            }
        }
    }
}

