package cn.zhangcf.demo;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;

public class Stream3 {
	public static void main(String[] args) throws IOException {
		File file = new File("d:" + File.separator + "shuai.txt");
		if(!file.getParentFile().exists()){
			file.getParentFile().mkdirs();
		}
		String msg = "世界和平！";
		Writer out = new FileWriter(file);
		out.write(msg);
		out.close();
	}
}
