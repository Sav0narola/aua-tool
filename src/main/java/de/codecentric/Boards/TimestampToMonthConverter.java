package de.codecentric.Boards;

import java.time.*;

public class TimestampToMonthConverter {

    public String getMonthFromTimestamp (long timestamp) {


        LocalDateTime localDateTime  =
                LocalDateTime.ofInstant(Instant.ofEpochMilli(timestamp), ZoneId.systemDefault());


        String month = localDateTime.getMonth().toString();

        return month;
    }
}
