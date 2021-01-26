package logingsss;

import java.sql.*;
public class DBModify_1 {
    private static Connection conn;
    public DBModify_1(Connection conn){
        this.conn=conn;
    }
    public static int insert(UserLoging user) {
        String sql = "insert into [dbo].[User] (user_name,user_pass) values(?,?)";
        PreparedStatement pstmt;
        try {
            pstmt = (PreparedStatement) conn.prepareStatement(sql);
            pstmt.setString(1, user.Getuser_name());
            pstmt.setString(2, user.Getuser_pass());
            int i = pstmt.executeUpdate();//获取收到影响的元组
            pstmt.close();
            return i;
        } catch (SQLException e) {
            e.printStackTrace();
            return 0;
        }

    }
    public static int select(UserLoging user) {
        String sql = "select* from [dbo].[User] where user_name=? and user_pass=?";
        PreparedStatement pstmt;
        try {
            pstmt = (PreparedStatement)conn.prepareStatement(sql);
            pstmt.setString(1, user.Getuser_name());
            pstmt.setString(2, user.Getuser_pass());
            ResultSet rs = pstmt.executeQuery();;//执行语句

            int col = rs.getMetaData().getColumnCount();//获取元数据 动态数据列
            if(rs.next()){
                return 1;
            }
            else {
                return 0;
            }

        } catch (SQLException e) {
            e.printStackTrace();
            return 0;
        }
    }
}
/*while (rs.next()) {
                for (int i = 1; i <= col; i++) {
                    System.out.print(rs.getString(i) + "\t");
                    if ((i == 2) && (rs.getString(i).length() < 8)) {
                        System.out.print("\t");
                    }
                }
                System.out.println("");
            }*/