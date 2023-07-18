package datamanagement;

import data.Student;
import java.util.ArrayList;
import util.MyUtils;

public class StudentList {

    private ArrayList<Student> studentList = new ArrayList<>();

    private String inputStudentCode(String inputMsg) {
        return MyUtils.getStringreg(inputMsg,
                "^S\\d{3}$",
                "Error: Code cannot be empty!",
                "Error: Code is not valid!");
    }

    private String inputStudentName(String inputMsg) {
        return MyUtils.getString(inputMsg, "Error: Name cannot be empty!");
    }

    private double inputStudentMark(String inputMsg) {
        return MyUtils.getDouble(inputMsg, "Invalid mark. Please try again!", 0, 10);
    }

    //Kiem tra code, tra ve i neu co, -1 neu khong tim thay
    private int checkStudentCode(String studentCode) {
        //Neu list rong thi return -1
        if (studentList.isEmpty()) {
            return -1;
        }

        for (int i = 0; i < studentList.size(); i++) {
            if (studentList.get(i).getCode().equalsIgnoreCase(studentCode)) {
                return i;
            }
        }

        return -1;
    }

    public void addNewStudent() {
        String code, name;
        double mark;

        System.out.println("Please provide the following information:");

        do {
            code = inputStudentCode("Enter the student code "
                    + "(starts with 'S' followed by 3 digits): ");
            if (checkStudentCode(code) >= 0) {
                System.out.println("The student code already exists. "
                        + "Please enter another one!");
                continue; //Cẩn thận khi dùng kết hợp continue và break, return,... 
                          //cho duyệt mảng!! -> dễ sai ngữ nghĩa!!!
            }             //VD: {2, 1, 3, 5}. Check 3 có trong mảng
            break;
        } while (true);

        name = inputStudentName("Enter the student's name: ");
        mark = inputStudentMark("Enter the student's mark(0..10): ");

        studentList.add(new Student(code, name, mark));

        System.out.println("A student created successfully!");
    }

    public void searchStudentByCode() {
        String studentCode = inputStudentCode("Enter the student code for searching (S###): ");
        int studentIndex = checkStudentCode(studentCode);

        if (studentIndex >= 0) {
            System.out.println("Here is the student with code '" + studentCode + "': ");
            studentList.get(studentIndex).viewInfo();
            return;
        }

        System.out.println("Student with code '" + studentCode + "' not found!");
    }

    public void updateStudentInfoByCode() {
        String studentCode = inputStudentCode("Enter the student code for udating (S###): ");
        int studentIndex = checkStudentCode(studentCode);

        if (studentIndex >= 0) {
            String newName = inputStudentName("Enter the student's new name: ");
            double newMark = inputStudentMark("Enter the student's new mark(0..10): ");
            studentList.get(studentIndex).setName(newName);
            studentList.get(studentIndex).setMark(newMark);
            System.out.println("Student information updated successfully!");
            return;
        }

        System.out.println("Student with code '" + studentCode + "' not found!");
    }

    public void removeStudentByCode() {
        String studentCode = inputStudentCode("Enter the student code for removal (S###): ");
        int studentIndex = checkStudentCode(studentCode);

        if (studentIndex >= 0) {
            String choice = MyUtils.getStringreg("Are you sure you want to remove this student? (Y/N): ",
                    "^[y,Y,n,N]$",
                    "Please enter your choice! (Y/N)",
                    "Invalid choice. Please enter 'Y/y' for Yes and 'N/n' for No.");

            if (choice.equalsIgnoreCase("Y")) {
                studentList.remove(studentIndex);
                System.out.println("Student with code '" + studentCode + "' has been successfully removed!");
            } else {
                System.out.println("Student removal has been cancelled.");
            }
            return;
        }

        System.out.println("Student with code '" + studentCode + "' not found!");
    }

    public void listAllStudents() {
        if (studentList.isEmpty()) {
            System.out.println("The student list is empty. "
                    + "There are no students to display.");
            return;
        }

        System.out.println("Here is the student list:");
        String header = String.format("|%-4s|%-20s|%4s|",
                "CODE", "NAME", "MARK");
        System.out.println(header);
        for (Student student : studentList) {
            student.viewInfo();
        }
    }

}
