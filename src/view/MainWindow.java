package view;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.util.*;
import java.util.Vector;
import javax.swing.table.DefaultTableModel;

public class MainWindow {
	public JFrame frame = new JFrame();
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
		JRadioButton radioSD1 = new JRadioButton("�� ����� ������ ����� � �������");
		JRadioButton radioSD2 = new JRadioButton("�� ����� ������ ����� � ���������� S ");
		JRadioButton radioSD3 = new JRadioButton("�� ������� � ���������� S");
		JRadioButton radioSD4 = new JRadioButton("������� ���� ���������, ��� S �� �������� ������ ��� ������ ��������� �������");
		
		ButtonGroup groupSD = new ButtonGroup();
		/*Object[] headers = {"��� ��������", "�����", "�����1", "�����2", "�����3"};
		Object[][] rows = {};*/
		// rows = new Vector<Vector<String>>();
		Vector columns = new Vector();
		columns.add("��� ��������");
		columns.add("�����");
		columns.add("���-�� ������ �����");
		columns.add("������ ����� S");
		columns.add("����� S �� ���.");

		groupSD.add(radioSD1);
		groupSD.add(radioSD2);
		groupSD.add(radioSD3);
		groupSD.add(radioSD4);

		DefaultTableModel model = new DefaultTableModel(columns,0);

		JTable table = new JTable();
		table.setModel(model);
		JScrollPane scrollPane = new JScrollPane(table);

		scrollPane.setBounds(20, 70, 390, 230);
		//input.setBounds(20, 20, 120, 30);
		buttAdd.setBounds(20, 20, 60, 30);
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
		
		Vector information = new Vector(); 
		
		buttAdd.addActionListener(new ActionListener() 
			{
				public void actionPerformed(ActionEvent event) 
				{
					AddDialog dialog = new AddDialog(information);
					model.addRow(information);
					System.out.println(information);
					
					
				}
			}
		);		
	}
	
	public void Show()
	{
		frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		frame.setVisible(true);
	}

}
