package com.w3bsurf.maven.serialization;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

public class JSON {
	
	// Serialize Java object to JSON using ObjectMapper from Jackson library
	public static void JSONSerialize(ArrayList<TestData> list) {
		
		ObjectMapper objectMapper = new ObjectMapper();
		
		try {
			
			// Measures JSON serialization time
			long start = System.currentTimeMillis();
			objectMapper.writeValue(new File("data/testdata.json"), list);
			long end = System.currentTimeMillis();
			System.out.println("JSON serialization time: " + (end-start) + "ms");
			
		} catch (IOException i) {
			i.printStackTrace();
		}
	}
	
	// Deserializes JSON to Java object using ObjectMapper from Jackson Library
	public static void JSONDeserialize() {

		ObjectMapper objectMapper = new ObjectMapper();
		objectMapper.enable(JsonParser.Feature.ALLOW_UNQUOTED_FIELD_NAMES);
		objectMapper.addMixIn(TestData.class, TestDataMixIn.class);
		
		try {
			
			long start = System.currentTimeMillis();
			ArrayList<TestData> list = objectMapper.readValue(new File("data/testdata.json"), new TypeReference<ArrayList<TestData>>(){});
			long end = System.currentTimeMillis();
			
			System.out.println("JSON deserialization time: "+ (end-start) + "ms");
			
		} catch (IOException i) {
			i.printStackTrace();
		} 	
	}

}
