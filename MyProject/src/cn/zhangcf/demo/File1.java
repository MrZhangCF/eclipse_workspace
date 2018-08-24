package cn.zhangcf.demo;

import java.io.File;
import java.io.IOException;

public class File1 {
	public static void main(String[] args) {
		
		//文件的创建和删除，但是对同名文件进行处理时，会出现文件的删除和创建出现延迟，可以通过Thread.sleep()改善。
		File file = new File("d:" + File.separator + "hello.txt");
		if(file.exists()){
			file.delete();
		}else{
			try {
				file.createNewFile();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
}
