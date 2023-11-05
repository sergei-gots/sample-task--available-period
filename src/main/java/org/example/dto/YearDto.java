package org.example.dto;

import java.util.ArrayList;

public class YearDto {

    public enum YearIndex {
        YEAR_1,
        YEAR_2,
        YEAR_3
    }

    int year;

    private ArrayList<String> monthDate;


    public void setYear(int year) {
        this.year = year;
    }

    public int getYear() {
        return year;
    }

    public void setMonthDate(ArrayList<String>  monthDate) {
        this.monthDate = monthDate;
    }

    public ArrayList<String> getMonthDate() {
        return monthDate;
    }
}
