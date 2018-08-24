package service;

import java.util.List;

import model.Course;

public interface CourseService {
	/**
	 * ��ӿγ�
	 * @param course
	 * @return
	 */
	Integer insert(Course course);
	/**
	 * ʹ������ɾ���γ�
	 * @param id
	 * @return
	 */
	Integer deleteByPrimaryKey(Integer id);
	/**
	 * ���ݿγ̺Ų鿴�γ�����
	 * @param id
	 * @return
	 */
	Course selectByPrimaryKey(Integer id);
	/**
	 * �鿴���пγ�
	 * @return
	 */
	List<Course> getAllCourse();
}
