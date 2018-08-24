package cn.zhangcf.netdemo.hello.server;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

public final class HelloServer {
	public static void main(String[] args) throws IOException {
		//1.创建一个服务端的服务对象
		ServerSocket server = new ServerSocket(9999);
		//2.需要等待客户连接，也就是说此时的程序会进入到一个阻塞状态
		System.out.println("等待客户端连接");
		Socket client = server.accept();  //表示等待连接，连接的都是客户
		PrintWriter out = new PrintWriter(client.getOutputStream());
		out.println("hello world");
		out.close();
		server.close();
	}
}
