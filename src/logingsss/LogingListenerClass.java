package logingsss;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;

public class LogingListenerClass implements ActionListener {
    private static JTextField name;
    private static JTextField pass;
    public LogingListenerClass(JTextField name,JTextField pass){
        this.name=name;
        this.pass=pass;
    }
    public void actionPerformed(ActionEvent e){

        String user_name = name.getText();
        String user_pass = pass.getText();//System.out.print(user_name+"\t"+user_pass);
        DBConn_1 con= new DBConn_1();//↓
        Connection conn = con.getConn();//连接数据库，并获取链接、获得coon
        DBModify_1 select = new DBModify_1(conn);
        UserLoging a= new UserLoging(user_name,user_pass);
        int i=select.select(a);//System.out.println(i);
        if(i==1)
            System.out.println("登陆成功");
        else
            System.out.println("登陆失败");
        con.closeConn();//断开连接
    }

}
