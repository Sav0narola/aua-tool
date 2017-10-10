package de.codecentric.Boards;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.runners.MockitoJUnitRunner;

import java.util.HashMap;
import java.util.Map;

import static org.assertj.core.api.Assertions.assertThat;

@RunWith(MockitoJUnitRunner.class)
public class FirebaseServiceTest {

    private FirebaseService firebaseService;


    @Test
    public void testThatBoardsCanBeMappedToMonthsWithBoardUsageAmount() throws BoardRequestException {
        Board boardWithDate = new Board();
        boardWithDate.setCreationDate(1507646466901L);
        Map<String, Board> boards = new HashMap<>();
        boards.put("someId", boardWithDate);

        System.out.println(boards);
        String result = mapMonthsToBoardAmount(boards);

        String expected = "[{\"Oktober\": 1}]";
        assertThat(result).isEqualTo(expected);
    }

    private String mapMonthsToBoardAmount(Map<String, Board> boards) {
        return null;
    }

}