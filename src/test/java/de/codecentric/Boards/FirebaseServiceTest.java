package de.codecentric.Boards;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;
import org.springframework.http.*;
import org.springframework.web.client.RestTemplate;

import java.util.HashMap;
import java.util.Map;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Matchers.any;
import static org.mockito.Matchers.anyString;
import static org.mockito.Matchers.eq;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class FirebaseServiceTest {
    private String ANY_JSON_BODY = "[{\"Oktober\": 1}]";
    private Map<String, Board> ANY_BOARDMAPPER_RESPONSE = new HashMap<>();

    @Mock
    private BoardMapper boardMapper;

    @Mock
    private RestTemplate restTemplate;

    @InjectMocks
    private FirebaseService firebaseService;

    @Test
    public void testThatBoardsCanBeMappedToMonthsWithBoardUsageAmount() throws BoardRequestException {
        ResponseEntity<String> templateResponse = new ResponseEntity<>(ANY_JSON_BODY, HttpStatus.OK);
        when(restTemplate.exchange(anyString(), any(HttpMethod.class), any(HttpEntity.class), eq(String.class))).thenReturn(templateResponse);
        when(boardMapper.map(anyString())).thenReturn(ANY_BOARDMAPPER_RESPONSE);

        Map<String, Board> serviceResponse = firebaseService.getBoards();

        verify(boardMapper).map(ANY_JSON_BODY);
        assertThat(serviceResponse).isEqualTo(ANY_BOARDMAPPER_RESPONSE);
    }



    // Spy von firebaseService - Grund: ich möchte privateMethodenaufrufe checken
    // TODO test of buildUrl as external parameter

}