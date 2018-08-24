package cn.zhangcf.demo;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;

//�ַ������ֽ�����ʹ�÷�����
//1.�����ļ���·������File����
//2.�����ֽ������ַ���������ʵ�����������
//3.�������ݵĶ�ȡ��д�����
//4.�ر�����(close())

public class Stream {
	public static void main(String[] args) throws IOException {
		//ʵ���ļ����������
		File file = new File("d:" + File.separator + "hello.txt");
		if(!file.getParentFile().exists()){
			file.getParentFile().mkdirs();
		}
		
		//��ʾ�����ļ�������������������ظ�ִ��֮�����ݻᱻ���ǣ�������׷�ӣ�
		OutputStream output = new FileOutputStream(file);
		
		String msg = "�Ŵ�����˧��";
		//�ļ������ʱ��ϵͳ���Զ������ļ����������в���ʹ��creatNewFile()������
		output.write(msg.getBytes());
		output.close();
		
		//�˹��췽����׷��true����ʾ�������ݵ�׷�ӡ�
		OutputStream output1 = new FileOutputStream("d:" + File.separator + "zhangcf.txt", true);
		String msg2 = "\r\n��˵����ԣ�";
		output1.write(msg.getBytes());
		output1.write(msg2.getBytes());
		
		output1.close();
	}
}
