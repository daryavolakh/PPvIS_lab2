package view;
import java.awt.*;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerConfigurationException;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.TransformerFactoryConfigurationError;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

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
import java.io.FileOutputStream;
import java.io.IOException;
import model.Student;

public class WriteToFile {
	Controller controller = new Controller();
	
	public WriteToFile(Controller controller) throws ParserConfigurationException, TransformerException
	{
		this.controller = controller;
		
		JFileChooser fileSave = new JFileChooser();
		fileSave.setCurrentDirectory(new File("D:\\Java\\Lab2"));
		int ret = fileSave.showSaveDialog(null);                
		if (ret == JFileChooser.APPROVE_OPTION)
		{
			File file = fileSave.getSelectedFile();

			DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
			DocumentBuilder builder = factory.newDocumentBuilder();
			Document document = builder.newDocument();
			
			Element mainRoot = document.createElement("students");
			//document.appendChild(mainRoot);
			for (int index = 0; index < controller.getStudents().size(); index ++)
			{

				Element rootElem = document.createElement("student");
				mainRoot.appendChild(rootElem);
				
				System.out.println("WRITE");
				Student student =  controller.getOneStudent(index);
				
				Element nameTitle = document.createElement("name");
				nameTitle.appendChild(document.createTextNode(student.name));
				
				rootElem.appendChild(nameTitle);
				
				Element adressTitle = document.createElement("adress");
				adressTitle.appendChild(document.createTextNode(student.adress));
				
				rootElem.appendChild(adressTitle);
				
				Element famMemTitle = document.createElement("familyMembers");
				String tempFamMem = "" + student.familyMembers;
				famMemTitle.appendChild(document.createTextNode(tempFamMem));
				
				rootElem.appendChild(famMemTitle);
				
				Element areaTitle = document.createElement("area");
				String tempArea = "" + student.area;
				areaTitle.appendChild(document.createTextNode(tempArea));
				
				rootElem.appendChild(areaTitle);
				
				Element areaPerPersonTitle = document.createElement("areaPerPerson");
				String tempAreaPer = "" + student.areaPerPerson;
				areaPerPersonTitle.appendChild(document.createTextNode(tempAreaPer));
				
				rootElem.appendChild(areaPerPersonTitle);
			}
			
			document.appendChild(mainRoot);
			document.getDocumentElement().normalize();
			
			TransformerFactory transFact = TransformerFactory.newInstance();
			Transformer transformer = transFact.newTransformer();
			DOMSource source = new DOMSource(document);
			StreamResult result = new StreamResult(file);
			transformer.transform(source, result);}
	}
	
	/*public WriteToFile(Controller controller) throws FileNotFoundException
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
	}*/
	
}
