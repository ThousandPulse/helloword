package studentSystem.onelogin;

import javax.swing.*;

public class OneStudentLoginWindow extends JFrame {
    private JButton determine;
    private JLabel ID;
    private JLabel name;
    private JLabel number;
    private JLabel address;
    private JLabel sex;
    private JLabel age;
    private JTextField studentID;
    private JTextField studentName;
    private JTextField studentNumber;
    private JTextField studentAddress;
    private JTextField studentSex;
    private JTextField studentAge;
    private JPanel panel;
    private String loginID;
    public OneStudentLoginWindow(String loginID){
        this();
        this.loginID = loginID;
    }

    public OneStudentLoginWindow(){
        this.setTitle("个人信息录入");
        this.setBounds(600,300,420,300);
        this.init();
        this.add(panel);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setVisible(true);
    }
    private void init(){

        panel = new JPanel();


        ID = new JLabel("学号：");
        ID.setBounds(85,40,40,26);
        panel.add(ID);

        name = new JLabel("账号：");
        name.setBounds(85,66,40,26);
        panel.add(name);

        number = new JLabel("电话：");
        number.setBounds(85,92,40,26);
        panel.add(number);

        address = new JLabel("地址：");
        address.setBounds(85,118,40,26);
        panel.add(address);

        sex = new JLabel("性别：");
        sex.setBounds(85,144,40,26);
        panel.add(sex);

        age = new JLabel("年龄：");
        age.setBounds(85,170,40,26);
        panel.add(age);

        studentID = new JTextField();
        studentID.setBounds(130,40,200,26);
        panel.add(studentID);

        studentName = new JTextField();
        studentName.setBounds(130,66,200,26);
        panel.add(studentName);

        studentNumber = new JTextField();
        studentNumber.setBounds(130,92,200,26);
        panel.add(studentNumber);

        studentAddress = new JTextField();
        studentAddress.setBounds(130,118,200,26);
        panel.add(studentAddress);

        studentSex = new JTextField();
        studentSex.setBounds(130,144,200,26);
        panel.add(studentSex);

        studentAge = new JTextField();
        studentAge.setBounds(130,170,200,26);
        panel.add(studentAge);
        OneStudentLoginActionListener actionListener = new OneStudentLoginActionListener(this,loginID,studentID
                ,studentName,studentNumber,studentAddress,studentSex,studentAge);
        determine = new JButton("确认");
        determine.setBounds(242,196,88,28);
        determine.addActionListener(actionListener);
        panel.add(determine);

        panel.setLayout(null);
    }
}