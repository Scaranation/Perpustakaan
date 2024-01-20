package utils;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Locale;

public class DateString {
    public static String now(){
        Locale locale = Locale.forLanguageTag("id");
        String pattern = "dd-MM-yyyy H:m:s";
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern(pattern, locale);
        LocalDateTime dateTime = LocalDateTime.now();
        return dateTime.format(formatter);
    }
}
