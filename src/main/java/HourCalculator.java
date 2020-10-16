import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalTime;
import java.util.Date;

import static java.time.temporal.ChronoUnit.MINUTES;

public class HourCalculator {

    public static String convertToMilitaryFormat(String input) {
        SimpleDateFormat MilitaryTimeFormat = new SimpleDateFormat("HH:mm");
        SimpleDateFormat StandardTimeFormat = new SimpleDateFormat("hh:mm a");
        Date date = null;
        try {
            date = (Date) StandardTimeFormat.parse(input);
        }
        catch (ParseException e) {
            return "";

        }
        return MilitaryTimeFormat.format(date);

    }

    public static boolean inBetween(String start, String end, String input) {
        LocalTime startTime = LocalTime.parse(start);
        LocalTime endTime = LocalTime.parse(end);
        LocalTime userInput = LocalTime.parse(input);
        if(!startTime.isAfter(endTime)) {
            return !userInput.isBefore(startTime) && !userInput.isAfter(endTime);
        }
        else {
            return (!userInput.isBefore(startTime) && !userInput.isAfter(LocalTime.parse("23:59"))
                    || (!userInput.isBefore(LocalTime.parse("00:00")) && !userInput.isAfter(endTime)));
        }
    }

    public static int timeDifference(String startTime, String endTime) {
        LocalTime start = LocalTime.parse(startTime);
        LocalTime end = LocalTime.parse(endTime);
        if(start.isBefore(end)) {
            return (int) Math.ceil(MINUTES.between(start, end)/60.0);
        }
        else if(start.isAfter(end)) {
            return (int) Math.ceil(MINUTES.between(start, LocalTime.parse("23:59"))/60.0) + (int) Math.ceil(MINUTES.between(LocalTime.parse("00:00"), end)/60.0);
        }
        else {
            return 0;
        }
    }

    public static int convertHoursToInt(String input) {
        if(inBetween("00:00", "04:00", input)) {
            return timeDifference("00:00", input) + 24;
        }
        else {
            return timeDifference("00:00", input);
        }
    }
}
