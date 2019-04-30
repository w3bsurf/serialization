package com.w3bsurf.maven.serialization;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.dataformat.xml.XmlMapper;

public class XML {

	public static void XMLSerialize(ArrayList<TestData> list) {
		
		XmlMapper xmlMapper = new XmlMapper();
		
		try {
			
			long start = System.currentTimeMillis();
			xmlMapper.writeValue(new File("data/testdata.xml"), list);
			long end = System.currentTimeMillis();
			
			//System.out.println("Serialized XML test data is saved in file data/testdata.xml");
			System.out.println("XML serialization time: " + (end-start) + "ms");
			
		} catch (IOException i) {
			i.printStackTrace();
		}
	}
	
	public static void XMLDeserialize() {
		
		XmlMapper xmlMapper = new XmlMapper();
		xmlMapper.enable(JsonParser.Feature.ALLOW_UNQUOTED_FIELD_NAMES);
		xmlMapper.addMixIn(TestData.class, TestDataMixIn.class);
		
		try {
			
			long start = System.currentTimeMillis();
			ArrayList<TestData> list = xmlMapper.readValue(new File("data/testdata.xml"), new TypeReference<ArrayList<TestData>>(){});
			long end = System.currentTimeMillis();
			
			System.out.println("XML deserialization time: "+ (end-start) + "ms");
			
		} catch (IOException i) {
			i.printStackTrace();
		}
	}
}
