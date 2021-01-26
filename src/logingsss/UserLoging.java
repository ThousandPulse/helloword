package logingsss;

public class UserLoging {
    private static String user_name;
    private static String user_pass;
    public UserLoging(String user_name, String user_pass){
        this.user_name=user_name;
        this.user_pass=user_pass;
    }
    public String Getuser_name(){
        return this.user_name;
    }
    public String Getuser_pass(){
        return this.user_pass;
    }
}
