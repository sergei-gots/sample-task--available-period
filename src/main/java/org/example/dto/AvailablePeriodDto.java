package org.example.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.time.LocalDate;

public class AvailablePeriodDto {
    @JsonProperty("Year_1")
    private YearDto year1;
    @JsonProperty("Year_2")
    private YearDto year2;
    @JsonProperty("Year_3")
    private YearDto year3;

    public AvailablePeriodDto() {
        LocalDate localDate = LocalDate.now();

        year1 = new YearDto(localDate, YearDto.YearIndex.YEAR_1);
        year2 = new YearDto(localDate, YearDto.YearIndex.YEAR_2);
        year3 = new YearDto(localDate, YearDto.YearIndex.YEAR_3);
    }

    public YearDto getYear1() {
        return year1;
    }

    public YearDto getYear2() {
        return year2;
    }
    public YearDto getYear3() {
        return year3;
    }
}
