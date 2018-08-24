package cn.zhangcf.demo;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;

public class Stream4 {
	public static void main(String[] args) throws IOException {
		File file = new File("d:" + File.separator + "io" + File.separator + "reader.txt");
		if (file.getParentFile().exists()) {
			file.getParentFile().mkdirs();
		}
		if (file.exists()) {
			//字符流适合处理中文
			Reader in = new FileReader(file);
			char data[] = new char[1024];
			int len = in.read(data);
			System.out.println(new String (data, 0, len));
		}
	}
}
