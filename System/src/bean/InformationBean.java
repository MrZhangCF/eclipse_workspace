package bean;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import data.Information;
import utils.DBUtils;

public class InformationBean {
	
	public List<Information> findAll() throws Exception{
		
		String sql = "select * from userinformation";
		ResultSet rs = DBUtils.query(sql);
		
		List<Information> infos = new ArrayList<>();
		while(rs.next()){
			
			Information info = new Information();
			info.setId(rs.getInt("id"));
			info.setName(rs.getString("name"));
			info.setGender(rs.getInt("gender"));
			info.setUrladdress(rs.getString("urladdress"));
			info.setPhonenumber(rs.getString("phonenumber"));
			info.setNumber(rs.getInt("number"));
			
			infos.add(info);
		}
		DBUtils.closeConnect();
		return infos;
	}
}
