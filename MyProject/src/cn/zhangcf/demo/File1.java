package cn.zhangcf.demo;

import java.io.File;
import java.io.IOException;

public class File1 {
	public static void main(String[] args) {
		
		//�ļ��Ĵ�����ɾ�������Ƕ�ͬ���ļ����д���ʱ��������ļ���ɾ���ʹ��������ӳ٣�����ͨ��Thread.sleep()���ơ�
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
