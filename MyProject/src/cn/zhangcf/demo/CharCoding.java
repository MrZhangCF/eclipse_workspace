package cn.zhangcf.demo;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;

public class CharCoding {
	public static void main(String[] args) throws IOException {
		InputStream input = System.in;
		ByteArrayOutputStream bos = new ByteArrayOutputStream();
		byte data [] = new byte[9];
		System.out.println("��������Ϣ��");
		int temp = 0;
		while((temp = input.read(data)) != -1){
			bos.write(data, 0, temp);
			if(temp < data.length){
				break;
			}
		}
		System.out.println("��������Ϊ��" + new String(bos.toByteArray()));
		bos.close();
	}
}
