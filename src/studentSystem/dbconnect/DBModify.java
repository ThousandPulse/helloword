package studentSystem.dbconnect;

import java.sql.*;

public class DBModify {
    private String SQL;
    private ResultSet rs;
    private static Statement st;

    public DBModify(Statement st) {
        DBModify.st = st;
    }

    private String[][] showAll(String SQL) {
        int studentCount = getStudentCount();
        String[][] result = new String[studentCount][7];
        try {
            rs = st.executeQuery(SQL);
            int j = 0;
            while (rs.next()) {
                for (int i = 1; i < 8; i++) {
                    result[j][i - 1] = rs.getString(i);
                }
                j++;
            }

        } catch (SQLException sqlException) {
            sqlException.printStackTrace();
        }
        return result;

    }

    public int getStudentCount() {
        SQL = " SELECT Count(*) FROM [dbo].[student]";
        try {
            int i = 0;
            rs = st.executeQuery(SQL);
            while (rs.next())
                i++;
            return i;
        } catch (SQLException sqlException) {
            sqlException.printStackTrace();
        }
        return 0;
    }

    public int getReportCount() {
        SQL = "SELECT Count(*) FROM [dbo].[result]";
        try {
            int i = 0;
            rs = st.executeQuery(SQL);
            while (rs.next())
                i++;
            return i;
        } catch (SQLException sqlException) {
            sqlException.printStackTrace();
        }
        return 0;
    }

    public int getCourseCount() {
        SQL = "SELECT Count(*) FROM [dbo].[course]";
        try {
            int i = 0;
            rs = st.executeQuery(SQL);
            while (rs.next())
                i++;
            return i;
        } catch (SQLException sqlException) {
            sqlException.printStackTrace();
        }
        return 0;
    }

    public String getStudentID(String studentName) {
        SQL = "SELECT student_id FROM [dbo].[student] WHERE student_name = '" + studentName + "'";
        String studentID = null;
        try {
            rs = st.executeQuery(SQL);
            while (rs.next())
                studentID = rs.getNString(1);

        } catch (SQLException sqlException) {
            sqlException.printStackTrace();
        }
        return studentID;
    }

    public String getStudentIDForLoginID(String loginID) {
        SQL = "SELECT * FROM [dbo].[student] WHERE login_id = "+loginID ;
        String studentID = null;
        try {
            rs = st.executeQuery(SQL);
            while (rs.next())
                studentID = rs.getNString(1);
        } catch (SQLException sqlException) {
            sqlException.printStackTrace();
        }

        return studentID;
    }

    public String getClassroomIDForName(String classroomName) {
        SQL = "SELECT classroom_id FROM [dbo].[classroom] WHERE classroom_name = '" + classroomName + "'";
        String classroomID = null;
        try {
            rs = st.executeQuery(SQL);
            while (rs.next())
                classroomID = rs.getNString(1);

        } catch (SQLException sqlException) {
            sqlException.printStackTrace();
        }
        return classroomID;
    }

    public String[] getStudentClassroomCourse(String studentName) {
        String studentID = getStudentID(studentName);
        String[] courseIDList = new String[getCourseCount()];
        SQL = "SELECT course_id FROM [dbo].[classroom_student],[dbo].[course] " +
                "WHERE student_id = '" + studentID + "' " +
                "AND classroom_student.classroom_id = course.classroom_id";

        try {
            rs = st.executeQuery(SQL);
            int i = 0;
            while (rs.next()) {
                courseIDList[i] = rs.getNString(1);
                i++;
            }

        } catch (SQLException sqlException) {
            sqlException.printStackTrace();
        }
        return courseIDList;
    }

    public String[] selectLogin(String loginName, String loginPwd) {
        SQL = "SELECT * FROM [dbo].[login] WHERE login_name = '" + loginName + "' " +
                "and login_pwd = '" + loginPwd + "'";

        String[] result = new String[4];
        try {
            rs = st.executeQuery(SQL);
            while (rs.next()) {
                for (int i = 1; i < 5; i++) {
                    result[i - 1] = rs.getString(i);
                }
            }
        } catch (SQLException sqlException) {
            sqlException.printStackTrace();
        }
        return result;
    }

    public String[][] selectStudent() {
        SQL = "SELECT * FROM [dbo].[student]";
        return showAll(SQL);
    }

    public String[][] selectStudentForName(String studentName) {
        SQL = "SELECT * FROM [dbo].[student] WHERE student_name = '" + studentName + "'";
        return showAll(SQL);
    }

    public String[][] selectStudentForID(String studentID) {
        SQL = "SELECT * FROM [dbo].[student] WHERE student_id = '" + studentID + "'";
        return showAll(SQL);
    }

    public boolean selectStudentForLoginID(String loginID) {
        SQL = "SELECT * FROM [dbo].[student] WHERE login_id = " + loginID ;
        String[][] loginStudent = showAll(SQL);
        return loginStudent[0][0] != null;
    }

    public boolean selectTeacherForLoginID(String loginID) {
        SQL = "SELECT * FROM [dbo].[teacher] WHERE login_id = " + loginID;
        String[] result = new String[3];
        try {
            rs = st.executeQuery(SQL);
            while (rs.next()) {
                result[0] = rs.getString(1);
                result[1] = rs.getString(2);
                result[2] = rs.getString(3);
            }
        } catch (SQLException sqlException) {
            sqlException.printStackTrace();
        }
        return result[0] != null;
    }

    public String[][] selectStudentForClassroomID(String classroomID) {
        SQL = "SELECT student.* FROM classroom_student,student WHERE" +
                " classroom_student.student_id = student.student_id and classroom_id =  '" + classroomID + "'";
        return showAll(SQL);
    }

    public String[][] selectStudentForClassroomName(String classroomName) {
        String[][] student = new String[0][0];
        try {
            SQL = "SELECT classroom_id FROM [dbo].[classroom] WHERE classroom_name = '" + classroomName + "'";
            rs = st.executeQuery(SQL);
            while (rs.next()) {
                student = selectStudentForClassroomID(rs.getString(1));

            }
            return student;
        } catch (SQLException sqlException) {
            //System.out.println("?????");
            sqlException.printStackTrace();
        }
        return student;
    }

    public String[][] selectStudentResultForCourseName(String courseName) {
        int studentCount = getStudentCount();
        String[][] result = new String[studentCount][2];

        try {
            SQL = "SELECT [student_name]" +
                    "      ,[course_result]" +
                    "  FROM [dbo].[result],[dbo].[student],[dbo].[course]" +
                    "  where course.course_name = '" + courseName + "'" +
                    "  and result.course_id = course.course_id" +
                    "  and result.student_id = student.student_id";
            rs = st.executeQuery(SQL);
            int j = 0;
            while (rs.next()) {
                for (int i = 1; i < 3; i++) {
                    result[j][i - 1] = rs.getString(i);
                }
                j++;
            }
            return result;
        } catch (SQLException sqlException) {
            sqlException.printStackTrace();
        }
        return result;
    }

    public String[] selectCourseNameList(String classroomID) {
        String[] courseList = new String[getCourseCount()];
        try {
            SQL = "SELECT [course_name] FROM [dbo].[course] WHERE classroom_id = '" + classroomID + "'";
            rs = st.executeQuery(SQL);
            int i = 0;
            while (rs.next()) {
                courseList[i] = rs.getString(1);
                i++;
            }
        } catch (SQLException sqlException) {
            System.out.println("?????");
            // sqlException.printStackTrace();
        }
        return courseList;
    }

    public String[][] selectAllStudentResult() {
        int reportCount = getReportCount();
        String[][] result = new String[reportCount][3];

        try {
            SQL = "SELECT [student_name],[course_result],[course_name]" +
                    "  FROM [dbo].[result],[dbo].[student],[dbo].[course]" +
                    "  where result.course_id = course.course_id" +
                    "  and result.student_id = student.student_id";
            rs = st.executeQuery(SQL);
            int j = 0;
            while (rs.next()) {
                for (int i = 1; i < 4; i++) {
                    result[j][i - 1] = rs.getString(i);
                }
                j++;
            }
            return result;
        } catch (SQLException sqlException) {
            sqlException.printStackTrace();
        }
        return result;
    }

    public String[][] selectSelfStudentResult(String studentID) {
        int reportCount = getReportCount();
        String[][] result = new String[reportCount][3];

        try {
            SQL = "SELECT [student_name],[course_result],[course_name]" +
                    "  FROM [dbo].[result],[dbo].[student],[dbo].[course]" +
                    "  where student.student_id = '"+studentID+"'" +
                    "  and result.course_id = course.course_id" +
                    "  and result.student_id = student.student_id";
            rs = st.executeQuery(SQL);
            int j = 0;
            while (rs.next()) {
                for (int i = 1; i < 4; i++) {
                    result[j][i - 1] = rs.getString(i);
                }
                j++;
            }
            return result;
        } catch (SQLException sqlException) {
            sqlException.printStackTrace();
        }
        return result;
    }

    public String[][] selectClassroomStudentResult(String classroomName) {
        int reportCount = getReportCount();
        String[][] result = new String[reportCount][3];

        try {
            SQL = "SELECT [student_name],[course_result],[course_name]" +
                    "  FROM [dbo].[result],[dbo].[student],[dbo].[course]," +
                    "[dbo].[classroom],[dbo].[classroom_student]" +
                    "  where classroom.classroom_name = '" + classroomName + "'" +
                    "  and result.course_id = course.course_id" +
                    "  and result.student_id = student.student_id" +
                    "  and student.student_id = classroom_student.student_id" +
                    "  and classroom_student.classroom_id = classroom.classroom_id";
            rs = st.executeQuery(SQL);
            int j = 0;
            while (rs.next()) {
                for (int i = 1; i < 4; i++) {
                    result[j][i - 1] = rs.getString(i);
                }
                j++;
            }
            return result;
        } catch (SQLException sqlException) {
            sqlException.printStackTrace();
        }
        return result;
    }

    public int upDataStudentName(String studentName, String loginID) {
        try {
            SQL = "UPDATE [dbo].[student] SET [student_name] = '" + studentName +
                    "' WHERE login_id = " + loginID;
            return st.executeUpdate(SQL);
        } catch (SQLException sqlException) {
            sqlException.printStackTrace();
        }
        return -1;
    }

    public int insertUser(String loginName, String loginPwd, String loginType) {
        try {
            SQL = "INSERT INTO [dbo].[login] ([login_type],[login_name],[login_pwd]) " +
                    "VALUES\n(" + loginType + ",'" + loginName + "','" + loginPwd + "')";
            return st.executeUpdate(SQL);  // 返回影响行数
        } catch (SQLException sqlException) {
            sqlException.printStackTrace();
        }
        return -1;
    }

    public int insertTeacher(String teacherName, String teacherID, String loginID) {
        try {
            SQL = "INSERT INTO [dbo].[teacher] ([teacher_id],[teacher_name],[login_id])" +
                    " VALUES\n('" + teacherID + "','" + teacherName + "'," + loginID + ")";
            return st.executeUpdate(SQL);  // 返回影响行数
        } catch (SQLException sqlException) {
            sqlException.printStackTrace();
        }
        return -1;
    }

    public int insertClassroom(String classroomID, String classroomName, String teacherID) {
        try {
            SQL = "INSERT INTO [dbo].[classroom] ([classroom_id],[classroom_name],[teacher_id]) " +
                    "VALUES ('" + classroomID + "','" + classroomName + "','" + teacherID + "'";
            return st.executeUpdate(SQL);  // 返回影响行数
        } catch (SQLException sqlException) {
            sqlException.printStackTrace();
        }
        return -1;
    }

    public int insertCourse(String courseID, String courseName, String classroomID) {
        try {
            SQL = "INSERT INTO [dbo].[course] ([course_id],[course_name],[classroom_id]) " +
                    "VALUES ('" + courseID + "','" + courseName + "','" + classroomID + "'";
            return st.executeUpdate(SQL);  // 返回影响行数
        } catch (SQLException sqlException) {
            sqlException.printStackTrace();
        }
        return -1;
    }

    public int insertStudent(String[] student) {
        /*
          student = [学号，姓名，电话，地址，性别，年龄，登陆账号]
          */
        try {
            SQL = "INSERT INTO [dbo].[student] ([student_id],[student_name],[student_number]," +
                    "[student_address],[student_sex],[student_age],[login_id]) VALUES " +
                    "('" + student[0] + "','" + student[1] + "','" + student[2] + "','" + student[3] +
                    "','" + student[4] + "'," + student[5] + "," + student[6] + ")";
            return st.executeUpdate(SQL);  // 返回影响行数
        } catch (SQLException sqlException) {
            sqlException.printStackTrace();
        }
        return -1;
    }

    public int classroomAddStudent(String classroomID, String studentName) {
        String studentID = getStudentID(studentName);
        try {
            SQL = "INSERT INTO [dbo].[classroom_student] ([classroom_id],[student_id]) " +
                    "VALUES ('" + classroomID + "','" + studentID + "'";
            return st.executeUpdate(SQL);  // 返回影响行数
        } catch (SQLException sqlException) {
            sqlException.printStackTrace();
        }
        return -1;
    }

    private void studentAddCourse_1(String studentID) {//, String courseID

        for (String courseID : getStudentClassroomCourse(studentID)) {
            if (!courseID.equals("")) {
                try {
                    SQL = "INSERT INTO [dbo].[result] ([student_id],[course_id]) " +
                            "VALUES ('" + studentID + "','" + courseID + "'";
                    st.executeUpdate(SQL);  // 返回影响行数
                } catch (SQLException sqlException) {
                    sqlException.printStackTrace();
                }
            }
        }
        //return -1;
    }

    public int deleteStudentInClassroom(String studentName, String classroomName) {  // 从班级中删除
        String studentID = getStudentID(studentName);
        deleteStudentInCourseAll(studentID);
        try {
            SQL = "DELETE FROM [dbo].[classroom_student] WHERE student_id = '" + studentID + "'";
            return st.executeUpdate(SQL);  // 返回影响行数
        } catch (SQLException sqlException) {
            sqlException.printStackTrace();
        }
        return -1;
    }

    private void deleteStudentInCourseAll(String studentID) {  // 删除其所有课程
        try {
            SQL = "DELETE FROM [dbo].[result] WHERE student_id = '" + studentID + "'";
            st.executeUpdate(SQL);  //
        } catch (SQLException sqlException) {
            sqlException.printStackTrace();
        }
    }

}