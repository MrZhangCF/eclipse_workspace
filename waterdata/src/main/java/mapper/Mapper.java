package mapper;

import java.util.List;

import pojo.All;
import pojo.Hmd;
import pojo.Pcp;
import pojo.Slr;
import pojo.Temp;
import pojo.Wnd;

public interface Mapper {
	
	List<All> getAll(String num);
	List<Hmd> getHmd(String num);
	List<Pcp> getPcp(String num);
	List<Slr> getSlr(String num);
	List<Temp> getTemp(String num);
	List<Wnd> getWnd(String num);
	
}
