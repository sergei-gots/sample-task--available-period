package org.example;

import org.example.dto.AvailablePeriodDto;
import org.example.dto.YearDto;
import org.example.dto.YearDto.YearIndex;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Locale;

@Service
public class AvailablePeriodService {

    final private static DateTimeFormatter formatter =
            DateTimeFormatter
                    .ofPattern("dd MMMM yyyy")
                    .withLocale(Locale.forLanguageTag("ru"));

    private String formatDate(int nYear, int nMonth, int nDay) {
        return LocalDate.of(nYear,nMonth,nDay).format(formatter);
    }


    public AvailablePeriodDto getAvailablePeriod() {

        LocalDate date = LocalDate.now();
        System.out.println("date = " + date);
        AvailablePeriodDto availablePeriodDto = new AvailablePeriodDto();

        int year = date.plusDays(1).getYear();
        System.out.println("year = " + year);

        availablePeriodDto.setYear1(createYearDto(year, date, YearIndex.YEAR_1));
        availablePeriodDto.setYear2(createYearDto(year-1, date, YearIndex.YEAR_2));
        availablePeriodDto.setYear3(createYearDto(year-2, date, YearIndex.YEAR_3));
        return availablePeriodDto;
    }

    private YearDto createYearDto(int year, LocalDate date, YearIndex yearIndex) {
        YearDto yearDto = new YearDto();
        ArrayList<String> monthDate = new ArrayList<>(13);

        yearDto.setYear(year);
        yearDto.setMonthDate(monthDate);

        monthDate.add(formatDate(year - 1, 12, 31));

        if (yearIndex == YearIndex.YEAR_1 && year != date.getYear()) {
                return yearDto;
        }

        int nMonthMax = (yearIndex == YearIndex.YEAR_1) ? date.getMonthValue() : 12;

        for (int i = 1; i<= nMonthMax; i++) {
            monthDate.add(formatDate(year, i, 1));
        }

        return yearDto;
    }

}
