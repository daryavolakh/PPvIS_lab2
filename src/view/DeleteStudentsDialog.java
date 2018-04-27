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
	public JTextField in1 = new JTextField("число членов семьи");
	public JTextField in2 = new JTextField("ФИО");

			public DeleteStudentsDialog(Controller controller)
			{				
				this.controller = controller;
				
				dialog.setTitle("Delete information");
				dialog.setSize(310, 210);
				dialog.setLayout(null);
				dialog.setLocationByPlatform(true);					
				
				
				in1.setBounds(45, 30, 180, 30);
				in2.setBounds(45, 60, 180, 30);
				buttonDel.setBounds(45, 100, 180, 30);	
				
				dialog.add(in1);
				dialog.add(in2);
				dialog.add(buttonDel);				
			}
			
			public void delStudents()
			{
				buttonDel.addActionListener(new ActionListener() 
				{
					public void actionPerformed(ActionEvent event) 
					{
						//вывести сюда информацию об удалении
						//String info1 = in1.getText();
						//String info2 = in2.getText();
						Vector<Vector> students = new Vector();
						
						students = controller.getStudents();
						
						System.out.println("LOL " + students);
						
						for (int index = 0; index < students.size(); index++)
						{
								Vector student = students.get(index);
								
								System.out.println("NOT " + student);
								System.out.println("hmmmm " + student.get(2));
								System.out.println("hmmmm " + student.get(0));
								
								if (in2.getText().equals(student.get(0)))     //0
								{
									System.out.println("NOT LOL ");
									if (in1.getText().equals(student.get(2)))
									{
										System.out.println("NOT LOL " + students);
										controller.deleteStudent(student);
									}
								}
						}					
						
						//dialog.setVisible(false);
					}
				});		
			}
			
			public void show()
			{
				dialog.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
				dialog.setVisible(true);
			}

}
