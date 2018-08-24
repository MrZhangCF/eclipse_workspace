package demo;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class TestDemo3 {
	
	public static void main(String[] args) throws IOException, Exception {
		final String filename = "C:\\Users\\zhangcf\\Documents\\WeChat Files\\Emotion_Pandora\\Files\\TEMCONH.OUT";
		//final String encoding = "GBK";
		File file = new File(filename);
		List<String> list = new ArrayList<String>();

		if (file.exists() && file.isFile()) {
			InputStreamReader read = new InputStreamReader(new FileInputStream(file));
			BufferedReader bufferedReader = new BufferedReader(read);
			String lineTxt = null;
			int count = 0;
			while ((lineTxt = bufferedReader.readLine()) != null) {
				count++;
				if(count>4){
					list.add(lineTxt);
				}
			}
			bufferedReader.close();
			read.close();
		}
		for (String string : list) {
			System.out.println(string);
		}
	}
}

