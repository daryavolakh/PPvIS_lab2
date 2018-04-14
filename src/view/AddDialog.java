package view;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.util.*;
import java.util.Vector;
import javax.swing.table.DefaultTableModel;

public class AddDialog extends MainWindow{
private JButton buttonAdd = new JButton("OK");
private Vector info = new Vector();
	public AddDialog(Vector info)
	{
		JFrame frame = new JFrame();
		
		frame.setTitle("Information");
		frame.setSize(310, 350);
		frame.setLayout(null);
		frame.setLocationByPlatform(true);
		
		JTextField input1 = new JTextField("ФИО: ");
		JTextField input2 = new JTextField("Адрес: ");
		JTextField input3 = new JTextField("Кол-во членов семьи: ");
		JTextField input4 = new JTextField("Жилая площадь: ");
		JTextField input5 = new JTextField("Жилая площадь на человека: ");	
		
		input1.setBounds(20, 20, 250, 30);
		input2.setBounds(20, 60, 250, 30);
		input3.setBounds(20, 100, 250, 30);
		input4.setBounds(20, 140, 250, 30);
		input5.setBounds(20, 180, 250, 30);
		buttonAdd.setBounds(100,240,100,30);
		
		frame.add(input1);
		frame.add(input2);
		frame.add(input3);
		frame.add(input4);
		frame.add(input5);
		frame.add(buttonAdd);
		
		buttonAdd.addActionListener(new ActionListener() 
		{
			public void actionPerformed(ActionEvent event) 
			{
				info.add(input1.getText());
				info.add(input2.getText());
				info.add(input3.getText());
				info.add(input4.getText());
				info.add(input5.getText());
				
				//controller.addStudent()
				//parent.update();
				//System.out.println(information);
				
				frame.setVisible(false);
				//System.out.println(info);
			}
		}
	);
				
		frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		frame.setVisible(true);

	}
	
	/*private void addInputListeners()
	{
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent event)
			{
				
			}
		});
	}*/
}
