package studentSystem;

public class Teacher {
    private String teacherID;
    private String teacherName;
    private String loginID;
    Teacher(String teacherID,String teacherName,String loginID){
        this.loginID = loginID;
        this.teacherID = teacherID;
        this.teacherName = teacherName;
    }

    public String getLoginID() {
        return loginID;
    }

    public String getTeacherID() {
        return teacherID;
    }

    public String getTeacherName() {
        return teacherName;
    }
}
