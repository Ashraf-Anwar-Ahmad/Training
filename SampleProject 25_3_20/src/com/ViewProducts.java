package com;

import java.awt.Dimension;
import java.awt.FlowLayout;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class ViewProducts 
{
	public static void main(String aba[])
	{
		Front3 obj=new  Front3();
		obj.Display3();
	}
}
class Front3
{
	public void Display3()
	{
		JFrame f=new JFrame();
		f.setContentPane(new JLabel(new ImageIcon("C:\\Users\\ashra\\eclipse-workspace\\SampleProject 25_3_20\\src\\com\\unnamed.jpg")));
		JButton b1=new JButton("WELCOME");
		b1.setPreferredSize(new Dimension(100,100));
		f.setLayout(new FlowLayout());
		f.setVisible(true);
		f.setSize(400,400);
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		f.add(b1);
	}
}