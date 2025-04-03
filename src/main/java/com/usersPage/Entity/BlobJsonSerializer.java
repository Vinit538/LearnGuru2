package com.usersPage.Entity;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.fasterxml.jackson.databind.deser.std.StdDeserializer;
import com.fasterxml.jackson.databind.node.ObjectNode;

import java.io.IOException;
import java.sql.Blob;
import java.sql.SQLException;

public class BlobJsonSerializer extends JsonSerializer<Blob> {

    @Override
    public void serialize(Blob blob, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) throws IOException {
        try {
            byte[] bytes = blob.getBytes(1, (int) blob.length());
            jsonGenerator.writeString(new String(bytes));
        } catch (SQLException e) {
            throw new IOException(e);
        }
    }
}

class BlobJsonDeserializer extends StdDeserializer<Blob> {

    public BlobJsonDeserializer() {
        this(null);
    }

    public BlobJsonDeserializer(Class<?> vc) {
        super(vc);
    }

    @Override
    public Blob deserialize(JsonParser jsonParser, DeserializationContext deserializationContext) throws IOException {
        try {
            JsonNode node = jsonParser.getCodec().readTree(jsonParser);
            byte[] bytes = node.binaryValue();
            return new javax.sql.rowset.serial.SerialBlob(bytes);
        } catch (SQLException e) {
            throw new IOException(e);
        }
    }
}
