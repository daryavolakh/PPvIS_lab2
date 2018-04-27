package view;
import model.*;
import controller.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.util.*;
import java.util.Vector;
import javax.swing.table.DefaultTableModel;

public class MainWindow {
	public JFrame frame = new JFrame();
	public Student student;
	public Vector columns = new Vector();
	public DefaultTableModel model = new DefaultTableModel(columns,0);
	public JTable table = new JTable();
	public Controller controller = new Controller();
	
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
		
		columns.add("ФИО студента");
		columns.add("Адрес");
		columns.add("Кол-во членов семьи");
		columns.add("Размер жилой S");
		columns.add("Жилая S на чел.");		
		
		table.setModel(model);
		JScrollPane scrollPane = new JScrollPane(table);

		scrollPane.setBounds(20, 70, 390, 230);
		buttAdd.setBounds(20, 20, 60, 30);
		buttImport.setBounds(245, 30, 80, 20);
		buttSave.setBounds(330, 30, 80, 20);
		buttSearch.setBounds(130, 440, 80, 20);
		buttDelete.setBounds(215, 440, 80, 20);

		frame.add(buttImport);
		frame.add(buttSave);
		frame.add(buttAdd);
		frame.add(buttSearch);
		frame.add(buttDelete);
		frame.add(scrollPane);
		frame.getContentPane().add(scrollPane);
		
		Vector row = new Vector();
		row.add("HELLO");
		model.addRow(row);
		
		buttAdd.addActionListener(new ActionListener() 
			{
				public void actionPerformed(ActionEvent event) 
				{
					AddDialog dialog = new AddDialog(MainWindow.this, controller);
					dialog.show();
					dialog.setInfo();
				}
			}
		);
		
		buttDelete.addActionListener(new ActionListener() 
		{
			public void actionPerformed(ActionEvent event) 
			{
				//Student student = new Student();
				DeleteDialog dialog = new DeleteDialog(MainWindow.this, controller);
				dialog.show();
				dialog.delStud();
			}
		}
	);
	}
	
	
	public void update(Controller controller)
	{
		//this.controller = controller;
		System.out.println("GET");
		for( int index = model.getRowCount() - 1; index >= 0; index-- ) 
		{
			model.removeRow(index);
		}
		
		Vector<Vector> students = controller.getStudents();
		System.out.println("LOOK ->"+ controller.getStudents());
		
		for (int index = 0; index < students.size(); index++)
		{
			model.addRow(students.get(index));
		}
	}
	
	public void show()
	{
		frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		frame.setVisible(true);
	}


}
