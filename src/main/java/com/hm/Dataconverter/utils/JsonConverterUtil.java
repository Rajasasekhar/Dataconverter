package com.hm.Dataconverter.utils;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.io.IOException;

@Component
public class JsonConverterUtil {
    private static final ObjectMapper objectMapper = new ObjectMapper();

    public <T> T convertJsonToPojo(String json, Class<T> clazz) throws IOException {
        return objectMapper.readValue(json, clazz);
    }
}
