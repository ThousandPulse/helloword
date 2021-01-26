package logingsss;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Loging extends JFrame implements ActionListener {
    public Loging() {
        JButton jbtLogin = new JButton("登录");
        JButton jbtRegister = new JButton("注册账号");
        JPanel panel = new JPanel();
        JLabel username = new JLabel("账号:");
        panel.setLayout(null);
        JTextField username_text = new JTextField(16);//创建JTextField，16表示16列，用于JTextField的宽度显示而不是限制字符个数
        JLabel userpass = new JLabel("密码:");
        JTextField userpass_text = new JTextField(16);//创建JTextField，16表示16列，用于JTextField的宽度显示而不是限制字符个数
        username.setBounds(85, 40, 40, 26);
        panel.add(username);
        username_text.setBounds(130, 40, 200, 26);
        panel.add(username_text);
        userpass.setBounds(85, 66, 40, 26);
        panel.add(userpass);
        userpass_text.setBounds(130, 66, 200, 26);
        panel.add(userpass_text);
        jbtLogin.setBounds(242, 102, 88, 28);
        panel.add(jbtLogin);
        jbtRegister.setBounds(130, 102, 88, 28);
        panel.add(jbtRegister);
        add(panel);                                            //JFrame中包含panel ，panel中包含jbtOK
        LogingListenerClass listener1 = new LogingListenerClass(username_text, userpass_text);      //实例化监听器listener1
        jbtLogin.addActionListener(listener1);                    //在jbtOK中添加监听器listener1
        jbtRegister.addActionListener(this);//实例化监听器
    }

    public void actionPerformed(ActionEvent e) {
        this.setVisible(false);
        JFrame frame = new Insert(this);
        frame.setTitle("注册");
        frame.setSize(420, 300);//窗口大小
        frame.setLocation(600, 300);//出现位置
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }

    public static void main(String[] args) {
        // TODO Auto-generated method stub
        JFrame frame = new Loging();
        frame.setTitle("登录");
        frame.setSize(420, 300);//窗口大小
        frame.setLocation(600, 300);//出现位置
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);

    }
}
