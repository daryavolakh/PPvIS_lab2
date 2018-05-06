package model;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.util.*;
import java.util.ArrayList;

import javax.swing.table.DefaultTableModel;

public class StudentDataBase {
	
	public ArrayList<Student> AllStudents = new ArrayList<Student>();
	public ArrayList getStudents() 
	{
		return AllStudents;
	}
	
	public Student getOneStudent(int index) 
	{
		return AllStudents.get(index);
	}
	
	public void setStudent(Student student) 
	{
		AllStudents.add(student);
		//System.out.println(AllStudents);
	}
	
	public void deleteStudent(Student student)
	{
		System.out.println("I AM HERE ->" + student);
		
		AllStudents.remove(student);
		System.out.println(AllStudents);
	}
}
