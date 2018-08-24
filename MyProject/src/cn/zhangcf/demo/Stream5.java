package cn.zhangcf.demo;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

//通过初始化来实现文件的拷贝

/**
 * 建立一个专门负责文件拷贝处理的类，该类具备如下功能： 1.需要判断拷贝的源文件存在 2.需要判断目标文件的父路径是否存在，如果不存在则创建
 * 3.需要进行文件拷贝操作
 * 
 * @author zhangcf
 */
class CopyUtil {
	private CopyUtil() {
	}

	/**
	 * 判断要拷贝的源路径是否存在
	 * 
	 * @param path
	 *            输入的源路径信息
	 * @return 路径存在返回true，路径不存在返回false
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
	 * 根据传入的路径来判断其父路径是否存在，如果不存在则创建
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
		System.out.println("拷贝文件所花费的时间：" + time);
	}
}

public class Stream5 {
	public static void main(String[] args) {
		if (args.length != 2) {
			System.out.println("错误的执行方式");
			System.exit(1);
		}
		if (CopyUtil.fileExists(args[0])) {
			CopyUtil.creatParentDir(args[1]);
			CopyUtil.copy(args[0], args[1]);
		} else {
			System.out.println("对不起，源文件不存在！");
		}
	}
}
