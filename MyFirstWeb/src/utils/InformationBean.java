package utils;

import java.util.ArrayList;
import java.util.List;

import DB.InformationDB;
import demo.Information;

public class InformationBean {
	public List<Information> findAllInformation(){
		
		try {
			InformationDB infoDB = new InformationDB();
			return infoDB.findAll();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return new ArrayList<Information>();
	}
}
