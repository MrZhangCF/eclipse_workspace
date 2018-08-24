package model;

import java.util.HashSet;
import java.util.Set;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;

public class HibernateMain {
	public static void main(String[] args) {
		// ��׼����ע�������������������ļ�
		StandardServiceRegistry registry = null;
		// ��ȡsessionFactory����
		SessionFactory sessionFactory = null;
		try {
			registry = new StandardServiceRegistryBuilder().configure("hibernate.cfg.xml").build();
			// ����ע����Ϣ�����Ự��������
			sessionFactory = new MetadataSources(registry).buildMetadata().buildSessionFactory();
		} catch (Exception e) {
			e.printStackTrace();
			// һ��ע��ʧ�ܣ���ٵ�ע��ʧ�ܵ�ע����
			StandardServiceRegistryBuilder.destroy(registry);
		}
		// ����session,����student�������һ������
		Session session = sessionFactory.openSession();

		Transaction tx = session.beginTransaction();

		Student student1 = new Student();
		student1.setName("Tom");
		Student student2 = new Student();
		student2.setName("Jack");

		Course course1 = new Course();
		course1.setName("Math");
		Course course2 = new Course();
		course2.setName("Music");

		Set<Course> courses = new HashSet<>();
		courses.add(course1);
		courses.add(course2);

		student1.setCourses(courses);

		Set<Course> courses2 = new HashSet<>();
		courses2.add(course1);

		student2.setCourses(courses2);

//		Set<Student> students = new HashSet<>();
//		students.add(student1);
//		students.add(student1);
//
//		course1.setStudents(students);
//
//		Set<Student> students2 = new HashSet<>();
//		students2.add(student1);
//
//		course2.setStudents(students2);
		
		session.save(student1);
		session.save(student2);

		//session.save(course1);
		//session.save(course2);
		
		session.flush();
		tx.commit();
		
		session.close();
		sessionFactory.close();
	}
}
