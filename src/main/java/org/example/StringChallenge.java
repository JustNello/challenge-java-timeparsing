package org.example;

import java.time.Duration;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

public class StringChallenge {

    private static final DateTimeFormatter AM_PM_FORMATTER = DateTimeFormatter.ofPattern("h:mma");

    private static LocalTime splitByHyphen(String full, int index) {
        if (index < 0 || index > 2)
            throw new IllegalArgumentException("Index should be an integer value: either 0 or 1");
        // DateTimeFormatter accepts am-pm-of-day as upper case text: AM or PM
        String fixedFull = full.toUpperCase();
        // Get either the left or right part of the full input String
        String result = fixedFull.split("-")[index];
        // Leverage LocalTime data type, that can be used in conjunction with other Java Time API
        // facilities, such as the Duration data type
        return LocalTime.parse(result, AM_PM_FORMATTER);
    }

    private static LocalTime startingHour(String full) {
        return splitByHyphen(full, 0);
    }

    private static LocalTime endingHour(String full) {
        return splitByHyphen(full, 1);
    }

    private static boolean isEndingHourNextDay(String full) {
        return startingHour(full).isAfter(endingHour(full));
    }

    public static String extractMinutesDiff(String full) {
        // Let's leverage Duration capabilities and the fact that
        // LocalTime stores time in the ISO-8601 standard;
        // this allows to parse the "full" String into two LocalTime objects
        // with 24 hour-format
        Duration result;

        // Let's refer to a scenario where a startingHour is given (10:00am) and an
        // endingHour (8:30am) that appears to occur before the startingHour within
        // the same day.
        // In such cases, the endingHour (8:30am) should be considered to occur on the
        // following day, not the same day as the startingHour (10:00am). This is because
        // we are dealing in contexts where time spans across midnight are considered,
        // using a 12-hour format
        if (isEndingHourNextDay(full)) {
            result = Duration
                    .between(startingHour(full), LocalTime.MAX)
                    .plusHours(endingHour(full).getHour())
                    .plusMinutes(endingHour(full).getMinute())
                    .plusMinutes(1);
        }
        // Let's refer to a scenario where a startingHour is given (10:00am) and an
        // endingHour (12:00pm) that occur after the startingHour within
        // the same day
        else {
            result = Duration.between(startingHour(full), endingHour(full));
        }

        return Long.toString(
                Math.abs(result.toMinutes()));
    }
}
