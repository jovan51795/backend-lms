package biz.global.util;

import java.io.IOException;

import org.jooq.JSON;
import org.springframework.stereotype.Service;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonDeserializer;

@Service
public class JSONDeserializer extends JsonDeserializer<JSON> {

    @Override
    public JSON deserialize(JsonParser p, DeserializationContext ctxt)
    throws IOException {
        Object t = p.readValueAsTree();
        return t == null ? null : JSON.json("" + t);
    }
}