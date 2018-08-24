package controller;

import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import model.Course;
import service.CourseService;

@Controller
@RequestMapping(value = "/course")
public class CourseController {
	@Resource
	private CourseService courseService;

	@RequestMapping(value = "/list")
	public ModelAndView getAllCourse(HttpServletRequest request, Model model) {
		ModelAndView modelAndView = new ModelAndView("course-list");
		List<Course> courses = courseService.getAllCourse();
		modelAndView.addObject("course", courses);
		return modelAndView;
	}

	@RequestMapping(value = "/detail")
	public ModelAndView getCourseDetail(HttpServletRequest request, Model model, Integer id) {
		ModelAndView modelAndView = new ModelAndView("course-detail");
		Course course = courseService.selectByPrimaryKey(id);
		modelAndView.addObject("course", course);
		return modelAndView;
	}

	@RequestMapping(value = "/add")
	public ModelAndView addCourse(HttpServletRequest request, Model model) {
		ModelAndView modelAndView = new ModelAndView("course-edit");
		return modelAndView;
	}

	@RequestMapping(value = "/save")
	public ModelAndView saveCourse(Course course) {
		ModelAndView modelAndView = new ModelAndView("course-list");
		courseService.insert(course);
		List<Course> courses = courseService.getAllCourse();
		modelAndView.addObject("courses", courses);
		return modelAndView;
	}

	@RequestMapping(value="/delete")
	public ModelAndView deleteCourse(Integer id){
		courseService.deleteByPrimaryKey(id);
		ModelAndView modelAndView = new ModelAndView("course-list");
		List<Course> courses = courseService.getAllCourse();
		modelAndView.addObject("courses", courses);
		return modelAndView;
	}
}
