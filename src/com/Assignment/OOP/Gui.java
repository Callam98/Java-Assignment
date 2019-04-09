package com.Assignment.OOP;
import javax.swing.JRadioButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.JWindow;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ButtonGroup;
import javax.swing.JButton;

public class Gui extends JFrame implements ActionListener
{
	private JRadioButton b1;
	private JRadioButton b2;
	private JRadioButton b3;
	private JRadioButton b4;
	private JRadioButton b5;
	private JRadioButton b6;
	private JRadioButton b7;
	
	JButton JB1;
	JButton JB2;
	
	JLabel Label1;
	JLabel Label2;
	JLabel Label3;
	
	
	
	
	private ButtonGroup group1;
	private ButtonGroup group2;
	private ButtonGroup group3;
	
	
	public Gui(String title)
	{
		
		super(title);
		//Sets Layout as Border Layout of JFrame
		this.setLayout(new BorderLayout());
		
		b1 = new JRadioButton("Yes");
		b2 = new JRadioButton("No");
		b3 = new JRadioButton("Hot");
		b4 = new JRadioButton("Cool");
		b5 = new JRadioButton("Normal");
		b6 = new JRadioButton("Yes");
		b7 = new JRadioButton("No");
		JB1 = new JButton("Check");
		JB2 = new JButton("Admin");
		 
		group1 = new ButtonGroup();
		group2 = new ButtonGroup();
		group3 = new ButtonGroup();
		
		Label1 = new JLabel("Throat Sore?:");
		Label2 = new JLabel("Temperature?:");
		Label3 = new JLabel("Aches and Pains?:");
		
		
		
		
		b1.setBounds(150, 50, 85, 50); 
		b2.setBounds(250,50,80,50); 
		b3.setBounds(120,100,80,50);
		b4.setBounds(200,100,80,50);
		b5.setBounds(275,100,80,50);
		b6.setBounds(150,150,100,50);
		b7.setBounds(250,150,100,50);
		
		Label1.setBounds(30, 50, 175, 50); 
		Label2.setBounds(30, 100, 175, 50); 
		Label3.setBounds(30, 150, 175, 50); 
		
		JB1.setBounds(100,200,100,50);
		JB2.setBounds(250,200,100,50);
		
		JB2.addActionListener(this);
		
		
		this.add(b1);
		this.add(b2);
		this.add(b3);
		this.add(b4);
		this.add(b5);
		this.add(b6);
		this.add(b7);
		this.add(JB1);
		this.add(JB2);
		this.add(Label1);
		this.add(Label2);
		this.add(Label3);
		
		group1.add(b1);
		group1.add(b2);
		group2.add(b3);
		group2.add(b4);
		group2.add(b5);
		group3.add(b6);
		group3.add(b7);
	}
	
		
		
		public void actionPerformed(ActionEvent event)
		{
			if(event.getSource()==JB2)
			{
				System.out.println("Admin was pressed");
			}
			
		}
}
		
		
		
	
