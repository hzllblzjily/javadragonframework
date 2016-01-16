package com.hongbao.dragonutil.jsonconverter;

import java.io.IOException;
import java.text.ParseException;

import org.joda.time.DateTime;
import org.joda.time.format.DateTimeFormat;
import org.joda.time.format.DateTimeFormatter;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonDeserializer;

public class JodaDateJsonDeserializer extends JsonDeserializer<DateTime>{

	@Override
	public DateTime deserialize(JsonParser p, DeserializationContext ctxt)
			throws IOException, JsonProcessingException {
		// TODO Auto-generated method stub
		String dateString = p.readValueAs(String.class);
		
		DateTimeFormatter formatter = DateTimeFormat.forPattern("yyyy-MM-dd");
		
		DateTime newDateTime = DateTime.parse(dateString,formatter);
		

		return newDateTime;
	}

}
