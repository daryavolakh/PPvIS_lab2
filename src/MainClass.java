

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

import controller.*;

import java.util.*;

import model.*;
import view.*;

public class MainClass {
	public static void main(String args[])
	{
		StudentDataBase model = new StudentDataBase();
		MainWindow view = new MainWindow();
		Controller controller = new Controller();
		view.Show();
		//controller.execute();
		//mainWindow.show()
	}	
}
