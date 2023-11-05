package org.example.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

public class AvailablePeriodDto {
    @JsonProperty("Year_1")
    private YearDto year1;
    @JsonProperty("Year_2")
    private YearDto year2;
    @JsonProperty("Year_3")
    private YearDto year3;

    public AvailablePeriodDto() {
    }

    public void setYear1(YearDto year1) {
        this.year1 = year1;
    }
    public void setYear2(YearDto year2) {
        this.year2 = year2;
    }
    public void setYear3(YearDto year3) { this.year3 = year3; }
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
