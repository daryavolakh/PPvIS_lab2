import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.util.*;
import java.util.Vector;
import javax.swing.table.DefaultTableModel;

public class MainWindow {
	public MainWindow() {
		JFrame frame = new JFrame();

		frame.setTitle("Lab 2");
		frame.setSize(450, 520);
		frame.setLayout(null);
		frame.setLocationByPlatform(true);

		JButton buttImport = new JButton("import");
		JButton buttSave = new JButton("save");
		JButton buttAdd = new JButton("add");
		JButton buttSearch = new JButton("search");
		JButton buttDelete = new JButton("delete");
		//JTextField input = new JTextField();
		JRadioButton radioSD1 = new JRadioButton("по числу членов семьи и фамилии");
		JRadioButton radioSD2 = new JRadioButton("по числу членов семьи и занимаемой S ");
		JRadioButton radioSD3 = new JRadioButton("по фамилии и занимаемой S");
		JRadioButton radioSD4 = new JRadioButton("вывести всех студентов, чья S на человека меньше или больше заданного предела");
		
		ButtonGroup groupSD = new ButtonGroup();

		Vector<String> columns = new Vector<String>();
		columns.add("ФИО студента");
		columns.add("Адрес");
		columns.add("Кол-во членов семьи");
		columns.add("Размер жилой S");
		columns.add("Жилая S на чел.");

		groupSD.add(radioSD1);
		groupSD.add(radioSD2);
		groupSD.add(radioSD3);
		groupSD.add(radioSD4);

		DefaultTableModel model = new DefaultTableModel(columns, 0);

		JTable table = new JTable();
		table.setModel(model);
		JScrollPane scrollPane = new JScrollPane(table);

		scrollPane.setBounds(20, 70, 390, 230);
		//input.setBounds(20, 20, 120, 30);
		buttAdd.setBounds(145, 20, 60, 30);
		buttImport.setBounds(245, 30, 80, 20);
		buttSave.setBounds(330, 30, 80, 20);
		radioSD1.setBounds(20, 320, 300, 20);
		radioSD2.setBounds(20, 350, 300, 20);
		radioSD3.setBounds(20, 380, 300, 20);
		radioSD4.setBounds(20, 410, 400, 20);
		buttSearch.setBounds(130, 440, 80, 20);
		buttDelete.setBounds(215, 440, 80, 20);

	//	frame.add(input);
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
		
	/*	buttAdd.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent event) {

				if (radioAdd1.isSelected() == true) {
					Vector<String> curRow = new Vector<String>();
					if (input.getText().equals(""))
						JOptionPane.showMessageDialog(null, "Empty line!");
					else {
						curRow.add(input.getText());
						model.addRow(curRow);
					}
				}

				else if (radioAdd2.isSelected() == true) {
					int count = model.getRowCount();
					Object value = input.getText();
					model.setValueAt(value, count - 1, 1);
					
					 * Vector<String> curRow = new Vector<String>(); if (input.getText().equals(""))
					 * JOptionPane.showMessageDialog(null, "Empty line!"); else {
					 * curRow.add(input.getText()); model.addRow(curRow); }
					 
				}

				else if (radioAdd3.isSelected() == true) {
					Vector<String> curRow = new Vector<String>();
					if (input.getText().equals(""))
						JOptionPane.showMessageDialog(null, "Empty line!");
					else {
						curRow.add(input.getText());
						model.addRow(curRow);
					}
				}

				else if (radioAdd4.isSelected() == true) {
					Vector<String> curRow = new Vector<String>();
					if (input.getText().equals(""))
						JOptionPane.showMessageDialog(null, "Empty line!");
					else {
						curRow.add(input.getText());
						model.addRow(curRow);
					}
				}

				else if (radioAdd5.isSelected() == true) {
					Vector<String> curRow = new Vector<String>();
					if (input.getText().equals(""))
						JOptionPane.showMessageDialog(null, "Empty line!");
					else {
						curRow.add(input.getText());
						model.addRow(curRow);
					}
				}
				/*
				 * int[] selectedRow = table.getSelectedRows(); selectedRow[0] =
				 * table.convertRowIndexToModel(selectedRow[0]); Object value =
				 * model.getValueAt(selectedRow[0], 0); if (!value.equals(""))
				 * JOptionPane.showMessageDialog(null, "Select another cell!"); else if
				 * (value.equals("")) { Object value2 =
				 * input.getText();//model.getValueAt(selectedRow[0], 0);
				 * model.setValueAt(value2,selectedRow[0],0); } input.setText(null);
				 
			}
		});
*/
		frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		frame.setVisible(true);
	}

}
