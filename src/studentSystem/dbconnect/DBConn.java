package studentSystem.dbconnect;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class DBConn {
    private static Connection conn;     //Connection对象（链接）
    private static final String JDriver = "com.microsoft.sqlserver.jdbc.SQLServerDriver";  //设置SQL Server数据库引擎
    private static final String connectDB = "jdbc:sqlserver://localhost:1433;DatabaseName = student_system";  //指定数据库
    private static final String user = "sa";
    private static final String password = "123456";//登陆密码
    public static Statement getStatement(){  // 返回用于执行静态 SQL 语句并返回它所生成结果的对象。
        try {
            Class.forName(JDriver);  //加载数据库引擎
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
            System.exit(0);
            return null;
        }
        Statement st;
        try {
            conn = DriverManager.getConnection(connectDB, user, password);  //连接数据库
            //Statement cmd = conn.createStatement(); //创建SQL命令对象//System.out.println("连接成功");
            st = conn.createStatement();
        } catch (SQLException e) {
            e.printStackTrace();
            System.exit(0);
            return null;
        }
        return st;
    }
    public static void closeConn(){
        try{
            conn.close();
        }catch(Exception e){
            e.printStackTrace();
        }
    }
}