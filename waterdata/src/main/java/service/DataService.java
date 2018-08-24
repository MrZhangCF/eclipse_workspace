package service;

import java.util.Date;
import java.util.List;

import pojo.All;
import pojo.Hmd;
import pojo.Pcp;
import pojo.Slr;
import pojo.Temp;
import pojo.Wnd;

public interface DataService {
	
	public List<All> getAll(String num);
	public List<Hmd> getHmdByDate(Date date, String tablename);
	public List<Pcp> getPcpByDate(Date date, String tablename);
	public List<Slr> getSlrByDate(Date date, String tablename);
	public List<Temp> getTempByDate(Date date, String tablename);
	public List<Wnd> getWndByDate(Date date, String tablename);
	
}
