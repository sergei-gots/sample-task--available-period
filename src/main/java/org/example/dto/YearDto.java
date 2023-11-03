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

    private String formatDate(int nDay, int nMonth, int nYear)
    {
        return nDay + monthNames.get(nMonth) + nYear;
    }

    public YearDto(LocalDate localDate, YearIndex yearIndex) {
        int baseYear = localDate.getYear();
        boolean the31december = localDate.getDayOfMonth() == 31 && localDate.getMonthValue() == 12;

        int yearToDisplay = baseYear - yearIndex.ordinal();

        //if the base date is 31 december of the current year, and the YEAR_1 is the report year here.
        if (the31december && yearIndex == YearIndex.YEAR_1) {
            //Set the year and add 31/12 for this year
            year = Integer.toString(yearToDisplay);
            monthDate.add(formatDate(31, 12, baseYear));
            return;
        }

        //If it's not 31/12 of the reported year:
        if(the31december) {
            yearToDisplay ++;
        }
        //1. Add 31-December of the report year
        monthDate.add(formatDate(31, 12, --yearToDisplay));
        //2. Set the year and increment year-to-display for the following months of
        //the following year
        year = Integer.toString(yearToDisplay++);
        //3. Add 01-of-each month of that following year
        int endMonth =  (yearIndex == YearIndex.YEAR_1)? localDate.getMonthValue() : 12;
        for (int i = 1; i <= endMonth; i++) {
            monthDate.add(formatDate(1, i, yearToDisplay));
        }
    }

    public String getYear() {
        return year;
    }

    public ArrayList<String> getMonthDate() {
        return monthDate;
    }
}
