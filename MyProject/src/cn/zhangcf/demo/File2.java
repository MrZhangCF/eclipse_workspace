package cn.zhangcf.demo;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;

class MyMath{
	
	//ʵ����������Ĺ��ܡ�
	public static double round(double num, int scale){
		return Math.round(num * Math.pow(10, scale)) / Math.pow(10, scale);
	}
}

public class File2 {
	public static void main(String[] args) {
		File file = new File("D:" + File.separator + "my.jpg");
		if (file.exists() && file.isFile()) {
			//��ȡ�ļ���С
			double size = file.length() / (double) 1024 / (double) 1024;
			if (size > 1.0) {
				System.out.println("�ļ���С: " + MyMath.round(size, 2) + " M");
			}else{
				System.out.println("�ļ���С: " + MyMath.round(size * 1024, 2) + " K");
			}
			
			//��ȡ���һ���޸�����
			System.out.println("���һ���޸����ڣ� " + new SimpleDateFormat("yyyy-MM-dd HH:mm:ss")
					.format(new Date(file.lastModified())));
		} else {
			System.out.println("�ļ������ڣ�");
		}
		
		//�����Ƕ��ļ��Ĳ����������Ŀ¼���в���
		//ʾ�����г�Ŀ¼�е������ļ�
		File dir = new File("D:" + File.separator);
		if(dir.exists() && dir.isDirectory()){
			File result[] = dir.listFiles();
			for(int x = 0; x< result.length; x++){
				System.out.println(result[x].getName());
			}
		}
	}
}
