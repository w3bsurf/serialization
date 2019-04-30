package com.w3bsurf.maven.serialization;

import java.util.ArrayList;

public class Main {

	public static void main(String[] args) {
		
		ArrayList<TestData> list = new ArrayList<TestData>();
		
		for (int i = 0; i<3000; i++) {
			list.add(new TestData("DataTitle", "Test Data", i, (i+0.1)));
		}

		System.out.println("***Serialization***");
		JAVA.JavaSerialize(list);
		XML.XMLSerialize(list);
		JSON.JSONSerialize(list);
		MsgPack.MsgPackSerialize(list);
		YAML.YAMLSerialize(list);
		
		System.out.println("***Deserialization***");
		JAVA.JavaDeserialize();
		XML.XMLDeserialize();
		JSON.JSONDeserialize();
		MsgPack.MsgPackDeserialize();
		YAML.YAMLDeserialize();

	}

}
