package view;
import java.awt.*;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import org.w3c.dom.Document;
import org.w3c.dom.NodeList;
import org.w3c.dom.Node;
import org.w3c.dom.Element;
import org.xml.sax.SAXException;
import java.awt.event.*;
import javax.swing.*;
import controller.*;
import java.util.*;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;

import model.*;

public class ReadingFromAFile {
	MainWindow mainWindow = new MainWindow();
	Controller controller = new Controller();
	
	public ReadingFromAFile(MainWindow mainWindow, Controller controller) throws ParserConfigurationException, SAXException, IOException
	{
		this.mainWindow = mainWindow;
		this.controller= controller;
		JFileChooser fileopen = new JFileChooser();
		fileopen.setCurrentDirectory(new File("D:\\Java\\Lab2"));
		int ret = fileopen.showDialog(null, "Открыть файл");                
		if (ret == JFileChooser.APPROVE_OPTION)
		{
			File file = fileopen.getSelectedFile();//new File("fileForReading.xml");
			DocumentBuilderFactory factory = DocumentBuilderFactory.newDefaultInstance();
			DocumentBuilder builder = factory.newDocumentBuilder();
			Document document = builder.parse(file);
			
			document.getDocumentElement().normalize();
	
			NodeList studNodeList = document.getElementsByTagName("student");
			
			for (int index = 0; index < studNodeList.getLength(); index++)
			{
				Student student = new Student();
				Node node = studNodeList.item(index);
				if (Node.ELEMENT_NODE == studNodeList.item(index).getNodeType())
				{
					Element element = (Element) studNodeList.item(index);
					
					student.setName(element.getElementsByTagName("name").item(0).getTextContent());
					student.setAdress(element.getElementsByTagName("adress").item(0).getTextContent());
					student.setFamilyMembers(Integer.valueOf(element.getElementsByTagName("familyMembers").item(0).getTextContent()));
					student.setArea(Integer.valueOf(element.getElementsByTagName("area").item(0).getTextContent()));
					student.setAreaPerPerson(Integer.valueOf(element.getElementsByTagName("areaPerPerson").item(0).getTextContent()));
				
					controller.setStudent(student);
				}				
			}
			mainWindow.update();
		}
	}
}
