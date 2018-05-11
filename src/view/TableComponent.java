package view;
import model.*;
import controller.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.util.*;
import java.util.Vector;
import javax.swing.table.DefaultTableModel;

public class TableComponent extends JPanel{
	public Controller controller = new Controller();
	public JPanel panel = new JPanel();
	public Vector columns = new Vector();
	public DefaultTableModel model = new DefaultTableModel(columns,0);
	public JTable table = new JTable();
	public JButton first = new JButton("1");
	public JButton next = new JButton("->");
	public JButton prev = new JButton("<-");
	public JButton last = new JButton("...");
	public JTextField number = new JTextField("Кол-во отображамых строк");
	public JButton change = new JButton("ок");
	private int num = 2;
	private int tempPages = num;
	private int activePage = 1;
	private JLabel label1 = new JLabel();
	private JLabel label2 = new JLabel();
	private JLabel label3 = new JLabel();
	
	
	public TableComponent(Controller controller)
	{
		this.controller = controller;
		
		panel.setPreferredSize(new Dimension(500, 700));		
		
		columns.add("Фамилия студента");
		columns.add("Адрес");
		columns.add("Кол-во членов семьи");
		columns.add("Размер жилой S");
		columns.add("Жилая S на чел.");		
		
		table.setModel(model);
		JScrollPane scrollPane = new JScrollPane(table);
		scrollPane.setBounds(20, 70, 10, 1);
		number.setBounds(105,530,10,10);
		
		panel.add(scrollPane);		
		panel.add(number);
		panel.add(change);
		panel.add(first);
		panel.add(next);
		panel.add(prev);
		panel.add(last);
		panel.add(label1);
		panel.add(label2);
		panel.add(label3);
		
		add(panel);		
		
		change.addActionListener(new ActionListener() 
		{
			public void actionPerformed(ActionEvent event) 
			{				
				num = Integer.parseInt(number.getText());
				firstPage();
			}
		}
	);
	}
	
	public void update()
	{
		clearTable();
		
		if (controller.getStudents().size() < num)
		{
			addToTable(0,controller.getStudents().size());
			label3.setText("Текущее кол-во записей: " + (controller.getStudents().size()- num));
			label1.setText("Активная страница: " + activePage);
		}
		else {
			addToTable(0,num);
			label3.setText("Текущее кол-во записей: " + num);
			label1.setText("Активная страница: " + activePage);
		}
		
		label2.setText("Кол-во записей: " + controller.getStudents().size());
		first.addActionListener(new ActionListener() 
		{
			public void actionPerformed(ActionEvent event) 
			{				
				firstPage();
			}
		}
	);
		
		next.addActionListener(new ActionListener() 
		{
			public void actionPerformed(ActionEvent event) 
			{
				nextPage();
				label3.setText("Текущее кол-во записей: " + num);
			}
		}
	);
		
		prev.addActionListener(new ActionListener() 
		{
			public void actionPerformed(ActionEvent event) 
			{
				prevPage();
				label3.setText("Текущее кол-во записей: " + num);
			}
		}
	);
		
		last.addActionListener(new ActionListener() 
		{
			public void actionPerformed(ActionEvent event) 
			{
				lastPage();
			}
		}
	);
	}
	
	public void addToTable(int from, int to)
	{
		for (int index = from; index < to; index++)
		{					
			Student student = new Student();
			student = controller.getOneStudent(index);
			
			Vector row = new Vector();
			
			row.add(student.name);
			row.add(student.adress);
			row.add(student.familyMembers);
			row.add(student.area);
			row.add(student.areaPerPerson);
			
			model.addRow(row);
		}
	}
	
	public void firstPage()
	{
		clearTable();
		if (controller.getStudents().size() < num)
			addToTable(0,controller.getStudents().size());
		else
		{
			addToTable(0,num);
			tempPages = num;
			label3.setText("Текущее кол-во записей: " + num);
		}
		activePage = 1;
		showActivePage();
	}
	
	public void nextPage()
	{
		int count = controller.getStudents().size();
		clearTable();
		if (tempPages + num >= count)
		{
			lastPage();
		}
		else {
			addToTable(tempPages,tempPages + num);
			tempPages+=num;
			activePage++;
		}
		
		showActivePage();
	}
	
	public void prevPage()
	{
		clearTable();		
		if (tempPages - num == 0)
			firstPage();
		else {
			addToTable(tempPages - num,tempPages);  
			tempPages = tempPages - num;
			activePage--;
		}
		showActivePage();
	}
	
	public void lastPage()
	{
		clearTable();
		int count = controller.getStudents().size();
		int ost = count % num;
		if (ost == 0)
		{
			addToTable(controller.getStudents().size() - num,controller.getStudents().size());
			tempPages = count;
			activePage = count/num;
			label3.setText("Текущее кол-во записей: " + num);
		}
		else {
		addToTable(controller.getStudents().size() - ost, controller.getStudents().size());
		tempPages = controller.getStudents().size() - ost;
		label3.setText("Текущее кол-во записей: " + ost);
		activePage = (count - ost)/num;
		}
		showActivePage();
	}
	
	public void showActivePage()
	{
		label1.setText("Активная страница: " + activePage);
	}
	
	public void clearTable()
	{
		for( int index = model.getRowCount() - 1; index >= 0; index-- ) 
		{
			model.removeRow(index);
		}
	}
}
