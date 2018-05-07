package view;

import java.util.*;
import javax.swing.*;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import controller.Controller;
import model.Student;

public class SearchWindow {
	public JFrame frame = new JFrame();
	public JButton buttonSearch = new JButton("ok");
	public Vector columns = new Vector();
	public DefaultTableModel model = new DefaultTableModel(columns,0);
	public JTable table = new JTable();
	public Controller controller = new Controller();
	public ArrayList<Student> searchStud = new ArrayList<Student>();
	
	
	public SearchWindow(Controller controller)
	{
		this.controller = controller;
		frame.setTitle("Search");
		frame.setSize(450, 320);
		frame.setLayout(null);
		frame.setLocationByPlatform(true);
		
		columns.add("ФИО студента");
		columns.add("Адрес");
		columns.add("Кол-во членов семьи");
		columns.add("Размер жилой S");
		columns.add("Жилая S на чел.");		
		
		table.setModel(model);
		JScrollPane scrollPane = new JScrollPane(table);

		scrollPane.setBounds(20, 70, 390, 230);		
		buttonSearch.setBounds(45, 100, 420, 30);
		
		frame.add(buttonSearch);
		frame.getContentPane().add(scrollPane);
	}
	
	
	public void FillTable()
	{		
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
	}
	
	public void show()
	{
		frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		frame.setVisible(true);
	}
}
