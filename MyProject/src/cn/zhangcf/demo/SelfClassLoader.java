package cn.zhangcf.demo;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;

class MyClassLoader extends ClassLoader {
	/**
	 * 实现一个自定义的类加载器，传入类的名称后，要通过指定的文件路径加载类
	 * 
	 * @param className
	 *            类的名称
	 * @return 返回类的Class对象
	 * @throws IOException
	 */
	public Class<?> loadData(String className) throws IOException {
		byte classData[] = this.loadClassData();
		return super.defineClass(className, classData, 0, classData.length);
	}

	/**
	 * 通过指定的文件路径进行类的文件加载，就是二进制读取
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
