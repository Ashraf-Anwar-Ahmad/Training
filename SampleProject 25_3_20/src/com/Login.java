package com;

import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

public class Login 
{
	public static void main(String ab[])
	{
		Front2 obj=new Front2();
		obj.Display2();
	}
}	
class Front2
{
	JLabel l1;
	JTextField t1,t2;
	JButton b1;		
		
	public void  Display2()
	{
		JFrame f=new JFrame();
		f.setContentPane(new JLabel(new ImageIcon("C:\\Users\\ashra\\eclipse-workspace\\SampleProject 25_3_20\\src\\com\\unnamed.jpg")));
		l1=new JLabel("LOGIN");
		t1=new JTextField("Email",20);
		t2=new JTextField("Password",20);
		b1=new JButton("LOGIN");
		f.add(l1);
		f.add(t1);
		f.add(t2);
		f.add(b1);
		f.setLayout(new FlowLayout(FlowLayout.CENTER));
		f.setVisible(true);
		f.setSize(250,400);
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		b1.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) 
			{
				try 
				{
					Class.forName("com.mysql.cj.jdbc.Driver");
					Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/customer","root","root");
					PreparedStatement pst=con.prepareStatement("Select * from register where Email=? and CreatePassword=?");
					pst.setString(1, t1.getText());
					pst.setString(2, t2.getText());
					ResultSet rs=pst.executeQuery();
					if(rs.next())
					{
						Front3 obj3=new Front3();
						obj3.Display3();
					}
					else
					{
						System.out.println("INVALID");
					}
					pst.close();
					con.close();
				} catch (Exception e2) {
					// TODO: handle exception
				}
			}
		});
	}
}
