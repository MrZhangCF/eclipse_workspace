package demo;

import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.SelectionKey;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;

public class EchoSelectorProtocol implements TCPProtocol {

	private int bufSize;

	public EchoSelectorProtocol(int bufSize) {
		this.bufSize = bufSize;
	}

	@Override
	public void handleAccept(SelectionKey key) throws IOException {

		SocketChannel clntChan = ((ServerSocketChannel) key.channel()).accept();
		clntChan.configureBlocking(false);
		// ��ѡ����ע�ᵽ���ӵ��Ŀͻ����ŵ�����ָ�����ŵ�keyֵ������ΪOP_READ��ͬʱΪ���ŵ�ָ�������ĸ���
		clntChan.register(key.selector(), SelectionKey.OP_READ, ByteBuffer.allocate(bufSize));
	}

	@Override
	public void handleRead(SelectionKey key) throws IOException {
		SocketChannel clntChan = (SocketChannel) key.channel();
		// ��ȡ���ŵ��������ĸ���������Ϊ������
		ByteBuffer buf = (ByteBuffer) key.attachment();
		long bytesRead = clntChan.read(buf);
		// ���read������������-1��˵���ͻ��˹ر������ӣ���ô�ͻ����Ѿ����յ������Լ������ֽ�����ȵ����ݣ����԰�ȫ�عر�
		if (bytesRead == -1) {
			clntChan.close();
		} else if (bytesRead > 0) {
			// ����������ܶ��������ݣ��򽫸��ŵ�����Ȥ�Ĳ�������ΪΪ�ɶ���д
			key.interestOps(SelectionKey.OP_READ | SelectionKey.OP_WRITE);
		}

	}

	@Override
	public void handleWrite(SelectionKey key) throws IOException {
		// ��ȡ����ŵ������Ļ�������������֮ǰ��ȡ��������
		ByteBuffer buf = (ByteBuffer) key.attachment();
		// ���û�������׼��������д���ŵ�
		buf.flip();
		SocketChannel clntChan = (SocketChannel) key.channel();
		// ������д�뵽�ŵ���
		clntChan.write(buf);
		if (!buf.hasRemaining()) {
			// ����������е������Ѿ�ȫ��д�����ŵ����򽫸��ŵ�����Ȥ�Ĳ�������Ϊ�ɶ�
			key.interestOps(SelectionKey.OP_READ);
		}
		// Ϊ�������������ڳ��ռ�
		buf.compact();
	}

}