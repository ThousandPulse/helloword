package studentSystem.loginwindow;

import studentSystem.dbconnect.DBConn;
import studentSystem.dbconnect.DBModify;
import studentSystem.studentwindow.StudentWindow;
import studentSystem.teacherwindow.TeacherWindow;
import studentSystem.onelogin.OneStudentLoginWindow;
import studentSystem.onelogin.OneTeacherLoginWindow;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class LoginActionListener implements ActionListener {
    private LoginWindow loginWindow;
    private JTextField userName;
    private JPasswordField userPwd;
    private String loginID;

    LoginActionListener(LoginWindow loginWindow, JTextField userName, JPasswordField userPwd) {
        this.loginWindow = loginWindow;
        this.userName = userName;
        this.userPwd = userPwd;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getActionCommand().equals("注册")) {
            loginWindow.setVisible(false);
            new RegisterWindow();
        } else if (e.getActionCommand().equals("登录")) {
            login();
        }
    }

    private void login() {
        DBModify dbModify = new DBModify(DBConn.getStatement());
        String[] loginSelect;
        String pass = String.valueOf(userPwd.getPassword());
        loginSelect = dbModify.selectLogin(userName.getText(), pass);
        loginID = loginSelect[0];
        if (loginID != null) {
            if (loginSelect[1].equals("1")) {
                if (!dbModify.selectStudentForLoginID(loginID)){
                    loginWindow.setVisible(false);
                    new OneStudentLoginWindow(loginID);  // 第一次登录填写个人信息
                }
                else{
                    new StudentWindow(loginID);
                }
            } else if (loginSelect[1].equals("2")) {
                if (!dbModify.selectTeacherForLoginID(loginID)){
                    loginWindow.setVisible(false);
                    new OneTeacherLoginWindow(loginID);  // 第一次登录填写个人信息
                }
                else{
                    loginWindow.setVisible(false);
                    new TeacherWindow(loginID);

                }

            }
        } else {
            JOptionPane.showMessageDialog(loginWindow, "用户名或密码错误！");
        }
        DBConn.closeConn();
    }
}