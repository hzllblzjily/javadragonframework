package com.hongbao.dragonutil.jsonconverter;

import java.io.IOException;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.hongbao.dragonutil.enumeration.EmGender;

public class EmGenderJsonSerializer  extends JsonSerializer<EmGender> {

	@Override
	public void serialize(EmGender value, JsonGenerator jgen,
			SerializerProvider provider) throws IOException,
			JsonProcessingException {

		jgen.writeNumber(value.getG());
		
		
	}

}
