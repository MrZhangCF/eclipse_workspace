package service;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import dao.CourseDao;
import model.Course;

@Service
public class CourseServiceImpl implements CourseService{

	@Resource
	private CourseDao courseDao;
	
	@Override
	public Integer insert(Course course) {
		return courseDao.insert(course);
	}

	@Override
	public Integer deleteByPrimaryKey(Integer id) {
		return courseDao.deleteByPrimaryKey(id);
	}

	@Override
	public Course selectByPrimaryKey(Integer id) {
		return courseDao.selectByPrimaryKey(id);
	}

	@Override
	public List<Course> getAllCourse() {
		return courseDao.getAllCourse();
	}
	

}
