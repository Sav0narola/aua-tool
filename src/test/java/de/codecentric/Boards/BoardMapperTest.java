package de.codecentric.Boards;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

import static org.assertj.core.api.Assertions.assertThat;


public class BoardMapperTest {

    @Test
    public void testThatBoardCanBeMappedFromJson() {
        String inputJson = "{\"id-12121212\": {\"id\":null,\"creationDate\":1507646466901,\"title\":\"AUA-Tool TestBoard\"}}";
        BoardMapper boardMapper = new BoardMapper(new ObjectMapper());

        Map<String, Board> boards = boardMapper.map(inputJson);

        Map<String, Board> expectedMap = new HashMap<>();
        Board expectedBoard = new Board();
        expectedBoard.setId(null);
        expectedBoard.setCreationDate(1507646466901L);
        expectedBoard.setTitle("AUA-Tool TestBoard");
        expectedMap.put("id-12121212", expectedBoard);
        assertThat(boards).isEqualTo(expectedMap);
    }
}