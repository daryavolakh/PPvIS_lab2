package model;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;
import java.util.Vector;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

import controller.Controller;
import model.Student;
import view.MainWindow;
import view.SearchMainDialog;

public class SearchStudentsDialog {
	public JFrame frame = new JFrame();
	public JButton buttonSearch = new JButton("let's go!");
	public Vector<String> columns = new Vector<String>();
	public DefaultTableModel model = new DefaultTableModel(columns, 0);
	public JTable table = new JTable();
	public Controller controller = new Controller();
	public MainWindow mainwindow = new MainWindow();
	public JTextField in1 = new JTextField();
	public JTextField in2 = new JTextField();
	public JTextField in3 = new JTextField();
	public JTextField in4 = new JTextField();
	public JLabel label1 = new JLabel();
	public JLabel label2 = new JLabel();
	public JLabel label3 = new JLabel();
	public JLabel label4 = new JLabel();
	private boolean dOrS;

	public SearchStudentsDialog(MainWindow mainwindow, Controller controller, boolean dOrS) {
		
		this.mainwindow = mainwindow;
		this.controller = controller;
		this.dOrS = dOrS;
		
		frame.setTitle("Search");
		frame.setSize(310, 260);
		frame.setLayout(null);
		frame.setLocationByPlatform(true);

		columns.add("ФИО студента");
		columns.add("Адрес");
		columns.add("Кол-во членов семьи");
		columns.add("Размер жилой S");
		columns.add("Жилая S на чел.");

		in1.setBounds(135, 30, 140, 30);
		in2.setBounds(135, 60, 140, 30);
		buttonSearch.setBounds(55, 130, 180, 30);

		frame.add(in1);
		frame.add(in2);
		frame.add(buttonSearch);
	}

	public void byNameAndNumber() {
		
		List<Student> founded = new ArrayList<Student>();
		
		label1.setText("Фамилия: ");
		label2.setText("Число членов семьи: ");
		
		label1.setBounds(72,30,80,30);
		label2.setBounds(5,60,130,30);
		
		frame.add(label1);
		frame.add(label2);
		
		buttonSearch.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent event) {				
				int number = Integer.parseInt(in2.getText());
				Student student;
				for (int index = 0; index < controller.getStudents().size(); index++) 
				{
					student = controller.getOneStudent(index);

					if (in1.getText().equals(student.surname) && number == student.familyMembers) {
						founded.add(student);
						System.out.println(student.surname);
					}	
				}

				if (founded.isEmpty())
					JOptionPane.showMessageDialog(null, "Студенты не найдены :(");
				
				else if (dOrS == true)
					delFounded(founded);
				else if (dOrS == false)
					showFounded(founded);
				
				frame.setVisible(false);
			}
		});
		
	}

	public void byNameAndArea() {
		List<Student> founded = new ArrayList<Student>();
		
		label1.setText("Фамилия: ");
		label2.setText("Площадь: ");
		
		label1.setBounds(30,30,80,30);
		label2.setBounds(30,60,80,30);
		
		in1.setBounds(105, 30, 140, 30);
		in2.setBounds(105,60,140,30);
		
		frame.add(label1);
		frame.add(label2);
		
		buttonSearch.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent event) {
				
				int number = Integer.parseInt(in2.getText());
				Student student;
				for (int index = 0; index < controller.getStudents().size(); index++) {
					student = controller.getOneStudent(index);

					if (in1.getText().equals(student.surname) && number == student.area) {
						founded.add(student);
					}
				}

				if (founded.isEmpty()) {
					JOptionPane.showMessageDialog(null, "Студенты не найдены :(");
				}
				
				else if (dOrS == true)
					delFounded(founded);
				else if (dOrS == false)
					showFounded(founded);
				
				frame.setVisible(false);
			}
		});
	}

	public void byNumberAndArea() {
		
		List<Student> founded = new ArrayList<Student>();
		
		buttonSearch.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent event) {
				
				int number = Integer.parseInt(in1.getText());
				int low = Integer.parseInt(in3.getText());
				int high = Integer.parseInt(in4.getText());

				Student student;

				for (int index = 0; index < controller.getStudents().size(); index++) {
					student = controller.getOneStudent(index);
					if (student.familyMembers == number && student.area >= low && student.area <= high) {
						founded.add(student);
					}
				}
				
				if (founded.isEmpty()) {
					JOptionPane.showMessageDialog(null, "Студенты не найдены :(");
				}
				
				else if (dOrS == true)
					delFounded(founded);
				else if (dOrS == false)
					showFounded(founded);

				frame.setVisible(false);
			}
		});
	}

	public void byAreaPerPerson() {
		
		List<Student> founded = new ArrayList<Student>();
		buttonSearch.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent event) {
				Student student;
				
				int low = Integer.parseInt(in3.getText());
				int high = Integer.parseInt(in4.getText());

				for (int index = 0; index < controller.getStudents().size(); index++) {
					student = controller.getOneStudent(index);
					if (student.areaPerPerson >= low && student.areaPerPerson <= high) {
						founded.add(student);
						System.out.println(student.surname);
					}
				}

				if (founded.isEmpty()) {
					JOptionPane.showMessageDialog(null, "Студенты не найдены :(");
				}
				
				else if (dOrS == true)
					delFounded(founded);
				else if (dOrS == false)
					showFounded(founded);

				frame.setVisible(false);
			}
		});
	}

	public void delAddTextFields() {
		frame.remove(in2);
		
		frame.add(label1);
		frame.add(label2);
		frame.add(label3);
		frame.add(label4);
		
		label1.setText("Число членов семьи: ");		
		label2.setText("Площадь: ");
		label3.setText("от");
		label4.setText("до");		
		
		label1.setBounds(5,30,130,30);
		label2.setBounds(50,70,80,30);
		label3.setBounds(115,70,40,30);
		label4.setBounds(180,70,40,30);
		in3.setBounds(135, 70, 40, 30);
		in4.setBounds(200, 70, 40, 30);

		frame.add(in3);
		frame.add(in4);
	}

	public void delTextFields() {
		frame.remove(in1);
		frame.remove(in2);
		
		
		frame.add(label1);
		frame.add(label3);
		frame.add(label4);
		
		label1.setText("Площадь на человека");
		label3.setText("от");
		label4.setText("до");
		
		label1.setBounds(70,20,140,25);
		label3.setBounds(70,50,40,30);
		label4.setBounds(130,50,40,30);
		in3.setBounds(85, 50, 40, 30);
		in4.setBounds(150, 50, 40, 30);

		frame.add(in3);
		frame.add(in4);
		
	}

	public void showFounded(List<Student> founded) {
		SearchMainDialog dialog = new SearchMainDialog(controller,founded);
		dialog.show();
		dialog.update();
	}
	
	public void delFounded(List<Student> founded) {
		controller.getStudents().removeAll(founded);
		mainwindow.update();
		JOptionPane.showMessageDialog(null, "Удалено студентов: " + founded.size());
	}

	public void show() {
		frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		frame.setVisible(true);
	}
}
