package main;

import datamanagement.StudentList;
import util.MyUtils;

public class StudentManagementSystem {
    public static void main(String[] args) {
        StudentList studentList = new StudentList();
        int choice;
        String divider = "-----------------------------------------";
        
        do {
            System.out.println("\n======= Student Management System =======\n");
            System.out.println("1. Add new student");
            System.out.println("2. Search a student based on his/her code");
            System.out.println("3. Update name and mark of a student based on his/her code");
            System.out.println("4. Remove a student based on his/her code");
            System.out.println("5. List all students");
            System.out.println("6. Exit");

            choice = MyUtils.getInt("Enter your choice (1-6): ", 
                                    "Invalid choice. Please try again!", 1, 6);

            switch (choice) {
                case 1:
                    System.out.println(divider);
                    studentList.addNewStudent();
                    break;
                case 2:
                    System.out.println(divider);
                    studentList.searchStudentByCode();
                    break;
                case 3:
                    System.out.println(divider);
                    studentList.updateStudentInfoByCode();
                    break;
                case 4:
                    System.out.println(divider);
                    studentList.removeStudentByCode();
                    break;
                case 5:
                    System.out.println(divider);
                    studentList.listAllStudents();
                    break;
                case 6:
                    System.out.println("Thank you for using the Student Management System. "
                                        + "Goodbye!");
                    break;
            }
        } while (choice != 6);

    }
}
