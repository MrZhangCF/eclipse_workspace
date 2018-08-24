package cn.zhangcf.netdemo.hello.client;

import java.io.IOException;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.Scanner;

public class HelloClient {
	public static void main(String[] args) throws UnknownHostException, IOException {
		Socket client = new Socket("localhost",9999);
		@SuppressWarnings("resource")
		Scanner scan = new Scanner(client.getInputStream());
		scan.useDelimiter("\n");
		if(scan.hasNext()){
			System.out.println(scan.next());
		}
		client.close();
	}
}
