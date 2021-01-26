package logingsss;

import java.sql.*;

public class Jdbcs {
    public static void main(String[] args) {
        String JDriver = "com.microsoft.sqlserver.jdbc.SQLServerDriver";//设置SQL Server数据库引擎
        String connectDB = "jdbc:sqlserver://localhost:1433;DatabaseName=qianmai";//指定数据库
        try {
            Class.forName(JDriver);//加载数据库引擎
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
            System.exit(0);
        }
        System.out.println("连接数据库成功");

        try {
            String user = "sa";
            String password = "123456";//登陆密码
            Connection con = DriverManager.getConnection(connectDB, user, password);//连接数据库
            System.out.println("连接数据库成功");
            Statement cmd = con.createStatement();//创建SQL命令对象



            // 关闭连接
            cmd.close();//关闭命令对象连接
            con.close();//关闭数据库连接
        } catch (SQLException e) {
            e.printStackTrace();
            System.exit(0);
        }
    }


}
