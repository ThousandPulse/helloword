package logingsss;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;



public class InsertListenerClass implements ActionListener {
    private static JTextField name;
    private static JTextField pass;
    private static JTextField pass2;
    public InsertListenerClass(JTextField name,JTextField pass,JTextField pass2){
        this.name=name;
        this.pass=pass;
        this.pass2=pass;
    }
    public void actionPerformed(ActionEvent e){

        String user_name = name.getText();
        String user_pass1 = pass.getText();//System.out.print(user_name+"\t"+user_pass);
        String user_pass2 = pass.getText();
        String user_pass=null;
        if(user_pass1.equals(user_pass2)){
            user_pass=user_pass1;
            DBConn_1 con= new DBConn_1();//↓
            Connection conn = con.getConn();//连接数据库，并获取链接、获得coon
            DBModify_1 select = new DBModify_1(conn);
            UserLoging a= new UserLoging(user_name,user_pass);
            int i=select.insert(a);//System.out.println(i);
            if(i==1)
                System.out.println("注册成功");
            else
                System.out.println("账号名已存在");
            con.closeConn();//断开连接
        }
        else {
            System.out.println("密码不一致");
        }

    }

}
