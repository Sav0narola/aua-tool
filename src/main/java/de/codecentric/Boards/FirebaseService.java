package de.codecentric.Boards;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.*;

@Service
public class FirebaseService implements Controller {

    @Value("${firebase.boardsUrl}")
    private String boardsUrl;

    @Autowired
    private RestTemplate restTemplate;

    @Autowired
    private BoardMapper boardMapper;

    @Override
    public Map<String, Board> getBoards() throws BoardRequestException {
        ResponseEntity<String> response = restTemplate.exchange(boardsUrl, HttpMethod.GET, null, String.class);
        if (response.hasBody()) {
            String json = response.getBody();
            return boardMapper.map(json);
        } else {
            return Collections.emptyMap();
        }
    }
}
