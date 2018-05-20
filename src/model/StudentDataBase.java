package model;

import java.util.ArrayList;
import java.util.List;

public class StudentDataBase {

	public List<Student> allStudents = new ArrayList<Student>();

	public List<Student> getStudents() {
		return allStudents;
	}

	public Student getOneStudent(int index) {
		return allStudents.get(index);
	}

	public void addStudent(Student student) {
		allStudents.add(student);
	}

	public void deleteStudent(Student student) {
		allStudents.remove(student);
	}
}
