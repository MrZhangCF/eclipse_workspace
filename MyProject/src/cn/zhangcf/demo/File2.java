package cn.zhangcf.demo;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;

class MyMath{
	
	//实现四舍五入的功能。
	public static double round(double num, int scale){
		return Math.round(num * Math.pow(10, scale)) / Math.pow(10, scale);
	}
}

public class File2 {
	public static void main(String[] args) {
		File file = new File("D:" + File.separator + "my.jpg");
		if (file.exists() && file.isFile()) {
			//获取文件大小
			double size = file.length() / (double) 1024 / (double) 1024;
			if (size > 1.0) {
				System.out.println("文件大小: " + MyMath.round(size, 2) + " M");
			}else{
				System.out.println("文件大小: " + MyMath.round(size * 1024, 2) + " K");
			}
			
			//获取最后一次修改日期
			System.out.println("最后一次修改日期： " + new SimpleDateFormat("yyyy-MM-dd HH:mm:ss")
					.format(new Date(file.lastModified())));
		} else {
			System.out.println("文件不存在！");
		}
		
		//以下是对文件的操作，下面对目录进行操作
		//示例：列出目录中的所有文件
		File dir = new File("D:" + File.separator);
		if(dir.exists() && dir.isDirectory()){
			File result[] = dir.listFiles();
			for(int x = 0; x< result.length; x++){
				System.out.println(result[x].getName());
			}
		}
	}
}
