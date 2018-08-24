package dao;

import java.util.List;

import model.Course;

public interface CourseDao {
	Integer deleteByPrimaryKey(Integer id);
	Integer insert(Course record);
	Integer insertSelective(Course record);
	Course selectByPrimaryKey(Integer id);
	Integer updateByPrimaryKeySelective(Course record);
	Integer updateByPrimary(Course record);
	List<Course> getAllCourse();
}
