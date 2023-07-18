package data;

public class Student {
    private String code;
    private String name;
    private double mark;

    public Student(String code, String name, double mark) {
        this.code = code;
        this.name = name;
        this.mark = mark;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getMark() {
        return mark;
    }

    public void setMark(double mark) {
        this.mark = mark;
    }

    public void viewInfo() {
    String studentInfo = String.format("|%-4s|%-20s|%4.1f|", code, name, mark);

    System.out.println(studentInfo);
}

}
