package de.codecentric.Boards;


import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class TimestampToMonthConverterTest {

    @Test
    public void shouldGetMonthFromTimestamp(){

        TimestampToMonthConverter timestampToMonthConverter = new TimestampToMonthConverter();

        String month = timestampToMonthConverter.getMonthFromTimestamp(1507646466901L);

        assertThat(month).isEqualTo("OCTOBER");
    }
}