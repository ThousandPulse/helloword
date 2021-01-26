package studentSystem.loginwindow;

import studentSystem.dbconnect.DBConn;
import studentSystem.dbconnect.DBModify;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Objects;

public class RegisterActionListener implements ActionListener {
    private RegisterWindow registerWindow;
    private JTextField userName;
    private JPasswordField password1;
    private JPasswordField password2;
    private JComboBox userTypeBox;

    RegisterActionListener(RegisterWindow registerWindow, JTextField userName,
                           JPasswordField password1, JPasswordField password2, JComboBox userTypeBox) {
        this.registerWindow = registerWindow;
        this.password1 = password1;
        this.password2 = password2;
        this.userName = userName;
        this.userTypeBox = userTypeBox;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getActionCommand().equals("返回登录")) {
            registerWindow.setVisible(false);
            new LoginWindow();
        } else if (e.getActionCommand().equals("确认注册")) {
            register();
        }
    }

    private void register() {

        String pass;
        int i = 0;
        if (String.valueOf(password2.getPassword()).equals("") ||
                String.valueOf(password1.getPassword()).equals("") ||
                userName.getText().equals("")) {
            JOptionPane.showMessageDialog(registerWindow, "不允许有空字符！");
            return;
        }
        DBModify dbModify = new DBModify(DBConn.getStatement());
        if (String.valueOf(password1.getPassword()).equals(String.valueOf(password2.getPassword()))) {
            pass = String.valueOf(password1.getPassword());

            if (Objects.requireNonNull(userTypeBox.getSelectedItem()).equals("我是学生")) {
                i = dbModify.insertUser(userName.getText(), pass, "1");
            } else if (userTypeBox.getSelectedItem().equals("我是老师"))
                i = dbModify.insertUser(userName.getText(), pass, "2");
            System.out.println(i);
        } else {
            JOptionPane.showMessageDialog(registerWindow, "两次密码不一样，请确认后重试！");
            DBConn.closeConn();
            return;
        }
        if (i == 1) {
            JOptionPane.showMessageDialog(registerWindow, "注册成功！");
        } else
            JOptionPane.showMessageDialog(registerWindow, "注册失败！");
        DBConn.closeConn();

    }
}

