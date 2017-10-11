package de.codecentric.Boards;

import org.springframework.beans.factory.annotation.Autowired;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.TimeoutException;

public class GraphMapper {

    private static final String noDate = "noDate";

    private TimestampToMonthConverter timestampToMonthConverter;

    @Autowired
    GraphMapper(TimestampToMonthConverter timestampToMonthConverter) {
        this.timestampToMonthConverter = timestampToMonthConverter; }

    public String mapMonthsToBoardAmount(Map<String, Board> boards) {

        Map<String, Integer> monthsMappedToBoardcount = new HashMap<>();

        for (Map.Entry<String, Board> mapEntry: boards.entrySet()) {

            Board board = mapEntry.getValue();
            try {
                String month = timestampToMonthConverter.getMonthFromTimestamp(board.getCreationDate());

                Integer boardCounter = monthsMappedToBoardcount.get(month);

                if (boardCounter == null) {
                    monthsMappedToBoardcount.put(month, 1);
                }else {

                    monthsMappedToBoardcount.put(month, boardCounter +1);
                }
            } catch (Exception e) {
                Integer boardCounter = monthsMappedToBoardcount.get(noDate);

                if (boardCounter == null) {
                    monthsMappedToBoardcount.put(noDate, 1);
                }else {

                    monthsMappedToBoardcount.put(noDate, boardCounter +1);
                }
            }
        }

        return "HIER DAS VON DER MAP monthsMappedToBoardcount GEBILDETE JSON";
    }
}
