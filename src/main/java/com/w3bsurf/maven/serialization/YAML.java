package com.w3bsurf.maven.serialization;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.dataformat.yaml.YAMLFactory;

public class YAML {
	
	// Serializes Java object to YAML using ObjectMapper from Jackson Library
	public static void YAMLSerialize(ArrayList<TestData> list) {
		
		ObjectMapper objectMapper = new ObjectMapper(new YAMLFactory());
		
		try {
			
			long start = System.currentTimeMillis();
			objectMapper.writeValue(new File("data/testdata.yaml"), list);
			long end = System.currentTimeMillis();
			System.out.println("YAML serialization time: " + (end-start) + "ms");
			
		} catch (IOException i) {
			i.printStackTrace();
		}
	}
	
	// Deserializes YAML to Java object using ObjectMapper from Jackson Library
	public static void YAMLDeserialize() {

		ObjectMapper objectMapper = new ObjectMapper(new YAMLFactory());
		objectMapper.enable(JsonParser.Feature.ALLOW_UNQUOTED_FIELD_NAMES);
		objectMapper.addMixIn(TestData.class, TestDataMixIn.class);
			
		try {
			
			long start = System.currentTimeMillis();
			ArrayList<TestData> list = objectMapper.readValue(new File("data/testdata.yaml"), new TypeReference<ArrayList<TestData>>(){});
			long end = System.currentTimeMillis();
			
			System.out.println("YAML deserialization time: "+ (end-start) + "ms");
			
		} catch (IOException i) {
			i.printStackTrace();
		} 	
	}
}
