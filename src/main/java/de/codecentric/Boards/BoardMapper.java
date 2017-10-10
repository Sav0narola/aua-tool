package de.codecentric.Boards;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.util.Map;

@Component
public class BoardMapper {

    private final static TypeReference<Map<String, Board>> TYPE_REFERENCE
            = new TypeReference<Map<String, Board>>() {
    };

    private ObjectMapper objectMapper;

    @Autowired
    BoardMapper(ObjectMapper objectMapper) {
        this.objectMapper = objectMapper;
    }

    public Map<String, Board> map(String inputJson) {
        try {
            return objectMapper.readValue(inputJson, TYPE_REFERENCE);
        } catch (IOException e) {
            throw new RuntimeException("Failed to parse JSON [" + inputJson + "]");
        }
    }
}
