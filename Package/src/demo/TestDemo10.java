package demo;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.net.SocketException;
import java.nio.ByteBuffer;
import java.nio.channels.SocketChannel;

public class TestDemo10 {
	//¿Í»§¶Ë´úÂë
	public static void main(String[] args) throws IOException{
		final String msg = "hello";
		byte [] text = msg.getBytes();
		
		SocketChannel channel = SocketChannel.open();
		channel.configureBlocking(false);
		if(!channel.connect(new InetSocketAddress("127.0.0.1", 9899))){
			while(!channel.finishConnect()){
				System.out.print(".");
			}
		}
		System.out.println("\n");
		ByteBuffer writeBuf = ByteBuffer.wrap(text);
		ByteBuffer readBuf = ByteBuffer.allocate(text.length);
		int totalByteRcvd = 0;
		int byteRcvd;
		while(totalByteRcvd<text.length){
			if(writeBuf.hasRemaining()){
				channel.write(writeBuf);
			}
			if((byteRcvd = channel.read(readBuf)) == -1){
				throw new SocketException("Connection closed prematurely!");
			}
			totalByteRcvd += byteRcvd;
			System.out.print(".");
		}
		System.out.println("Received: " + new String(readBuf.array(), 0, totalByteRcvd));
		channel.close();
	}
}
