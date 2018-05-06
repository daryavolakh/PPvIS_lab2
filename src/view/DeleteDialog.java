package view;
import java.awt.*;
import model.*;
import java.awt.event.*;
import javax.swing.*;
import java.util.*;
import java.util.Vector;
import javax.swing.table.DefaultTableModel;
import controller.*;

public class DeleteDialog {
//MainWindow parent;
public JDialog dialog = new JDialog();
public JButton buttonDel = new JButton("OK");
private MainWindow mainwindow = new MainWindow();
public Controller controller = new Controller();
public Vector items = new Vector();
public JComboBox comboBox = new JComboBox(items);

	public DeleteDialog(MainWindow mainwindow, Controller controller)
	{				
		this.mainwindow = mainwindow;
		this.controller = controller;
		
		dialog.setTitle("Delete information");
		dialog.setSize(310, 210);
		dialog.setLayout(null);
		dialog.setLocationByPlatform(true);			
		
		items.add("по фамилии и числу членов семьи");
		items.add("по числу членов семьи и занимаемой S");
		items.add("по фамилии и занимаемой S");
		items.add("вывести всех студентов, чья S на человека меньше/больше заданного предела");
						
		comboBox.setBounds(25, 35, 245, 30);
		buttonDel.setBounds(45, 100, 180, 30);
		
		dialog.add(comboBox);
		dialog.add(buttonDel);
				
	}
	
	public void delStud()
	{
		buttonDel.addActionListener(new ActionListener() 
		{
			public void actionPerformed(ActionEvent event) 
			{
				if (comboBox.getSelectedItem() == items.get(0))
				{
					DeleteStudentsDialog delete = new DeleteStudentsDialog(mainwindow,controller);
					delete.show();					
					delete.delByNameAndNumber();
					dialog.setVisible(false);
				}
				
				if (comboBox.getSelectedItem() == items.get(1))
				{
					DeleteStudentsDialog delete = new DeleteStudentsDialog(mainwindow,controller);
					delete.addTextFields();
					delete.show();					
					delete.delByNumberAndArea();
					dialog.setVisible(false);
				}
				
				if (comboBox.getSelectedItem() == items.get(2))
				{
					DeleteStudentsDialog delete = new DeleteStudentsDialog(mainwindow,controller);
					//delete.delAddTextFields();
					delete.show();
					delete.delByNameAndArea();
					dialog.setVisible(false);
				}
				
				if (comboBox.getSelectedItem() == items.get(3))
				{
					DeleteStudentsDialog delete = new DeleteStudentsDialog(mainwindow,controller);
					delete.delTextFields();
					delete.show();	
					delete.delByAreaPerPerson();
					dialog.setVisible(false);
				}				
			}
		});
	}
	
	public void show()
	{
		dialog.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		dialog.setVisible(true);
	}
}