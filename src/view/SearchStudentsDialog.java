package view;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.*;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import controller.Controller;
import model.Student;

public class SearchStudentsDialog {
	public JFrame frame = new JFrame();
	public JButton buttonSearch = new JButton("search");
	public Vector columns = new Vector();
	public DefaultTableModel model = new DefaultTableModel(columns,0);
	public JTable table = new JTable();
	public Controller controller = new Controller();
	public ArrayList<Student> searchStud = new ArrayList<Student>();
	public JTextField in1 = new JTextField();
	public JTextField in2 = new JTextField();
	public JTextField in3 = new JTextField();
	public JTextField in4 = new JTextField();
	
	public SearchStudentsDialog(Controller controller)
	{
		this.controller = controller;
		frame.setTitle("Search");
		frame.setSize(550, 450);
		frame.setLayout(null);
		frame.setLocationByPlatform(true);
		
		columns.add("Фамилия студента");
		columns.add("Адрес");
		columns.add("Кол-во членов семьи");
		columns.add("Размер жилой S");
		columns.add("Жилая S на чел.");		
		
		table.setModel(model);
		JScrollPane scrollPane = new JScrollPane(table);

		scrollPane.setBounds(70, 130, 390, 230);		
		buttonSearch.setBounds(60, 90, 410, 30);		
		in1.setBounds(175, 20, 180, 30);
		in2.setBounds(175, 50, 180, 30);	
		
		frame.add(in1);
		frame.add(in2);
		frame.add(buttonSearch);
		frame.add(scrollPane);
		frame.getContentPane().add(scrollPane);
	}
	
	public void byNameAndNumber()
	{
		buttonSearch.addActionListener(new ActionListener() 
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
						searchStud.add(student);
					}
				}
				
				if (searchStud.isEmpty())
				{
					JOptionPane.showMessageDialog(null, "Студенты не найдены :(");
				}
				
				else 
				{
					fillTable(searchStud);
				}
			}
		});					
	}
	
	public void byNameAndArea()
	{
		buttonSearch.addActionListener(new ActionListener() 
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
						searchStud.add(student);
					}
				}
				
				if (searchStud.isEmpty())
				{
					JOptionPane.showMessageDialog(null, "Студенты не найдены :(");
				}
				
				else 
				{
					fillTable(searchStud);
				}
				searchStud.clear();
			}
		});	
		
	}
	
	public void byNumberAndArea()
	{
		buttonSearch.addActionListener(new ActionListener() 
		{
			public void actionPerformed(ActionEvent event) 
			{					
				
				int number = Integer.parseInt(in1.getText());						
				int low = Integer.parseInt(in3.getText());						
				int high = Integer.parseInt(in4.getText());
				
				Student student;
				
				for (int index = 0; index < controller.getStudents().size(); index++)
				{
					student = controller.getOneStudent(index);	
					if (student.familyMembers == number && student.area >= low && student.area <= high)      
					{
						searchStud.add(student);
					}
				}
				if (searchStud.isEmpty())
				{
					JOptionPane.showMessageDialog(null, "Студенты не найдены :(");
				}
				
				else 
				{
					fillTable(searchStud);
				}
				searchStud.clear();
			}
		});					
	}
	
	public void byAreaPerPerson()
	{
		buttonSearch.addActionListener(new ActionListener() 
		{
			public void actionPerformed(ActionEvent event) 
			{	
				Student student;

				int low = Integer.parseInt(in3.getText());
				int high = Integer.parseInt(in4.getText());
				
				for (int index = 0; index < controller.getStudents().size(); index++)
				{
					student = controller.getOneStudent(index);	
					if (student.areaPerPerson >= low && student.areaPerPerson <= high)      
					{
						searchStud.add(student);
					}
				}
				
				if (searchStud.isEmpty())
				{
					JOptionPane.showMessageDialog(null, "Студенты не найдены :(");
				}
				
				else 
				{
					fillTable(searchStud);
				}
				searchStud.clear();
			}
		});					
	}
	
	
	/*public void addTextFields()
	{
		in3.setBounds(85, 70, 40, 30);
		in4.setBounds(135, 70, 40, 30);
		
		frame.add(in3);
		frame.add(in4);
	}*/
	
	public void delAddTextFields()
	{
		frame.remove(in2);
		in3.setBounds(220, 55, 40, 30);
		in4.setBounds(270, 55, 40, 30);
		
		frame.add(in3);
		frame.add(in4);
	}
	
	public void delTextFields()
	{
		frame.remove(in1);
		frame.remove(in2);
		in3.setBounds(220, 30, 40, 30);
		in4.setBounds(270, 30, 40, 30);
		
		frame.add(in3);
		frame.add(in4);
	}
	
	
	public void fillTable(ArrayList<Student> searchStud)
	{		
		
		for( int index = model.getRowCount() - 1; index >= 0; index-- ) 
		{
			model.removeRow(index);
		}
		
		for (int index = 0; index < searchStud.size(); index++)
		{
			Student student = searchStud.get(index);
			
			Vector row = new Vector();
			
			row.add(student.name);
			row.add(student.adress);
			row.add(student.familyMembers);
			row.add(student.area);
			row.add(student.areaPerPerson);
			
			model.addRow(row);
		}
		searchStud.clear();
	}
	
	public void show()
	{
		frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		frame.setVisible(true);
	}
}
