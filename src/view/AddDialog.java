package view;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JTextField;

import controller.Controller;
import model.Student;

public class AddDialog {

	public JDialog dialog = new JDialog();
	public JButton buttonAdd = new JButton("OK");
	public JTextField input1 = new JTextField("Фамилия: ");
	public JTextField input2 = new JTextField("Имя: ");
	public JTextField input3 = new JTextField("Город: ");
	public JTextField input4 = new JTextField("Улица: ");
	public JTextField input5 = new JTextField("Дом: ");
	public JTextField input6 = new JTextField("Кол-во членов семьи: ");
	public JTextField input7 = new JTextField("Жилая площадь: ");
	private MainWindow mainWindow = new MainWindow();
	public Controller controller = new Controller();

	public AddDialog(MainWindow mainWindow, Controller controller) {
	
		this.mainWindow = mainWindow;
		this.controller = controller;
		dialog.setTitle("Information");
		dialog.setSize(310, 450);
		dialog.setLayout(null);
		dialog.setLocationByPlatform(true);

		input1.setBounds(20, 20, 250, 30);
		input2.setBounds(20, 60, 250, 30);
		input3.setBounds(20, 100, 250, 30);
		input4.setBounds(20, 140, 250, 30);
		input5.setBounds(20, 180, 250, 30);
		input6.setBounds(20, 220, 250, 30);
		input7.setBounds(20, 260, 250, 30);
		buttonAdd.setBounds(100, 300, 100, 30);

		dialog.add(input1);
		dialog.add(input2);
		dialog.add(input3);
		dialog.add(input4);
		dialog.add(input5);
		dialog.add(input6);
		dialog.add(input7);
		dialog.add(buttonAdd);
	}

	public void setInfo() {
		buttonAdd.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent event) {

				Student student = new Student();

				student.surname = input1.getText();
				student.name = input2.getText();
				student.town = input3.getText();
				student.street = input4.getText();
				student.house = input5.getText();
				String famMem = input6.getText();
				student.familyMembers = Integer.parseInt(famMem);
				String tempArea = input7.getText();
				student.area = Integer.parseInt(tempArea);
				double tempAreaPerPerson = student.area / student.familyMembers;
				student.areaPerPerson = tempAreaPerPerson;

				controller.addStudent(student);

				mainWindow.update();

				dialog.setVisible(false);
			}
		});
	}

	public void show() {
		dialog.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		dialog.setVisible(true);
	}
}
