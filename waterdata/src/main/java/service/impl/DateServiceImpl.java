package service.impl;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import mapper.Mapper;
import pojo.All;
import pojo.Hmd;
import pojo.Pcp;
import pojo.Slr;
import pojo.Temp;
import pojo.Wnd;
import service.DataService;

@Service
public class DateServiceImpl implements DataService{

	@Autowired
	Mapper mapper;
	
	public List<Hmd> getHmdByDate(Date date, String tablename) {
		
		return mapper.getHmd(tablename);
	}

	public List<Pcp> getPcpByDate(Date date, String tablename) {
		
		return mapper.getPcp(tablename);
	}

	public List<Slr> getSlrByDate(Date date, String tablename) {
		
		return mapper.getSlr(tablename);
	}

	public List<Temp> getTempByDate(Date date, String tablename) {
		
		return mapper.getTemp(tablename);
	}

	public List<Wnd> getWndByDate(Date date, String tablename) {
		
		return mapper.getWnd(tablename);
	}

	public List<All> getAll(String num) {
		List<All> all = mapper.getAll(num);
		
		return all;
	}
	
//	public static void main(String[] args) {
//		new DateServiceImpl().getAll("57216");
//	}
}
