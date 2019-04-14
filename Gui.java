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
import javax.swing.JComboBox;

public class Gui extends JFrame implements ActionListener
{
	private JRadioButton throat1;
	private JRadioButton throat2;
	private JRadioButton temp1;
	private JRadioButton temp2;
	private JRadioButton temp3;
	private JRadioButton ache1;
	private JRadioButton ache2;
	
	private String throatInput;
	private String tempInput;
	private String achesInput;
	
	JButton JB1;
	JButton JB2;
	
	JLabel Label1;
	JLabel Label2;
	JLabel Label3;
	
	
	
	
	private ButtonGroup group1;
	private ButtonGroup group2;
	private ButtonGroup group3;
	
	JPanel Panel1 = new JPanel();
	JPanel Panel2 = new JPanel();
	JPanel Panel3 = new JPanel();
	
	public Gui(String title)
	{
		
		super(title);
		//Sets Layout as Border Layout of JFrame
		this.setLayout(new BorderLayout());
		
		throat1 = new JRadioButton("Yes");
		throat2 = new JRadioButton("No");
		temp1 = new JRadioButton("Hot");
		temp2 = new JRadioButton("Cool");
		temp3 = new JRadioButton("Normal");
		ache1 = new JRadioButton("Yes");
		ache2 = new JRadioButton("No");
		JB1 = new JButton("Check");
		JB2 = new JButton("Admin");
		 
		group1 = new ButtonGroup();
		group2 = new ButtonGroup();
		group3 = new ButtonGroup();
		
		Label1 = new JLabel("Throat Sore?:");
		Label2 = new JLabel("Temperature?:");
		Label3 = new JLabel("Aches and Pains?:");
		
		
		
		
		throat1.setBounds(150, 50, 85, 50); 
		throat2.setBounds(250,50,80,50); 
		temp1.setBounds(120,100,80,50);
		temp2.setBounds(200,100,80,50);
		temp3.setBounds(275,100,80,50);
		ache1.setBounds(150,150,100,50);
		ache2.setBounds(250,150,100,50);
		
		Label1.setBounds(30, 50, 175, 50); 
		Label2.setBounds(30, 100, 175, 50); 
		Label3.setBounds(30, 200, 175, 50); 
		
		JB1.setBounds(100,200,100,50);
		JB2.setBounds(250,200,100,50);
		
		JB2.addActionListener(this);
		JB1.addActionListener(this);
		
		String achesInput;
		String tempInput;
		String throatInput;
		
		
		this.add(throat1);
		this.add(throat2);
		this.add(temp1);
		this.add(temp2);
		this.add(temp3);
		this.add(ache1);
		this.add(ache2);
		this.add(JB1);
		this.add(JB2);
		this.add(Label1);
		this.add(Label2);
		this.add(Label3);
		
		group1.add(throat1);
		group1.add(throat2);
		group2.add(temp1);
		group2.add(temp2);
		group2.add(temp3);
		group3.add(ache1);
		group3.add(ache2);
		
		
		throat1.setActionCommand("yes");
		throat2.setActionCommand("no");
		temp1.setActionCommand("hot");
		temp2.setActionCommand("cool");
		temp3.setActionCommand("normal");
		ache1.setActionCommand("yes");
		ache2.setActionCommand("no");
		
		
		
		
	}
		
		
		public void actionPerformed(ActionEvent event)
		{
			if(event.getSource()==JB2)
			{
				Login L1 = new Login("Login");
				L1.setVisible(true);
				L1.setSize(300,200);
				this.dispose();
				System.out.println("Admin was pressed");
			}
			else if (event.getSource()==JB1)
			{
				
				throatInput=group1.getSelection().getActionCommand();
				tempInput= group2.getSelection().getActionCommand();
				achesInput=group3.getSelection().getActionCommand();
				System.out.println(throatInput+tempInput+achesInput);
				Patient P1 = new Patient((String)tempInput,(String)achesInput,(String)throatInput);
				
				//JOptionPane.showMessageDialog(this, "AchesInput:"+ achesInput);
				JOptionPane.showMessageDialog(this,Math.round(P1.pCheck()*100)+"% That you have tonsilitis");
			}
			
			
		}
		
		
		
	}



