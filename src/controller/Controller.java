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
	
	public Vector getStudents() 
	{
		return stdb.getStudents();
	}
	
	public void setStudent(Student student)    //закинуть в StudentDatBase!!!!!!!!!
	{
		stdb.setStudent(student);
	}
	
	public void deleteStudent(Vector student)
	{
		System.out.println("NOT LOL " + student);
		stdb.deleteStudent(student);
	}
}
