package action;

import java.io.File;
import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Iterator;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

import utils.DBUtils;

public class PicturePostAndMsgGet extends HttpServlet {

	private static final long serialVersionUID = 1L;

	
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
	}



	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		String temp = "D:\\Server\\upload\\temp";
		String loadpath = "D:\\Server\\upload";
		
		DiskFileItemFactory factory = new DiskFileItemFactory();
		factory.setSizeThreshold(8192);
		factory.setRepository(new File(temp));
		
		ServletFileUpload upload = new ServletFileUpload(factory);
		upload.setFileSizeMax(10* 1024 * 1024);
		
		try {
			List<?> list = upload.parseRequest(req);
			Iterator<?> iter = list.iterator();
			while(iter.hasNext()){
				FileItem item = (FileItem) iter.next();//忽略其他不是文件域的所有表单信息
				if(!item.isFormField()){
					String fullName = item.getName();  //连带目录的文件名
					String name = fullName.substring(fullName.lastIndexOf("\\") + 1); //从全路径中剥离出文件名
					long size = item.getSize();
					if(name == null || name.equals("") && size == 0){
						continue;
					}
					int point = name.indexOf(".");
					String[] infomation = name.split("+");
					String sql = "select * from userinformation where name='" + infomation[0] + "' and phonenumber='" + infomation[2] + "'";
					ResultSet rs = DBUtils.query(sql);
					
					int rows = 0;
					boolean flag = rs.last();
					
					if(!flag){
						rows = 1;				
					}else{
						rows = rs.getRow();
						System.out.println();
						rows += 1;
					}
					String newName = name.substring(0, point) + "(" + rows + ")" + name.substring(point, name.length());
					
					DBUtils.closeConnect();
					
					String urladdress = infomation[0] + "+" + infomation[2];
					int number = rows;
					String insertSql = "insert into userinformation (name,gender,urladdress,phonenumber,number) values('" + infomation[0] +"','" + infomation[1] + "','" + urladdress + "','" + infomation[2] +"','" + number + "');";
					int lines = DBUtils.insert(insertSql);
					if(lines == -1){
						System.out.println("插入数据失败");
					}
					
					File file = new File(loadpath, newName);
					
					item.write(file);
					
					DBUtils.closeConnect();
				}
			}
		} catch (FileUploadException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}
}
