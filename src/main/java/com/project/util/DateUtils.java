package com.project.util;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class DateUtils {

    private static final DateTimeFormatter FORMATTER =
            DateTimeFormatter.ofPattern("yyyy-MM-dd");


    public static LocalDate parseDate(String value){
        return LocalDate.parse(value, FORMATTER);
    }
}
