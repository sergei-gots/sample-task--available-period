package org.example.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.time.Instant;
import java.time.LocalDate;
import java.time.ZoneId;

public class AvailablePeriodDto {
    @JsonProperty("Year_1")
    private YearDto year1;
    @JsonProperty("Year_2")
    private YearDto year2;
    @JsonProperty("Year_3")
    private YearDto year3;

    public AvailablePeriodDto(Instant date) {
        LocalDate localDate = LocalDate.ofInstant(date, ZoneId.of("UTC"));
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
