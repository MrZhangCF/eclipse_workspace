package cn.zhangcf.demo;

import java.io.File;

//�г�ָ��Ŀ¼�������ļ���������Ŀ¼�е����ݣ�ʹ�õݹ�ʵ�֡�
public class File3 {
	public static void main(String[] args) {
		new Thread(()->{
			File file = new File("d:" + File.separator + "Ѹ������" + File.separator + "���غϼ�");
			listFile(file);
		}).start();
		System.out.println("��ʼ���Ŀ¼��Ϣ.....................");
	}

	/**
	 * �г�ָ��Ŀ¼�µ�������Ŀ¼��Ϣ
	 * @param file
	 */
	public static void listFile(File file) {
		if (file.exists() && file.isDirectory()) {
			File result[] = file.listFiles();
			if (result != null) {
				for (int x = 0; x < result.length; x++) {
					listFile(result[x]);
				}
			}
		}
		System.out.println(file);
	}
}
