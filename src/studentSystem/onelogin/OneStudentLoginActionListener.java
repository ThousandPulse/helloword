package studentSystem.onelogin;

import studentSystem.dbconnect.DBConn;
import studentSystem.dbconnect.DBModify;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class OneStudentLoginActionListener implements ActionListener {
    private OneStudentLoginWindow oneStudentLoginWindow;
    private JTextField studentID;
    private JTextField studentName;
    private JTextField studentNumber;
    private JTextField studentAddress;
    private JTextField studentSex;
    private JTextField studentAge;
    private String loginID;

    OneStudentLoginActionListener(OneStudentLoginWindow oneStudentLoginWindow,String loginID,
                                  JTextField studentID,JTextField studentName,
                                  JTextField studentNumber,JTextField studentAddress,
                                  JTextField studentSex, JTextField studentAge) {
        this.oneStudentLoginWindow = oneStudentLoginWindow;
        this.studentID = studentID;
        this.studentName = studentName;
        this.studentNumber = studentNumber;
        this.studentAddress = studentAddress;
        this.studentSex = studentSex;
        this.studentAge = studentAge;
        this.loginID = loginID;
        System.out.println(this.loginID);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        DBModify dbModify = new DBModify(DBConn.getStatement());
        // student = [学号，姓名，电话，地址，性别，年龄，登陆账号]
        String[] student = {studentID.getText(),studentName.getText(),studentNumber.getText(),studentAddress.getText(),
                studentSex.getText(),studentAge.getText(),loginID};

        int selectIn = dbModify.insertStudent(student);
        if(selectIn>0){
            JOptionPane.showMessageDialog(oneStudentLoginWindow,"写入成功！");
            // 跳转学生界面
        }else
            JOptionPane.showMessageDialog(oneStudentLoginWindow,"请检查内容，填写真实信息！");
        DBConn.closeConn();
    }


}

