package dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;

import model.Student;

@Repository
public class StudentDAOImpl implements StudentDAO{
	
	private static final Logger logger = LoggerFactory.getLogger(StudentDAOImpl.class);
	private SessionFactory sessionFactory;
	
	public void setSessionFactory(SessionFactory sf){
		this.sessionFactory = sf;
	}
	
	@Override
	public void addStudent(Student p) {
		Session session = this.sessionFactory.getCurrentSession();
		session.persist(p);
		logger.info("Student saved successfully, Student Detial="+p);
	}

	@Override
	public void updateStudent(Student p) {
		Session session = this.sessionFactory.getCurrentSession();
		session.update(p);
		logger.info("Student Updated successfully, Student Detail="+p);
	}

	@Override
	public List<Student> listStudent() {
		Session session = this.sessionFactory.getCurrentSession();
		List<Student> studentList = session.createQuery("from Student").list();
		for(Student p:studentList){
			logger.info("Student List:"+p);
		}
		return studentList;
	}

	@Override
	public Student getStudentById(int id) {
		Session session = this.sessionFactory.getCurrentSession();
		logger.info("Student id in DAO:"+id);
		Student p = session.get(Student.class, id);
		logger.info("Student loaded successfully, Student details="+p);
		return p;
	}

	@Override
	public void removeStudent(int id) {
		Session session = this.sessionFactory.getCurrentSession();
		Student p = session.load(Student.class, id);
		if(null != p){
			session.delete(p);
		}
		logger.info("Student deleted successfully, student details="+p);
	}

}
