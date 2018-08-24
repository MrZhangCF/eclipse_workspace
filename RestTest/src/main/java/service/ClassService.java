package service;

import java.util.List;

import model.ClassTaken;
import model.Student;

public interface ClassService {
	public List<ClassTaken> getClassByStudentId();
	public Student getStudentById(int id);
	public void removeStudent(int id);
}
