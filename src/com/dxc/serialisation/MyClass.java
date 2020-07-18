package com.dxc.serialisation;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

public class MyClass implements Serializable {
	String s;
	transient int i;

	public MyClass(String s, int i) {
		this.s = s;
		this.i = i;
	}

	public String toString() {
		return "s=" + s + "; i=" + i;
	}
	
}

  public class SerializationDemo {

	public static void main(String[] args) {

		// Object serialization
		try {
			MyClass object1 = new MyClass("java", 5);
			System.out.println("object1: " + object1);
			FileOutputStream fos = new FileOutputStream("serial");
			ObjectOutputStream oos = new ObjectOutputStream(fos);
			oos.writeObject(object1);
			oos.flush();
			oos.close();
			//System.out.println(object1.hashCode());
		} catch (IOException e) {
			System.out.println("Exception during serialization: " + e);
			System.exit(0);
		}
		// Object deserialization
		try {
			MyClass object2;
			FileInputStream fis = new FileInputStream("serial");
			ObjectInputStream ois = new ObjectInputStream(fis);
			object2 = (MyClass) ois.readObject();
			ois.close();
			System.out.println("object2: " + object2);
			//System.out.println(object2.hashCode());
		} catch (Exception e) {
			System.out.println("Exception during deserialization: " + e);
			System.exit(0);
		}




	}

}
