package cn.zhangcf.demo;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

//ͨ����ʼ����ʵ���ļ��Ŀ���

/**
 * ����һ��ר�Ÿ����ļ�����������࣬����߱����¹��ܣ� 1.��Ҫ�жϿ�����Դ�ļ����� 2.��Ҫ�ж�Ŀ���ļ��ĸ�·���Ƿ���ڣ�����������򴴽�
 * 3.��Ҫ�����ļ���������
 * 
 * @author zhangcf
 */
class CopyUtil {
	private CopyUtil() {
	}

	/**
	 * �ж�Ҫ������Դ·���Ƿ����
	 * 
	 * @param path
	 *            �����Դ·����Ϣ
	 * @return ·�����ڷ���true��·�������ڷ���false
	 */
	public static boolean fileExists(String path) {
		File file = new File(path);
		if (file.exists()) {
			return true;
		} else {
			return false;
		}
	}

	/**
	 * ���ݴ����·�����ж��丸·���Ƿ���ڣ�����������򴴽�
	 * 
	 * @param path
	 */
	public static void creatParentDir(String path) {
		File file = new File(path);
		if (!file.getParentFile().exists()) {
			file.getParentFile().mkdirs();
		}
	}

	/**
	 * 
	 * @param srcPath
	 * @param desPath
	 * @return
	 * @throws IOException
	 */
	public static boolean copy(String srcPath, String desPath) {
		File inFile = new File(srcPath);
		File outFile = new File(desPath);
		InputStream input = null;
		OutputStream output = null;

		boolean flag = false;

		try {
			input = new FileInputStream(inFile);
			output = new FileOutputStream(outFile);
			copyHandle(input, output);
		} catch (IOException e) {
			flag = false;
		} finally {
			try {
				input.close();
				output.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return flag;
	}

	private static void copyHandle(InputStream input, OutputStream output) throws IOException {
		long start = System.currentTimeMillis();
		int temp = 0;
		byte data[] = new byte[2048];
		while((temp = input.read(data)) != -1){
			output.write(data, 0, temp);
		}
		long time = System.currentTimeMillis() - start;
		System.out.println("�����ļ������ѵ�ʱ�䣺" + time);
	}
}

public class Stream5 {
	public static void main(String[] args) {
		if (args.length != 2) {
			System.out.println("�����ִ�з�ʽ");
			System.exit(1);
		}
		if (CopyUtil.fileExists(args[0])) {
			CopyUtil.creatParentDir(args[1]);
			CopyUtil.copy(args[0], args[1]);
		} else {
			System.out.println("�Բ���Դ�ļ������ڣ�");
		}
	}
}
