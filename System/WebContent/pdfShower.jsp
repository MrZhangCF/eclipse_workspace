<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="java.util.*,java.io.*"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>PDF</title>
</head>
<body>
	<%
		out.clear();
		out = pageContext.pushBody();
		response.setContentType("application/pdf");

		try {
			String pdfPath = "D:" + File.separator + "Server" + File.separator + "upload" + File.separator
					+ "testpdf.pdf";
			File file = new File(pdfPath);
			if (file.exists()) {
				DataOutputStream temp = new DataOutputStream(response.getOutputStream());
				DataInputStream in = new DataInputStream(new FileInputStream(pdfPath));
				byte[] b = new byte[2048];
				while ((in.read(b)) != -1) {
					temp.write(b);
					temp.flush();
				}

				in.close();
				temp.close();
			} else {
				out.print(pdfPath + " 文件不存在");
			}
		} catch (Exception e) {
			out.print(e.getMessage());
		}
	%>
</body>
</html>