package controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import pojo.All;
import pojo.Hmd;
import pojo.Pcp;
import pojo.Slr;
import pojo.Temp;
import pojo.Wnd;
import service.DataService;

@Controller
public class CheckController {
	
	@Autowired
	private DataService dataService;
	
	@RequestMapping(value="/all/{num}",method=RequestMethod.GET)
	public ModelAndView getAll(@PathVariable Integer num){
		List<All> all = dataService.getAll(num.toString());
		ModelAndView modelAndView = new ModelAndView("all");
		modelAndView.addObject("all",all);
		
		return modelAndView;
	}
	
	@RequestMapping(value="/hmd/{num}",method=RequestMethod.GET)
	public ModelAndView getHmd(@PathVariable Integer num){
		List<Hmd> hmds = dataService.getHmdByDate(null, num.toString());
		ModelAndView modelAndView = new ModelAndView("hmd");
		modelAndView.addObject("hmds",hmds);
		
		return modelAndView;
	}
	
	@RequestMapping(value="/pcp/{num}",method=RequestMethod.GET)
	public ModelAndView getPcp(@PathVariable Integer num){
		List<Pcp> pcps = dataService.getPcpByDate(null, num.toString());
		ModelAndView modelAndView = new ModelAndView("pcp");
		modelAndView.addObject("pcps",pcps);
		
		return modelAndView;
	}
	
	@RequestMapping(value="/slr/{num}",method=RequestMethod.GET)
	public ModelAndView getSlr(@PathVariable Integer num){
		List<Slr> slrs = dataService.getSlrByDate(null, num.toString());
		ModelAndView modelAndView = new ModelAndView("slr");
		modelAndView.addObject("slrs",slrs);
		
		return modelAndView;
	}
	
	@RequestMapping(value="/temp/{num}",method=RequestMethod.GET)
	public ModelAndView getTemp(@PathVariable Integer num){
		List<Temp> temps = dataService.getTempByDate(null, num.toString());
		ModelAndView modelAndView = new ModelAndView("temp");
		modelAndView.addObject("temps",temps);
		
		return modelAndView;
	}
	
	@RequestMapping(value="/wnd/{num}",method=RequestMethod.GET)
	public ModelAndView getWnd(@PathVariable Integer num){
		List<Wnd> wnds = dataService.getWndByDate(null, num.toString());
		ModelAndView modelAndView = new ModelAndView("wnd");
		modelAndView.addObject("wnds",wnds);
		
		return modelAndView;
	}
}