package servlet;

import java.io.File;
import java.io.IOException;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.fileupload.DiskFileUpload;
import org.apache.commons.fileupload.FileItem;


/**
 * Servlet implementation class PictureServlet
 */
@WebServlet(description = "用于图片的接收和图片处理信息的回传", urlPatterns = { "/PictureServlet" })
public class PictureServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * Default constructor.
	 */
	public PictureServlet() {
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	// protected void doPost(HttpServletRequest request, HttpServletResponse
	// response)
	// throws ServletException, IOException {
	// // TODO Auto-generated method stub
	// doGet(request, response);
	// }

	@SuppressWarnings("deprecation")
	public void doPost(HttpServletRequest request, HttpServletResponse response)

			throws ServletException, IOException {
		
		
		String temp = request.getSession().getServletContext().getRealPath("/") + "temp";// 临时目录

		System.out.println("temp=" + temp);

		String loadpath = request.getSession().getServletContext().getRealPath("/") + "Image";// 上传文件存放目录

		System.out.println("loadpath=" + loadpath);

		DiskFileUpload fu = new DiskFileUpload();

		fu.setSizeMax(10 * 1024 * 1024);// 设置允许用户上传文件大小,单位:字节

		fu.setSizeThreshold(8192);// 设置最多只允许在内存中存储的数据,单位:字节

		fu.setRepositoryPath(temp);// 设置一旦文件大小超过getSizeThreshold()的值时数据存放在硬盘的目录

		// 开始读取上传信息

		int index = 0;

		List<?> fileItems = null;

		try {

			fileItems = fu.parseRequest(request);

			System.out.println("fileItems=" + fileItems);

		} catch (Exception e) {

			e.printStackTrace();

		}

		Iterator<?> iter = fileItems.iterator();// 依次处理每个上传的文件

		while (iter.hasNext())

		{

			FileItem item = (FileItem) iter.next();// 忽略其他不是文件域的所有表单信息

			if (!item.isFormField())

			{

				String name = item.getName();// 获取上传文件名,包括路径

				name = name.substring(name.lastIndexOf("\\") + 1);// 从全路径中提取文件名

				long size = item.getSize();

				if ((name == null || name.equals("")) && size == 0)

					continue;

				int point = name.indexOf(".");

				name = (new Date()).getTime() + index + name.substring(point, name.length()) ;

				index++;

				File fNew = new File(loadpath, name);

				try {

					item.write(fNew);

				} catch (Exception e) {

					// TODO Auto-generated catch block

					e.printStackTrace();

				}

			}else// 取出不是文件域的所有表单信息
			{

				String fieldvalue = item.getString();

				// 如果包含中文应写为：(转为UTF-8编码)

				// String fieldvalue = new
				// String(item.getString().getBytes(),"UTF-8");

			}

		}

		String text1 = "您可真帅！";

		response.setContentType("text/html;charset=utf-8");
		response.getWriter().append(text1);
		//response.sendRedirect("result.jsp?text1=" + text1);

	}

}
