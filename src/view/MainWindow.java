package view;
import model.*;
import controller.*;
import java.awt.*;
import java.awt.event.*;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.File;
import javax.swing.*;
import java.util.*;
import java.util.Vector;
import javax.swing.table.DefaultTableModel;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactoryConfigurationError;

import org.xml.sax.SAXException;

public class MainWindow {
	public JFrame frame = new JFrame();
	public Controller controller = new Controller();
	public TableComponent table = new TableComponent(controller);
	
	public MainWindow() {
		frame.setTitle("Lab 2");
		frame.setSize(590, 700);
		frame.setLayout(null);
		frame.setLocationByPlatform(true);

		JPanel mainPanel = new JPanel();
		JButton buttImport = new JButton("import");
		JButton buttSave = new JButton("save");
		JButton buttAdd = new JButton("add");
		JButton buttSearch = new JButton("search");
		JButton buttDelete = new JButton("delete");	
		JToolBar menu = new JToolBar("MENU");
		
		menu.setFloatable(false);
		menu.setOrientation(SwingConstants.HORIZONTAL);
		menu.setOrientation(SwingConstants.CENTER);		

		JButton menuImport = new JButton("import");
		JButton menuSave = new JButton("save");
		JButton menuAdd = new JButton("add");
		JButton menuSearch = new JButton("search");
		JButton menuDelete = new JButton("delete");	
		
		menu.add(menuAdd);
		menu.add(menuSearch);
		menu.add(menuDelete);
		menu.add(menuImport);
		menu.add(menuSave);
	
		buttAdd.setBounds(70, 50, 70, 20);
		buttSearch.setBounds(145, 50, 80, 20);
		buttDelete.setBounds(230, 50, 80, 20);
		buttImport.setBounds(315, 50, 80, 20);
		buttSave.setBounds(400, 50, 80, 20);
		menu.setBounds(0,0,224,30);
		
		mainPanel.setBounds(40, 90, 490, 500);
		mainPanel.add(table);
		
		frame.add(menu);
		frame.add(buttImport);
		frame.add(buttSave);
		frame.add(buttAdd);
		frame.add(buttSearch);
		frame.add(buttDelete);
		frame.add(mainPanel);

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
		
		buttSearch.addActionListener(new ActionListener() 
		{
			public void actionPerformed(ActionEvent event) 
			{
				SearchMainDialog dialog = new SearchMainDialog(controller);
				
				dialog.show();
				dialog.searchStud();
			}
		}
	);
		
		buttImport.addActionListener(new ActionListener() 
		{
			public void actionPerformed(ActionEvent event) 
			{
				try {
					ReadingFromAFile read = new ReadingFromAFile(MainWindow.this, controller);
				} catch (ParserConfigurationException | SAXException | IOException e) {
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
					try {
						WriteToFile write = new WriteToFile(controller);
					} catch (ParserConfigurationException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				} catch (TransformerException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}						
			}
		}
	);
		
		menuAdd.addActionListener(new ActionListener() 
		{
			public void actionPerformed(ActionEvent event) 
			{
				AddDialog dialog = new AddDialog(MainWindow.this, controller);
				dialog.show();
				dialog.setInfo();
			}
		}
	);
		
		menuDelete.addActionListener(new ActionListener() 
		{
			public void actionPerformed(ActionEvent event) 
			{
				DeleteDialog dialog = new DeleteDialog(MainWindow.this, controller);
				
				dialog.show();
				dialog.delStud();
			}
		}
	);
		
		menuSearch.addActionListener(new ActionListener() 
		{
			public void actionPerformed(ActionEvent event) 
			{
				SearchMainDialog dialog = new SearchMainDialog(controller);
				
				dialog.show();
				dialog.searchStud();
			}
		}
	);
		
		menuImport.addActionListener(new ActionListener() 
		{
			public void actionPerformed(ActionEvent event) 
			{
				try {
					ReadingFromAFile read = new ReadingFromAFile(MainWindow.this, controller);
				} catch (ParserConfigurationException | SAXException | IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
	);
		
		menuSave.addActionListener(new ActionListener() 
		{
			public void actionPerformed(ActionEvent event) 
			{
				try {
					try {
						WriteToFile write = new WriteToFile(controller);
					} catch (ParserConfigurationException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				} catch (TransformerException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}						
			}
		}
	);
	}
	
	
	public void update()
	{
		table.update();
	}
	
	public void show()
	{
		frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		frame.setVisible(true);
	}


}
