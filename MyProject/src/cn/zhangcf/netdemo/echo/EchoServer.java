package cn.zhangcf.netdemo.echo;

import java.io.IOException;
import java.io.PrintStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

public class EchoServer {

	private static class MyThread implements Runnable {
		private Socket client;

		public MyThread(Socket client) {
			this.client = client;
		}

		@Override
		public void run() {
			// TODO Auto-generated method stub
			try {
				Scanner scan = new Scanner(client.getInputStream());
				scan.useDelimiter("\n");
				PrintStream out = new PrintStream(client.getOutputStream());
				boolean flag = true;
				while (flag) {
					if (scan.hasNext()) {
						String str = scan.next().trim();
						if ("byebye".equalsIgnoreCase(str)) {
							out.println("byebye!!");
							flag = false;
							break;
						}
						out.println("Echo : " + str);
					}
				}
				out.close();
				scan.close();
			} catch (Exception e) {
				e.printStackTrace();
			}

		}

	}

	public static void main(String[] args) throws IOException {
		ServerSocket server = new ServerSocket(8888);
		boolean flag = true;
		while(flag){
			Socket client = server.accept();
			new Thread(new MyThread(client)).start();;
		}
		server.close();
	}
}
