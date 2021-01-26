package studentSystem.onelogin;

import javax.swing.*;

public class OneTeacherLoginWindow extends JFrame {
    private JButton determine;
    private JLabel ID;
    private JLabel name;
    private JTextField teacherID;
    private JTextField teacherName;
    private JPanel panel;
    private String loginID;
    public OneTeacherLoginWindow(String loginID){
        this();
        this.loginID = loginID;
    }

    public OneTeacherLoginWindow(){
        this.setTitle("个人信息录入");
        this.setBounds(600,300,420,300);
        this.init();
        this.add(panel);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setVisible(true);
    }
    private void init(){

        panel = new JPanel();

        ID = new JLabel("职工号：");
        ID.setBounds(60,80,65,26);
        panel.add(ID);

        name = new JLabel("老师姓名：");
        name.setBounds(60,126,65,26);
        panel.add(name);

        teacherID = new JTextField();
        teacherID.setBounds(130,80,200,26);
        panel.add(teacherID);

        teacherName = new JTextField();
        teacherName.setBounds(130,126,200,26);
        panel.add(teacherName);

        OneTeacherLoginActionListener actionListener = new OneTeacherLoginActionListener(this,loginID,teacherID
                ,teacherName);
        determine = new JButton("确认");
        determine.setBounds(242,196,88,28);
        determine.addActionListener(actionListener);
        panel.add(determine);

        panel.setLayout(null);
    }
}