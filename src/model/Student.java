package model;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.util.*;
import java.util.Vector;
import javax.swing.table.DefaultTableModel;

public class Student {
	public String name ;
	public String adress;
	public int familyMembers;
	public int area;
	public int areaPerPerson;
	
	public String getName()
	{
		return name;
	}
	
	public void setName(String name)
	{
		this.name = name;
	}
	
	public String getAdress()
	{
		return adress;
	}
	
	public void setAdress(String adress)
	{
		this.adress = adress;
	}
	
	public int getFamilyMembers()
	{
		return familyMembers;
	}
	
	public void setFamilyMembers(int familyMembers)
	{
		this.familyMembers = familyMembers;
	}
	
	public int getArea()
	{
		return area;
	}
	
	public void setArea(int area)
	{
		this.area = area;
	}
	
	public int getAreaPerPerson()
	{
		return areaPerPerson;
	}
	
	public void setAreaPerPerson(int areaPerPerson)
	{
		this.areaPerPerson = areaPerPerson;
	}
}
