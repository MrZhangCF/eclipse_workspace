package service;

import java.util.List;

import model.Student;

public interface StudentService {
	public void addStudent(Student p);
	public void updateStudent(Student p);
	public List<Student> listStudent();
	public Student getStudentById(int id);
	public void removeStudent(int id);
}
