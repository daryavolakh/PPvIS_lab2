package view;
import model.*;
import controller.*;
import java.awt.*;
import java.awt.event.*;
import java.io.FileNotFoundException;
import java.io.File;
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
				DeleteDialog dialog = new DeleteDialog(MainWindow.this, controller);
				
				dialog.show();
				dialog.delStud();
			}
		}
	);
		
		buttImport.addActionListener(new ActionListener() 
		{
			public void actionPerformed(ActionEvent event) 
			{
				try {
					ReadingFromAFile read = new ReadingFromAFile(MainWindow.this, controller);
				} catch (FileNotFoundException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
	);
		
		buttSave.addActionListener(new ActionListener() 
		{
			public void actionPerformed(ActionEvent event) 
			{
				try {
					WriteToFile write = new WriteToFile(controller);
				} catch (FileNotFoundException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
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
		
		for (int index = 0; index < controller.getStudents().size(); index++)
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
	
	public void show()
	{
		frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		frame.setVisible(true);
	}


}
