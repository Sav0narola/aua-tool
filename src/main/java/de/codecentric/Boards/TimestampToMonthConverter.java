package de.codecentric.Boards;

import org.springframework.stereotype.Component;

import java.time.*;

@Component

public class TimestampToMonthConverter {

    public String getMonthFromTimestamp (long timestamp) {

        LocalDateTime localDateTime  =
                LocalDateTime.ofInstant(Instant.ofEpochMilli(timestamp), ZoneId.systemDefault());

        Integer month = localDateTime.getMonth().getValue();
        Integer year = localDateTime.getYear();
        if(month < 10){
            return year + "-0" + month;
        }else {
            return year + "-" +month;
        }
    }
}
