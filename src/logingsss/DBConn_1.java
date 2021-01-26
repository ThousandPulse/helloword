package logingsss;

import java.sql.*;

public class DBConn_1 {
    private static Connection conn;     //Connection对象（链接）
    public static Connection getConn(){
        String JDriver = "com.microsoft.sqlserver.jdbc.SQLServerDriver";//设置SQL Server数据库引擎
        String connectDB = "jdbc:sqlserver://localhost:1433;DatabaseName=qianmai";//指定数据库
        try {
            Class.forName(JDriver);//加载数据库引擎
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
            System.exit(0);
        }
        try {
            String user = "sa";
            String password = "123456";//登陆密码
            conn = DriverManager.getConnection(connectDB, user, password);//连接数据库
            Statement cmd = conn.createStatement(); //创建SQL命令对象//System.out.println("连接成功");
            return conn;

        } catch (SQLException e) {
            e.printStackTrace();
            System.exit(0);
            return null;
        }

    }
    public static void closeConn(){
        try{
            conn.close();
        }catch(Exception e){
            e.printStackTrace();
        }
    }
}