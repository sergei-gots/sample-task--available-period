package org.example.dto;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class YearDto {
    private static final Map<Integer, String> monthNames;

    static {
        monthNames = new HashMap<>();
        monthNames.put(1, " января ");
        monthNames.put(2, " февраля ");
        monthNames.put(3, " марта ");
        monthNames.put(4, " апреля ");
        monthNames.put(5, " мая ");
        monthNames.put(6, " июня ");
        monthNames.put(7, " июля ");
        monthNames.put(8, " августа ");
        monthNames.put(9, " сентября ");
        monthNames.put(10, " октября ");
        monthNames.put(11, " ноября ");
        monthNames.put(12, " декабря ");
    }
    public enum YearIndex {
        YEAR_1,
        YEAR_2,
        YEAR_3
    }

    String year;
    ArrayList<String> monthDate = new ArrayList<>(13);

    private String formatDate(int day, int month, int year) {
        return day + monthNames.get(month) + year;
    }

    public YearDto(LocalDate localDate, YearIndex yearIndex) {
        int targetYear = localDate.getYear();
        boolean the31december = localDate.getDayOfMonth() == 31 && localDate.getMonthValue() == 12;

        targetYear -= (yearIndex.ordinal() + 1);

        //if the target date is 31 december of the current year, and the YEAR_1 is being constructed.
        if(the31december && yearIndex == YearIndex.YEAR_1) {
            year = Integer.toString(targetYear+1);
            monthDate.add(formatDate(31, 12, targetYear));
            return;
        }

        year = Integer.toString(targetYear);
        monthDate.add(formatDate(31, 12, targetYear));

        targetYear+=1;
        int endMonth =  (yearIndex == YearIndex.YEAR_1)? localDate.getMonthValue() : 12;
        for (int i = 1; i <= endMonth; i++) {
            monthDate.add(formatDate(1, i, targetYear));
        }
    }

    public String getYear() {
        return year;
    }

    public ArrayList<String> getMonthDate() {
        return monthDate;
    }
}
