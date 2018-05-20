package controller;

import java.util.List;

import model.Student;
import model.StudentDataBase;

public class Controller {
	public StudentDataBase stdb = new StudentDataBase();

	public List<Student> getStudents() {
		return stdb.getStudents();
	}

	public Student getOneStudent(int index) {
		return stdb.getOneStudent(index);
	}

	public void addStudent(Student student) {
		stdb.addStudent(student);
	}

	public void deleteStudent(Student student) {
		stdb.deleteStudent(student);
	}
}
