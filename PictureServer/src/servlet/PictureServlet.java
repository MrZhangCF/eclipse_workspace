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
@WebServlet(description = "����ͼƬ�Ľ��պ�ͼƬ������Ϣ�Ļش�", urlPatterns = { "/PictureServlet" })
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
		
		
		String temp = request.getSession().getServletContext().getRealPath("/") + "temp";// ��ʱĿ¼

		System.out.println("temp=" + temp);

		String loadpath = request.getSession().getServletContext().getRealPath("/") + "Image";// �ϴ��ļ����Ŀ¼

		System.out.println("loadpath=" + loadpath);

		DiskFileUpload fu = new DiskFileUpload();

		fu.setSizeMax(10 * 1024 * 1024);// ���������û��ϴ��ļ���С,��λ:�ֽ�

		fu.setSizeThreshold(8192);// �������ֻ�������ڴ��д洢������,��λ:�ֽ�

		fu.setRepositoryPath(temp);// ����һ���ļ���С����getSizeThreshold()��ֵʱ���ݴ����Ӳ�̵�Ŀ¼

		// ��ʼ��ȡ�ϴ���Ϣ

		int index = 0;

		List<?> fileItems = null;

		try {

			fileItems = fu.parseRequest(request);

			System.out.println("fileItems=" + fileItems);

		} catch (Exception e) {

			e.printStackTrace();

		}

		Iterator<?> iter = fileItems.iterator();// ���δ���ÿ���ϴ����ļ�

		while (iter.hasNext())

		{

			FileItem item = (FileItem) iter.next();// �������������ļ�������б���Ϣ

			if (!item.isFormField())

			{

				String name = item.getName();// ��ȡ�ϴ��ļ���,����·��

				name = name.substring(name.lastIndexOf("\\") + 1);// ��ȫ·������ȡ�ļ���

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

			}else// ȡ�������ļ�������б���Ϣ
			{

				String fieldvalue = item.getString();

				// �����������ӦдΪ��(תΪUTF-8����)

				// String fieldvalue = new
				// String(item.getString().getBytes(),"UTF-8");

			}

		}

		String text1 = "������˧��";

		response.setContentType("text/html;charset=utf-8");
		response.getWriter().append(text1);
		//response.sendRedirect("result.jsp?text1=" + text1);

	}

}
