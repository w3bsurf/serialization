package com.w3bsurf.maven.serialization;

import com.fasterxml.jackson.annotation.JsonProperty;

public abstract class TestDataMixIn {
	
	TestDataMixIn(@JsonProperty("title") String title,
				@JsonProperty("type") String type,
				@JsonProperty("id") int id,
				@JsonProperty("number") double number) {
	}
}
