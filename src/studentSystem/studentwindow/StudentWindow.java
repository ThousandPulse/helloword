package studentSystem.studentwindow;

import javax.swing.*;

public class StudentWindow extends JFrame {
    private JButton classAdd;
    private JLabel classroomName;
    private JTextField addClassroom;
    private JMenu menu_0;
    private JMenu menu_1;
    private JMenuBar bar;
    private JPanel panel;
    private String loginID;
    private  JPanel jPanel2;
    private  JPanel jPanel3;

    public StudentWindow(){
        this("1");
    }


    public StudentWindow(String loginID) {
        this.loginID = loginID;
        this.setTitle("学生端");
        this.setBounds(600, 300, 420, 300);
        this.init();
        this.add(panel);
        this.add(jPanel2);
        this.add(jPanel3);
        this.add(panel);
        this.setJMenuBar(bar);

        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setVisible(true);
    }

    private void init() {

        bar = new JMenuBar();
        panel = new JPanel();
        jPanel2 = new JPanel();
        jPanel2.setVisible(false);
        jPanel3 = new JPanel();
        jPanel3.setVisible(false);

        menu_0 = new JMenu("个人操作");
        JMenuItem item_0_1 = new JMenuItem("加入班级",new ImageIcon("src/l.gif"));
        JMenuItem item_0_2 = new JMenuItem("修改个人信息",new ImageIcon("src/l.gif"));
        menu_0.add(item_0_1);
        menu_0.add(item_0_2);
        bar.add(menu_0);

        menu_1 = new JMenu("个人查询");
        JMenuItem item_1_1 = new JMenuItem("查询个人信息",new ImageIcon("src/l.gif"));
        JMenuItem item_1_2 = new JMenuItem("查询个人成绩",new ImageIcon("src/l.gif"));
        JMenuItem item_1_3 = new JMenuItem("查询个人课程",new ImageIcon("src/l.gif"));
        menu_1.add(item_1_1);
        menu_1.add(item_1_2);
        menu_1.add(item_1_3);
        bar.add(menu_1);

        classroomName = new JLabel("班级名称：");
        classroomName.setBounds(60, 40, 65, 26);
        classroomName.setVisible(false);
        panel.add(classroomName);

        addClassroom = new JTextField();
        addClassroom.setBounds(130, 40, 200, 26);
        addClassroom.setVisible(false);
        panel.add(addClassroom);

        classAdd = new JButton("确认加入");
        classAdd.setBounds(242, 102, 88, 28);
        classAdd.setVisible(false);
        panel.add(classAdd);
        StudentWindowActionListener actionListener = new StudentWindowActionListener(loginID,this,
                classAdd,classroomName,addClassroom,menu_0,menu_1,panel,jPanel2,jPanel3);
        item_0_1.addActionListener(actionListener);
        item_0_2.addActionListener(actionListener);
        item_1_1.addActionListener(actionListener);
        item_1_2.addActionListener(actionListener);
        item_1_3.addActionListener(actionListener);
        classAdd.addActionListener(actionListener);
        panel.setLayout(null);
    }
}
