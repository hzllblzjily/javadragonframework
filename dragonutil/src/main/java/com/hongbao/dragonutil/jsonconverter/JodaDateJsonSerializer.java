package com.hongbao.dragonutil.jsonconverter;

import java.io.IOException;
import java.text.SimpleDateFormat;

import org.joda.time.DateTime;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;



public class JodaDateJsonSerializer extends JsonSerializer<DateTime> {

	@Override
	public void serialize(DateTime value, JsonGenerator jgen,
			SerializerProvider provider) throws IOException,
			JsonProcessingException {

		
		jgen.writeString(value.toString("yyyy-MM-dd"));
		
		
	}

}
