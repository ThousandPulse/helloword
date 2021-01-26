package studentSystem.loginwindow;

import javax.swing.*;

public class LoginWindow extends JFrame {
    private JButton jbtLogin;
    private JButton jbtRegister;
    private JLabel name;
    private JLabel pwd;
    private JTextField userName;
    private JPasswordField userPwd;
    private JPanel panel;

    public LoginWindow(){
        this.setTitle("登录");
        this.setBounds(600,300,420,300);
        this.init();
        this.add(panel);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setVisible(true);
    }
    private void init(){

        panel = new JPanel();


        name = new JLabel("账号：");
        name.setBounds(85,40,40,26);
        panel.add(name);

        pwd = new JLabel("密码：");
        pwd.setBounds(85,66,40,26);
        panel.add(pwd);

        userName = new JTextField();
        userName.setBounds(130,40,200,26);
        panel.add(userName);

        userPwd = new JPasswordField();
        userPwd.setBounds(130,66,200,26);
        panel.add(userPwd);

        LoginActionListener loginActionListener = new LoginActionListener(this,userName,userPwd);

        jbtLogin = new JButton("登录");
        jbtLogin.setBounds(242,102,88,28);
        jbtLogin.addActionListener(loginActionListener);
        panel.add(jbtLogin);

        jbtRegister = new JButton("注册");
        jbtRegister.setBounds(130,102,88,28);
        jbtRegister.addActionListener(loginActionListener);
        panel.add(jbtRegister);

        panel.setLayout(null);
    }
}
