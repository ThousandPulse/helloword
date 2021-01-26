package shiyan8.shiyan2;

import java.util.*;

public class MainClass {
    public static void main(String[] args) {
        LinkedList<Student> studentList = new LinkedList<Student>();  // 新建学生链表
        Student stu;  // 声明学生变量
        String[] stuName = {"张华", "王红", "孙磊"};  // 新建学生姓名列表
        int[] stuAge = {20, 21, 22};  // 新建学生年龄列表
        for (int i = 0; i < stuName.length; i++) {
            stu = new Student();  // 学生对象初始化
            stu.setName(stuName[i]);  // 学生对象设置名字
            stu.setAge(stuAge[i]);  // 学生对象设置年龄
            studentList.add(stu);  // 向链表添加学生
        }
        Iterator<Student> it = studentList.iterator();  // 加载迭代器
        while (it.hasNext()) {
            Student nowStu = it.next();  // 获得学生对象
            System.out.println("姓名：" + nowStu.getName() + "\t年龄：" + nowStu.getAge() + "岁");
        }
    }
}