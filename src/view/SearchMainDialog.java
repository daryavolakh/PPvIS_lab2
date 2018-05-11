package view;
import java.awt.*;
import model.*;
import java.awt.event.*;
import javax.swing.*;
import java.util.*;
import java.util.Vector;
import javax.swing.table.DefaultTableModel;
import controller.*;

public class SearchMainDialog 
{
	public JDialog dialog = new JDialog();
	public JButton buttonSearch = new JButton("SEARCH");
	public Controller controller = new Controller();
	public Vector items = new Vector();
	public JComboBox comboBox = new JComboBox(items);

		public SearchMainDialog(Controller controller)
		{				
			this.controller = controller;
			
			dialog.setTitle("Search");
			dialog.setSize(310, 210);
			dialog.setLayout(null);
			dialog.setLocationByPlatform(true);			
			
			items.add("по фамилии и числу членов семьи");
			items.add("по числу членов семьи и занимаемой S");
			items.add("по фамилии и занимаемой S");
			items.add("вывести всех студентов, чья S на человека меньше/больше заданного предела");
							
			comboBox.setBounds(25, 35, 245, 30);
			buttonSearch.setBounds(45, 100, 180, 30);
			
			dialog.add(comboBox);
			dialog.add(buttonSearch);					
		}
		
		public void searchStud()
		{
			buttonSearch.addActionListener(new ActionListener() 
			{
				public void actionPerformed(ActionEvent event) 
				{
					if (comboBox.getSelectedItem() == items.get(0))
					{
						SearchStudentsDialog search = new SearchStudentsDialog(controller);
						search.show();	
						search.byNameAndNumber();
						dialog.setVisible(false);
					}
					
					if (comboBox.getSelectedItem() == items.get(1))
					{
						SearchStudentsDialog search = new SearchStudentsDialog(controller);
						search.delAddTextFields();
						search.show();	
						search.byNumberAndArea();
						dialog.setVisible(false);
					}
					
					if (comboBox.getSelectedItem() == items.get(2))
					{
						SearchStudentsDialog search = new SearchStudentsDialog(controller);
						search.show();
						search.byNameAndArea();
						dialog.setVisible(false);
					}
					
					if (comboBox.getSelectedItem() == items.get(3))
					{
						SearchStudentsDialog search = new SearchStudentsDialog(controller);
						search.show();	
						search.delTextFields();
						search.byAreaPerPerson();
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
