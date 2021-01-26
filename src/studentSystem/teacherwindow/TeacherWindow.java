package studentSystem.teacherwindow;

import javax.swing.*;

public class TeacherWindow extends JFrame {
    private JButton selectMenu0;
    private JLabel labelMenu0;
    private JTextField inputMenu0;

    private JButton selectMenu1;
    private JLabel labelMenu1;
    private JTextField inputMenu1;

    private JButton selectMenu2;
    private JLabel labelMenu2;
    private JTextField inputMenu2;

    private JMenu menu_0;
    private JMenu menu_1;
    private JMenu menu_2;
    private JMenu item_0_1;
    private JMenuItem item_0_1_1;
    private JMenuItem item_0_1_2;
    private JMenuItem item_0_1_3;
    private JMenu item_0_2;
    private JMenuItem item_0_2_1;
    private JMenuItem item_0_2_2;
    private JMenu item_1_1;
    private JMenuItem item_1_1_1;
    private JMenuItem item_1_1_2;
    private JMenuItem item_1_2;
    private JMenu item_2_1;
    private JMenuItem item_2_1_1;
    private JMenuItem item_2_1_2;
    private JMenuItem item_2_1_3;
    private JMenuItem item_2_1_4;
    private JMenuItem item_2_2_1;
    private JMenuItem item_2_2_2;
    private JMenu item_2_2;
    private JMenuBar bar;

    private JPanel panel;
    private  JPanel jPanel2;
    private  JPanel jPanel3;
    private  JPanel jPanel4;
    private JTextArea area;
    private String loginID;

    public TeacherWindow(){
        this("2");
    }


    public TeacherWindow(String loginID) {
        this.loginID = loginID;
        this.setTitle("老师端");
        this.setBounds(600, 300, 420, 300);
        this.initMenu();
        this.initPanel();
        this.initJPanel2();
        this.initJPanel3();
        this.initJPanel4();
        this.setJMenuBar(bar);
        this.addActionListener();
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setVisible(true);
    }

    /*
    * */
    private void initJPanel4(){
        jPanel4 = new JPanel();
        area=new JTextArea(10, 30);//构造一个文本域
        area.setLineWrap(false);
        jPanel4.add(area);

        jPanel4.setVisible(false);

    }

    private void initJPanel3(){
        jPanel3 = new JPanel();

        labelMenu2 = new JLabel("学号：");
        labelMenu2.setBounds(60, 40, 65, 26);
        labelMenu2.setVisible(false);
        jPanel3.add(labelMenu2);

        inputMenu2 = new JTextField();
        inputMenu2.setBounds(130, 40, 200, 26);
        inputMenu2.setVisible(false);
        jPanel3.add(inputMenu2);

        selectMenu2 = new JButton("学号排序");
        selectMenu2.setBounds(142, 102, 188, 28);
        selectMenu2.setVisible(false);
        jPanel3.add(selectMenu2);

        jPanel3.setVisible(false);
        jPanel3.setLayout(null);
    }

    private void initJPanel2(){
        jPanel2 = new JPanel();

        labelMenu1 = new JLabel("课程名称：");
        labelMenu1.setBounds(60, 40, 65, 26);
        labelMenu1.setVisible(false);
        jPanel2.add(labelMenu1);

        inputMenu1 = new JTextField();
        inputMenu1.setBounds(130, 40, 200, 26);
        inputMenu1.setVisible(false);
        jPanel2.add(inputMenu1);

        selectMenu1 = new JButton("查询成绩");
        selectMenu1.setBounds(142, 102, 188, 28);
        selectMenu1.setVisible(false);
        jPanel2.add(selectMenu1);

        jPanel2.setVisible(false);
        jPanel2.setLayout(null);
    }

    private void initPanel(){
        panel = new JPanel();

        labelMenu0 = new JLabel("学生姓名：");
        labelMenu0.setBounds(60, 40, 65, 26);
        labelMenu0.setVisible(false);
        panel.add(labelMenu0);

        inputMenu0 = new JTextField();
        inputMenu0.setBounds(130, 40, 200, 26);
        inputMenu0.setVisible(false);
        panel.add(inputMenu0);

        selectMenu0 = new JButton("根据学生姓名查询");
        selectMenu0.setBounds(142, 102, 188, 28);
        selectMenu0.setVisible(false);
        panel.add(selectMenu0);
        panel.setVisible(false);
        panel.setLayout(null);
    }

    private void initMenu() {

        bar = new JMenuBar();

/* 4. 能够查询每个课程的最高分、 、班级和学号。(算法类) */
        menu_0 = new JMenu("学生信息管理");
        item_0_1 = new JMenu("查询学生信息");
        item_0_1_1 = new JMenuItem("根据学生姓名查询");
        item_0_1_2 = new JMenuItem("根据学生学号查询");
        item_0_1_3 = new JMenuItem("根据班级查询");
        item_0_1.add(item_0_1_1);
        item_0_1.add(item_0_1_2);
        item_0_1.add(item_0_1_3);
        item_0_2 = new JMenu("班级管理");
        item_0_2_1 = new JMenuItem("新建班级");
        item_0_2_2 = new JMenuItem("从班级踢出学生");
        item_0_2.add(item_0_2_1);
        item_0_2.add(item_0_2_2);
        menu_0.add(item_0_1);
        menu_0.add(item_0_2);
        bar.add(menu_0);

        menu_1 = new JMenu("学生成绩管理");

        item_1_1 = new JMenu("查询成绩");
        item_1_1_1 = new JMenuItem("查询所有成绩");
        item_1_1_2 = new JMenuItem("根据课程名称查询");
        item_1_1.add(item_1_1_1);
        item_1_1.add(item_1_1_2);
        item_1_2 = new JMenuItem("批改成绩");
        menu_1.add(item_1_1);
        menu_1.add(item_1_2);
        bar.add(menu_1);

        menu_2 = new JMenu("成绩处理");

        item_2_1 = new JMenu("排序");
        item_2_1_1 = new JMenuItem("按照学号排序");
        item_2_1_2 = new JMenuItem("按照总成绩排序");
        item_2_1_3 = new JMenuItem("按照平均成绩排序");
        item_2_1_4 = new JMenuItem("按照单科成绩排序");
        item_2_1.add(item_2_1_1);
        item_2_1.add(item_2_1_2);
        item_2_1.add(item_2_1_3);
        item_2_1.add(item_2_1_4);
        item_2_2 = new JMenu("比例");
        item_2_2_1 = new JMenuItem("优秀率");
        item_2_2_2 = new JMenuItem("不及格率");
        item_2_2.add(item_2_2_1);
        item_2_2.add(item_2_2_2);
        menu_2.add(item_2_1);
        menu_2.add(item_2_2);
        bar.add(menu_2);


    }
    private void addActionListener(){

        TeacherWindowActionListener actionListener = new TeacherWindowActionListener(loginID,this,
                selectMenu0,labelMenu0,inputMenu0,
                selectMenu1,labelMenu1,inputMenu1,
                selectMenu2,labelMenu2,inputMenu2,
                panel,jPanel2,jPanel3,jPanel4,area);
        item_0_1_1.addActionListener(actionListener);
        item_0_1_2.addActionListener(actionListener);
        item_0_1_3.addActionListener(actionListener);
        item_0_2_1.addActionListener(actionListener);
        item_0_2_2.addActionListener(actionListener);
        item_1_1_1.addActionListener(actionListener);
        item_1_1_2.addActionListener(actionListener);
        item_1_2.addActionListener(actionListener);
        item_2_1_1.addActionListener(actionListener);
        item_2_1_2.addActionListener(actionListener);
        item_2_1_3.addActionListener(actionListener);
        item_2_1_4.addActionListener(actionListener);
        item_2_2_1.addActionListener(actionListener);
        item_2_2_2.addActionListener(actionListener);
        selectMenu0.addActionListener(actionListener);
        selectMenu1.addActionListener(actionListener);
        selectMenu2.addActionListener(actionListener);
    }

}