package cn.zhangcf.demo;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;

class MyClassLoader extends ClassLoader {
	/**
	 * ʵ��һ���Զ�����������������������ƺ�Ҫͨ��ָ�����ļ�·��������
	 * 
	 * @param className
	 *            �������
	 * @return �������Class����
	 * @throws IOException
	 */
	public Class<?> loadData(String className) throws IOException {
		byte classData[] = this.loadClassData();
		return super.defineClass(className, classData, 0, classData.length);
	}

	/**
	 * ͨ��ָ�����ļ�·����������ļ����أ����Ƕ����ƶ�ȡ
	 * 
	 * @return
	 * @throws IOException
	 */
	private byte[] loadClassData() throws IOException {
		InputStream input = new FileInputStream(new File("d:" + File.separator + "Member.class"));
		ByteArrayOutputStream bos = new ByteArrayOutputStream();
		byte data[] = new byte[20];
		int temp = 0;
		while ((temp = input.read(data)) != -1) {
			bos.write(data, 0, temp);
		}
		byte res[] = bos.toByteArray();
		input.close();
		bos.close();
		return res;
	}
}

public class SelfClassLoader {
	public static void main(String[] args) throws IOException, InstantiationException, IllegalAccessException {
		Class<?> cls = new MyClassLoader().loadData("cn.zhangcf.vo.Member");
		System.out.println(cls.newInstance());
		System.out.println(cls.getClassLoader());
		System.out.println(cls.getClassLoader().getParent());
		System.out.println(cls.getClassLoader().getParent().getParent());
	}
}
