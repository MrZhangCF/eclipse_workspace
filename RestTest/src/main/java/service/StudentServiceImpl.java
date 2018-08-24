package service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.stereotype.Service;

import dao.StudentDAO;
import model.Student;

@Service
public class StudentServiceImpl implements StudentService {

	private StudentDAO studentDAO;

	public void setStudentDAO(StudentDAO studentDAO) {
		this.studentDAO = studentDAO;
	}

	@Override
	@Transactional
	public void addStudent(Student p) {
		this.studentDAO.addStudent(p);
	}

	@Override
	@Transactional
	public void updateStudent(Student p) {
		this.studentDAO.updateStudent(p);
	}

	@Override
	@Transactional
	public List<Student> listStudent() {
		return this.studentDAO.listStudent();
	}

	@Override
	@Transactional
	public Student getStudentById(int id) {
		return this.studentDAO.getStudentById(id);
	}

	@Override
	@Transactional
	public void removeStudent(int id) {
		this.studentDAO.removeStudent(id);
	}

}
