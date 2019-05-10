package com.w3bsurf.maven.serialization;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

public class JAVA {
	
	// Serialize Java object using ObjectOutputStream
	public static void JavaSerialize(ArrayList<TestData> list) {
		
		try {
			
			FileOutputStream fileOut = new FileOutputStream("data/testdata.ser");
			ObjectOutputStream out = new ObjectOutputStream(fileOut);
			// Measures the time takes to serialize using ObjectOutputStream
			long start = System.currentTimeMillis();
			out.writeObject(list);
			long end = System.currentTimeMillis();
			out.close();
			fileOut.close();
			
			System.out.println("Native serialization time: " + (end-start) + "ms");
			
		} catch (IOException i) {
			i.printStackTrace();
			return;
		}
	}
	
	// Deserialize a serialized Java object using ObjectInputStream
	public static void JavaDeserialize() {
		
		try {
			
			FileInputStream fileIn = new FileInputStream("data/testdata.ser");
			ObjectInputStream in = new ObjectInputStream(fileIn);
			// Measure deserialization time
			long start = System.currentTimeMillis();
			ArrayList<TestData> list = (ArrayList<TestData>) in.readObject();
			long end = System.currentTimeMillis();
			in.close();
			fileIn.close();
			
			System.out.println("Native deserialization time: "+ (end-start) + "ms");
			
		} catch (IOException i) {
			i.printStackTrace();
			return;
		} catch (ClassNotFoundException c) {
			System.out.println("TestData class not found.");
			c.printStackTrace();
			return;
		}
	}
}
