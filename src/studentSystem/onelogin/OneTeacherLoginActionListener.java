package studentSystem.onelogin;

import studentSystem.dbconnect.DBConn;
import studentSystem.dbconnect.DBModify;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class OneTeacherLoginActionListener implements ActionListener {
    private OneTeacherLoginWindow oneStudentLoginWindow;
    private JTextField teacherID;
    private JTextField teacherName;
    private String loginID;

    OneTeacherLoginActionListener(OneTeacherLoginWindow oneTeacherLoginWindow, String loginID,
                                  JTextField teacherID, JTextField teacherName) {
        this.oneStudentLoginWindow = oneTeacherLoginWindow;
        this.teacherID = teacherID;
        this.teacherName = teacherName;
        this.loginID = loginID;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        DBModify dbModify = new DBModify(DBConn.getStatement());
        int teacher = dbModify.insertTeacher(teacherName.getText(), teacherID.getText(), loginID);
        if (teacher > 0) {
            JOptionPane.showMessageDialog(oneStudentLoginWindow, "写入成功！");
            // 跳转学生界面
        } else
            JOptionPane.showMessageDialog(oneStudentLoginWindow, "请检查内容，填写真实信息！");
        DBConn.closeConn();
    }


}

