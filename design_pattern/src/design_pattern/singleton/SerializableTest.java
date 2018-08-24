package design_pattern.singleton;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

public class SerializableTest {
	public static void main(String[] args) {
		MultiThreadSingleton singleton = MultiThreadSingleton.getInstance();
		
		File file = new File("MySingleton.txt");
		
		try {
			FileOutputStream fos = new FileOutputStream(file);
			ObjectOutputStream oos = new ObjectOutputStream(fos);
			oos.writeObject(singleton);
			fos.close();
			oos.close();
			System.out.println(singleton.hashCode());
		} catch (FileNotFoundException e1) { 
			e1.printStackTrace();
		} catch (IOException e2) { 
			e2.printStackTrace();
		}
		
		try {
			FileInputStream fis = new FileInputStream(file);
			ObjectInputStream ois = new ObjectInputStream(fis);
			MultiThreadSingleton rSingleton = (MultiThreadSingleton) ois.readObject();
			fis.close();
			ois.close();
			System.out.println(rSingleton.hashCode());
		} catch (FileNotFoundException e11) { 
			e11.printStackTrace();
		} catch (IOException e21) { 
			e21.printStackTrace();
		} catch (ClassNotFoundException e) { 
			e.printStackTrace();
		}
	}
}
