package com.w3bsurf.maven.serialization;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

public class JAVA {
	
	public static void JavaSerialize(ArrayList<TestData> list) {
		
		try {
			
			FileOutputStream fileOut = new FileOutputStream("data/testdata.ser");
			ObjectOutputStream out = new ObjectOutputStream(fileOut);
			long start = System.currentTimeMillis();
			out.writeObject(list);
			long end = System.currentTimeMillis();
			out.close();
			fileOut.close();
			
			//System.out.println("Serialized native test data is saved in file data/testdata.ser");
			System.out.println("Native serialization time: " + (end-start) + "ms");
			
		} catch (IOException i) {
			i.printStackTrace();
			return;
		}
	}
	
	public static void JavaDeserialize() {
		
		try {
			
			FileInputStream fileIn = new FileInputStream("data/testdata.ser");
			ObjectInputStream in = new ObjectInputStream(fileIn);
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
