package de.codecentric.Boards;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.lang.reflect.ParameterizedType;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class FirebaseController implements Controller{

    @Value("${firebase.boardsUrl}")
    private String boardsUrl;

    private final ParameterizedTypeReference<Map<String, Boards>> TYPE_REFENCE =
            new ParameterizedTypeReference<Map<String, Boards>>() {
            };

    @Autowired
    private RestTemplate restTemplate;


    @Override
    public Map<String, Boards> getBoards() throws BoardRequestException {
        ResponseEntity<Map<String, Boards>> boards = restTemplate.exchange(boardsUrl, HttpMethod.GET,
                null, TYPE_REFENCE);
        return null;
    }
}
