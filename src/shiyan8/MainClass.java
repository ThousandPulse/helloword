package shiyan8;

import java.util.*;

public class MainClass {
    public static void main(String[] args) {
        HashMap<String, String> teacherList = new HashMap<String, String>();
        String[] teacherName = {"Tom  ", "John", "Susan", "Jerry", "Jim  ", "Kevin", "Lucy"};  // 老师名字的列表
        String[] courseName = {"CoreJava", "Oracle", "Oracle", "JDBC", "Unix", "JSP", "JSP"};  // 课程列表
        for (int i = 0; i < teacherName.length; i++) {
            teacherList.put(teacherName[i], courseName[i]);  // 以老师的名字作为键，以老师教授的课程名作为值加入map
        }
        teacherList.put("Allen", "JDBC");  // 增加了一位新老师Allen 教JDBC
        teacherList.put("Lucy", "CoreJava");  // Lucy 改为教CoreJava
        Set<String> setTeacher = teacherList.keySet();  // 获得key的Set视图
        Collection<String> setCourse = teacherList.values();  // 将value复值给Collection接口变量
        Iterator<String> itTeacher = setTeacher.iterator();  // 迭代器
        Iterator<String> itCourse = setCourse.iterator();  // 迭代器
        System.out.println("迭代器遍历");
        while (itTeacher.hasNext()) {
            String tName = itTeacher.next();
            String cName = itCourse.next();
            System.out.println("姓名：" + tName + "\t课程：" + cName);
        }
        System.out.println("for增强循环遍历");
        for (String name : setTeacher) {
            System.out.println("姓名:" + name + "\t课程：" + teacherList.get(name));  // 通过get(key)获得value
        }
        System.out.println("教JSP的老师有：");
        for (String name : setTeacher) {
            if (teacherList.get(name).equals("JSP"))  // 增强for循环遍历，对比
                System.out.println(name);
        }
    }
}