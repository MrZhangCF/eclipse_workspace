package cn.zhangcf.demo;

import java.io.File;

//列出指定目录中所有文件，包括子目录中的内容，使用递归实现。
public class File3 {
	public static void main(String[] args) {
		new Thread(()->{
			File file = new File("d:" + File.separator + "迅雷下载" + File.separator + "下载合集");
			listFile(file);
		}).start();
		System.out.println("开始输出目录信息.....................");
	}

	/**
	 * 列出指定目录下的所有子目录信息
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
