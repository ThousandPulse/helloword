package studentSystem.studentwindow;

import studentSystem.Student;
import studentSystem.dbconnect.DBConn;
import studentSystem.dbconnect.DBModify;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class StudentWindowActionListener implements ActionListener {
    private StudentWindow studentWindow;
    private JButton classAdd;
    private JLabel classroomName;
    private JTextField addClassroom;
    private JMenu menu_0;
    private JMenu menu_1;
    private String loginID;
    private Student student;
    private JPanel jPanel;
    private  JPanel jPanel2;
    private  JPanel jPanel3;

    StudentWindowActionListener( String loginID, StudentWindow studentWindow,
                                 JButton classAdd,JLabel classroomName,
                                 JTextField addClassroom,JMenu menu_0,JMenu menu_1,
                                 JPanel jPanel,JPanel jPanel2,JPanel jPanel3) {
        this.jPanel = jPanel;
        this.loginID = loginID;
        this.studentWindow = studentWindow;
        this.classAdd = classAdd;
        this.classroomName = classroomName;
        this.addClassroom = addClassroom;
        this.jPanel2 = jPanel2;
        this.jPanel3 = jPanel3;
        //this.menu_0 = menu_0;
        //this.menu_1 = menu_1;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        studentWindow.setBounds(600, 300, 420, 300);
        jPanel.setVisible(false);
        jPanel2.setVisible(false);
        jPanel3.setVisible(false);
        selectSelf();
        switch (e.getActionCommand()){
            case "加入班级":
                addClassroomItem();
                break;
            case "修改个人信息":
                System.out.println("修改个人信息");
                break;
            case "查询个人信息":
                System.out.println("查询个人信息");
                showSelf();
                break;
            case "查询个人成绩":
                showSelfCourseResult();
                System.out.println("查询个人成绩");
                break;
            case "查询个人课程":
                System.out.println("查询个人课程");
                break;
            case "确认加入":
                addClassroomButton();
                break;
        }
    }
    /* 当作有吧，不想搞这个模块了,截图搞前面的 */
    private void updataSelf(){

    }

    private void addClassroomItem(){
        jPanel.setVisible(true);
        classAdd.setVisible(true);
        classroomName.setVisible(true);
        addClassroom.setVisible(true);

    }
    private void addClassroomButton(){
        DBModify dbModify = new DBModify(DBConn.getStatement());
        String classroomID = dbModify.getClassroomIDForName(addClassroom.getText());
        int add = dbModify.classroomAddStudent(classroomID,student.getStudentID());
        if (add == 1){
            JOptionPane.showMessageDialog(studentWindow,"加入成功！");
        }else
            JOptionPane.showMessageDialog(studentWindow,"加入失败！");
        System.out.println(student.getStudentID()+classroomID);
        DBConn.closeConn();
    }
    private void selectSelf(){
        DBModify dbModify = new DBModify(DBConn.getStatement());
        String studentID = dbModify.getStudentIDForLoginID(loginID);
        String[][] strStudent = dbModify.selectStudentForID(studentID);
        student = new Student(strStudent[0][0],strStudent[0][1],
                strStudent[0][2],strStudent[0][3],strStudent[0][4],
                strStudent[0][5],loginID);
        DBConn.closeConn();
    }
    private void showSelf(){
        jPanel2.setVisible(true);
        jPanel2.add(new JLabel(student.getStudentName()));
        jPanel2.add(new JLabel(student.getStudentID()));
        jPanel2.add(new JLabel("年龄："+student.getStudentAge()+" 岁"));
        jPanel2.add(new JLabel("性别："+student.getStudentSex()));
        jPanel2.add(new JLabel("地址："+student.getStudentAddress()));
        jPanel2.add(new JLabel("电话："+student.getStudentNumber()));
        studentWindow.add(jPanel2);
    }
    private void showSelfCourseResult(){
        jPanel3.setVisible(true);
        DBModify dbModify = new DBModify(DBConn.getStatement());
        String[][] strStudent = dbModify.selectSelfStudentResult(student.getStudentID());
        StringBuilder chengjidan= new StringBuilder();
        int width = 0;
        for (String[] strings : strStudent) {
            width++;
            chengjidan.append(strings[2]).append("\t");
        }
        chengjidan.append("\n");
        for (String[] strings : strStudent) {
            chengjidan.append(strings[1]).append("\t");
        }
        String c = String.valueOf(chengjidan);
        System.out.println(c);
        JTextArea area=new JTextArea(10, 30);//构造一个文本域
        area.setText(String.valueOf(chengjidan));
        area.setLineWrap(false);
        jPanel3.add(area);
        if (width*106>420)
            studentWindow.setBounds(600, 300, width*106, 300);
        studentWindow.add(jPanel3);
        DBConn.closeConn();
    }
    /* 当作有吧，不想搞这个模块了 */
    private void showSelfCourse(){

    }

}

