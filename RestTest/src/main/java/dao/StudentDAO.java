package dao;

import java.util.List;

import model.Student;

public interface StudentDAO {
	public void addStudent(Student p);

	public void updateStudent(Student p);

	public List<Student> listStudent();

	public Student getStudentById(int id);

	public void removeStudent(int id);
}
