package de.codecentric.Boards;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.lang.reflect.ParameterizedType;
import java.util.*;

@Service
public class FirebaseController implements Controller {

    @Value("${firebase.boardsUrl}")
    private String boardsUrl;

    private final ParameterizedTypeReference<Map<String, Boards>> TYPE_REFENCE =
            new ParameterizedTypeReference<Map<String, Boards>>() {
            };

    @Autowired
    private RestTemplate restTemplate;


    @Override
    public Map<String, Boards> getBoards() throws BoardRequestException {
        Boards testBoard = new Boards();

        ResponseEntity<Map<String, Boards>> responseBoard = restTemplate.exchange(boardsUrl, HttpMethod.GET,
                null, TYPE_REFENCE);
        if (responseBoard.hasBody()) {
            return responseBoard.getBody();
        } else {
            return Collections.emptyMap();
        }
    }

    @Override
    public Map<String, Boards> getBoards(Map<String, Boards> map) throws BoardRequestException {
        ResponseEntity<Map<String, Boards>> boards = restTemplate.exchange(boardsUrl, HttpMethod.GET,
                null, TYPE_REFENCE);
        if (boards.hasBody()) {
            return boards.getBody();
        } else {
            return Collections.emptyMap();
        }
    }
}
