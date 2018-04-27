package view;
import java.awt.*;
import model.*;
import controller.*;
import java.awt.event.*;
import javax.swing.*;
import java.util.*;
import java.util.Vector;
import javax.swing.table.DefaultTableModel;


public class AddDialog {
	
public JDialog dialog = new JDialog();
public JButton buttonAdd = new JButton("OK");
public JTextField input1 = new JTextField("ФИО: ");
public JTextField input2 = new JTextField("Адрес: ");
public JTextField input3 = new JTextField("Кол-во членов семьи: ");
public JTextField input4 = new JTextField("Жилая площадь: ");
public JTextField input5 = new JTextField("Жилая площадь на человека: ");	
private MainWindow mainWindow = new MainWindow();
public Controller controller = new Controller();

	public AddDialog(MainWindow mainWindow, Controller controller)
	{	
		//this.parent = parent;
		this.mainWindow = mainWindow;
		this.controller = controller;
		dialog.setTitle("Information");
		dialog.setSize(310, 350);
		dialog.setLayout(null);
		dialog.setLocationByPlatform(true);		
		
		input1.setBounds(20, 20, 250, 30);
		input2.setBounds(20, 60, 250, 30);
		input3.setBounds(20, 100, 250, 30);
		input4.setBounds(20, 140, 250, 30);
		input5.setBounds(20, 180, 250, 30);
		buttonAdd.setBounds(100,240,100,30);
		
		dialog.add(input1);
		dialog.add(input2);
		dialog.add(input3);
		dialog.add(input4);
		dialog.add(input5);
		dialog.add(buttonAdd);
	}
	
	public void setInfo()
	{
		buttonAdd.addActionListener(new ActionListener() 
		{

			public void actionPerformed(ActionEvent event) 
			{
				
				//Создать студента на основе введедных данных в диалоге
				Student student = new Student();
				
				//добавить в модель при помощи контроллера				
				student.name = input1.getText();
				student.adress = input2.getText();
				String famMem = input3.getText();
				student.familyMembers = Integer.parseInt(famMem);
				String tempArea = input4.getText();
				student.area = Integer.parseInt(tempArea);
				String tempAreaPerPerson = input5.getText();
				student.areaPerPerson = Integer.parseInt(tempAreaPerPerson);
				System.out.println(student.name + " " + student.adress + " " + student.familyMembers);
				
				controller.setStudent(student);
				
				//сказать главному окну обновиться
				mainWindow.update(controller);
								
				dialog.setVisible(false);
			}
		}
	);
}
	
	
	public void show()
	{
		dialog.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		dialog.setVisible(true);
	}
}
