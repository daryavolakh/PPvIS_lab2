package controller;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.util.*;
import java.util.Vector;
import javax.swing.table.DefaultTableModel;

import model.*;
import view.*;

public class Controller {
	public StudentDataBase stdb = new StudentDataBase();
	
	public ArrayList getStudents() 
	{
		return stdb.getStudents();
	}
	
	public Student getOneStudent(int index) 
	{
		return stdb.getOneStudent(index);
	}
	
	public void setStudent(Student student)    
	{
		stdb.setStudent(student);
	}
	
	public void deleteStudent(Student student)
	{
		System.out.println("controller + delete " + student);
		stdb.deleteStudent(student);
	}
}
