package cn.zhangcf.demo;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.Serializable;
import java.util.Scanner;


public class Stream6 {
	public static void main(String[] args) throws IOException {
		Scanner scan = new Scanner(new FileInputStream(new File("d:" + File.separator + "info.txt")));
		scan.useDelimiter("\n");
		while(scan.hasNext()){
			System.out.println(scan.next());
		}
		scan.close();
	}
}
