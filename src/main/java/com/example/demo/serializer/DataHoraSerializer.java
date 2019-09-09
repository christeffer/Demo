package com.example.demo.serializer;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.fasterxml.jackson.databind.ser.std.StdSerializer;

public class DataHoraSerializer extends StdSerializer<Date> {

	private static final long serialVersionUID = -5669986905617524103L;

	private SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy HH:mm");

	public DataHoraSerializer() {
		this(null);
	}

	public DataHoraSerializer(Class<Date> t) {
		super(t);
	}

	@Override
	public void serialize(Date date, JsonGenerator generator, SerializerProvider provider) throws IOException {
		generator.writeString(formatter.format(date));
	}

}
