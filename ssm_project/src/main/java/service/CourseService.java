package service;

import java.util.List;

import model.Course;

public interface CourseService {
	/**
	 * 添加课程
	 * @param course
	 * @return
	 */
	Integer insert(Course course);
	/**
	 * 使用主键删除课程
	 * @param id
	 * @return
	 */
	Integer deleteByPrimaryKey(Integer id);
	/**
	 * 根据课程号查看课程详情
	 * @param id
	 * @return
	 */
	Course selectByPrimaryKey(Integer id);
	/**
	 * 查看所有课程
	 * @return
	 */
	List<Course> getAllCourse();
}
