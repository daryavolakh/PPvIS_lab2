import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.util.*;

/*public class MainClass {
	public static void main(String args[]) {
		MainWindow frame = new MainWindow();
	}

}*/

public class MainClass {
	public static void main(String args[])
	{
		Controller controller = new Controller();
		controller.execute();
	}	
}

class Student {
	String name = "Piu";
	public String getName()
	{
		return name;
	}	
}

class Model {
	public Student getStudent() {
		return new Student();
	}
} 

class View {
	public void ShowStudent(Student student) 
	{
		System.out.println("Student: " + student.getName());
	}
}

class Controller {
	Model model = new Model();
	View view = new View();
	void execute() {
		Student student = model.getStudent();
		view.ShowStudent(student);
	}
}