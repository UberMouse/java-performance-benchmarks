package org.sample;

import org.openjdk.jmh.annotations.Benchmark;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class DateBenchmark {

    @Benchmark
    public void dateParsingWithFormat(DateState state) throws ParseException {
        Date date = state.formatter.parse("20-09-2017 00:00:00");
        date = new Date(date.getTime() + 24 * state.oneHour);

        state.formatter.format(date);
    }

    @Benchmark
    public void dateLongWithFormat(DateState state) {
        long newTime = state.time + 24 * state.oneHour;

        state.formatter.format(new Date(newTime));
    }

    @Benchmark
    public long dateLong(DateState state) {
        long newTime = state.time + 24 * state.oneHour;

        return newTime;
    }
}


