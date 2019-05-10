package com.w3bsurf.maven.serialization;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import org.msgpack.jackson.dataformat.MessagePackFactory;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

public class MsgPack {
	
	// Serializes Java object to MsgPack using ObjectMapper from Jackson Library
	public static void MsgPackSerialize(ArrayList<TestData> list) {
		
		ObjectMapper objectMapper = new ObjectMapper(new MessagePackFactory());
		
		try {
			
			long start = System.currentTimeMillis();
			objectMapper.writeValue(new File("data/testdata.msgpack"), list);
			long end = System.currentTimeMillis();
			System.out.println("MessagePack serialization time: " + (end-start) + "ms");
			
		} catch (IOException i) {
			i.printStackTrace();
		}
	}
	
	// Deserializes MsgPack to Java object using ObjectMapper from Jackson Library
	public static void MsgPackDeserialize() {
		
		ObjectMapper objectMapper = new ObjectMapper(new MessagePackFactory());
		objectMapper.enable(JsonParser.Feature.ALLOW_UNQUOTED_FIELD_NAMES);
		objectMapper.addMixIn(TestData.class, TestDataMixIn.class);
		
		try {
			
			long start = System.currentTimeMillis();
			ArrayList<TestData> list = objectMapper.readValue(new File("data/testdata.msgpack"), new TypeReference<ArrayList<TestData>>(){});
			long end = System.currentTimeMillis();
			
			System.out.println("MessagePack deserialization time: "+ (end-start) + "ms");
	
		} catch (IOException i) {
			i.printStackTrace();
		} 
	}

}
