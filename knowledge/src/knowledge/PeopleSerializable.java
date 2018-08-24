package knowledge;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

public class PeopleSerializable implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String name;
	private transient int age;
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public static void main(String[] args) {
		PeopleSerializable p1 = new PeopleSerializable();
		p1.setAge(23);
		p1.setName("zhangcf");
		ObjectOutputStream oos = null;
		ObjectInputStream ois = null;

		try {
			FileOutputStream fos = new FileOutputStream("D:\\people.out");
			oos = new ObjectOutputStream(fos);
			oos.writeObject(p1);
			oos.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		PeopleSerializable p2 ;
		try {
			FileInputStream fis = new FileInputStream("D:\\people.out");
			ois = new ObjectInputStream(fis);
			p2 = (PeopleSerializable) ois.readObject();
			System.out.println(p2.getName() + " " + p2.getAge());
		} catch (IOException | ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
}
