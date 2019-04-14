package com.Assignment.OOP;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

public class Login extends JFrame implements ActionListener
	{
		JButton JL1;
		JButton JL2;
		
		JLabel L1;
		JLabel L2;
		
		JTextField TF1;
		JPasswordField PF1;
		JPanel P1;
		JPanel P2;
		
		
		
		
		public Login (String title)
		{
			super(title);
			
			
			
			JL1 = new JButton("Patient");
			JL2 = new JButton("Login");
			
			L1 = new JLabel("UserName:");
			L2 = new JLabel("Password:");
			
			TF1 = new JTextField(10);
			PF1 = new JPasswordField(10);
			
			JL1.addActionListener(this);
			JL2.addActionListener(this);
			
			
			//Attribute for panel1
			P1 = new JPanel(new GridLayout(2,2));
			P1.add(L1);
			P1.add(TF1);
			P1.add(L2);
			P1.add(PF1);
			add(P1,BorderLayout.CENTER);
			P1.setBackground(Color.gray);
			
			//Attributes for panel 2
			P2 = new JPanel(new GridLayout(1,1));
			P2.add(JL1);
			P2.add(JL2);
			add(P2,BorderLayout.SOUTH);
		}
			
		
		public void actionPerformed(ActionEvent event)
			{
				if(event.getSource()==JL1)
				{
					Gui G1 = new Gui("Tonsilitis checker");
					G1.setSize(400, 300);
					G1.setVisible(true);
					this.dispose();
				}
				else if(event.getSource()==JL2)
				{
					String T1 = TF1.getText();
					String T2 = PF1.getText();
					if(T1.contentEquals("Callam") && T2.contentEquals("1234"))
							{
							System.out.println("Login Succesful");
							AdminMenu A1 = new AdminMenu("AdminMenu");
							A1.setVisible(true);
							A1.setSize(500,500);
							this.dispose();
						
							}
					else
					{
						System.out.println("Login Unsuccesful");
						JOptionPane.showMessageDialog(this,"Invalid Login");
					}
					
					
				}
				
			}
			
			
			
			
			
			
			
		}
		
	


