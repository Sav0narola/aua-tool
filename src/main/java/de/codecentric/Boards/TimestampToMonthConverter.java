package de.codecentric.Boards;

import org.springframework.stereotype.Component;

import java.time.*;

@Component

public class TimestampToMonthConverter {

    public String getMonthFromTimestamp (long timestamp) {

        LocalDateTime localDateTime  =
                LocalDateTime.ofInstant(Instant.ofEpochMilli(timestamp), ZoneId.systemDefault());

        String month = localDateTime.getMonth().toString();

        return month;
    }
}
