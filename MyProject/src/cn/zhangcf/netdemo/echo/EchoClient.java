package cn.zhangcf.netdemo.echo;

import java.io.IOException;
import java.io.PrintStream;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.Scanner;

public class EchoClient {
	public static void main(String[] args) throws UnknownHostException, IOException {
		Socket client = new Socket("192.168.2.176", 8888);
		Scanner keyScan = new Scanner(System.in);
		keyScan.useDelimiter("\n");
		Scanner netScan = new Scanner(client.getInputStream());
		netScan.useDelimiter("\n");
		PrintStream netout = new PrintStream(client.getOutputStream());
		boolean flag = true;
		while (flag) {
			System.out.println("请输入要发送的信息");
			String str = null;
			if (keyScan.hasNext()) {
				str = keyScan.next().trim();
				netout.println(str);
				if (netScan.hasNext()) {
					System.out.println(netScan.next());
				}
			}
			if ("byebye".equalsIgnoreCase(str)) {
				flag = false;
				//break;
			}
		}
		keyScan.close();
		netScan.close();
		client.close();
	}
}
