package studentSystem;

import javax.swing.*;

public class Student {
    private String studentID;
    private String studentName;
    private String studentNumber;
    private String studentAddress;
    private String studentSex;
    private String studentAge;
    private String loginID;

    public Student(String studentID, String studentName, String studentNumber,
                   String studentAddress, String studentSex, String studentAge, String loginID) {
        this.loginID = loginID;
        this.studentID = studentID;
        this.studentName = studentName;
        this.studentNumber = studentNumber;
        this.studentAddress = studentAddress;
        this.studentSex = studentSex;
        this.studentAge = studentAge;
    }

    public String getLoginID() {
        return loginID;
    }

    public String getStudentAddress() {
        return studentAddress;
    }

    public String getStudentAge() {
        return studentAge;
    }

    public String getStudentID() {
        return studentID;
    }

    public String getStudentName() {
        return studentName;
    }

    public String getStudentNumber() {
        return studentNumber;
    }

    public String getStudentSex() {
        return studentSex;
    }
}
