package model;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.util.*;
import java.util.Vector;
import javax.swing.table.DefaultTableModel;

public class Student {
	String name ;
	String adress;
	int familyMembers;
	int area;
	int areaPerPerson;
	public String getName()
	{
		return name;
	}
	
	public String setName(String newName)
	{
		name = newName;
		return name;
	}
	
	public String getAdress()
	{
		return adress;
	}
	
	public String setAdress(String newAdress)
	{
		adress = newAdress;
		return adress;
	}
	
	public int getFamilyMembers()
	{
		return familyMembers;
	}
	
	public int setFamilyMembers(int newFamilyMembers)
	{
		familyMembers = newFamilyMembers;
		return familyMembers;
	}
}
