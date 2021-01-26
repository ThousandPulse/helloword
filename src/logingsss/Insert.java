package logingsss;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Insert extends JFrame implements ActionListener {
    private static JFrame frame1;
    public Insert(JFrame frame1){
        this.frame1=frame1;
        JButton jbtloging = new JButton("返回登录");
        JButton jbtinsert = new JButton("注册");
        JPanel panel = new JPanel();
        panel.setLayout(null);
        JLabel username = new JLabel("账   号:");
        JTextField username_text = new JTextField(16);//创建JTextField，16表示16列，用于JTextField的宽度显示而不是限制字符个数
        JLabel userpass = new JLabel("密   码:");
        JTextField userpass_text = new JTextField(16);//创建JTextField，16表示16列，用于JTextField的宽度显示而不是限制字符个数
        JLabel userpass2 = new JLabel("确认密码:");
        JTextField userpass2_text = new JTextField(16);
        username.setBounds(85,40,40,26);
        panel.add(username);
        username_text.setBounds(130,40,200,26);
        panel.add(username_text);
        userpass.setBounds(85,66,40,26);
        panel.add(userpass);
        userpass_text.setBounds(130,66,200,26);
        panel.add(userpass_text);
        userpass2.setBounds(85,92,40,26);
        panel.add(userpass2);
        userpass2_text.setBounds(130,92,200,26);
        panel.add(userpass2_text);
        jbtloging.setBounds(130,128,88,28);
        panel.add(jbtloging);
        jbtinsert.setBounds(242,128,88,28);
        panel.add(jbtinsert);
        add(panel);                                            //JFrame中包含panel ，panel中包含jbtOK
        InsertListenerClass listener1 = new InsertListenerClass(username_text,userpass_text,userpass2_text);      //实例化监听器listener1
        jbtinsert.addActionListener(listener1);
        jbtloging.addActionListener(this);
    }
    public void actionPerformed(ActionEvent e){
        this.dispose();
        frame1.setVisible(true);
    }

}
