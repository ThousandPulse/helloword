package studentSystem.teacherwindow;

import studentSystem.dbconnect.DBConn;
import studentSystem.dbconnect.DBModify;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.lang.reflect.Array;
import java.util.Arrays;

public class TeacherWindowActionListener implements ActionListener {
    private TeacherWindow teacherWindow;
    private JButton selectMenu0;
    private JLabel labelMenu0;
    private JTextField inputMenu0;

    private JButton selectMenu1;
    private JLabel labelMenu1;
    private JTextField inputMenu1;

    private JButton selectMenu2;
    private JLabel labelMenu2;
    private JTextField inputMenu2;
    private JPanel jPanel;
    private JPanel jPanel2;
    private JPanel jPanel3;
    private  JPanel jPanel4;
    private JTextArea area;
    private String loginID;

    TeacherWindowActionListener(String loginID, TeacherWindow teacherWindow,
                                JButton selectMenu0,JLabel labelMenu0,JTextField inputMenu0,
                                JButton selectMenu1,JLabel labelMenu1,JTextField inputMenu1,
                                JButton selectMenu2,JLabel labelMenu2,JTextField inputMenu2,
                                JPanel jPanel, JPanel jPanel2, JPanel jPanel3, JPanel jPanel4,JTextArea area) {
        this.loginID = loginID;
        this.teacherWindow = teacherWindow;
        this.selectMenu0 = selectMenu0;
        this.labelMenu0 = labelMenu0;
        this.inputMenu0 = inputMenu0;
        this.selectMenu1 = selectMenu1;
        this.labelMenu1 = labelMenu1;
        this.inputMenu1 = inputMenu1;
        this.selectMenu2 = selectMenu2;
        this.labelMenu2 = labelMenu2;
        this.inputMenu2 = inputMenu2;
        this.jPanel = jPanel;
        this.jPanel2 = jPanel2;
        this.jPanel3 = jPanel3;
        this.jPanel4 = jPanel4;
        this.area = area;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        teacherWindow.setBounds(600, 300, 420, 300);
        jPanel.setVisible(false);
        jPanel2.setVisible(false);
        jPanel3.setVisible(false);
        jPanel4.setVisible(false);
        switch (e.getActionCommand()) {
            case "根据学生姓名查询":
                selectForNameWindow();
                break;
            case "按照名字查找":
                selectStudentFromName();
                break;
            case "根据学生学号查询":
                selectForIDWindow();
                break;
            case "按照学号查找":
                selectStudentFromID();
                break;
            case "根据班级查询":
                selectForClassroomWindow();
                break;
            case "新建班级"://
                addClassroomWindow();
                break;
            case "从班级踢出学生":
                deleteStudentWindow();
                break;
            case "查询所有成绩"://
                selectStudentAll();
                break;
            case "根据课程名称查询":
                getReportForCourseWindow();
                break;
            case "批改成绩":
                System.out.println("批改成绩");//
                break;
            case "按照学号排序":
                System.out.println("按照学号排序");
                break;
            case "按照总成绩排序":
                System.out.println("按照总成绩排序");
                break;
            case "按照平均成绩排序":
                System.out.println("按照平均成绩排序");
                break;
            case "按照单科成绩排序":
                sortReportForCourseWindow();
                break;
            case "优秀率":
                System.out.println("优秀率");
                break;
            case "不及格率":
                System.out.println("不及格率");
                break;
        }
    }
    private void selectStudentAll() {
        teacherWindow.add(jPanel4);
        DBModify dbModify = new DBModify(DBConn.getStatement());
        String[][] student = dbModify.selectAllStudentResult();
        StringBuilder text= new StringBuilder();
        for (String[] item: student){
            for (String a :item){
                text.append(a);
                text.append("\t");
            }
            text.append("\n");
        }
        teacherWindow.setBounds(600, 300, 700, 300);
        area.setText(String.valueOf(text));
        area.setVisible(true);
        jPanel4.setVisible(true);
        DBConn.closeConn();

    }
    private void selectStudentFromName() {
        teacherWindow.add(jPanel4);
        DBModify dbModify = new DBModify(DBConn.getStatement());
        String[][] student = dbModify.selectStudentForName(inputMenu0.getText());
        StringBuilder text= new StringBuilder();
        for (String a :student[0]){
            text.append(a);
            text.append("\t");
        }

        teacherWindow.setBounds(600, 300, 700, 300);
        area.setText(String.valueOf(text));
        area.setVisible(true);
        jPanel4.setVisible(true);
        DBConn.closeConn();

    }

    private void selectStudentFromID() {
        teacherWindow.add(jPanel4);
        DBModify dbModify = new DBModify(DBConn.getStatement());
        String[][] student = dbModify.selectStudentForID(inputMenu0.getText());
        StringBuilder text= new StringBuilder();
        for (String a :student[0]){
            text.append(a);
            text.append("\t");
        }
        teacherWindow.setBounds(600, 300, 700, 300);
        area.setText(String.valueOf(text));
        area.setVisible(true);
        jPanel4.setVisible(true);
        DBConn.closeConn();

    }
    private void sortReportForCourseWindow(){
        teacherWindow.add(jPanel3);
        selectMenu2.setText("排序");
        labelMenu2.setText("科目：");
        showLTB(labelMenu2,inputMenu2,selectMenu2);
        jPanel3.setVisible(true);
    }

    private void getReportForCourseWindow(){
        teacherWindow.add(jPanel2);
        selectMenu1.setText("课程成绩查询");
        labelMenu1.setText("课程：");
        showLTB(labelMenu1,inputMenu1,selectMenu1);
        jPanel2.setVisible(true);
    }

    private void deleteStudentWindow(){
        teacherWindow.add(jPanel);
        selectMenu0.setText("踢出");
        labelMenu0.setText("学生ID：");
        showLTB(labelMenu0,inputMenu0,selectMenu0);
        jPanel.setVisible(true);
    }
    private void addClassroomWindow(){
        teacherWindow.add(jPanel);
        selectMenu0.setText("添加");
        labelMenu0.setText("班级ID：");
        showLTB(labelMenu0,inputMenu0,selectMenu0);
        jPanel.setVisible(true);
    }
    private void selectForClassroomWindow(){
        teacherWindow.add(jPanel);
        selectMenu0.setText("按照班级查找");
        labelMenu0.setText("班级ID：");
        showLTB(labelMenu0,inputMenu0,selectMenu0);
        jPanel.setVisible(true);
    }

    private void selectForIDWindow(){
        teacherWindow.add(jPanel);
        selectMenu0.setText("按照学号查找");
        labelMenu0.setText("学生ID：");
        showLTB(labelMenu0,inputMenu0,selectMenu0);
        jPanel.setVisible(true);
    }
    private void selectForNameWindow(){
        teacherWindow.add(jPanel);
        selectMenu0.setText("按照名字查找");
        labelMenu0.setText("姓名：");
        showLTB(labelMenu0,inputMenu0,selectMenu0);
        jPanel.setVisible(true);
    }

    private void showLTB(JLabel jLabel,JTextField jTextField,JButton jButton){
        jLabel.setVisible(true);
        jTextField.setVisible(true);
        jButton.setVisible(true);
    }
}

