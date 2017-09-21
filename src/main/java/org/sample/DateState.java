package org.sample;

import org.openjdk.jmh.annotations.Scope;
import org.openjdk.jmh.annotations.State;

import java.text.ParseException;
import java.text.SimpleDateFormat;

@State(Scope.Thread)
public class DateState {
    public SimpleDateFormat formatter = new SimpleDateFormat("dd-MM-yyyy HH:mm:ss");;
    public long oneHour = 3600 * 1000;
    public long time;

    public DateState() {
        try {
            time = formatter.parse("20-09-2017 00:00:00").getTime();
        } catch (ParseException e) {
            e.printStackTrace();
        }
    }
}
