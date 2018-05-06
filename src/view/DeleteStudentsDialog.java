package view;
import java.awt.*;
import model.*;
import java.awt.event.*;
import javax.swing.*;
import java.util.*;
import java.util.Vector;
import javax.swing.table.DefaultTableModel;

import controller.Controller;

public class DeleteStudentsDialog {
	public JDialog dialog = new JDialog();
	public JButton buttonDel = new JButton("OK");
	public Controller controller = new Controller();
	public JTextField in1 = new JTextField();
	public JTextField in2 = new JTextField();
	public JTextField in3 = new JTextField();
	public JTextField in4 = new JTextField();
	public MainWindow mainwindow = new MainWindow();

			public DeleteStudentsDialog(MainWindow mainwindow, Controller controller)
			{		
				this.mainwindow = mainwindow;
				this.controller = controller;
				
				dialog.setTitle("Delete information");
				dialog.setSize(310, 310);
				dialog.setLayout(null);
				dialog.setLocationByPlatform(true);									
				
				in1.setBounds(45, 30, 180, 30);
				in2.setBounds(45, 60, 180, 30);
				buttonDel.setBounds(45, 130, 180, 30);	
				
				dialog.add(in1);
				dialog.add(in2);
				dialog.add(buttonDel);				
			}
			
			public void delByNameAndNumber()
			{
				buttonDel.addActionListener(new ActionListener() 
				{
					public void actionPerformed(ActionEvent event) 
					{	
						int number = Integer.parseInt(in2.getText());
						Student student;
						for (int index = 0; index < controller.getStudents().size(); index++)
						{	
							student = controller.getOneStudent(index);
								
							if (in1.getText().equals(student.name) && number == student.familyMembers)     
							{
								controller.deleteStudent(student);								
							}
						}
						mainwindow.update();
					}
				});					
			}
			
			public void delByNameAndArea()
			{
				buttonDel.addActionListener(new ActionListener() 
				{
					public void actionPerformed(ActionEvent event) 
					{	
						int number = Integer.parseInt(in2.getText());
						Student student;
						for (int index = 0; index < controller.getStudents().size(); index++)
						{	
							student = controller.getOneStudent(index);
								
							if (in1.getText().equals(student.name) && number == student.area)     
							{
								controller.deleteStudent(student);
								
							}
						}
						mainwindow.update();
					}
				});	
				
			}
			
			public void delByNumberAndArea()
			{
				buttonDel.addActionListener(new ActionListener() 
				{
					public void actionPerformed(ActionEvent event) 
					{					
						System.out.println("LOL ");
						
						//String tempNumber = in1.getText();
						int number = Integer.parseInt(in1.getText());
						
						//String tempLow = in3.getText();
						int low = Integer.parseInt(in3.getText());
						
						//String tempHigh = in4.getText();
						int high = Integer.parseInt(in4.getText());
						Student student;
						for (int index = 0; index < controller.getStudents().size(); index++)
						{
							student = controller.getOneStudent(index);	
							if (student.familyMembers == number && student.area >= low && student.area <= high)      
							{
								controller.deleteStudent(student);
							}
						}
						mainwindow.update();
					}
				});					
			}
			
			public void delByAreaPerPerson()
			{
				buttonDel.addActionListener(new ActionListener() 
				{
					public void actionPerformed(ActionEvent event) 
					{					
						System.out.println("LOL ");
						Student student;

						//String tempNumber = in1.getText();
						int number = Integer.parseInt(in1.getText());
						
						//String tempLow = in3.getText();
						int low = Integer.parseInt(in3.getText());
						
						//String tempHigh = in4.getText();
						int high = Integer.parseInt(in4.getText());
						
						for (int index = 0; index < controller.getStudents().size(); index++)
						{
							student = controller.getOneStudent(index);	
							if (student.familyMembers == number && student.area >= low && student.area <= high)      
							{
								controller.deleteStudent(student);
							}
						}
						mainwindow.update();
					}
				});					
			}
			
			public void addTextFields()
			{
				in3.setBounds(85, 95, 40, 30);
				in4.setBounds(135, 95, 40, 30);
				
				dialog.add(in3);
				dialog.add(in4);
			}
			
			public void delAddTextFields()
			{
				dialog.remove(in2);
				in3.setBounds(85, 95, 40, 30);
				in4.setBounds(135, 95, 40, 30);
				
				dialog.add(in3);
				dialog.add(in4);
			}
			
			public void delTextFields()
			{
				dialog.remove(in1);
				dialog.remove(in2);
				in3.setBounds(85, 65, 40, 30);
				in4.setBounds(135, 65, 40, 30);
				
				dialog.add(in3);
				dialog.add(in4);
			}
			
			public void show()
			{
				dialog.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
				dialog.setVisible(true);
			}

}
