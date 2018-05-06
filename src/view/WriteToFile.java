package view;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.util.*;
import java.util.Scanner;
import java.io.File;
import java.io.PrintWriter;
import java.io.FileNotFoundException;
import model.*;
import controller.*;

public class WriteToFile {
	Controller controller = new Controller();
	
	public WriteToFile(Controller controller) throws FileNotFoundException
	{
		this.controller = controller;
		File file = new File("writeStudents.txt");
		PrintWriter printWr = new PrintWriter(file);
		Student student;
		for (int index = 0; index < controller.getStudents().size(); index++)
		{
			student = controller.getOneStudent(index);
			printWr.println(student.name + " " + student.adress + " " + student.familyMembers + " " + student.area + " " + student.areaPerPerson);
		}		
		
		printWr.close();
	}
	
}
