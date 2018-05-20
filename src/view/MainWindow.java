package view;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JToolBar;
import javax.swing.SwingConstants;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.TransformerException;

import org.xml.sax.SAXException;

import controller.Controller;
import model.Student;

public class MainWindow {
	public JFrame frame = new JFrame();
	public Controller controller = new Controller();
	public TableComponent table = new TableComponent(controller, controller.getStudents());
	public JPanel mainPanel = new JPanel();

	public MainWindow() {
		frame.setTitle("Lab 2");
		frame.setSize(700, 670);
		frame.setLayout(null);
		frame.setLocationByPlatform(true);

		
		JButton buttImport = new JButton("import");
		JButton buttSave = new JButton("save");
		JButton buttAdd = new JButton("add");
		JButton buttSearch = new JButton("search");
		JButton buttDelete = new JButton("delete");
		JToolBar toolbar = new JToolBar("toolbar");
		JMenuBar menuBar = new JMenuBar();
		JMenu menu = new JMenu("MENU");
		JMenuItem menuAdd = new JMenuItem("add");
		JMenuItem menuDelete = new JMenuItem("delete");
		JMenuItem menuSearch = new JMenuItem("search");
		JMenuItem menuImport = new JMenuItem("import");
		JMenuItem menuSave = new JMenuItem("save");
		Font font = new Font("Verdana", Font.PLAIN, 11);		
		
		menuBar.add(menu);
		
		menu.setFont(font);
		menuAdd.setFont(font);
		menuDelete.setFont(font);
		menuSearch.setFont(font);
		menuImport.setFont(font);
		menuSave.setFont(font);

		toolbar.setFloatable(false);
		toolbar.setOrientation(SwingConstants.HORIZONTAL);
		toolbar.setOrientation(SwingConstants.CENTER);

		JButton toolbarImport = new JButton("import");
		JButton toolbarSave = new JButton("save");
		JButton toolbarAdd = new JButton("add");
		JButton toolbarSearch = new JButton("search");
		JButton toolbarDelete = new JButton("delete");

		menu.add(menuAdd);
		menu.add(menuDelete);
		menu.add(menuSearch);
		menu.add(menuImport);
		menu.add(menuSave);
		
		menu.addSeparator();
		
		toolbar.add(toolbarAdd);
		toolbar.add(toolbarSearch);
		toolbar.add(toolbarDelete);
		toolbar.add(toolbarImport);
		toolbar.add(toolbarSave);

		menu.setBounds(0, 0, 70, 20);
		buttAdd.setBounds(125, 50, 70, 20);
		buttSearch.setBounds(200, 50, 80, 20);
		buttDelete.setBounds(285, 50, 80, 20);
		buttImport.setBounds(370, 50, 80, 20);
		buttSave.setBounds(455, 50, 80, 20);
		toolbar.setBounds(460, 0, 224, 30);

		mainPanel.setBounds(40, 90, 600, 800);
		mainPanel.add(table);		
		
		frame.setJMenuBar(menuBar);
		
		frame.add(toolbar);
		frame.add(buttImport);
		frame.add(buttSave);
		frame.add(buttAdd);
		frame.add(buttSearch);
		frame.add(buttDelete);
		frame.add(mainPanel);

		buttAdd.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent event) {
				add();
			}
		});

		buttDelete.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent event) {
				delete();
			}
		});

		buttSearch.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent event) {
				search();
			}
		});

		buttImport.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent event) {
				imp();
			}
		});

		buttSave.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent event) {
				save();
			}
		});

		toolbarAdd.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent event) {
				add();
			}
		});

		toolbarDelete.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent event) {
				delete();
			}
		});

		toolbarSearch.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent event) {
				search();
			}
		});

		toolbarImport.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent event) {
				imp();
			}
		});

		toolbarSave.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent event) {
				save();
			}

		});
		
		menuAdd.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent event) {
				add();
			}
		});
		
		menuDelete.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent event) {
				delete();
			}
		});

		menuSearch.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent event) {
				search();
			}
		});

		menuImport.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent event) {
				imp();
			}
		});

		menuSave.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent event) {
				save();
			}
		});		
	}

	public void add() {
		AddDialog dialog = new AddDialog(MainWindow.this, controller);
		dialog.show();
		dialog.setInfo();
	}

	public void delete() {
		Selected selected = new Selected(MainWindow.this, controller, true);
		selected.searchStud();
		selected.show();
	}

	public void search() {
		Selected selected = new Selected(MainWindow.this, controller, false);
		selected.searchStud();
		selected.show();
	}

	public void imp() {
		try {
			ReadingFromAFile read = new ReadingFromAFile(MainWindow.this, controller);
		} catch (ParserConfigurationException | SAXException | IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void save() {
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

	public void update() {
		mainPanel.remove(table);
		frame.remove(mainPanel);
		JPanel newPanel = new JPanel();
		TableComponent newTable = new TableComponent(controller, controller.getStudents());
		newPanel.add(newTable);
		
		newPanel.setBounds(40, 90, 600, 800);
		frame.add(newPanel);
		newTable.update(controller.getStudents());
	}

	public void show() {
		frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		frame.setVisible(true);
	}
}
