package cn.zhangcf.demo;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;

public class Stream2 {
	public static void main(String[] args) throws IOException {
		File file = new File("d:" + File.separator + "hello.txt");
		if(file.exists()){
			
			//把文件内容读入内存
			InputStream input = new FileInputStream(file);
			byte data[] = new byte[1024];
			int len = input.read(data);
			System.out.println("读取内容为【"+ new String(data, 0, len) +"】");
			input.close();
		}
	}
}
