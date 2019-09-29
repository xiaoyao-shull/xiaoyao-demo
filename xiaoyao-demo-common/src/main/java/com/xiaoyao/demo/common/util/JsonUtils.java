package com.xiaoyao.demo.common.util;

import java.io.IOException;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

/**
 * @author xiaoyao
 */
public abstract class JsonUtils {

    private JsonUtils() {

    }

    private static ObjectMapper objectMapper = new ObjectMapper();

    public static ObjectMapper getObjectMapper() {
        return objectMapper;
    }

    public static <T> T readValue(String json, Class<T> clazz) {
        try {
            return objectMapper.readValue(json, clazz);

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public static <T> String writeValue(T object) {
        try {
            return objectMapper.writeValueAsString(object);

        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }
    }
}
