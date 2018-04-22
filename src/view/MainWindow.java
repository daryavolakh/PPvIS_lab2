package view;
import model.*;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.util.*;
import java.util.Vector;
import javax.swing.table.DefaultTableModel;

public class MainWindow {
	public JFrame frame = new JFrame();
	public Student student;
	public StudentDataBase StDB = new StudentDataBase();
	public Vector columns = new Vector();
	public DefaultTableModel model = new DefaultTableModel(columns,0);
	public JTable table = new JTable();
	MainWindow window;
	//public MainWindow parent = new MainWindow(this);

	
	public MainWindow() {
		frame.setTitle("Lab 2");
		frame.setSize(450, 520);
		frame.setLayout(null);
		frame.setLocationByPlatform(true);

		JButton buttImport = new JButton("import");
		JButton buttSave = new JButton("save");
		JButton buttAdd = new JButton("add");
		JButton buttSearch = new JButton("search");
		JButton buttDelete = new JButton("delete");
		
		JRadioButton radioSD1 = new JRadioButton("по числу членов семьи и фамилии");
		JRadioButton radioSD2 = new JRadioButton("по числу членов семьи и занимаемой S ");
		JRadioButton radioSD3 = new JRadioButton("по фамилии и занимаемой S");
		JRadioButton radioSD4 = new JRadioButton("вывести всех студентов, чья S на человека меньше или больше заданного предела");
		
		ButtonGroup groupSD = new ButtonGroup();
		
		columns.add("ФИО студента");
		columns.add("Адрес");
		columns.add("Кол-во членов семьи");
		columns.add("Размер жилой S");
		columns.add("Жилая S на чел.");

		groupSD.add(radioSD1);
		groupSD.add(radioSD2);
		groupSD.add(radioSD3);
		groupSD.add(radioSD4);
		
		table.setModel(model);
		JScrollPane scrollPane = new JScrollPane(table);

		scrollPane.setBounds(20, 70, 390, 230);
		buttAdd.setBounds(20, 20, 60, 30);
		buttImport.setBounds(245, 30, 80, 20);
		buttSave.setBounds(330, 30, 80, 20);
		radioSD1.setBounds(20, 320, 300, 20);
		radioSD2.setBounds(20, 350, 300, 20);
		radioSD3.setBounds(20, 380, 300, 20);
		radioSD4.setBounds(20, 410, 400, 20);
		buttSearch.setBounds(130, 440, 80, 20);
		buttDelete.setBounds(215, 440, 80, 20);

		frame.add(buttImport);
		frame.add(buttSave);
		frame.add(buttAdd);
		frame.add(buttSearch);
		frame.add(buttDelete);
		frame.add(scrollPane);
		frame.getContentPane().add(scrollPane);
		frame.add(radioSD1);
		frame.add(radioSD2);
		frame.add(radioSD3);
		frame.add(radioSD4);
		
		Vector row = new Vector();
		row.add("HELLO");
		model.addRow(row);
		
		buttAdd.addActionListener(new ActionListener() 
			{
				public void actionPerformed(ActionEvent event) 
				{
					Student student = new Student();
					AddDialog dialog = new AddDialog(window, true);
					dialog.Show();
					dialog.SetInfo(student,StDB);
				}
			}
		);
	}
	
	public void update()
	{
		for( int index = model.getRowCount() - 1; index >= 0; index-- ) 
		{
			model.removeRow(index);
		}
		
		Vector<Vector> students = StDB.getStudents();
		System.out.println("LOOK ->"+ StDB.getStudents());
		
		for (int index = 0; index < students.size(); index++)
		{
			model.addRow(students.get(index));
		}
	}
	
	public void Show()
	{
		frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		frame.setVisible(true);
	}	
}
