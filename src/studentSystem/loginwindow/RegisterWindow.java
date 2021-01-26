package studentSystem.loginwindow;

import javax.swing.*;


public class RegisterWindow extends JFrame {
    private JButton jbtLogin;
    private JButton jbtRegister;
    private JLabel name;
    private JLabel pwd1;
    private JLabel pwd2;
    private JLabel userType;
    private JTextField userName;
    private JPasswordField userPwd1;
    private JPasswordField userPwd2;
    private JComboBox userTypeBox;
    private JPanel panel;


    public RegisterWindow() {
        this.setTitle("注册");
        this.setBounds(600, 300, 420, 300);
        this.init();
        this.add(panel);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setVisible(true);
    }

    private void init() {
        panel = new JPanel();

        name = new JLabel("账       号：");
        name.setBounds(60, 40, 65, 26);
        panel.add(name);

        pwd1 = new JLabel("密       码：");
        pwd1.setBounds(60, 66, 65, 26);
        panel.add(pwd1);

        pwd2 = new JLabel("确认密码：");
        pwd2.setBounds(60, 92, 65, 26);
        panel.add(pwd2);

        userType = new JLabel("选择类型：");
        userType.setBounds(60,118,65,26);
        panel.add(userType);

        userTypeBox = new JComboBox();
        userTypeBox.setBounds(130,118,80,26);
        userTypeBox.addItem("我是学生");
        userTypeBox.addItem("我是老师");
        panel.add(userTypeBox);

        userName = new JTextField();
        userName.setBounds(130, 40, 200, 26);
        panel.add(userName);

        userPwd1 = new JPasswordField();
        userPwd1.setBounds(130, 66, 200, 26);
        panel.add(userPwd1);

        userPwd2 = new JPasswordField();
        userPwd2.setBounds(130, 92, 200, 26);
        panel.add(userPwd2);



        RegisterActionListener registerActionListener = new RegisterActionListener(this,userName,userPwd1,userPwd2,userTypeBox);  // 添加监听器对象


        jbtLogin = new JButton("返回登录");
        jbtLogin.setBounds(130, 144, 88, 28);
        jbtLogin.addActionListener(registerActionListener);  // 添加监听器
        panel.add(jbtLogin);

        jbtRegister = new JButton("确认注册");
        jbtRegister.setBounds(242, 144, 88, 28);
        jbtRegister.addActionListener(registerActionListener);  // 添加监听器
        panel.add(jbtRegister);

        panel.setLayout(null);
    }

}
