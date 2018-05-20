package view;

import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;
import java.util.Vector;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

import controller.Controller;
import model.Student;

public class TableComponent extends JPanel {
	public Controller controller = new Controller();
	public JPanel panelTable = new JPanel();
	public JPanel panelButtons = new JPanel();
	public Vector<String> columns = new Vector<String>();
	public DefaultTableModel model = new DefaultTableModel(columns, 0);
	public JTable table = new JTable();
	public JButton first = new JButton("1");
	public JButton next = new JButton("->");
	public JButton prev = new JButton("<-");
	public JButton last = new JButton("...");
	public JTextField number = new JTextField("..");
	public JButton change = new JButton("ок");
	private int num = 4;
	private int tempPages = num;
	private int activePage = 1;
	private JLabel label1 = new JLabel();
	private JLabel label2 = new JLabel();
	private JLabel label3 = new JLabel();
	private JLabel label4 = new JLabel();
	private JLabel label5 = new JLabel("Изменить кол-во строк: ");
	public List<Student> students = new ArrayList<Student>();

	public TableComponent(Controller controller, List<Student> students) {
		this.controller = controller;
		this.students = students;
		panelTable.setPreferredSize(new Dimension(500, 650));

		columns.add("ФИО студента");
		columns.add("Адрес");
		columns.add("Кол-во членов семьи");
		columns.add("Размер жилой S");
		columns.add("Жилая S на чел.");

		table.setModel(model);
		JScrollPane scrollPane = new JScrollPane(table);
		scrollPane.setBounds(20, 70, 10, 1);
		number.setBounds(105, 530, 10, 10);

		panelTable.add(scrollPane);
		panelTable.add(label5);
		panelTable.add(number);
		panelTable.add(change);
		panelTable.add(first);
		panelTable.add(next);
		panelTable.add(prev);
		panelTable.add(last);
		panelTable.add(label1);
		panelTable.add(label2);
		panelTable.add(label3);
		panelTable.add(label4);

		add(panelTable);

		change.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent event) {
				num = Integer.parseInt(number.getText());
				firstPage();
				int ost = students.size() % num;
				if (ost == 0)
					label4.setText("Кол-во страниц: " + (students.size() / num));
				else
					label4.setText("Кол-во страниц: " + (((students.size() - ost) / num) + 1));
				
				label2.setText("Кол-во записей: " + students.size());
			}
		});
	}

	public void addRow(Student student) {
		Vector row = new Vector();

		row.add(student.surname + " " + student.name);
		row.add(student.town + " " + student.street + " " + student.house);
		row.add(student.familyMembers);
		row.add(student.area);
		row.add(student.areaPerPerson);

		model.addRow(row);
	}

	public void addToTable(int from, int to) {
		if (to == 1) {
			Student student = new Student();
			student = students.get(0);
			addRow(student);
		}

		else {
			for (int index = from; index < to; index++) {
				Student student = new Student();
				student = students.get(index);
				addRow(student);
			}
		}
	}

	public void firstPage() {

		System.out.println("FIRST tempPgaes = " + tempPages);
		clearTable();
		if (students.size() < num) {
			addToTable(0, students.size());
			tempPages = num;
		} else {
			addToTable(0, num);
			tempPages = num;
			label3.setText("Текущее кол-во записей: " + num);
		}
		activePage = 1;
		showActivePage();
	}

	public void nextPage() {
		System.out.println("tempPgaes before next= " + tempPages);
		int count = students.size();
		clearTable();
		if (tempPages + num >= count) {
			lastPage();
		} else {
			label3.setText("Текущее кол-во записей: " + num);
			addToTable(tempPages, tempPages + num);
			tempPages += num;
			activePage++;
		}

		System.out.println("tempPgaes after next = " + tempPages);

		showActivePage();
	}

	public void prevPage() {
		clearTable();
		System.out.println("tempPages before prev = " + tempPages);
		if (tempPages - 2 * num <= 0)
			firstPage();
		else {

			label3.setText("Текущее кол-во записей: " + num);
			addToTable((tempPages - 2 * num), tempPages - num);
			tempPages = tempPages - num;
			activePage--;
			showActivePage();
		}

		System.out.println("tempPgaes after prev = " + tempPages);
	}

	public void lastPage() {
		clearTable();
		System.out.println("LAST = " + tempPages);
		int count = students.size();
		int ost = count % num;
		if (ost == 0) {
			addToTable(students.size() - num, students.size());
			tempPages = students.size();
			activePage = count / num;
			label3.setText("Текущее кол-во записей: " + num);
		} else {
			// tempPages = ;
			addToTable(students.size() - ost, students.size());
			tempPages = students.size() - ost + num;
			label3.setText("Текущее кол-во записей: " + ost);
			activePage = (count - ost) / num + 1;
		}
		showActivePage();
	}

	public void showActivePage() {
		label1.setText("Активная страница: " + activePage);
	}

	public void clearTable() {
		for (int index = model.getRowCount() - 1; index >= 0; index--) {
			model.removeRow(index);
		}
	}

	public void update(List<Student> students) {
		this.students = students;
		clearTable();
		tempPages = num;
		System.out.println("tempPgaes = " + tempPages);
		activePage = 1;
		if (students.size() == 1) {
			addToTable(0, students.size());

			label3.setText("Текущее кол-во записей: " + (students.size()));
			label1.setText("Активная страница: " + activePage);
			label4.setText("Кол-во страниц: 1");
		}

		else if (students.size() < num) {
			addToTable(0, students.size());
			label3.setText("Текущее кол-во записей: " + (students.size()));
			label1.setText("Активная страница: " + activePage);
			label4.setText("Кол-во страниц: 1");
		} else {
			addToTable(0, num);
			label3.setText("Текущее кол-во записей: " + num);
			label1.setText("Активная страница: " + activePage);
			int ost = students.size() % num;
			if (ost == 0)
				label4.setText("Кол-во страниц: " + (students.size() / num));
			else
				label4.setText("Кол-во страниц: " + (((students.size() - ost) / num) + 1));
		}

		label2.setText("Кол-во записей: " + students.size());

		first.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent event) {
				firstPage();
			}
		});

		next.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent event) {
				nextPage();
			}
		});

		prev.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent event) {
				prevPage();
			}
		});

		last.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent event) {
				lastPage();
			}
		});
	}
}
