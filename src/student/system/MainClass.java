package student.system;

import studentSystem.dbconnect.DBConn;
import studentSystem.dbconnect.DBModify;

public class MainClass {
    /**
     *   1. 能够根据学生姓名 、学号、班级、课程名称查询具体内容。
     *   2. 能够实现按照单科成绩、总成绩、平均成绩、学号排序。(算法类)
     *   3. 能够实现学生信息的插入、删除和修改。(算法类)
     *   4. 能够查询每个课程的最高分、最低分及相应学生姓名、班级和学号。(算法类)
     *   5. 能够查询每个班级某门课程的优秀率（90分及以上）、不及格率，并进行排序。(算法类)
     *   6. 能够使用图形界面进行操作。
     */
    public static void main(String[] args){
        DBModify dbModify = new DBModify(DBConn.getStatement());
        //dbModify.selectStudent();
//        dbModify.selectStudentForName("张三");
//        dbModify.selectStudentForID("202010620000");
//        dbModify.selectStudentForClassroomName("零班");
//        dbModify.studentResult("JAVA");selectStudentForClassroomName
        //String[][] result = dbModify.selectStudentForClassroomName("零班");
        //System.out.println(Arrays.deepToString(result));
        //System.out.println(result);
        DBConn.closeConn();

    }
}
