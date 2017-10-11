package de.codecentric.Boards;

import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

import static org.assertj.core.api.Assertions.assertThat;

public class GraphMapperTest {

    @Test
    public void testThatBoardsCanBeMappedToMonthsWithBoardUsageAmount() throws BoardRequestException {

        GraphMapper graphMapper = new GraphMapper(new TimestampToMonthConverter());
        Board boardWithDate = new Board();
        boardWithDate.setCreationDate(1507646466901L);
        Map<String, Board> boards = new HashMap<>();
        boards.put("someId", boardWithDate);
        boards.put("somersId", boardWithDate);


        System.out.println(boards);
        String result = graphMapper.mapMonthsToBoardAmount(boards);

        String expected = "[{\"OCTOBER\": 2]";
        assertThat(result).isEqualTo(expected);
    }
}