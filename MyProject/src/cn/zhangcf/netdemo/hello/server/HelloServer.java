package cn.zhangcf.netdemo.hello.server;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

public final class HelloServer {
	public static void main(String[] args) throws IOException {
		//1.����һ������˵ķ������
		ServerSocket server = new ServerSocket(9999);
		//2.��Ҫ�ȴ��ͻ����ӣ�Ҳ����˵��ʱ�ĳ������뵽һ������״̬
		System.out.println("�ȴ��ͻ�������");
		Socket client = server.accept();  //��ʾ�ȴ����ӣ����ӵĶ��ǿͻ�
		PrintWriter out = new PrintWriter(client.getOutputStream());
		out.println("hello world");
		out.close();
		server.close();
	}
}
