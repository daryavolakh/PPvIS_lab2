package view;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import controller.*;
import java.util.*;
import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;
import model.*;

public class ReadingFromAFile {
	MainWindow mainWindow = new MainWindow();
	Controller controller = new Controller();
	public ReadingFromAFile(MainWindow mainWindow, Controller controller) throws FileNotFoundException
	{
		this.mainWindow = mainWindow;
		this.controller = controller;
		
		File file = new File("readStudents.txt"); 
		Scanner scanner = new Scanner(file);
		
		while (scanner.hasNextLine())
		{
			String line = scanner.nextLine();
			String[] info = line.split(" ");
			
			Student student = new Student();
			
			student.name = info[0];
			student.adress = info[1];
			student.familyMembers = Integer.parseInt(info[2]);
			student.area = Integer.parseInt(info[3]);
			student.areaPerPerson = Integer.parseInt(info[4]);
			
			controller.setStudent(student);
		}
		
		scanner.close();
		mainWindow.update();
	}

}
