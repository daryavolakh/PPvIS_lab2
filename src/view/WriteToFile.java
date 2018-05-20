package view;

import java.io.File;

import javax.swing.JFileChooser;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

import org.w3c.dom.Document;
import org.w3c.dom.Element;

import controller.Controller;
import model.Student;

public class WriteToFile {
	Controller controller = new Controller();

	public WriteToFile(Controller controller) throws ParserConfigurationException, TransformerException {
		this.controller = controller;

		JFileChooser fileSave = new JFileChooser();
		fileSave.setCurrentDirectory(new File("D:\\Java\\Lab2"));
		int ret = fileSave.showSaveDialog(null);
		if (ret == JFileChooser.APPROVE_OPTION) {
			File file = fileSave.getSelectedFile();

			DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
			DocumentBuilder builder = factory.newDocumentBuilder();
			Document document = builder.newDocument();

			Element mainRoot = document.createElement("students");
			
			for (int index = 0; index < controller.getStudents().size(); index++) {

				Element rootElem = document.createElement("student");
				mainRoot.appendChild(rootElem);

				System.out.println("WRITE");
				Student student = controller.getOneStudent(index);

				Element surnameTitle = document.createElement("surname");
				surnameTitle.appendChild(document.createTextNode(student.surname));

				rootElem.appendChild(surnameTitle);

				Element nameTitle = document.createElement("name");
				nameTitle.appendChild(document.createTextNode(student.name));

				rootElem.appendChild(nameTitle);

				Element townTitle = document.createElement("town");
				townTitle.appendChild(document.createTextNode(student.town));

				rootElem.appendChild(townTitle);
				
				Element streetTitle = document.createElement("street");
				streetTitle.appendChild(document.createTextNode(student.street));

				rootElem.appendChild(streetTitle);
				
				Element houseTitle = document.createElement("house");
				houseTitle.appendChild(document.createTextNode(student.house));

				rootElem.appendChild(houseTitle);

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
			transformer.transform(source, result);
		}
	}
}
