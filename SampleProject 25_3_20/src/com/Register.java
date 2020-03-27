  package com;

import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

public class Register 
{
	public static void main(String ab[]) throws Exception
	{
		Front obj=new Front();
		obj.Display();
	}
}
class Front
{
	JLabel l1;
	JTextField t1,t2,t3,t4;
	JButton b1;
	public void Display()
	{
		JFrame f=new JFrame();
		f.setContentPane(new JLabel(new ImageIcon("C:\\Users\\ashra\\eclipse-workspace\\SampleProject 25_3_20\\src\\com\\unnamed.jpg")));
		l1=new JLabel("Register FIRST");
		t1=new JTextField("Enter Name",20);
		t2=new JTextField("Enter Number",20);
		t3=new JTextField("Enter Email ID",20);
		t4=new JTextField("Create Password",20);
		b1=new JButton("Register");
		f.add(l1);
		f.add(t1);
		f.add(t2);
		f.add(t3);
		f.add(t4);
		f.add(b1);		
		b1.addActionListener(new ActionListener() 
		{
			public void actionPerformed(ActionEvent e)
			{
				String url="jdbc:mysql://localhost:3306/Customer";
				String user="root";
				String pass="root";
				String sql="insert into register values(?,?,?,?)";
				try {		
				Connection con=DriverManager.getConnection(url, user, pass);
				PreparedStatement pst=con.prepareStatement(sql);
				pst.setString(1, t1.getText());
				pst.setInt(2, Integer.parseInt(t2.getText()));
				pst.setString(3, t3.getText());
				pst.setString(4, t4.getText());
				int count=pst.executeUpdate();
				System.out.println(count+" row/s affected");
				pst.close();
				con.close();}catch(Exception ee) {}
				Front2 obj2=new Front2();
				obj2.Display2();
			}
		});		
		f.setLayout(new FlowLayout());
		f.setVisible(true);
		f.setSize(250,400);
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
}