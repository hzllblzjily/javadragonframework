package com.hongbao.dragonutil.jsonconverter;

import java.io.IOException;

import org.joda.time.DateTime;
import org.joda.time.format.DateTimeFormat;
import org.joda.time.format.DateTimeFormatter;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonDeserializer;
import com.hongbao.dragonutil.enumeration.EmGender;

public class EmGenderJsonDeserializer extends JsonDeserializer<EmGender>{

	@Override
	public EmGender deserialize(JsonParser p, DeserializationContext ctxt)
			throws IOException, JsonProcessingException {
		// TODO Auto-generated method stub
		int gender = p.readValueAs(Integer.class);
		if(gender == 0){
			return EmGender.UNDEFINED;
		}else if(gender == 1){
			return EmGender.MALE;
		}else if(gender == 2){
			return EmGender.FEMAILE;
		}
		return EmGender.UNDEFINED;
	}

}
