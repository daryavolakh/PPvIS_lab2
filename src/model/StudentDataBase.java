package model;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.util.*;
import java.util.Vector;
import javax.swing.table.DefaultTableModel;

public class StudentDataBase {
	
	public Vector<Vector> AllStudents = new Vector();
	
	public Vector getStudents() 
	{
		return AllStudents;
	}
	
	public void setStudent(Student student) 
	{
		Vector OneStudent = new Vector();
		
		OneStudent.add(student.name);
		System.out.println(OneStudent);
		OneStudent.add(student.adress);
		System.out.println(OneStudent);
		OneStudent.add(student.familyMembers);
		System.out.println(OneStudent);
		OneStudent.add(student.area);
		System.out.println(OneStudent);
		OneStudent.add(student.areaPerPerson);
		System.out.println(OneStudent);
		
		AllStudents.add(OneStudent);	
		System.out.println(AllStudents);
	}
}
