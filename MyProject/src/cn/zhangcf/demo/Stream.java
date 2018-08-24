package cn.zhangcf.demo;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;

//字符流和字节流的使用方法：
//1.根据文件的路径创建File对象
//2.根据字节流或字符流的子类实例化父类对象
//3.进行数据的读取、写入操作
//4.关闭流！(close())

public class Stream {
	public static void main(String[] args) throws IOException {
		//实现文件的内容输出
		File file = new File("d:" + File.separator + "hello.txt");
		if(!file.getParentFile().exists()){
			file.getParentFile().mkdirs();
		}
		
		//表示进行文件的内容输出，但是在重复执行之后，内容会被覆盖，而不是追加！
		OutputStream output = new FileOutputStream(file);
		
		String msg = "张春风真帅！";
		//文件输出的时候系统会自动进行文件创建，所有不用使用creatNewFile()方法。
		output.write(msg.getBytes());
		output.close();
		
		//此构造方法中追加true，表示可以内容的追加。
		OutputStream output1 = new FileOutputStream("d:" + File.separator + "zhangcf.txt", true);
		String msg2 = "\r\n您说的真对！";
		output1.write(msg.getBytes());
		output1.write(msg2.getBytes());
		
		output1.close();
	}
}
