package com.Assignment.OOP;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;


	public class AdminMenu extends JFrame implements ActionListener
	{
		
		String Patients;
		private JButton AP;
		private JButton Home;
		private JButton Delete;
		private JButton Accuracy;
		private JButton Reset;
		private JButton D_Display;
		
		private JTextArea Display;
		
		private JScrollPane Scroll;

		JPanel Panel1 ;
		JPanel Panel2 ;
		//JPanel Panel3 = new JPanel();
		//JPanel Panel4 = new JPanel();
		
		
		
		public AdminMenu (String Title)
		{
			//Border Settings
			
			//Instaniate buttons
			
			Home = new JButton("Home");
			Home.addActionListener(this);
			Accuracy = new JButton("Accuray");
			Accuracy.addActionListener(this);
			D_Display = new JButton("Display Data");
			D_Display.addActionListener(this);
			Display = new JTextArea();
			Scroll = new JScrollPane(Display);
			
			Panel1 = new JPanel(new GridLayout(2,2));
			Panel2 = new JPanel(new GridLayout(1,1));
			
			
			Panel1.add(Accuracy);
			
			Panel1.add(D_Display);
			Panel1.add(Home);
			
			add(Panel1,BorderLayout.SOUTH);
			Panel1.setBackground(Color.gray);
			
			Panel2.add(Scroll);
			Panel2.setPreferredSize(new Dimension(200,200));
			add(Panel2,BorderLayout.CENTER);
			
		}
			

		public void actionPerformed(ActionEvent e)
		{
			if(e.getSource()==Home)
			{
				Login L1 = new Login("Login");
				L1.setVisible(true);
				L1.setSize(300,200);
				this.dispose();
				System.out.println("Admin was pressed");
			}
			else if(e.getSource()==Accuracy)
			{
				FileProcessor F1 = new FileProcessor();
				JOptionPane.showMessageDialog(this,"Accuracy of this data is:"+ Math.round(F1.accuracy())+"%");
			}
			else if(e.getSource()==D_Display)
			{
				FileProcessor F2 = new FileProcessor();
				for(int i = 0;i < F2.getLineCount();i++)
				{
					Patients = Patients +"Patient ID:";
					for(int j = 0; j < F2.getCols();j++)
					{
						Patients = Patients+F2.getFileValues()[i][j]+"-";
					}
					Patients = Patients +"\n";
					Display.setText(Patients);
					Display.setEditable(false);
					
				}
				
				
			}
			
		}
				
			
	
			
			
			
		
	}

		

